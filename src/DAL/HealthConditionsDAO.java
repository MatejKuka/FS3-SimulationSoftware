package DAL;

import BE.GeneralInfo;
import BE.HealthConditions;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * This is CASE
 */

public class HealthConditionsDAO {

    DBConnector dbConnector;

    public HealthConditionsDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public HealthConditions getHealthCondition(int idCitizen) throws Exception {
        HealthConditions healthConditions = null;
        String query =  "SELECT * FROM Health WHERE Citizen = ?";

        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCitizen);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                String saveAs = resultSet.getString("SaveAs");
                String professNote = resultSet.getString("ProfessNote");
                String currAssess = resultSet.getString("CurrAssess");
                String expectedLvl = resultSet.getString("ExpectedLvl");
                String follUpDate = resultSet.getString("FollUpDate");
                String observNote = resultSet.getString("ObservNote");
                int typeOfCase = resultSet.getInt("TypeOfCase");
                int citizen = resultSet.getInt("Citizen");


                healthConditions = new HealthConditions(idCitizen, saveAs, professNote, currAssess, expectedLvl, follUpDate,
                                                        observNote, typeOfCase, citizen);
                System.out.println(healthConditions);
            }
        }
        return healthConditions;
    }

    public void updateHealthConditions(HealthConditions healthConditions) throws Exception {
        String query =  "UPDATE Health_Condition_Answ SET SaveAs = ?, ProfessNote = ?, CurrAssess = ?, ExpectedLvl = ?, " +
                        "FollUpDate = ?, ObservNote = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, healthConditions.getSaveAs());
            preparedStatement.setString(2, healthConditions.getProfessNote());
            preparedStatement.setString(3, healthConditions.getCurrAssess());
            preparedStatement.setString(4, healthConditions.getExpectedLvl());
            preparedStatement.setString(5, healthConditions.getFollUpDate());
            preparedStatement.setString(6, healthConditions.getObservNote());
            preparedStatement.setInt(7, healthConditions.getId());

            preparedStatement.executeUpdate();
        }
    }
}
