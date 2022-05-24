package BE;

public class Citizen {
    private int id;
    private String firstName;
    private String lastName;
    private int school;
    private int generalInfo;

    public Citizen(int id, String firstName, String lastName, int school, int generalInfo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.school = school;
        this.generalInfo = generalInfo;
    }
//    String fName, String lName, int school, int generalInfo
//    public Citizen(String firstName, String lastName, int school, int generalInfo) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.school = school;
//        this.generalInfo = generalInfo;
//    }

    /*public Citizen(int id, String fName, String lName, int school) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.school = school;
    }*/

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSchool() {
        return school;
    }

    public int getGeneralInfo() {
        return generalInfo;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", fName='" + firstName +
                ", lName='" + lastName +
                ", school=" + school +
                ", generalInfo=" + generalInfo;
    }
}
