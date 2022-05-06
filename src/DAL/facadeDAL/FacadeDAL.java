package DAL.facadeDAL;

import BE.School;
import BE.User;

import java.util.List;

public class FacadeDAL implements IFacadeDAL{


    @Override
    public User compareLogins(String username, String password) throws Exception {
        return null;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return null;
    }

    @Override
    public List<User> getAllAdmins() throws Exception {
        return null;
    }

    @Override
    public List<User> getAllStudents() throws Exception {
        return null;
    }

    @Override
    public List<User> getAllTeacher() throws Exception {
        return null;
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
}
