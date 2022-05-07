package BE;

public class HealthConditionsAnsw {
    private int id;
    private String SaveAs;
    private String ProfessNote;
    private String CurrAssess;
    private String ExpectedLvl;
    private String FollUpDate;
    private String ObservNote;
    private int TypeOfCase;
    private int Citizen;

    public HealthConditionsAnsw(int id, String saveAs, String professNote, String currAssess, String expectedLvl, String follUpDate, String observNote, int typeOfCase, int citizen) {
        this.id = id;
        SaveAs = saveAs;
        ProfessNote = professNote;
        CurrAssess = currAssess;
        ExpectedLvl = expectedLvl;
        FollUpDate = follUpDate;
        ObservNote = observNote;
        TypeOfCase = typeOfCase;
        Citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public String getSaveAs() {
        return SaveAs;
    }

    public String getProfessNote() {
        return ProfessNote;
    }

    public String getCurrAssess() {
        return CurrAssess;
    }

    public String getExpectedLvl() {
        return ExpectedLvl;
    }

    public String getFollUpDate() {
        return FollUpDate;
    }

    public String getObservNote() {
        return ObservNote;
    }

    public int getTypeOfCase() {
        return TypeOfCase;
    }

    public int getCitizen() {
        return Citizen;
    }
}
