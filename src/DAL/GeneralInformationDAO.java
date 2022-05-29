package DAL;

import BE.GeneralInfo;
import BE.School;
import BLL.exeptions.UserException;
import DAL.Connector.DBConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GeneralInformationDAO {
    DBConnector dbConnector;

    public GeneralInformationDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public GeneralInfo createGeneralInfo(String mastery,
                                        String motivation,
                                        String resources,
                                        String roller,
                                        String habits,
                                        String educationJob,
                                        String lifeStory,
                                        String healthInfo,
                                        String assistiveDevices,
                                        String interiorOfDwelling,
                                        String network,
                                         int citizenId) throws UserException {
        GeneralInfo generalInfo = null;
        int id = 0;
        String query = "INSERT INTO General_Information VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            preparedStatement.setInt(12,citizenId);

            int created = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                generalInfo = new GeneralInfo(id, mastery, motivation, resources, roller, habits,
                                              educationJob, lifeStory, healthInfo, assistiveDevices,
                                              interiorOfDwelling, network, citizenId);
            }
        } catch (Exception e) {
            throw new UserException("Not able to create general info", e);
        }
        return generalInfo;
    }

    public void updateGeneralInfo(GeneralInfo generalInfo) throws UserException {
        String query =  "UPDATE General_Information SET Mastery = ?, Motivation = ?, Ressources = ?, Roller = ?, " +
                        "Habits = ?, EducationJob = ?, LifeStory = ?, HealthInfo = ?, AssistiveDevices = ?," +
                        " InteriorOfDwelling = ?, Networ = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, generalInfo.getMastery());
            preparedStatement.setString(2, generalInfo.getMotivation());
            preparedStatement.setString(3, generalInfo.getResources());
            preparedStatement.setString(4, generalInfo.getRoller());
            preparedStatement.setString(5, generalInfo.getHabits());
            preparedStatement.setString(6, generalInfo.getEducationJob());
            preparedStatement.setString(7, generalInfo.getLifeStory());
            preparedStatement.setString(8, generalInfo.getHealthInfo());
            preparedStatement.setString(9, generalInfo.getAssistiveDevices());
            preparedStatement.setString(10, generalInfo.getInteriorOfDwelling());
            preparedStatement.setString(11, generalInfo.getNetwork());
            preparedStatement.setInt(12, generalInfo.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to update general info", e);
        }
    }

    public List<GeneralInfo> getAllGeneralInfo() throws UserException {
        List<GeneralInfo> generalInfoArrayList = new ArrayList<>();
        String query = "SELECT * FROM General_Information";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String mastery = resultSet.getString("Mastery");
                String motivation = resultSet.getString("Motivation");
                String resources = resultSet.getString("Ressources");
                String roller = resultSet.getString("Roller");
                String habits = resultSet.getString("Habits");
                String educationJob = resultSet.getString("EducationJob");
                String lifeStory = resultSet.getString("LifeStory");
                String healthInfo = resultSet.getString("HealthInfo");
                String assistiveDevices = resultSet.getString("AssistiveDevices");
                String interiorOfDwelling = resultSet.getString("InteriorOfDwelling");
                String network = resultSet.getString("Networ");
                int citizenId = resultSet.getInt("Citizen");
                GeneralInfo generalInfo = new GeneralInfo(id, mastery, motivation, resources, roller, habits,
                        educationJob, lifeStory, healthInfo, assistiveDevices,
                        interiorOfDwelling, network, citizenId);
                generalInfoArrayList.add(generalInfo);
            }
        } catch (Exception e) {
            throw new UserException("Not able to get all general info", e);
        }
        return generalInfoArrayList;
    }

    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws UserException {
        GeneralInfo generalInfo = null;
        String query =  "SELECT * FROM General_Information WHERE Id = ?";

        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idGeneralInfo);
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()){
                int id = resultSet.getInt("Id");
                String mastery = resultSet.getString("Mastery");
                String motivation = resultSet.getString("Motivation");
                String resources = resultSet.getString("Ressources");
                String roller = resultSet.getString("Roller");
                String habits = resultSet.getString("Habits");
                String educationJob = resultSet.getString("EducationJob");
                String lifeStory = resultSet.getString("LifeStory");
                String healthInfo = resultSet.getString("HealthInfo");
                String assistiveDevices = resultSet.getString("AssistiveDevices");
                String interiorOfDwelling = resultSet.getString("InteriorOfDwelling");
                String network = resultSet.getString("Networ");
                int citizenId = resultSet.getInt("Citizen");


                generalInfo = new GeneralInfo(id, mastery, motivation, resources, roller, habits,
                            educationJob, lifeStory, healthInfo, assistiveDevices,
                            interiorOfDwelling, network, citizenId);
            }
        } catch (Exception e) {
            throw new UserException("Not able to get general info", e);
        }
        return generalInfo;
    }
}
