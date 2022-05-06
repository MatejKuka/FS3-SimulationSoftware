package DAL;

import BE.School;
import BE.User;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class TeacherStudentDAO {

    private DBConnector dbConnector;

    public TeacherStudentDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public void addStudentToTeacher(User student, User teacher) throws Exception {
        if (student.getRoleID() != 3 || teacher.getRoleID() != 2){
            System.out.println("One user needs to be student, another needs to be teacher, can not assign selected users together!");
        }
        else {
            String query = "INSERT INTO Users_School VALUES (?,?)";
            try (Connection connection = dbConnector.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, student.getUserID());
                preparedStatement.setInt(2, teacher.getUserID());
                preparedStatement.executeUpdate();
            }
        }
    }

    public void removeStudentFromTeacher(User student, User teacher) throws Exception {
        String query = "DELETE from Users_School WHERE Users = ? AND School = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getUserID());
            preparedStatement.setInt(2, teacher.getUserID());
            preparedStatement.execute();
        }
    }
}
