package BE;

public class FunctionalityState {
    private int Id;
    private int CurrLvl;
    private int ExpectedLvl;
    private String ProfessNote;
    private String FollUpDate;
    private int FunctionalityType;
    private int Citizen;

    public FunctionalityState(int id, int currLvl, int expectedLvl, String professNote, String follUpDate, int functionalityType, int citizen) {
        Id = id;
        CurrLvl = currLvl;
        ExpectedLvl = expectedLvl;
        ProfessNote = professNote;
        FollUpDate = follUpDate;
        FunctionalityType = functionalityType;
        Citizen = citizen;
    }

    public int getId() {
        return Id;
    }

    public int getCurrLvl() {
        return CurrLvl;
    }

    public int getExpectedLvl() {
        return ExpectedLvl;
    }

    public String getProfessNote() {
        return ProfessNote;
    }

    public String getFollUpDate() {
        return FollUpDate;
    }

    public int getFunctionalityType() {
        return FunctionalityType;
    }

    public int getCitizen() {
        return Citizen;
    }

    @Override
    public String toString() {
        return  "Id=" + Id +
                ", CurrLvl=" + CurrLvl +
                ", ExpectedLvl=" + ExpectedLvl +
                ", ProfessNote='" + ProfessNote +
                ", FollUpDate='" + FollUpDate +
                ", FunctionalityType=" + FunctionalityType +
                ", Citizen=" + Citizen;
    }
}
