package BLL.facadeBLL;

import BE.*;
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

    public List<User> getAllStudentsFromOneSchool(int schoolId) throws Exception {
        return userManager.getAllStudents(schoolId);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userManager.getAllUsers();
    }

    @Override
    public List<User> getAllAdmins() throws Exception {
        return userManager.getAllAdmins();
    }

    @Override
    public List<User> getAllAdminsFromOneSchool(int schoolId) throws Exception {
        return facadeDAL.getAllAdminsFromOneSchool(schoolId);
    }

    @Override
    public List<User> getAllTeacherFromOneSchool(int schoolId) throws Exception {
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
    public void updateCitizen(Citizen citizen) throws Exception {
        facadeDAL.updateCitizen(citizen);
    }

    @Override
    public void deleteCitizen(Citizen citizen, int generalInfoIdOfCitizen) throws Exception {
        facadeDAL.deleteCitizen(citizen, generalInfoIdOfCitizen);
    }

    @Override
    public Citizen createCitizen(String fName, String lName, int school, int generalInfo) throws Exception {
        return facadeDAL.createCitizen(fName, lName, school, generalInfo);
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
