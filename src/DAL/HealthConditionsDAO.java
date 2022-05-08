package DAL;

import BE.GeneralInfo;
import BE.HealthConditions;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
        String query =  "SELECT * FROM Health_Condition_Answ WHERE Citizen = ?";

        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCitizen);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                int id = resultSet.getInt("Id");
                String saveAs = resultSet.getString("SaveAs");
                String professNote = resultSet.getString("ProfessNote");
                String currAssess = resultSet.getString("CurrAssess");
                String expectedLvl = resultSet.getString("ExpectedLvl");
                String follUpDate = resultSet.getString("FollUpDate");
                String observNote = resultSet.getString("ObservNote");
                int typeOfCase = resultSet.getInt("TypeOfCase");
                int citizen = resultSet.getInt("Citizen");


                healthConditions = new HealthConditions(id, saveAs, professNote, currAssess, expectedLvl, follUpDate,
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

    public HealthConditions createHealthCondition(String SaveAs,
                                                  String ProfessNote,
                                                  String CurrAssess,
                                                  String ExpectedLvl,
                                                  String FollUpDate,
                                                  String ObservNote,
                                                  int TypeOfCase,
                                                  int Citizen) throws Exception {
        HealthConditions healthConditions = null;
        int id = 0;
        String query = "INSERT INTO Health_Condition_Answ VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, SaveAs);
            preparedStatement.setString(2, ProfessNote);
            preparedStatement.setString(3, CurrAssess);
            preparedStatement.setString(4, ExpectedLvl);
            preparedStatement.setString(5, FollUpDate);
            preparedStatement.setString(6, ObservNote);
            preparedStatement.setInt(7, TypeOfCase);
            preparedStatement.setInt(8, Citizen);


            int created = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                healthConditions = new HealthConditions(id, SaveAs,ProfessNote, CurrAssess,
                                                        ExpectedLvl, FollUpDate, ObservNote, TypeOfCase, Citizen);
            }
        }
        return healthConditions;
    }
}
