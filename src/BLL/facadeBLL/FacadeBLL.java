package BLL.facadeBLL;

import BE.*;
import BLL.LoginManager;
import BLL.exeptions.UserException;
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
    public User compareLogins(String username, String password) throws UserException {
        return loginManager.compareLogins(username, password);
    }

    @Override

    public List<User> getAllStudentsFromOneSchool(int schoolId) throws UserException {
        return facadeDAL.getAllStudentsFromOneSchool(schoolId);
    }

    @Override
    public List<User> getAllUsers() throws UserException {
        return facadeDAL.getAllUsers();
    }

    @Override
    public List<User> getAllAdmins() throws UserException {
        return facadeDAL.getAllAdmins();
    }

    @Override
    public List<User> getAllAdminsFromOneSchool(int schoolId) throws UserException {
        return facadeDAL.getAllAdminsFromOneSchool(schoolId);
    }

    @Override
    public List<User> getAllTeacherFromOneSchool(int schoolId) throws UserException {
        return facadeDAL.getAllTeacherFromOneSchool(schoolId);
    }

    @Override
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws UserException {
        return facadeDAL.getAllCitizenFromOneSchool(schoolId);
    }

    @Override
    public void addCitizenToStudent(Student student, Citizen citizen) throws UserException {
        facadeDAL.addCitizenToStudent(student, citizen);
    }

    @Override
    public void removeCitizenFromStudent(User student, Citizen citizen) throws UserException {
        facadeDAL.removeCitizenFromStudent(student, citizen);
    }

    @Override
    public List<Citizen> getStudentCitizens(int studentId) throws UserException {
        return facadeDAL.getStudentCitizens(studentId);
    }

    @Override
    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws UserException {
        return facadeDAL.getGeneralInfo(idGeneralInfo);
    }

    @Override
    public GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits, String educationJob, String lifeStory, String healthInfo, String assistiveDevices, String interiorOfDwelling, String network, int citizenId) throws UserException {
        return facadeDAL.createGeneralInfo(mastery, motivation, resources, roller, habits, educationJob, lifeStory, healthInfo, assistiveDevices, interiorOfDwelling, network, citizenId);
    }

    @Override
    public List<GeneralInfo> getAllGeneralInfo() throws UserException {
        return facadeDAL.getAllGeneralInfo();
    }

    @Override
    public void updateGeneralInfo(GeneralInfo generalInfo) throws UserException {
        facadeDAL.updateGeneralInfo(generalInfo);
    }

    @Override
    public List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws UserException {
        return facadeDAL.getCitizenFunctionalityState(idCitizen);
    }

    @Override
    public void updateCitizen(Citizen citizen) throws UserException {
        facadeDAL.updateCitizen(citizen);
    }

    @Override
    public void deleteCitizen(Citizen citizen) throws UserException {
        facadeDAL.deleteCitizen(citizen);
    }

    @Override
    public Citizen createCitizen(String fName, String lName, int school) throws UserException {
        return facadeDAL.createCitizen(fName, lName, school);
    }

    @Override
    public Citizen getCitizenById(int citizenId) throws UserException {
        return facadeDAL.getCitizenById(citizenId);
    }

    @Override
    public List<School> getAllSchools() throws UserException {
        return facadeDAL.getAllSchools();
    }

    @Override
    public School createSchool(String name, String city) throws UserException {
        return facadeDAL.createSchool(name, city);
    }

    @Override
    public void deleteSchool(School school) throws UserException {
        facadeDAL.deleteSchool(school);
    }

    @Override
    public void updateSchool(School school) throws UserException {
        facadeDAL.updateSchool(school);
    }

    @Override

    public void addUserToSchool(User user, School school) throws UserException {
        facadeDAL.addUserToSchool(user, school);
    }

    @Override
    public void removeUserFromSchool(User user, School school) throws UserException {
        facadeDAL.removeUserFromSchool(user, school);
    }

    @Override
    public School getSchoolById(int schoolId) throws UserException {
        return facadeDAL.getSchoolById(schoolId);
    }

    @Override
    public List<HealthConditions> getHealthCondition(int idCitizen) throws UserException {
        return facadeDAL.getHealthCondition(idCitizen);
    }

    @Override
    public void updateHealthConditions(HealthConditions healthConditions) throws UserException {
        facadeDAL.updateHealthConditions(healthConditions);
    }

    @Override
    public HealthConditions createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl, String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws UserException {
        return facadeDAL.createHealthCondition(SaveAs, ProfessNote, CurrAssess, ExpectedLvl, FollUpDate, ObservNote, TypeOfCase, Citizen);
    }

    @Override
    public FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String saveAs, int functionalityType, int citizen) throws UserException {
        return facadeDAL.createFunctionalityState(currLvl, expectedLvl, professNote, saveAs, functionalityType, citizen);
    }

    @Override
    public void updateFunctionalityState(FunctionalityState functionalityState) throws UserException {
        facadeDAL.updateFunctionalityState(functionalityState);
    }

    @Override
    public List<CitizensAssessment> getCitizenAssessmentById(int id) throws UserException {
        return facadeDAL.getCitizenAssessment(id);
    }

    @Override
    public CitizensAssessment createCitizensAssessment(String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) throws UserException {
        return facadeDAL.createCitizensAssessment(performance, importance, citizWishes, follUpDate, observNote, functionalityType, citizen);
    }

    @Override
    public void updateCitizensAssessment(CitizensAssessment citizensAssessment) throws UserException {
        facadeDAL.updateCitizenAssessment(citizensAssessment);
    }

    @Override
    public int returnUsersSchoolID(User user) throws UserException {
        return facadeDAL.returnUsersSchoolID(user);
    }
    @Override
    public User createStudent(String firstName, String lastName, String loginName, String password) throws UserException {
        return facadeDAL.createStudent(firstName, lastName, loginName, password);
    }

    @Override
    public void deleteUser(User user) throws UserException {
        facadeDAL.deleteUser(user);
    }

    @Override
    public void updateUser(int userID, String firstName, String lastName, String loginName, String password) throws UserException {
        facadeDAL.updateUser(userID, firstName, lastName, loginName, password);
    }

    @Override
    public User createAdmin(String firstName, String lastName, String loginName, String password) throws UserException {
        return facadeDAL.createAdmin(firstName, lastName, loginName, password);
    }

    @Override
    public User createTeacher(String firstName, String lastName, String loginName, String password) throws UserException {
        return facadeDAL.createTeacher(firstName, lastName, loginName, password);
    }

}
