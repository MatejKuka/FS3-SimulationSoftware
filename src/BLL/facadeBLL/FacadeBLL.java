package BLL.facadeBLL;
import BE.Citizen;
import BE.GeneralInfo;
import BE.User;
import BLL.CitizenManager;
import BLL.GenerInfoManager;
import BLL.UserManager;

import java.io.IOException;
import java.util.List;

public class FacadeBLL implements IFacadeBLL {
    UserManager userManager;
    CitizenManager citizenManager;
    GenerInfoManager generInfoManager;

    public FacadeBLL() throws IOException {
        userManager = new UserManager();
        citizenManager = new CitizenManager();
        generInfoManager = new GenerInfoManager();
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

    @Override
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        return citizenManager.getAllCitizenFromOneSchool(schoolId);
    }

    @Override
    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception {
        return generInfoManager.getGeneralInfo(idGeneralInfo);
    }

    public int returnUsersSchoolID(User user) throws Exception {
        return userManager.returnUsersSchoolID(user);
    }
}
