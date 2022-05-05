package DAL;

import BE.School;
import DAL.Connector.DBConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {
    DBConnector dbConnector;

    public SchoolDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public List<School> getAllCustomers() throws Exception {
        List<School> allSchools = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM School";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("SchName");
                String city = rs.getString("City");
                School school = new School(id, name, city);
                System.out.println(school);
                allSchools.add(school);
            }
            return allSchools;
        }
    }

    public School createSchool(String name, String city) throws Exception {
        School school = null;
        int id = 0;
        String query = "INSERT INTO School VALUES(?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, city);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                school = new School(id, name, city);
            }

        }
        return school;
    }
}
