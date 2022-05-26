package BLL.facadeBLL;

import BE.*;
import BLL.exeptions.UserException;

import java.util.List;

public interface IFacadeBLL {

    //LoginManager
    User compareLogins(String username, String password) throws UserException;
    int returnUsersSchoolID(User user) throws UserException;
    User createStudent(String firstName, String lastName, String loginName, String password) throws UserException;
    void deleteUser(User user) throws UserException;
    void updateUser(User user) throws UserException;
    User createAdmin(String firstName, String lastName, String loginName, String password) throws UserException;
    User createTeacher(String firstName, String lastName, String loginName, String password) throws UserException;


    //User
    List<User> getAllStudentsFromOneSchool(int schoolId) throws UserException;
    List<User> getAllUsers() throws UserException;
    List<User> getAllAdmins() throws UserException;
    List<User> getAllAdminsFromOneSchool(int schoolId) throws UserException;
    List<User> getAllTeacherFromOneSchool(int schoolId) throws UserException;

    //CitizenManager
    List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws UserException;
    void addCitizenToStudent(Student student, Citizen citizen) throws UserException;
    void removeCitizenFromStudent(User student, Citizen citizen) throws UserException;
    List<Citizen> getStudentCitizens(int studentId) throws UserException;

    //GeerInfoManager
    GeneralInfo getGeneralInfo(int idGeneralInfo) throws UserException;
    GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits,
                                  String educationJob, String lifeStory, String healthInfo, String assistiveDevices,
                                  String interiorOfDwelling, String network, int citizenId) throws UserException;
    List<GeneralInfo> getAllGeneralInfo() throws UserException;
    void updateGeneralInfo(GeneralInfo generalInfo) throws UserException;
    List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws UserException;

    //Citizen
    void updateCitizen(Citizen citizen) throws UserException;
    void deleteCitizen(Citizen citizen) throws UserException;
    Citizen createCitizen(String fName, String lName, int school) throws UserException;
    Citizen getCitizenById(int citizenId) throws UserException;

    //School
    List<School> getAllSchools() throws UserException;
    School createSchool(String name, String city) throws UserException;
    void deleteSchool(School school) throws UserException;
    void updateSchool(School school) throws UserException;
    void addUserToSchool(User user, School school) throws UserException;
    void removeUserFromSchool(User user, School school) throws UserException;
    School getSchoolById(int schoolId) throws UserException;

    List<HealthConditions> getHealthCondition(int idCitizen) throws UserException;
    void updateHealthConditions(HealthConditions healthConditions) throws UserException;
    HealthConditions createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl,
                                           String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws UserException;

    void updateFunctionalityState(FunctionalityState functionalityState) throws UserException;

    List<CitizensAssessment> getCitizenAssessmentById(int id) throws UserException;
    CitizensAssessment createCitizensAssessment(String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) throws UserException;

    FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String saveAs, int functionalityType, int citizen) throws UserException;

}
