package BLL.facadeBLL;

import BE.User;

import java.util.List;

public interface IFacadeBLL {

    //UserManager
    public User compareLogins(String username, String password) throws Exception;


    public List<User> getAllStudents() throws Exception;
    public List<User> getAllUsers() throws Exception;
    public List<User> getAllAdmins() throws Exception;
    public List<User> getAllTeacher() throws Exception;
}
