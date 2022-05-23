package DAL;

import BE.CitizensAssessment;
import BE.School;
import BE.User;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersSchoolDAO {

    private DBConnector dbConnector;

    public UsersSchoolDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public void addUserToSchool(User user, School school) throws Exception {
        String query = "INSERT INTO Users_School VALUES (?,?)";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, school.getId());
            preparedStatement.setInt(2, user.getUserID());

            preparedStatement.executeUpdate();
        }
    }

    public void removeUserFromSchool(User user, School school) throws Exception {
        String query = "DELETE from Users_School WHERE Users = ? AND School = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setInt(2, school.getId());
            preparedStatement.executeUpdate();
        }

        String queryTeacherStudent = "DELETE from Teacher_Student WHERE Teacher = ? OR Student = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryTeacherStudent);
            preparedStatement.setInt(1, user.getUserID());
            preparedStatement.setInt(2, user.getUserID());
            preparedStatement.executeUpdate();
        }
    }

    public int returnUsersSchoolID(User user) throws Exception {
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
        }
        return schoolId;
    }
} // TODO MAtej - check these methods and implements them
