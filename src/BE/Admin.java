package BE;

public class Admin extends User{

    String firstName;
    String lastName;


    public Admin(int UserID, String loginName, String password, String mail, int roleID, String firstName, String lastName) {
        super(UserID, loginName, password, mail, roleID);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
