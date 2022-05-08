package DAL;

import BE.CitizensAssessment;
import BE.HealthConditions;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CitizensAssessmentDAO {

    DBConnector dbConnector;

    public CitizensAssessmentDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public CitizensAssessment getCitizenAssessment(int idCitizen) throws Exception {
        CitizensAssessment citizensAssessment = null;
        String query =  "SELECT * FROM Citizens_Assessment WHERE Citizen = ?";

        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idCitizen);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                String performance = resultSet.getString("Performance");
                String importance = resultSet.getString("Importance");
                String citizWishes = resultSet.getString("CitizWishes");
                String follUpDate = resultSet.getString("FollUpDate");
                String observNote = resultSet.getString("ObservNote");
                int functionalityType = resultSet.getInt("FunctionalityType");
                int citizen = resultSet.getInt("Citizen");

                citizensAssessment = new CitizensAssessment(idCitizen,  performance, importance, citizWishes, follUpDate, observNote, functionalityType, citizen);
                System.out.println(citizensAssessment);
            }
        }
        return citizensAssessment;
    }

    public void updateCitizenAssessment(CitizensAssessment citizensAssessment) throws Exception {
        String query =  "UPDATE Citizens_Assessment SET Performance = ?, ProfessNote = ?, CitizWishes = ?, FollUpDate = ?, " +
                        "ObservNote = ?, FunctionalityType = ?, Citizen = ?  WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, citizensAssessment.getPerformance());
            preparedStatement.setString(2, citizensAssessment.getImportance());
            preparedStatement.setString(3, citizensAssessment.getCitizWishes());
            preparedStatement.setString(4, citizensAssessment.getFollUpDate());
            preparedStatement.setString(5, citizensAssessment.getObservNote());
            preparedStatement.setInt(6, citizensAssessment.getFunctionalityType());
            preparedStatement.setInt(7, citizensAssessment.getCitizen());
            preparedStatement.setInt(8, citizensAssessment.getId());

            preparedStatement.executeUpdate();
        }
    }

    public CitizensAssessment createCitizensAssessment(String Performance,
                                                       String Importance,
                                                       String CitizWishes,
                                                       String FollUpDate,
                                                       String ObservNote,
                                                       int FunctionalityType,
                                                       int Citizen) throws Exception {
        CitizensAssessment citizensAssessment = null;
        int id = 0;
        String query = "INSERT INTO Citizens_Assessment VALUES(?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, Performance);
            preparedStatement.setString(2, Importance);
            preparedStatement.setString(3, CitizWishes);
            preparedStatement.setString(4, FollUpDate);
            preparedStatement.setString(5, ObservNote);
            preparedStatement.setInt(6, FunctionalityType);
            preparedStatement.setInt(7, Citizen);

            int created = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                citizensAssessment = new CitizensAssessment(id, Performance,Importance, CitizWishes,
                        FollUpDate, ObservNote, FunctionalityType, Citizen);
            }
        }
        return citizensAssessment;
    }
}
