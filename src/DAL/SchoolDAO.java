package DAL;

import BE.School;
import BLL.exeptions.UserException;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {
    DBConnector dbConnector;

    public SchoolDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public List<School> getAllSchools() throws UserException {
        List<School> allSchools = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM School";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("SchName");
                String city = rs.getString("City");
                School school = new School(id, name, city);
                allSchools.add(school);
            }
        } catch (Exception e) {
            throw new UserException("Not able to get all schools", e);
        }
        return allSchools;
    }

    public School createSchool(String name, String city) throws UserException {
        School school = null;
        int id = 0;
        String query = "INSERT INTO School VALUES(?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, city);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                school = new School(id, name, city);
            }
        } catch (Exception e) {
            throw new UserException("Not able to create school", e);
        }
        return school;
    }

    //when deleting school also delete Users, Fictive citizens connections with school,
    //do we need also delete citizens GenInfo, HealthCon, CitizenAss and FunctionState??
    public void deleteSchool(School school) throws UserException {
        String querySchool = "DELETE FROM School WHERE Id = ?";
        String querySchoolUsers = "DELETE FROM Users_School WHERE School = ?";
        String querySchoolCitizens = "DELETE FROM Citizen WHERE School = ?";

        try(Connection connection = dbConnector.getConnection()) {

            PreparedStatement preparedStatement1 = connection.prepareStatement(querySchoolUsers);
            preparedStatement1.setInt(1, school.getId());
            preparedStatement1.executeUpdate();

            PreparedStatement preparedStatement2 = connection.prepareStatement(querySchoolCitizens);
            preparedStatement2.setInt(1, school.getId());
            preparedStatement2.executeUpdate();

            PreparedStatement preparedStatement = connection.prepareStatement(querySchool);
            preparedStatement.setInt(1, school.getId());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new UserException("Not able to delete school", e);
        }

    }

    public void updateSchool(School school) throws UserException {
        String query =  "UPDATE School SET SchName = ?, City = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, school.getName());
            preparedStatement.setString(2, school.getCity());
            preparedStatement.setInt(3, school.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to update school info", e);
        }
    }

    public School getSchoolById(int schoolId) throws UserException {
        School school = null;
        String query = "SELECT * FROM School WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,schoolId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                int id = resultSet.getInt("Id");
                String schName = resultSet.getString("SchName");
                String city = resultSet.getString("City");

                school = new School(id, schName, city);
            }
        } catch (Exception e) {
            throw new UserException("Not able to find school by ID", e);
        }
        return school;
    }
}
