package DAL.facadeDAL;

import BE.*;
import BLL.exeptions.UserException;

import java.util.List;

public interface IFacadeDAL {

    //UsersSchoolDAO
    int returnUsersSchoolID(User user) throws UserException;
    void addUserToSchool(User user, School school) throws UserException;
    void removeUserFromSchool(User user, School school) throws UserException;

    //UserDAO
    User compareLogins(String username, String password) throws UserException;
    List<User> getAllUsers() throws UserException;
    List<User> getAllAdmins() throws UserException;
    List<User> getAllAdminsFromOneSchool(int schoolId) throws UserException;
    List<User> getAllStudentsFromOneSchool(int schoolId) throws UserException;
    List<User> getAllTeacherFromOneSchool(int schoolId) throws UserException;
    User createAdmin(String firstName, String lastName, String loginName, String password) throws UserException;
    User createTeacher(String firstName, String lastName, String loginName, String password) throws UserException;
    User createStudent(String firstName, String lastName, String loginName, String password) throws UserException;
    void deleteUser(int userId) throws UserException;
    void updateUser(int userID, String firstName, String lastName, String loginName, String password) throws UserException;

    //SchoolDAO
    List<School> getAllSchools() throws UserException;
    School createSchool(String name, String city) throws UserException;
    void deleteSchool(School school) throws UserException;
    void updateSchool(School school) throws UserException;
    School getSchoolById(int schoolId) throws UserException;


    //HealthConditionsDAO
    List<HealthConditions> getHealthCondition(int idCitizen) throws UserException;
    void updateHealthConditions(HealthConditions healthConditions) throws UserException;
    HealthConditions createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl,
                                           String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws UserException;


    //GeneralInformationDAO
    GeneralInfo getGeneralInfo(int idGeneralInfo) throws UserException;
    GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits,
                                  String educationJob, String lifeStory, String healthInfo, String assistiveDevices,
                                  String interiorOfDwelling, String network, int citizenId) throws UserException;
    void updateGeneralInfo(GeneralInfo generalInfo) throws UserException;
    List<GeneralInfo> getAllGeneralInfo() throws UserException;

    //FunctionalityStateDAO
    List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws UserException;
    void updateFunctionalityState(FunctionalityState functionalityState) throws UserException;
    FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String saveAs,
                                                int functionalityType, int citizen) throws UserException;


    //CitizenAssessmentDAO
    List<CitizensAssessment> getCitizenAssessment(int idCitizen) throws UserException;
    void updateCitizenAssessment(CitizensAssessment citizensAssessment) throws UserException;
    CitizensAssessment createCitizensAssessment(String performance, String importance, String citizWishes, String follUpDate,
                                                String observNote, int functionalityType, int citizen) throws UserException;


    //CitizenDAO
    List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws UserException;
    void updateCitizen(Citizen citizen) throws UserException;
    void deleteCitizen(Citizen citizen) throws UserException;
    Citizen createCitizen(String fName, String lName, int school) throws UserException;
    Citizen getCitizenById(int citizenId) throws UserException;

    //StudentCitizenDAO
    void addCitizenToStudent(Student student, Citizen citizen) throws UserException;
    void removeCitizenFromStudent(User student, Citizen citizen) throws UserException;
    List<Citizen> getStudentCitizens(int studentId) throws UserException;
}
