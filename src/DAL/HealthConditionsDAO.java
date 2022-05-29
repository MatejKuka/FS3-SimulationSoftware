package DAL;

import BE.HealthConditions;
import BLL.exeptions.UserException;
import DAL.Connector.DBConnector;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is CASE
 */

public class HealthConditionsDAO {

    DBConnector dbConnector;

    public HealthConditionsDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public List<HealthConditions> getHealthCondition(int idCitizen) throws UserException {
        List<HealthConditions> healthConditionsList = new ArrayList<>();
        HealthConditions healthConditions;
        String query =  "SELECT * FROM Health_Condition_Answ WHERE Citizen = ?";

        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCitizen);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
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
                healthConditionsList.add(healthConditions);
            }
        } catch (Exception e) {
            throw new UserException("Not able to get health conditions", e);
        }
        return healthConditionsList;
    }

    public void updateHealthConditions(HealthConditions healthConditions) throws UserException {
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
        } catch (Exception e) {
            throw new UserException("Not able to update health conditions", e);
        }
    }

    public HealthConditions createHealthCondition(String SaveAs,
                                                  String ProfessNote,
                                                  String CurrAssess,
                                                  String ExpectedLvl,
                                                  String FollUpDate,
                                                  String ObservNote,
                                                  int TypeOfCase,
                                                  int Citizen) throws UserException {
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
        } catch (Exception e) {
            throw new UserException("Not able to create health conditions", e);
        }
        return healthConditions;
    }
}
