package BLL.facadeBLL;
import BE.Citizen;
import BE.FunctionalityState;
import BE.GeneralInfo;
import BE.User;
import BLL.CitizenManager;
import BLL.GenerInfoManager;
import BLL.UserManager;
import DAL.facadeDAL.FacadeDAL;

import java.io.IOException;
import java.util.List;

public class FacadeBLL implements IFacadeBLL {
    UserManager userManager;
    CitizenManager citizenManager;
    GenerInfoManager generInfoManager;
    FacadeDAL facadeDAL;

    public FacadeBLL() throws IOException {
        userManager = new UserManager();
        citizenManager = new CitizenManager();
        generInfoManager = new GenerInfoManager();
        facadeDAL = new FacadeDAL();
    }

    @Override
    public User compareLogins(String username, String password) throws Exception {
        return userManager.compareLogins(username, password);
    }

    @Override
    public List<User> getAllStudents(int schoolId) throws Exception {
            return userManager.getAllStudents(schoolId);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userManager.getAllUsers();
    }

    @Override
    public List<User> getAllAdmins(int schoolId) throws Exception {
        return userManager.getAllAdmins(schoolId);
    }

    @Override
    public List<User> getAllTeacher(int schoolId) throws Exception {
        return userManager.getAllTeacher(schoolId);
    }

    @Override
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        return citizenManager.getAllCitizenFromOneSchool(schoolId);
    }

    @Override
    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception {
        return generInfoManager.getGeneralInfo(idGeneralInfo);
    }

    @Override
    public List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws Exception {
        return facadeDAL.getCitizenFunctionalityState(idCitizen);
    }

    @Override
    public int returnUsersSchoolID(User user) throws Exception {
        return userManager.returnUsersSchoolID(user);
    }

    @Override
    public User createStudent(String firstName, String lastName, String loginName, String password) throws Exception {
        return facadeDAL.createStudent(firstName, lastName, loginName, password);
    }

    @Override
    public void deleteUser(User user) throws Exception {
        facadeDAL.deleteUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        facadeDAL.updateUser(user);
    }

    @Override
    public User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception {
        return facadeDAL.createAdmin(firstName, lastName, loginName, password);
    }

    @Override
    public User createTeacher(String firstName, String lastName, String loginName, String password) throws Exception {
        return facadeDAL.createTeacher(firstName, lastName, loginName, password);
    }

}
