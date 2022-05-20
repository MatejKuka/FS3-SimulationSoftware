package BLL.facadeBLL;

import BE.Citizen;
import BE.FunctionalityState;
import BE.GeneralInfo;
import BE.User;

import java.util.List;

public interface IFacadeBLL {

    //UserManager
    User compareLogins(String username, String password) throws Exception;
    int returnUsersSchoolID(User user) throws Exception;
    User createStudent(String firstName, String lastName, String loginName, String password, int schoolId) throws Exception;
    void deleteUser(User user) throws Exception;
    void updateUser(User user) throws Exception;
    User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception;
    User createTeacher(String firstName, String lastName, String loginName, String password, int schoolId) throws Exception;


    List<User> getAllStudents(int schoolId) throws Exception;
    List<User> getAllUsers() throws Exception;
    List<User> getAllAdmins() throws Exception;
    List<User> getAllTeacher(int schoolId) throws Exception;


    //CitizenManager
    List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception;


    //GeerInfoManager
    GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception;

    List<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws Exception;

    void updateCitizen(Citizen citizen) throws Exception;
    void deleteCitizen(Citizen citizen, int generalInfoIdOfCitizen) throws Exception;
    Citizen createCitizen(String fName, String lName, int school, int generalInfo) throws Exception;


}
