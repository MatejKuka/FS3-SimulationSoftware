package DAL;

import BE.CitizensAssessment;
import BE.School;
import BE.User;
import BLL.exeptions.UserException;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersSchoolDAO {

    private DBConnector dbConnector;

    public UsersSchoolDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public void addUserToSchool(User user, School school) throws UserException {
        String query = "INSERT INTO Users_School VALUES (?,?)";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, school.getId());
            preparedStatement.setInt(2, user.getUserID());

            preparedStatement.executeUpdate();
        }   catch (Exception e) {
            throw new UserException("Not able to add user to school", e);
        }
    }

    public void removeUserFromSchool(User user, School school) throws UserException {
        String query = "DELETE from Users_School WHERE Users = ? AND School = ?";
        String queryTeacherStudent = "DELETE from Teacher_Student WHERE Teacher = ? OR Student = ?";
        try (Connection connection = dbConnector.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setInt(2, school.getId());
            preparedStatement.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(queryTeacherStudent);
            preparedStatement1.setInt(1, user.getUserID());
            preparedStatement1.setInt(2, user.getUserID());
            preparedStatement1.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to remove user from school", e);
        }
    }

    public int returnUsersSchoolID(User user) throws UserException {
        int schoolId = 0;
        String query = "SELECT School from Users_School WHERE Users = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                schoolId = resultSet.getInt("School");
            }
        } catch (Exception e) {
            throw new UserException("Not able to return users school ID", e);
        }
        return schoolId;
    }
}
