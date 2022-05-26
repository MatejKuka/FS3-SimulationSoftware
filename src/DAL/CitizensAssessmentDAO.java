package DAL;

import BE.CitizensAssessment;
import BE.HealthConditions;
import BLL.exeptions.UserException;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CitizensAssessmentDAO {

    DBConnector dbConnector;

    public CitizensAssessmentDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public List<CitizensAssessment> getCitizenAssessment(int idCitizen) throws UserException {
        List<CitizensAssessment> citizensAssessmentList = new ArrayList<>();
        CitizensAssessment citizensAssessment = null;
        String query =  "SELECT * FROM Citizens_Assessment WHERE Citizen = ?";

        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCitizen);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                int id = resultSet.getInt("Id");
                String performance = resultSet.getString("Performance");
                String importance = resultSet.getString("Importance");
                String citizWishes = resultSet.getString("CitizWishes");
                String follUpDate = resultSet.getString("FollUpDate");
                String observNote = resultSet.getString("ObservNote");
                int functionalityType = resultSet.getInt("FunctionalityType");
                int citizen = resultSet.getInt("Citizen");

                citizensAssessment = new CitizensAssessment(id,  performance, importance, citizWishes, follUpDate, observNote, functionalityType, citizen);
                citizensAssessmentList.add(citizensAssessment);
            }
        } catch (Exception e) {
            throw new UserException("Not able to get citizen assessment", e);
        }
        return citizensAssessmentList;
    }

    public void updateCitizenAssessment(CitizensAssessment citizensAssessment) throws UserException {
        String query =  "UPDATE Citizens_Assessment SET Performance = ?, Importance = ?, CitizWishes = ?, FollUpDate = ?, " +
                        "ObservNote = ?  WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, citizensAssessment.getPerformance());
            preparedStatement.setString(2, citizensAssessment.getImportance());
            preparedStatement.setString(3, citizensAssessment.getCitizWishes());
            preparedStatement.setString(4, citizensAssessment.getFollUpDate());
            preparedStatement.setString(5, citizensAssessment.getObservNote());
            preparedStatement.setInt(6, citizensAssessment.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to update citizen assessment", e);
        }
    }

    public CitizensAssessment createCitizensAssessment(String performance,
                                                       String importance,
                                                       String citizWishes,
                                                       String follUpDate,
                                                       String observNote,
                                                       int functionalityType,
                                                       int citizen) throws UserException {
        CitizensAssessment citizensAssessment = null;
        int id = 0;
        String query = "INSERT INTO Citizens_Assessment VALUES(?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, performance);
            preparedStatement.setString(2, importance);
            preparedStatement.setString(3, citizWishes);
            preparedStatement.setString(4, follUpDate);
            preparedStatement.setInt(5, functionalityType);
            preparedStatement.setInt(6, citizen);
            preparedStatement.setString(7, observNote);

            int created = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                citizensAssessment = new CitizensAssessment(id, performance,importance, citizWishes,
                        follUpDate, observNote, functionalityType, citizen);
            }
        } catch (Exception e) {
            throw new UserException("Not able to create citizen assessment", e);
        }
        return citizensAssessment;
    }
}
