package DAL;

import BE.School;
import BE.User;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

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
    }
}
