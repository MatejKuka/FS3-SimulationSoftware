package DAL;

import BE.Citizen;
import BE.Student;
import BE.Teacher;
import BE.User;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentCitizenDAO {
    private DBConnector dbConnector;

    public StudentCitizenDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public void addCitizenToStudent(Student student, Citizen citizen) throws Exception {
        String query = "INSERT INTO Student_Citizen VALUES (?,?)";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getUserID());
            preparedStatement.setInt(2, citizen.getId());
            preparedStatement.executeUpdate();
        }
    }


    public void removeCitizenFromStudent(User student, Citizen citizen) throws Exception {
        String query = "DELETE FROM Student_Citizen WHERE Citizen = ? AND Student = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.setInt(2, student.getUserID());
            preparedStatement.executeUpdate();
        }
    }

    public List<Citizen> getStudentCitizens(int studentId) throws Exception {
        List<Citizen> allCitizens = new ArrayList<>();
        String query =  "SELECT c.Id, c.FName, c.LName, c.School, c.General_information " +
                        "FROM Citizen c " +
                        "JOIN Student_Citizen s ON s.Citizen = c.Id " +
                        "WHERE s.Student = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                int school = rs.getInt("School");
                int genInfo = rs.getInt("General_information");


                Citizen citizen = new Citizen(id, fName, lName, school, genInfo);
                System.out.println(citizen);
                allCitizens.add(citizen);
            }
            return allCitizens;
        }
    }
}
