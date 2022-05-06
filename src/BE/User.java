package BE;

public class User {
    private int userID;
    private String firstName;
    private String lastName;
    private String loginName;
    private String password;
    private int roleID;

    public User(int userID, String loginName, String password, int roleID) {
        this.loginName = loginName;
        this.password = password;
        this.userID = userID;
        this.roleID = roleID;
    }

    public User(int userID, String firstName, String lastName, String loginName, String password, int roleID) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loginName = loginName;
        this.password = password;
        this.roleID = roleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", roleID=" + roleID +
                '}';
    }
}
