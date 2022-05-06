package GUI.Models;

import BE.User;
import BLL.facadeBLL.FacadeBLL;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class MainModel {

    private static int idRole;
    private static String nameRole;
    ObservableList<User> students;
    ObservableList<User> teachers;
    ObservableList<User> admins;
    ObservableList<User> users;
    FacadeBLL manager;

    public MainModel() throws IOException {
        manager = new FacadeBLL();
        students = FXCollections.observableArrayList();
        admins = FXCollections.observableArrayList();
        teachers = FXCollections.observableArrayList();
        users = FXCollections.observableArrayList();

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

        System.out.println(userObservableList);
        return userObservableList;
    }

    public void changeRoleId(int number){
        idRole = number;
        System.out.println("static roleID changed to " + idRole);
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
}
