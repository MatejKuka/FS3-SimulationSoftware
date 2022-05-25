package BLL.facadeBLL;

import BE.*;

import java.util.List;

public interface IFacadeBLL {

    //LoginManager
    User compareLogins(String username, String password) throws Exception;
    int returnUsersSchoolID(User user) throws Exception;
    User createStudent(String firstName, String lastName, String loginName, String password) throws Exception;
    void deleteUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
    User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception;
    User createTeacher(String firstName, String lastName, String loginName, String password) throws Exception;


    //User
    List<User> getAllStudentsFromOneSchool(int schoolId) throws Exception;
    List<User> getAllUsers() throws Exception;
    List<User> getAllAdmins() throws Exception;
    List<User> getAllAdminsFromOneSchool(int schoolId) throws Exception;
    List<User> getAllTeacherFromOneSchool(int schoolId) throws Exception;


    //CitizenManager
    List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception;


    //GeerInfoManager
    GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception;
    GeneralInfo createGeneralInfo(String mastery, String motivation, String resources, String roller, String habits,
                                  String educationJob, String lifeStory, String healthInfo, String assistiveDevices,
                                  String interiorOfDwelling, String network, int citizenId) throws Exception;
List<GeneralInfo> getAllGeneralInfo() throws Exception;



    List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws Exception;

    //Citizen
    void updateCitizen(Citizen citizen) throws Exception;
    void deleteCitizen(Citizen citizen) throws Exception;
    Citizen createCitizen(String fName, String lName, int school) throws Exception;
    Citizen getCitizenById(int citizenId) throws Exception;

    //School
    List<School> getAllSchools() throws Exception;
    School createSchool(String name, String city) throws Exception;
    void deleteSchool(School school) throws Exception;
    void updateSchool(School school) throws Exception;

    void addUserToSchool(User user, School school) throws Exception;
    void removeUserFromSchool(User user, School school) throws Exception;

    School getSchoolById(int schoolId) throws Exception;

}
