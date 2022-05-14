package BE;

public class Teacher extends User{

    public Teacher(int userID, String firstName, String lastName, String loginName, String password, int roleID) {
        super(userID, firstName, lastName, loginName, password, roleID);
        //roleID = 1;
    }

    @Override
    public String toString() {
        return super.toString() + " TEACHER";
    }
}
