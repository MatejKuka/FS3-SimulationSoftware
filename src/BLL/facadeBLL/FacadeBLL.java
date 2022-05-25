package BLL.facadeBLL;

import BE.*;
import BLL.LoginManager;
import DAL.facadeDAL.FacadeDAL;

import java.io.IOException;
import java.util.List;

public class FacadeBLL implements IFacadeBLL {
    FacadeDAL facadeDAL;
    LoginManager loginManager;

    public FacadeBLL() throws IOException {
        facadeDAL = new FacadeDAL();
        loginManager = new LoginManager();
    }

    @Override
    public User compareLogins(String username, String password) throws Exception {
        return loginManager.compareLogins(username, password);
    }

    @Override

    public List<User> getAllStudentsFromOneSchool(int schoolId) throws Exception {
        return facadeDAL.getAllStudentsFromOneSchool(schoolId);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return facadeDAL.getAllUsers();
    }

    @Override
    public List<User> getAllAdmins() throws Exception {
        return facadeDAL.getAllAdmins();
    }

    @Override
    public List<User> getAllAdminsFromOneSchool(int schoolId) throws Exception {
        return facadeDAL.getAllAdminsFromOneSchool(schoolId);
    }

    @Override
    public List<User> getAllTeacherFromOneSchool(int schoolId) throws Exception {
        return facadeDAL.getAllTeacherFromOneSchool(schoolId);
    }

    @Override
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        return facadeDAL.getAllCitizenFromOneSchool(schoolId);
    }

    @Override
    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception {
        return facadeDAL.getGeneralInfo(idGeneralInfo);
    }

    @Override
    public GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits, String educationJob, String lifeStory, String healthInfo, String assistiveDevices, String interiorOfDwelling, String network, int citizenId) throws Exception {
        return facadeDAL.createGeneralInfo(mastery, motivation, resources, roller, habits, educationJob, lifeStory, healthInfo, assistiveDevices, interiorOfDwelling, network, citizenId);
    }

    @Override
    public List<GeneralInfo> getAllGeneralInfo() throws Exception {
        return facadeDAL.getAllGeneralInfo();
    }

    @Override
    public List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws Exception {
        return facadeDAL.getCitizenFunctionalityState(idCitizen);
    }

    @Override
    public void updateCitizen(Citizen citizen) throws Exception {
        facadeDAL.updateCitizen(citizen);
    }

    @Override
    public void deleteCitizen(Citizen citizen) throws Exception {
        facadeDAL.deleteCitizen(citizen);
    }

    @Override
    public Citizen createCitizen(String fName, String lName, int school) throws Exception {
        return facadeDAL.createCitizen(fName, lName, school);
    }

    @Override
    public Citizen getCitizenById(int citizenId) throws Exception {
        return facadeDAL.getCitizenById(citizenId);
    }

    @Override
    public List<School> getAllSchools() throws Exception {
        return facadeDAL.getAllSchools();
    }

    @Override
    public School createSchool(String name, String city) throws Exception {
        return facadeDAL.createSchool(name, city);
    }

    @Override
    public void deleteSchool(School school) throws Exception {
        facadeDAL.deleteSchool(school);
    }

    @Override
    public void updateSchool(School school) throws Exception {
        facadeDAL.updateSchool(school);
    }

    @Override

    public void addUserToSchool(User user, School school) throws Exception {
        facadeDAL.addUserToSchool(user, school);
    }

    @Override
    public void removeUserFromSchool(User user, School school) throws Exception {
        facadeDAL.removeUserFromSchool(user, school);
    }

    @Override
    public School getSchoolById(int schoolId) throws Exception {
        return facadeDAL.getSchoolById(schoolId);
    }

    @Override
    public int returnUsersSchoolID(User user) throws Exception {
        return facadeDAL.returnUsersSchoolID(user);
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
