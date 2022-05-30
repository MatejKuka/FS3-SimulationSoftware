package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class School {
    private int id;
    private StringProperty name = new SimpleStringProperty();
    private StringProperty city = new SimpleStringProperty();

    public School(int id, String name, String city) {
        this.id = id;
        setName(name);
        setCity(city);
    }

    public School(String name, String city) {
        setName(name);
        setCity(city);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public String getCity() {
        return city.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name +
                ", city='" + city;
    }
}
