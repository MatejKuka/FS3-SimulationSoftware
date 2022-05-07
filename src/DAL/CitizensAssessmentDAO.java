package DAL;

import BE.CitizensAssessment;
import BE.HealthConditions;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
                String functionalityType = resultSet.getString("FunctionalityType");
                int citizen = resultSet.getInt("Citizen");

                citizensAssessment = new CitizensAssessment(idCitizen,  performance, importance, citizWishes, follUpDate, observNote, functionalityType, citizen);
                System.out.println(citizensAssessment);
            }
        }
        return citizensAssessment;
    }
}
