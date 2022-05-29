package DAL;

import BE.FunctionalityState;
import BLL.exeptions.UserException;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FunctionalityStateDAO {

    private final DBConnector dbConnector;

    public FunctionalityStateDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws UserException {
        List<FunctionalityState> functionalityStateList = new ArrayList<>();
        FunctionalityState functionalityState;
        String query =  "SELECT * FROM Functionality_State_Answ WHERE Citizen = ?";

        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCitizen);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                int id = resultSet.getInt("Id");
                int currLvl = resultSet.getInt("CurrLvl");
                int expectedLvl = resultSet.getInt("ExpectedLvl");
                String professNote = resultSet.getString("ProfessNote");
                String saveAs = resultSet.getString("SaveAs");
                int functionalityType = resultSet.getInt("FunctionalityType");
                int citizen = resultSet.getInt("Citizen");


                functionalityState = new FunctionalityState(id, currLvl, expectedLvl, professNote, saveAs, functionalityType, citizen);
                functionalityStateList.add(functionalityState);

            }
        } catch (Exception e) {
            throw new UserException("Not able to get functionality state", e);
        }
        return functionalityStateList;
    }


    public void updateFunctionalityState(FunctionalityState functionalityState) throws UserException {
        String query =  "UPDATE Functionality_State_Answ SET CurrLvl = ?, ExpectedLvl = ?, ProfessNote = ?, SaveAs = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, functionalityState.getCurrLvl());
            preparedStatement.setInt(2, functionalityState.getExpectedLvl());
            preparedStatement.setString(3, functionalityState.getProfessNote());
            preparedStatement.setString(4, functionalityState.getSaveAs());
            preparedStatement.setInt(5, functionalityState.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to update functionality state", e);
        }
    }

    public FunctionalityState createFunctionalityState(int currLvl,
                                                       int expectedLvl,
                                                       String professNote,
                                                       String saveAs,
                                                       int functionalityType,
                                                       int citizen) throws UserException {
        FunctionalityState functionalityState = null;
        int id = 0;
        String query = "INSERT INTO Functionality_State_Answ VALUES(?, ?, ?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, functionalityType);
            preparedStatement.setInt(2, citizen);
            preparedStatement.setInt(3, currLvl);
            preparedStatement.setInt(4, expectedLvl);
            preparedStatement.setString(5, saveAs);
            preparedStatement.setString(6, professNote);

            int created = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                functionalityState = new FunctionalityState(id, currLvl, expectedLvl, professNote, saveAs, functionalityType, citizen);
            }
        } catch (Exception e) {
            throw new UserException("Not able to create functionality state", e);
        }
        return functionalityState;
    }
}
