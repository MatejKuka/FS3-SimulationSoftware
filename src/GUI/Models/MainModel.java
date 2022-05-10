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


    public MainModel() throws IOException {
        manager = new FacadeBLL();
        students = FXCollections.observableArrayList();
        admins = FXCollections.observableArrayList();
        teachers = FXCollections.observableArrayList();
        users = FXCollections.observableArrayList();
        citizensBySchool = FXCollections.observableArrayList();
        functionalityStates = FXCollections.observableArrayList();
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
        ObservableList<User> userObservableList = FXCollections.observableArrayList();

        if (roleID == 1) userObservableList.setAll(getAllAdmins());
            else if (idRole == 2) userObservableList.setAll(getAllTeacher());
            else if (idRole == 3)userObservableList.setAll(getAllStudents());

        return userObservableList;
    }

    public void changeRoleId(int number){
        idRole = number;
    }

    public int getRoleId(){
        return idRole;
    }

    public void changeRoleName(int roleID){
        if (roleID == 1) nameRole = "Admins";
        else if (idRole == 2) nameRole = "Teachers";
        else if (idRole == 3) nameRole = "Students";
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
}
