package DAL;

import BE.GeneralInfo;
import BE.School;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class GeneralInformationDAO {
    DBConnector dbConnector;

    public GeneralInformationDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public GeneralInfo createSchool(String mastery,
                                    String motivation,
                                    String resources,
                                    String roller,
                                    String habits,
                                    String educationJob,
                                    String lifeStory,
                                    String healthInfo,
                                    String assistiveDevices,
                                    String interiorOfDwelling,
                                    String network) throws Exception {
        GeneralInfo generalInfo = null;
        int id = 0;
        String query = "INSERT INTO General_Information VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, mastery);
            preparedStatement.setString(2, motivation);
            preparedStatement.setString(3, resources);
            preparedStatement.setString(4, roller);
            preparedStatement.setString(5, habits);
            preparedStatement.setString(6, educationJob);
            preparedStatement.setString(7, lifeStory);
            preparedStatement.setString(8, healthInfo);
            preparedStatement.setString(9, assistiveDevices);
            preparedStatement.setString(10, interiorOfDwelling);
            preparedStatement.setString(11, network);

            int created = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                generalInfo = new GeneralInfo(id, mastery, motivation, resources, roller, habits,
                                              educationJob, lifeStory, healthInfo, assistiveDevices,
                                              interiorOfDwelling, network);
            }
        }
        return generalInfo;
    }
}
