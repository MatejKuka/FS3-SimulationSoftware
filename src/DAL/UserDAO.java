package DAL;

import BE.*;
import BLL.exeptions.UserException;
import BLL.utils.UserFactory;
import DAL.Connector.DBConnector;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    private final DBConnector dbConnector;
    private final UserFactory userFactory;

    public UserDAO() throws IOException {
        dbConnector = DBConnector.getInstance();
        userFactory = new UserFactory();
    }

    public User compareLogins(String username, String password) throws UserException {
        User user = null;

        try (Connection con = dbConnector.getConnection()) {
            String sql = "SELECT * FROM Users WHERE [UserName] = ? AND [UPassword] = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userID = resultSet.getInt("Id");
                String firstName = resultSet.getString("FName");
                String lastName = resultSet.getString("LName");
                String loginName = resultSet.getString("UserName");
                String userPassword = resultSet.getString("UPassword");
                int roleID = resultSet.getInt("Type_Of_User");

                if (roleID == UserFactory.UserType.ADMIN.getIdInDatabase())
                    user = userFactory.createUser(userID, firstName, lastName, loginName, userPassword, UserFactory.UserType.ADMIN);

                else if (roleID == UserFactory.UserType.TEACHER.getIdInDatabase())
                    user = userFactory.createUser(userID, firstName, lastName, loginName, userPassword, UserFactory.UserType.TEACHER);

                else
                    user = userFactory.createUser(userID, firstName, lastName, loginName, userPassword, UserFactory.UserType.STUDENT);
            }
        } catch (Exception e) {
            throw new UserException("Not able to compare logins", e);
        }
        return user;
    }

    public List<User> getAllUsers() throws UserException {
        User user;
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
                String password = rs.getString("UPassword");
                int type = rs.getInt("Type_Of_User");

                if (type == UserFactory.UserType.ADMIN.getIdInDatabase())
                    user = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.ADMIN);

                else if (type == UserFactory.UserType.TEACHER.getIdInDatabase())
                    user = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.TEACHER);

                else
                    user = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.STUDENT);

                allUsers.add(user);
            }
        } catch (Exception e) {
            throw new UserException("Not able to show all users", e);
        }
        return allUsers;
    }


    public List<User> getAllAdminsFromOneSchool(int schoolId) throws UserException {
        List<User> allAdmins = new ArrayList<>();
        String query = "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword " +
                "FROM Users u " +
                "JOIN Users_School s ON s.Users = u.id " +
                "WHERE u.Type_Of_User = 1 AND s.School = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, schoolId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String userName = resultSet.getString("UserName");
                String password = resultSet.getString("UPassword");

                User admin = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.ADMIN);
                allAdmins.add(admin);
            }
        } catch (Exception e) {
            throw new UserException("Not able to show all admins from one school", e);
        }
        return allAdmins;
    }

    public List<User> getAllAdmins() throws UserException {
        List<User> allAdmins = new ArrayList<>();
        String query =  "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword " +
                        "FROM Users u " +
                        "WHERE u.Type_Of_User = 1 AND u.Id NOT IN " +
                        "(" +
                            "SELECT us.Users " +
                            "FROM Users_School us " +
                        ")";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String userName = resultSet.getString("UserName");
                String password = resultSet.getString("UPassword");


                User admin = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.ADMIN);
                System.out.println(admin);
                allAdmins.add(admin);
            }
        } catch (Exception e) {
            throw new UserException("Not able to show all admins", e);
        }
        return allAdmins;
    }

    public List<User> getAllStudentsFromOneSchool(int schoolId) throws UserException {
        List<User> allStudents = new ArrayList<>();
        String query = "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword " +
                " FROM Users u " +
                "JOIN Users_School s ON s.Users = u.id " +
                "WHERE u.Type_Of_User = 3 AND s.School = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, schoolId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String fName = resultSet.getString("FName");
                String lName = resultSet.getString("LName");
                String userName = resultSet.getString("UserName");
                String password = resultSet.getString("UPassword");


                User student = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.STUDENT);
                allStudents.add(student);
            }
        } catch (Exception e) {
            throw new UserException("Not able to show all students from one school", e);
        }
        return allStudents;
    }

    public List<User> getAllTeachersFromOneSchool(int schoolId) throws UserException {
        List<User> allTeachers = new ArrayList<>();
        String query = "SELECT u.Id, u.FName, u.LName, u.UserName, u.UPassword " +
                " FROM Users u " +
                "JOIN Users_School s ON s.Users = u.id " +
                "WHERE u.Type_Of_User = 2 AND s.School = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, schoolId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("Id");
                String fName = rs.getString("FName");
                String lName = rs.getString("LName");
                String userName = rs.getString("UserName");
                String password = rs.getString("UPassword");


                User teacher = userFactory.createUser(id, fName, lName, userName, password, UserFactory.UserType.TEACHER);
                allTeachers.add(teacher);
            }
        } catch (Exception e) {
            throw new UserException("Not able to show all teachers from one school", e);
        }
        return allTeachers;
    }

    public User createAdmin(String firstName, String lastName, String loginName, String password) throws UserException {
        User admin = null;
        int type = UserFactory.UserType.ADMIN.getIdInDatabase();
        int id = 0;
        String query = "INSERT INTO Users VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, loginName);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, type);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            if (created != 0) {
                admin = userFactory.createUser(id, firstName, lastName, loginName, password, UserFactory.UserType.ADMIN);
            }
        } catch (Exception e) {
            throw new UserException("Not able to create admin", e);
        }
        return admin;
    }

    public User createTeacher(String firstName, String lastName, String loginName, String password) throws UserException {
        User teacher = null;
        int type = UserFactory.UserType.TEACHER.getIdInDatabase();
        int id = 0;
        String query = "INSERT INTO Users VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, loginName);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, type);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            if (created != 0) {
                teacher = userFactory.createUser(id, firstName, lastName, loginName, password, UserFactory.UserType.TEACHER);
            }
        } catch (Exception e) {
            throw new UserException("Not able to create teacher", e);
        }
        return teacher;
    }

    public User createStudent(String firstName, String lastName, String loginName, String password) throws UserException {
        User student = null;
        int type = UserFactory.UserType.STUDENT.getIdInDatabase();
        int id = 0;
        String query = "INSERT INTO Users VALUES(?, ?, ?, ?, ?)";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, loginName);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, type);
            int created = preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
            if (created != 0) {
                student = userFactory.createUser(id, firstName, lastName, loginName, password, UserFactory.UserType.STUDENT);
            }
        } catch (Exception e) {
            throw new UserException("Not able to create student", e);
        }
        return student;
    }

    public void deleteUser(User user) throws UserException {
        String query = "DELETE FROM Users WHERE Id = ?";
        String queryUserSchool = "DELETE FROM Users_School WHERE Users = ?";

        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement2 = connection.prepareStatement(queryUserSchool);
            preparedStatement2.setInt(1, user.getUserID());
            preparedStatement2.executeUpdate();

            PreparedStatement preparedStatement1 = connection.prepareStatement(query);
            preparedStatement1.setInt(1, user.getUserID());
            preparedStatement1.executeUpdate();
        } catch (Exception e) {
            throw new UserException("Not able to delete user", e);
        }
    }

    public void updateUser(int userID, String firstName, String lastName, String loginName, String password) throws UserException {
        String query = "UPDATE Users SET FName = ?, LName = ?, UserName = ?, UPassword = ? WHERE Id = ?";
        try (Connection connection = dbConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, loginName);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, userID);
            preparedStatement.executeUpdate();
        }  catch (Exception e) {
            throw new UserException("Not able to update user", e);
        }
    }
}
