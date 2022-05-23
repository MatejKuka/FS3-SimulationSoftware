package BLL;

import BE.User;
import BLL.utils.LoginUserHelper;
import DAL.facadeDAL.FacadeDAL;

import java.io.IOException;
import java.util.List;

public class UserManager {
    FacadeDAL facadeDAL;
    LoginUserHelper loginUserHelper;

    public UserManager() throws IOException {
        facadeDAL = new FacadeDAL();
        loginUserHelper = new LoginUserHelper();
    }

    public User compareLogins(String username, String password) throws Exception {
        User user = facadeDAL.compareLogins(username, password);
        if (user != null) return loginUserHelper.getInstance(user);
        else return null;
    }

    public List<User> getAllStudents(int schoolId) throws Exception {
        return facadeDAL.getAllStudentsFromOneSchool(schoolId);
    }

    public List<User> getAllUsers() throws Exception {
        return facadeDAL.getAllUsers();
    }

    public List<User> getAllAdmins() throws Exception {
        return facadeDAL.getAllAdmins();
    }

    public List<User> getAllTeacher(int schoolId) throws Exception {
        return facadeDAL.getAllTeacherFromOneSchool(schoolId);
    }
    public int returnUsersSchoolID(User user) throws Exception {
        return facadeDAL.returnUsersSchoolID(user);
    }

}
