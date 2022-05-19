package BE;

public class FunctionalityState {
    private int id;
    private int currLvl;
    private int expectedLvl;
    private String professNote;
    private String saveAs;
    private int functionalityType;
    private int citizen;

    public FunctionalityState(int id, int currLvl, int expectedLvl, String professNote, String saveAs, int functionalityType, int citizen) {
        this.id = id;
        this.currLvl = currLvl;
        this.expectedLvl = expectedLvl;
        this.professNote = professNote;
        this.saveAs = saveAs;
        this.functionalityType = functionalityType;
        this.citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public int getCurrLvl() {
        return currLvl;
    }

    public int getExpectedLvl() {
        return expectedLvl;
    }

    public String getProfessNote() {
        return professNote;
    }

    public String getSaveAs() {
        return saveAs;
    }

    public int getFunctionalityType() {
        return functionalityType;
    }

    public int getCitizen() {
        return citizen;
    }

    @Override
    public String toString() {
        return  "Id=" + id +
                ", CurrLvl=" + currLvl +
                ", ExpectedLvl=" + expectedLvl +
                ", ProfessNote='" + professNote +
                ", FollUpDate='" + saveAs +
                ", FunctionalityType=" + functionalityType +
                ", Citizen=" + citizen;
    }
}
