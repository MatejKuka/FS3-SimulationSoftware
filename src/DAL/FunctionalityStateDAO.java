package DAL;

import BE.CitizensAssessment;
import BE.FunctionalityState;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FunctionalityStateDAO {

    DBConnector dbConnector;

    public FunctionalityStateDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public FunctionalityState getCitizenFunctionalityState(int idCitizen) throws Exception {
        FunctionalityState functionalityState = null;
        String query =  "SELECT * FROM Functionality_State_Answ WHERE Citizen = ?";

        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCitizen);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                int id = resultSet.getInt("Id");
                int currLvl = resultSet.getInt("CurrLvl");
                int expectedLvl = resultSet.getInt("ExpectedLvl");
                String professNote = resultSet.getString("ProfessNote");
                String follUpDate = resultSet.getString("FollUpDate");
                int functionalityType = resultSet.getInt("FunctionalityType");
                int citizen = resultSet.getInt("Citizen");


                functionalityState = new FunctionalityState(id, currLvl, expectedLvl, professNote, follUpDate, functionalityType, citizen);
                System.out.println(functionalityType);
            }
        }
        return functionalityState;
    }

    public void updateFunctionalityState(FunctionalityState functionalityState) throws Exception {
        String query =  "UPDATE Functionality_State_Answ SET CurrLvl = ?, ExpectedLvl = ?, ProfessNote = ?, FollUpDate = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, functionalityState.getCurrLvl());
            preparedStatement.setInt(2, functionalityState.getExpectedLvl());
            preparedStatement.setString(3, functionalityState.getProfessNote());
            preparedStatement.setString(4, functionalityState.getFollUpDate());
            preparedStatement.setInt(5, functionalityState.getId());

            preparedStatement.executeUpdate();
        }
    }
}
