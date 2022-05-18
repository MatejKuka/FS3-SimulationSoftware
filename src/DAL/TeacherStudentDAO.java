package DAL;

import BE.School;
import BE.Student;
import BE.Teacher;
import BE.User;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherStudentDAO {

    private DBConnector dbConnector;

    public TeacherStudentDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public void addStudentToTeacher(Student student, Teacher teacher) throws Exception {
        String query = "INSERT INTO Teacher_Student VALUES (?,?)";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getUserID());
            preparedStatement.setInt(2, teacher.getUserID());
            preparedStatement.executeUpdate();
        }
    }

    public void removeStudentFromTeacher(Student student, Teacher teacher) throws Exception {
        String query = "DELETE from Teacher_Student WHERE Teacher = ? AND Student = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, teacher.getUserID());
            preparedStatement.setInt(2, student.getUserID());
            preparedStatement.executeUpdate();
        }
    }

    public List<User> getTeacherStudents(int teacherId) throws Exception {
        List<User> allStudents = new ArrayList<>();
        String query =  "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword, u.Type_Of_User " +
                        "FROM Users u " +
                        "JOIN Teacher_Student t ON t.Student = u.Id " +
                        "WHERE t.Teacher = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, teacherId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                String userName = rs.getString("UserName");
                String password = rs.getString("UPassword");
                int type = rs.getInt("Type_Of_User");

                Student student = new Student(id, fName, lName, userName, password, type);
                System.out.println(student);
                allStudents.add(student);
            }
            return allStudents;
        }
    }
}
