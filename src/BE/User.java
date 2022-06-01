package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class User {
    private int userID;
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty loginName = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private final int roleID;

    public User(int userID, String loginName, String password, int roleID) {
        setLoginName(loginName);
        setPassword(password);
//        this.loginName = loginName;
//        this.password = password;
        this.userID = userID;
        this.roleID = roleID;
    }

    public User(int userID, String firstName, String lastName, String loginName, String password, int roleID) {
        this.userID = userID;
        setFirstName(firstName);
        setLastName(lastName);
        setLoginName(loginName);
        setPassword(password);
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.loginName = loginName;
//        this.password = password;
        this.roleID = roleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getLoginName() {
        return loginName.get();
    }

    public void setLoginName(String loginName) {
        this.loginName.set(loginName);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public int getRoleID() {
        return roleID;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }



    /*@Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", roleID=" + roleID +
                '}';
    }*/
}
