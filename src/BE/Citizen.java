package BE;

public class Citizen {
    private final int id;
    private String fName;
    private String lName;
    private int school;
    private int generalInfo;

    public Citizen(int id, String fName, String lNAme, int school, int generalInfo) {
        this.id = id;
        this.fName = fName;
        this.lName = lNAme;
        this.school = school;
        this.generalInfo = generalInfo;
    }

    public Citizen(int id, String fName, String lNAme, int school) {
        this.id = id;
        this.fName = fName;
        this.lName = lNAme;
        this.school = school;
    }

    
}
