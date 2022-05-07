package BE;

public class Student extends User {

    public Student(int userID, String firstName, String lastName, String loginName, String password, int roleID) {
        super(userID, firstName, lastName, loginName, password, roleID);
//        roleID = 3
    }
}
