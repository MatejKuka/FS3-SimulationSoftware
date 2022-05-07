package DAL;

import BE.Citizen;
import BE.School;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO {
    private DBConnector dbConnector;

    public CitizenDAO() throws IOException {
        this.dbConnector = DBConnector.getInstance();
    }

    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        List<Citizen> allCitizensFromOneSchool = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM School WHERE School = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, schoolId);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                int idOfSchool = rs.getInt("School");
                int generalInfoId = rs.getInt("General_Information");
                Citizen citizen = new Citizen(id, fName, lName, idOfSchool, generalInfoId);
                System.out.println(citizen);
                allCitizensFromOneSchool.add(citizen);
            }
            return allCitizensFromOneSchool;
        }
    }

    //you can not change school and general info of the citizen
    public void updateCitizen(Citizen citizen) throws Exception {
        String query =  "UPDATE Citizen SET FName = ?, LName = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, citizen.getfName());
            preparedStatement.setString(2, citizen.getlName());
            preparedStatement.setInt(3, citizen.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteCitizen(Citizen citizen) throws Exception {
        String queryCitizen = "DELETE FROM Citizen WHERE Id = ?";
        try(Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryCitizen);
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.executeUpdate();
        }

        String queryGeneralInfo = "DELETE FROM General_Information WHERE Id = ?";
        try(Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryGeneralInfo);
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.executeUpdate();
        }

        String queryHealthConditions = "DELETE FROM Health_Condition_Answ WHERE Id = ?";
        try(Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryHealthConditions);
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.executeUpdate();
        }

        String queryCitizenAssessment = "DELETE FROM Citizens_Assessment WHERE Id = ?";
        try(Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryCitizenAssessment);
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.executeUpdate();
        }

        String queryFunctionalityState = "DELETE FROM Functionality_State_Answ WHERE Id = ?";
        try(Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryFunctionalityState);
            preparedStatement.setInt(1, citizen.getId());
            preparedStatement.executeUpdate();
        }
    }

    public Citizen createCitizen(String fName, String lName, int school, int generalInfo) throws Exception {
        Citizen citizen = null;
        int id = 0;
        String query = "INSERT INTO Citizen VALUES(?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fName);
            preparedStatement.setString(2, lName);
            preparedStatement.setInt(3, school);
            preparedStatement.setInt(4, generalInfo);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                citizen = new Citizen(id, fName, lName, school, generalInfo);
            }
        }
        return citizen;
    }
}
