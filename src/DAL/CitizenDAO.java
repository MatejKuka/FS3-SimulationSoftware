package DAL;

import BE.Citizen;
import BLL.exeptions.UserException;
import DAL.Connector.DBConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO {
    private DBConnector dbConnector;

    public CitizenDAO() throws IOException {
        this.dbConnector = DBConnector.getInstance();
    }

    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws UserException {
        List<Citizen> allCitizensFromOneSchool = new ArrayList<>();

        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM Citizen WHERE School = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, schoolId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                int idOfSchool = resultSet.getInt("School");

                Citizen citizen = new Citizen(id, fName, lName, idOfSchool);
                allCitizensFromOneSchool.add(citizen);
            }
        } catch (Exception e) {
            throw new UserException("Not able to get all citizens from one school", e);
        }
        return allCitizensFromOneSchool;
    }

    //you can not change school and general info of the citizen
    public void updateCitizen(Citizen citizen) throws UserException {
        String query = "UPDATE Citizen SET FName = ?, LName = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, citizen.getFirstName());
            preparedStatement.setString(2, citizen.getLastName());
            preparedStatement.setInt(3, citizen.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to update citizen", e);
        }
    }
    
    public void deleteCitizen(Citizen citizen) throws UserException {
        String queryCitizen = "DELETE FROM Citizen WHERE Id = ?";
        String queryGeneralInfo = "DELETE FROM General_Information WHERE Citizen = ?";
        String queryHealthConditions = "DELETE FROM Health_Condition_Answ WHERE Citizen = ?";
        String queryCitizenAssessment = "DELETE FROM Citizens_Assessment WHERE Citizen = ?";
        String queryFunctionalityState = "DELETE FROM Functionality_State_Answ WHERE Citizen = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement1 = connection.prepareStatement(queryGeneralInfo);
            preparedStatement1.setInt(1, citizen.getId());
            preparedStatement1.executeUpdate();

            PreparedStatement preparedStatement2 = connection.prepareStatement(queryHealthConditions);
            preparedStatement2.setInt(1, citizen.getId());
            preparedStatement2.executeUpdate();

            PreparedStatement preparedStatement3 = connection.prepareStatement(queryCitizenAssessment);
            preparedStatement3.setInt(1, citizen.getId());
            preparedStatement3.executeUpdate();

            PreparedStatement preparedStatement4 = connection.prepareStatement(queryFunctionalityState);
            preparedStatement4.setInt(1, citizen.getId());
            preparedStatement4.executeUpdate();

            PreparedStatement preparedStatement = connection.prepareStatement(queryCitizen);
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to delete citizen", e);
        }
    }

    public Citizen createCitizen(String fName, String lName, int school) throws UserException {
        Citizen citizen = null;
        int id = 0;
        String query = "INSERT INTO Citizen VALUES(?, ?, ?)";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fName);
            preparedStatement.setString(2, lName);
            preparedStatement.setInt(3, school);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            if (created != 0) {
                citizen = new Citizen(id, fName, lName, school);
            }
        } catch (Exception e) {
            throw new UserException("Not able to create citizen", e);
        }
        return citizen;
    }

    public Citizen getCitizenById(int citizenId) throws UserException {

        Citizen citizen = null;
        String query =  "SELECT * " +
                        "FROM Citizen " +
                        "WHERE Id = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, citizenId);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                int idOfSchool = resultSet.getInt("School");

                citizen = new Citizen(id, fName, lName, idOfSchool);

            }
        } catch (Exception e) {
            throw new UserException("Not able to get citizen by ID", e);
        }
        return citizen;
    }
}
