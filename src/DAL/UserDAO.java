package DAL;

import BE.*;
import DAL.Connector.DBConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    private DBConnector dbConnector;

    public UserDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

    public User compareLogins(String username, String password) throws Exception
    {
        User user = null;

        try (Connection con = dbConnector.getConnection()) {
            String sql ="SELECT [loginName],[password],[email],[roleID],[userID] FROM LoginUser WHERE [loginName] = ? AND [password] = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                int userID = rs.getInt("userID");
                String loginName = rs.getString("loginName");
                String email = rs.getString("email");
                int roleID = rs.getInt("roleID");

                user = null; // change this
            }
        }
        catch (Exception e)
        {
            user =null;
            e.printStackTrace();
        }
        return user;
    } // TODO Matej - this method needs to be changed

    public List<User> getAllUsers() throws Exception {
        User user = null;
        List<User> allUsers = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM Users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                String userName = rs.getString("UserName");
                String  password = rs.getString("UPassword");
                int type = rs.getInt("Type_Of_User");

                if (type == 1)
                    user = new Admin(id, fName, lName, userName, password, type);
                else if (type == 2)
                    user = new Teacher(id, fName, lName, userName, password, type);
                else
                    user = new Student(id, fName, lName, userName, password, type);

                allUsers.add(user);
            }
            return allUsers;
        }
    }

    public List<User> getAllAdmins() throws Exception {
        List<User> allAdmins = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM Users WHERE Type_Of_User = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                String userName = rs.getString("UserName");
                String  password = rs.getString("UPassword");
                int type = rs.getInt("Type_Of_User");
                Admin admin = new Admin(id, fName, lName, userName, password, type);
                allAdmins.add(admin);
            }
            return allAdmins;
        }
    }

    public List<User> getAllStudents() throws Exception {
        List<User> allStudents = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM Users WHERE Type_Of_User = 3";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                String userName = rs.getString("UserName");
                String  password = rs.getString("UPassword");
                int type = rs.getInt("Type_Of_User");
                Student student = new Student(id, fName, lName, userName,password, type);
                allStudents.add(student);
            }
            return allStudents;
        }
    }

    public List<User> getAllTeacher() throws Exception {
        List<User> allTeachers = new ArrayList<>();
        try (Connection connection = dbConnector.getConnection()) {
            String query = "SELECT * FROM Users WHERE Type_Of_User = 2";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                String userName = rs.getString("UserName");
                String  password = rs.getString("UPassword");
                int type = rs.getInt("Type_Of_User");
                Teacher teacher = new Teacher(id, fName, lName, userName, password, type);
                allTeachers.add(teacher);
            }
            return allTeachers;
        }
    }

    public User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception {
        User admin = null;
        int type = 1;
        int id = 0;
        String query = "INSERT INTO Users VALUES(?, ?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, loginName);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, type);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                admin = new Admin(id,firstName, lastName, loginName, password, type);
            }
        }
        return admin;
    }

    public User createTeacher(String firstName, String lastName, String loginName, String password) throws Exception {
        User teacher = null;
        int type = 2;
        int id = 0;
        String query = "INSERT INTO Users VALUES(?, ?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, loginName);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, type);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                teacher = new Admin(id,firstName, lastName, loginName, password, type);
            }
        }
        return teacher;
    }

    public User createStudent(String firstName, String lastName, String loginName, String password) throws Exception {
        User student = null;
        int type = 3;
        int id = 0;
        String query = "INSERT INTO Users VALUES(?, ?, ?, ?, ?)";

        try(Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, loginName);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, type);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()){
                id = resultSet.getInt(1);
            }
            if (created != 0){
                student = new Admin(id,firstName, lastName, loginName, password, type);;
            }
        }
        return student;
    }


}
