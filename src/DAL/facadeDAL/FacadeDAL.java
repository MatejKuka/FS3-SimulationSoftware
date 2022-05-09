package DAL.facadeDAL;

import BE.Citizen;
import BE.GeneralInfo;
import BE.School;
import BE.User;
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
    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception {
        return generalInformationDAO.getGeneralInfo(idGeneralInfo);
    }

    @Override
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        return citizenDAO.getAllCitizenFromOneSchool(schoolId);
    }


}
