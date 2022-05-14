package BE;

public class Admin extends User{

    public Admin(int userID, String firstName, String lastName, String loginName, String password, int roleID) {
        super(userID, firstName, lastName, loginName, password, roleID);
//        roleID = 1
    }

    @Override
    public String toString() {
        return super.toString() + " ADMIN";
    }
}
