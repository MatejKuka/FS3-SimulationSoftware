package DAL.facadeDAL;

import BE.*;

import java.util.List;

public interface IFacadeDAL {

    //UsersSchoolDAO
    int returnUsersSchoolID(User user) throws Exception;
    void addUserToSchool(User user, School school) throws Exception;
    void removeUserFromSchool(User user, School school) throws Exception;

    //UserDAO
    User compareLogins(String username, String password) throws Exception;
    List<User> getAllUsers() throws Exception;
    List<User> getAllAdmins() throws Exception;
    List<User> getAllStudents(int schoolId) throws Exception;
    List<User> getAllTeacher(int schoolId) throws Exception;
    public User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception;
    public User createTeacher(String firstName, String lastName, String loginName, String password) throws Exception;
    public User createStudent(String firstName, String lastName, String loginName, String password) throws Exception;
    void deleteUser(User user) throws Exception;
    void updateUser(User user) throws Exception;

    //TeacherStudentDAO
    void addStudentToTeacher(Student student, Teacher teacher) throws Exception;
    void removeStudentFromTeacher(Student student, Teacher teacher) throws Exception;
    List<User> getTeacherStudents(int teacherId) throws Exception;


    //SchoolDAO
    List<School> getAllSchools() throws Exception;
    School createSchool(String name, String city) throws Exception;
    void deleteSchool(School school) throws Exception;
    void updateSchool(School school) throws Exception;


    //HealthConditionsDAO
    List<HealthConditions> getHealthCondition(int idCitizen) throws Exception;
    void updateHealthConditions(HealthConditions healthConditions) throws Exception;
    HealthConditions createHealthCondition(String SaveAs, String ProfessNote, String CurrAssess, String ExpectedLvl,
                                           String FollUpDate, String ObservNote, int TypeOfCase, int Citizen) throws Exception;


    //GeneralInformationDAO
    GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception;
    GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits,
                                  String educationJob, String lifeStory, String healthInfo, String assistiveDevices,
                                  String interiorOfDwelling, String network) throws Exception;
    void updateGeneralInfo(GeneralInfo generalInfo) throws Exception;

    //FunctionalityStateDAO
    List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws Exception;
    void updateFunctionalityState(FunctionalityState functionalityState) throws Exception;
    FunctionalityState createFunctionalityState(int currLvl, int expectedLvl, String professNote, String saveAs,
                                                int functionalityType, int citizen) throws Exception;


    //CitizenAssessmentDAO
    List<CitizensAssessment> getCitizenAssessment(int idCitizen) throws Exception;
    void updateCitizenAssessment(CitizensAssessment citizensAssessment) throws Exception;
    CitizensAssessment createCitizensAssessment(String performance, String importance, String citizWishes, String follUpDate,
                                                String observNote, int functionalityType, int citizen) throws Exception;


    //CitizenDAO
    List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception;
    void updateCitizen(Citizen citizen) throws Exception;
    void deleteCitizen(Citizen citizen, int generalInfoIdOfCitizen) throws Exception;
    Citizen createCitizen(String fName, String lName, int school, int generalInfo) throws Exception;

    //StudentCitizenDAO
    void addCitizenToStudent(Student student, Citizen citizen) throws Exception;
    void removeCitizenFromStudent(User student, Citizen citizen) throws Exception;
    List<Citizen> getStudentCitizens(int studentId) throws Exception;
}
