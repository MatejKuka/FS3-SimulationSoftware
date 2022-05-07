package BLL.facadeBLL;
import BE.User;
import BLL.utils.UserManager;

import java.io.IOException;
import java.util.List;

public class FacadeBLL implements IFacadeBLL {
    UserManager userManager;

    public FacadeBLL() throws IOException {
        userManager = new UserManager();
    }

    @Override
    public User compareLogins(String username, String password) throws Exception {
        return userManager.compareLogins(username, password);
    }

    @Override
    public List<User> getAllStudents() throws Exception {
            return userManager.getAllStudents();
    }

    public List<User> getAllUsers() throws Exception {
        return userManager.getAllUsers();
    }

    public List<User> getAllAdmins() throws Exception {
        return userManager.getAllAdmins();
    }

    public List<User> getAllTeacher() throws Exception {
        return userManager.getAllTeacher();
    }
}
