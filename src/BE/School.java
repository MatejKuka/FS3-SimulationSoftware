package BE;

public class School {
    private int id;
    private String name;
    private String city;

    public School(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public School(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name +
                ", city='" + city;
    }
}
