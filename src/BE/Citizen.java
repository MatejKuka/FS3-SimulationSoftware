package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Citizen {
    private int id;
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private int school;

    public Citizen(int id, String firstName, String lastName, int school) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        this.school = school;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public String getLastName() {
        return lastName.get();
    }

    public int getSchool() {
        return school;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", fName='" + firstName +
                ", lName='" + lastName +
                ", school=" + school;
    }
}
