package DAL.facadeDAL;

import BE.*;
import DAL.*;

import java.io.IOException;
import java.util.List;

public class FacadeDAL implements IFacadeDAL{
    UserDAO userDAO;
    CitizenDAO citizenDAO;
    UsersSchoolDAO usersSchoolDAO;
    GeneralInformationDAO generalInformationDAO;

    public FacadeDAL() throws IOException {
        userDAO = new UserDAO();
        citizenDAO = new CitizenDAO();
        usersSchoolDAO = new UsersSchoolDAO();
        generalInformationDAO = new GeneralInformationDAO();
    }


    @Override
    public int returnUsersSchoolID(User user) throws Exception {
        return usersSchoolDAO.returnUsersSchoolID(user);
    }

    @Override
    public void addUserToSchool(User user, School school) throws Exception {
        
    }

    @Override
    public void removeUserFromSchool(User user, School school) throws Exception {

    }

    @Override
    public User compareLogins(String username, String password) throws Exception {
        return userDAO.compareLogins(username, password);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return userDAO.getAllUsers();
    }

    @Override
    public List<User> getAllAdmins() throws Exception {
        return userDAO.getAllAdmins();
    }

    @Override
    public List<User> getAllStudents() throws Exception {
        return userDAO.getAllStudents();
    }

    @Override
    public List<User> getAllTeacher() throws Exception {
        return userDAO.getAllTeachers();
    }

    @Override
    public User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception {
        return null;
    }

    @Override
    public User createTeacher(String firstName, String lastName, String loginName, String password) throws Exception {
        return null;
    }

    @Override
    public User createStudent(String firstName, String lastName, String loginName, String password) throws Exception {
        return null;
    }

    @Override
    public void deleteUser(User user) throws Exception {

    }

    @Override
    public void updateUser(User user) throws Exception {

    }

    @Override
    public void addStudentToTeacher(User student, User teacher) throws Exception {

    }

    @Override
    public void removeStudentFromTeacher(User student, User teacher) throws Exception {

    }

    @Override
    public List<School> getAllCustomers() throws Exception {
        return null;
    }

    @Override
    public School createSchool(String name, String city) throws Exception {
        return null;
    }

    @Override
    public void deleteSchool(School school) throws Exception {

    }

    @Override
    public void updateSchool(School school) throws Exception {

    }

    @Override
    public List<HealthConditions> getHealthCondition(int idCitizen) throws Exception {
        return null;
    }

    @Override
    public void updateHealthConditions(HealthConditions healthConditions) throws Exception {

    }

    @Override
    public HealthConditions createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl, String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws Exception {
        return null;
    }

    @Override
    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception {
        return generalInformationDAO.getGeneralInfo(idGeneralInfo);
    }

    @Override
    public GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits, String educationJob, String lifeStory, String healthInfo, String assistiveDevices, String interiorOfDwelling, String network) throws Exception {
        return null;
    }

    @Override
    public void updateGeneralInfo(GeneralInfo generalInfo) throws Exception {

    }

    @Override
    public List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws Exception {
        return null;
    }

    @Override
    public void updateFunctionalityState(FunctionalityState functionalityState) throws Exception {

    }

    @Override
    public FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String follUpDate, int functionalityType, int citizen) throws Exception {
        return null;
    }

    @Override
    public List<CitizensAssessment> getCitizenAssessment(int idCitizen) throws Exception {
        return null;
    }

    @Override
    public void updateCitizenAssessment(CitizensAssessment citizensAssessment) throws Exception {

    }

    @Override
    public CitizensAssessment createCitizensAssessment(String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) throws Exception {
        return null;
    }

    @Override
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        return citizenDAO.getAllCitizenFromOneSchool(schoolId);
    }

    @Override
    public void updateCitizen(Citizen citizen) throws Exception {

    }

    @Override
    public void deleteCitizen(Citizen citizen, int generalInfoIdOfCitizen) throws Exception {

    }

    @Override
    public Citizen createCitizen(String fName, String lName, int school, int generalInfo) throws Exception {
        return null;
    }


}
