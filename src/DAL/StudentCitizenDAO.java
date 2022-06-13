package DAL;

import BE.Citizen;
import BE.Student;
import BE.User;
import BLL.exeptions.UserException;
import DAL.Connector.DBConnector;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentCitizenDAO {
    private final DBConnector dbConnector;

    public StudentCitizenDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    /////////////////////
    public void addCitizenToStudent(Student student, Citizen citizen) throws UserException {
        String query = "INSERT INTO Student_Citizen VALUES (?,?)";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getUserID());
            preparedStatement.setInt(2, citizen.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to add citizen to student", e);
        }
    }

    public void removeCitizenFromStudent(User student, Citizen citizen) throws UserException {
        String query = "DELETE FROM Student_Citizen WHERE Citizen = ? AND Student = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.setInt(2, student.getUserID());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to remove citizen from student", e);
        }
    }

    public List<Citizen> getStudentCitizens(int studentId) throws UserException {
        List<Citizen> allCitizens = new ArrayList<>();
        String query =  "SELECT c.Id, c.FName, c.LName, c.School " +
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


                Citizen citizen = new Citizen(id, fName, lName, school);
                allCitizens.add(citizen);
            }
        } catch (Exception e) {
            throw new UserException("Not able to get student citizens", e);
        }
        return allCitizens;
    }
}
