package DAL.facadeDAL;

import BE.Citizen;
import BE.School;
import BE.User;

import java.util.List;

public interface IFacadeDAL {

    //UsersSchoolDAO


    //UserDAO
    public User compareLogins(String username, String password) throws Exception;
    public List<User> getAllUsers() throws Exception;
    public List<User> getAllAdmins() throws Exception;
    public List<User> getAllStudents() throws Exception;
    public List<User> getAllTeacher() throws Exception;

    //TeacherStudentDAO


    //SchoolDAO
    public List<School> getAllCustomers() throws Exception;
    public School createSchool(String name, String city) throws Exception;
    public void deleteSchool(School school) throws Exception;


    //HealthConditionsDAO


    //GeneralInformationDAO


    //FunctionalityStateDAO


    //CitizenAssessmentDAO


    //CitizenDAO
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception;

}
