package DAL.facadeDAL;

import BE.Citizen;
import BE.School;
import BE.User;
import DAL.CitizenDAO;
import DAL.UserDAO;

import java.io.IOException;
import java.util.List;

public class FacadeDAL implements IFacadeDAL{
    UserDAO userDAO;
    CitizenDAO citizenDAO;

    public FacadeDAL() throws IOException {
        userDAO = new UserDAO();
        citizenDAO = new CitizenDAO();
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
    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        return citizenDAO.getAllCitizenFromOneSchool(schoolId);
    }


}
