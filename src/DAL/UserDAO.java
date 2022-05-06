package DAL;

import BE.*;
import DAL.Connector.DBConnector;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    private DBConnector dbConnector;

    public UserDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
    }

//public User(int userID, String firstName, String lastName, String loginName, String password, int roleID)
    public User compareLogins(String username, String password) throws Exception
    {
        User user = null;

        try (Connection con = dbConnector.getConnection()) {
            String sql ="SELECT * FROM Users WHERE [UserName] = ? AND [UPassword] = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                int userID = rs.getInt("Id");
                String loginName = rs.getString("UserName");
                String firstName = rs.getString("FName");
                String lastName = rs.getString("LName");
                int roleID = rs.getInt("Type_Of_User");

                user = new User(userID, firstName, lastName, loginName, password, roleID);
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


}
