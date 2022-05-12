package GUI.Models;

import BE.Citizen;
import BE.FunctionalityState;
import BE.GeneralInfo;
import BE.User;
import BLL.facadeBLL.FacadeBLL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class MainModel {

    private static int idRole;
    private static int currentSchoolId;
    public static User currrentUser;
    private static String nameRole;
    ObservableList<User> students;
    ObservableList<User> teachers;
    ObservableList<User> admins;
    ObservableList<User> users;
    ObservableList<FunctionalityState> functionalityStates;
    ObservableList<Citizen> citizensBySchool;
    FacadeBLL manager;
    ObservableList<User> userObservableList;


    public MainModel() throws IOException {
        manager = new FacadeBLL();
        students = FXCollections.observableArrayList();
        admins = FXCollections.observableArrayList();
        teachers = FXCollections.observableArrayList();
        users = FXCollections.observableArrayList();
        citizensBySchool = FXCollections.observableArrayList();
        functionalityStates = FXCollections.observableArrayList();
        userObservableList = FXCollections.observableArrayList();

    }

    public User compareLogins(String username, String password) throws Exception {
        return manager.compareLogins(username, password);
    }

    public ObservableList<User> getAllStudents() throws Exception {
        students.setAll(manager.getAllStudents());
        return students;
    }

    public ObservableList<User> getAllUsers() throws Exception {
        users.setAll(manager.getAllUsers());
        return users;
    }

    public ObservableList<User> getAllAdmins() throws Exception {
        admins.setAll(manager.getAllAdmins());
        return admins;
    }

    public ObservableList<User> getAllTeacher() throws Exception {
        teachers.setAll(manager.getAllTeacher());
        return teachers;
    }


    public ObservableList<User> getUsersByRole(int roleID) throws Exception {

        if (roleID == 1) userObservableList.setAll(getAllAdmins());
            else if (roleID == 2) userObservableList.setAll(getAllTeacher());
            else if (roleID == 3) userObservableList.setAll(getAllStudents());

        return userObservableList;
    }

    public void deleteUser(User user) throws Exception {
        //manager.deleteUser(user);
        userObservableList.remove(user);
        System.out.println("user is deleted: " + user);
        System.out.println(userObservableList);
    }

    public void updateUser(User user) throws Exception {
        manager.updateUser(user);
    }





    public void changeRoleId(int number){
        idRole = number;
    }

    public int getRoleId(){
        return idRole;
    }

    public void changeRoleName(int roleID){
        if (roleID == 1) nameRole = "Admins";
        else if (roleID == 2) nameRole = "Teachers";
        else if (roleID == 3) nameRole = "Students";
    }

    public String getRoleName() {
        return nameRole;
    }

    public List<Citizen> getAllCitizenFromOneSchool(int schoolId) throws Exception {
        citizensBySchool.setAll(manager.getAllCitizenFromOneSchool(schoolId));
        return citizensBySchool;
    }

    public User setCurrentUser(User user){
        currrentUser = user;
        System.out.println("Current user: " + currrentUser);
        return currrentUser;
    }

    public User getCurrentUser(){
        return currrentUser;
    }

    public int setCurrentSchoolId(User user) throws Exception {
        currentSchoolId = returnUsersSchoolID(user);
        System.out.println("Id of the current school:" + currentSchoolId);
        return currentSchoolId;
    }

    public int getCurrentSchoolId(){
        return currentSchoolId;
    }

    public int returnUsersSchoolID(User user) throws Exception {
        return manager.returnUsersSchoolID(user);
    } // TODO Matej - all these methods for setting something(school, currentUser,...) can be easily put in facade or in one method

    public GeneralInfo getGeneralInfo(int idGeneralInfo) throws Exception {
        return manager.getGeneralInfo(idGeneralInfo);
    }

    public ObservableList<FunctionalityState> getCitizenFunctionalityState(int idCitizen) throws Exception{
        functionalityStates.setAll(manager.getCitizenFunctionalityState(idCitizen));
        return functionalityStates;
    }

    public User createStudent(String firstName, String lastName, String loginName, String password) throws Exception {
        return manager.createStudent(firstName, lastName, loginName, password);
    }


    public User createAdmin(String firstName, String lastName, String loginName, String password) throws Exception {
        return manager.createAdmin(firstName, lastName, loginName, password);
    }
    public User createTeacher(String firstName, String lastName, String loginName, String password) throws Exception {
        return manager.createTeacher(firstName, lastName, loginName, password);
    }

} //TODO Matej - I need to delete a user from observable list
