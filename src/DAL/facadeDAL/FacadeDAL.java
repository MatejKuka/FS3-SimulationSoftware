package DAL.facadeDAL;

import BE.*;
import BLL.exeptions.UserException;
import DAL.*;

import java.io.IOException;
import java.util.List;

public class FacadeDAL implements IFacadeDAL{
    private static FacadeDAL instance;

    UserDAO userDAO;
    CitizenDAO citizenDAO;
    UsersSchoolDAO usersSchoolDAO;
    GeneralInformationDAO generalInformationDAO;
    SchoolDAO schoolDAO;
    HealthConditionsDAO healthConditionsDAO;
    FunctionalityStateDAO functionalityStateDAO;
    CitizensAssessmentDAO citizensAssessmentDAO;
    StudentCitizenDAO studentCitizenDAO;

    public FacadeDAL() throws IOException {
        userDAO = new UserDAO();
        citizenDAO = new CitizenDAO();
        usersSchoolDAO = new UsersSchoolDAO();
        generalInformationDAO = new GeneralInformationDAO();
        schoolDAO = new SchoolDAO();
        healthConditionsDAO = new HealthConditionsDAO();
        functionalityStateDAO = new FunctionalityStateDAO();
        citizensAssessmentDAO = new CitizensAssessmentDAO();
        studentCitizenDAO = new StudentCitizenDAO();
    }


    @Override
    public int returnUsersSchoolID(User user) throws UserException {
        return usersSchoolDAO.returnUsersSchoolID(user);
    }

    @Override
    public void addUserToSchool(User user, School school) throws UserException {
        usersSchoolDAO.addUserToSchool(user, school);
    }

    @Override
    public void removeUserFromSchool(User user, School school) throws UserException {
        usersSchoolDAO.removeUserFromSchool(user, school);
    }

    @Override
    public User compareLogins(String username, String password) throws UserException {
        return userDAO.compareLogins(username, password);
    }

    @Override
    public List<User> getAllUsers() throws UserException {
        return userDAO.getAllUsers();
    }

    @Override
    public List<User> getAllAdmins() throws UserException {
        return userDAO.getAllAdmins();
    }

    @Override
    public List<User> getAllAdminsFromOneSchool(int schoolId) throws UserException {
        return userDAO.getAllAdminsFromOneSchool(schoolId);
    }

    @Override
    public List<User> getAllStudentsFromOneSchool(int schoolId) throws UserException {
        return userDAO.getAllStudentsFromOneSchool(schoolId);
    }

    @Override
    public List<User> getAllTeacherFromOneSchool(int schoolId) throws UserException {
        return userDAO.getAllTeachersFromOneSchool(schoolId);
    }

    @Override
    public User createAdmin(String firstName, String lastName, String loginName, String password) throws UserException {
        return userDAO.createAdmin(firstName, lastName, loginName,password);
    }

    @Override
    public User createTeacher(String firstName, String lastName, String loginName, String password) throws UserException {
        return userDAO.createTeacher( firstName,  lastName,  loginName,  password);
    }

    @Override
    public User createStudent(String firstName, String lastName, String loginName, String password) throws UserException {
        return userDAO.createStudent(firstName,  lastName,  loginName,  password);
    }

    @Override
    public void deleteUser(User user) throws UserException {
        userDAO.deleteUser(user);
    }

    @Override
    public void updateUser(User user) throws UserException {
        userDAO.updateUser(user);
    }

    @Override
    public List<School> getAllSchools() throws UserException {
        return schoolDAO.getAllSchools();
    }

    @Override
    public School createSchool(String name, String city) throws UserException {
        return schoolDAO.createSchool(name, city);
    }

    @Override
    public void deleteSchool(School school) throws UserException {
        schoolDAO.deleteSchool(school);
    }

    @Override
    public void updateSchool(School school) throws UserException {
        schoolDAO.updateSchool(school);
    }

    @Override
    public School getSchoolById(int schoolId) throws UserException {
        return schoolDAO.getSchoolById(schoolId);
    }

    @Override
    public List<HealthConditions> getHealthCondition(int idCitizen) throws UserException {
        return healthConditionsDAO.getHealthCondition(idCitizen);
    }

    @Override
    public void updateHealthConditions(HealthConditions healthConditions) throws UserException {
        healthConditionsDAO.updateHealthConditions(healthConditions);
    }

    @Override
    public HealthConditions createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl, String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws UserException {
        return healthConditionsDAO.createHealthCondition(SaveAs, ProfessNote, CurrAssess, ExpectedLvl, FollUpDate, ObservNote, TypeOfCase, Citizen);
    }

    @Override
    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws UserException {
        return generalInformationDAO.getGeneralInfo(idGeneralInfo);
    }

    @Override
    public GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits, String educationJob, String lifeStory, String healthInfo, String assistiveDevices, String interiorOfDwelling, String network, int citizenId) throws UserException {
        return generalInformationDAO.createGeneralInfo(mastery, motivation, resources, roller, habits, educationJob, lifeStory, healthInfo, assistiveDevices, interiorOfDwelling, network, citizenId);
    }

    @Override
    public void updateGeneralInfo(GeneralInfo generalInfo) throws UserException {
        generalInformationDAO.updateGeneralInfo(generalInfo);
    }

    @Override
    public List<GeneralInfo> getAllGeneralInfo() throws UserException {
        return generalInformationDAO.getAllGeneralInfo();
    }

    @Override
    public List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws UserException {
        return functionalityStateDAO.getCitizenFunctionalityState(idCitizen);
    }

    @Override
    public void updateFunctionalityState(FunctionalityState functionalityState) throws UserException {
        functionalityStateDAO.updateFunctionalityState(functionalityState);
    }

    @Override
    public FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String saveAs, int functionalityType, int citizen) throws UserException {
        return functionalityStateDAO.createFunctionalityState(currLvl, expectedLvl, professNote, saveAs, functionalityType, citizen);
    }

    @Override
    public List<CitizensAssessment> getCitizenAssessment(int idCitizen) throws UserException {
        return citizensAssessmentDAO.getCitizenAssessment(idCitizen);
    }

    @Override
    public void updateCitizenAssessment(CitizensAssessment citizensAssessment) throws UserException {
        citizensAssessmentDAO.updateCitizenAssessment(citizensAssessment);
    }

    @Override
    public CitizensAssessment createCitizensAssessment(String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) throws UserException {
        return citizensAssessmentDAO.createCitizensAssessment(performance, importance, citizWishes, follUpDate, observNote, functionalityType, citizen);
    }

    @Override
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws UserException {
        return citizenDAO.getAllCitizenFromOneSchool(schoolId);
    }

    @Override
    public void updateCitizen(Citizen citizen) throws UserException {
        citizenDAO.updateCitizen(citizen);
    }

    @Override
    public void deleteCitizen(Citizen citizen) throws UserException {
        citizenDAO.deleteCitizen(citizen);
    }

    @Override
    public Citizen createCitizen(String fName, String lName, int school) throws UserException {
        return citizenDAO.createCitizen(fName, lName, school);
    }

    @Override
    public Citizen getCitizenById(int citizenId) throws UserException {
        return citizenDAO.getCitizenById(citizenId);
    }


    public void addCitizenToStudent(Student student, Citizen citizen) throws UserException{
        studentCitizenDAO.addCitizenToStudent(student, citizen);
    }

    public void removeCitizenFromStudent(User student, Citizen citizen) throws UserException{
        studentCitizenDAO.removeCitizenFromStudent(student, citizen);
    }

    public List<Citizen> getStudentCitizens(int studentId) throws UserException{
        return studentCitizenDAO.getStudentCitizens(studentId);
    }


}
