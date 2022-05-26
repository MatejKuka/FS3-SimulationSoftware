package DAL;

import BE.*;
import BLL.utils.UserFactory;
import DAL.Connector.DBConnector;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    private DBConnector dbConnector;
    UserFactory userFactory;

    public UserDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
        userFactory = new UserFactory();
    }

    public User compareLogins(String username, String password) throws Exception {
        User user = null;

        try (Connection con = dbConnector.getConnection()) {
            String sql ="SELECT * FROM Users WHERE [UserName] = ? AND [UPassword] = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int userID = resultSet.getInt("Id");
                String firstName = resultSet.getString("FName");
                String lastName = resultSet.getString("LName");
                String loginName = resultSet.getString("UserName");
                String userPassword = resultSet.getString("UPassword");
                int roleID = resultSet.getInt("Type_Of_User");

                if (roleID ==  UserFactory.UserType.ADMIN.getIdInDatabase())
                    user = userFactory.createUser(userID, firstName, lastName, loginName, userPassword, UserFactory.UserType.ADMIN);

                else if (roleID ==  UserFactory.UserType.TEACHER.getIdInDatabase())
                    user = userFactory.createUser(userID, firstName, lastName, loginName, userPassword, UserFactory.UserType.TEACHER);

                else
                    user = userFactory.createUser(userID, firstName, lastName, loginName, userPassword, UserFactory.UserType.STUDENT);
            }
        }
        return user;
    }

    //TEST THIS
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

                if (type ==  UserFactory.UserType.ADMIN.getIdInDatabase())
                    user = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.ADMIN);

                else if (type ==  UserFactory.UserType.TEACHER.getIdInDatabase())
                    user = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.TEACHER);

                else
                    user = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.STUDENT);

                allUsers.add(user);
            }
            return allUsers;
        }
    }


    public List<User> getAllAdminsFromOneSchool(int schoolId) throws Exception {
        List<User> allAdmins = new ArrayList<>();
        String query =  "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword " + //u.Type_Of_User " +
                        "FROM Users u " +
                        "JOIN Users_School s ON s.Users = u.id " +
                        "WHERE u.Type_Of_User = 1 AND s.School = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,schoolId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String userName = resultSet.getString("UserName");
                String  password = resultSet.getString("UPassword");
//                int type = resultSet.getInt("Type_Of_User");

                User admin = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.ADMIN);
                System.out.println(admin);
                allAdmins.add(admin);
            }
            return allAdmins;
        }
    }

    public List<User> getAllAdmins() throws Exception {
        List<User> allAdmins = new ArrayList<>();
        String query =  "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword " +  //u.Type_Of_User" +
                        " FROM Users u " +
                        "JOIN Users_School s ON s.Users = u.id " +
                        "WHERE u.Type_Of_User = 1";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String userName = resultSet.getString("UserName");
                String  password = resultSet.getString("UPassword");
//                int type = resultSet.getInt("Type_Of_User");

                User admin = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.ADMIN);
                System.out.println(admin);
                allAdmins.add(admin);
            }
            return allAdmins;
        }
    }

    public List<User> getAllStudentsFromOneSchool(int schoolId) throws Exception {
        List<User> allStudents = new ArrayList<>();
        String query =  "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword " +  //u.Type_Of_User" +
                        " FROM Users u " +
                        "JOIN Users_School s ON s.Users = u.id " +
                        "WHERE u.Type_Of_User = 3 AND s.School = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,schoolId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String userName = resultSet.getString("UserName");
                String  password = resultSet.getString("UPassword");
//                int type = resultSet.getInt("Type_Of_User");

                User student = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.STUDENT);
                allStudents.add(student);
            }
            return allStudents;
        }
    }

    public List<User> getAllTeachersFromOneSchool(int schoolId) throws Exception {
        List<User> allTeachers = new ArrayList<>();
        String query =  "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword " + //, u.Type_Of_User" +
                        " FROM Users u " +
                        "JOIN Users_School s ON s.Users = u.id " +
                        "WHERE u.Type_Of_User = 2 AND s.School = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,schoolId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                String userName = rs.getString("UserName");
                String  password = rs.getString("UPassword");
//                int type = rs.getInt("Type_Of_User");

                User teacher = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.TEACHER);
                allTeachers.add(teacher);
            }
            return allTeachers;
        }
    }

    public User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception {
        User admin = null;
        int type = UserFactory.UserType.ADMIN.getIdInDatabase();
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
                admin = userFactory.createUser(id, firstName, lastName, loginName, password, UserFactory.UserType.ADMIN);
            }
        }
        return admin;
    }

    public User createTeacher(String firstName, String lastName, String loginName, String password) throws Exception {
        User teacher = null;
        int type = UserFactory.UserType.TEACHER.getIdInDatabase();
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
                teacher = userFactory.createUser(id, firstName, lastName, loginName, password, UserFactory.UserType.TEACHER);
            }
        }
        return teacher;
    }

    public User createStudent(String firstName, String lastName, String loginName, String password) throws Exception {
        User student = null;
        int type = UserFactory.UserType.STUDENT.getIdInDatabase();
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
                student = userFactory.createUser(id, firstName, lastName, loginName, password, UserFactory.UserType.STUDENT);
                System.out.println(student);
            }
        }
        return student;
    }

    public void deleteUser(User user) throws Exception {
        String query = "DELETE FROM Users WHERE Id = ?";
        String queryUserSchool = "DELETE FROM Users_School WHERE Users = ?";
        String queryTeacherStudent = "DELETE FROM Teacher_Student WHERE Teacher = ? OR Student = ?";

        try(Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement2 = connection.prepareStatement(queryUserSchool);
            preparedStatement2.setInt(1, user.getUserID());
            preparedStatement2.executeUpdate();

            PreparedStatement preparedStatement3 = connection.prepareStatement(queryTeacherStudent);
            preparedStatement3.setInt(1, user.getUserID());
            preparedStatement3.setInt(2, user.getUserID());
            preparedStatement3.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setInt(1, user.getUserID());
            preparedStatement1.executeUpdate();
        } // TODO Oliver - error
    }

    public void updateUser(User user) throws Exception {
        String query =  "UPDATE Users SET FName = ?, LName = ?, UserName = ?, UPassword = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getLoginName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setInt(5, user.getUserID());
            preparedStatement.executeUpdate();
        }
    }
}
