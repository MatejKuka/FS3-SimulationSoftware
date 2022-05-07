package DAL;

import BE.Citizen;
import BE.School;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAO {
    private DBConnector dbConnector;

    public CitizenDAO() throws IOException {
        this.dbConnector = DBConnector.getInstance();
    }

    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        List<Citizen> allCitizensFromOneSchool = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM School WHERE School = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, schoolId);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                int idOfSchool = rs.getInt("School");
                int generalInfoId = rs.getInt("General_Information");
                Citizen citizen = new Citizen(id, fName, lName, idOfSchool, generalInfoId);
                System.out.println(citizen);
                allCitizensFromOneSchool.add(citizen);
            }
            return allCitizensFromOneSchool;
        }
    }
}
