package BE;

public class CitizensAssessment {
    private int id;
    private String Performance;
    private String Importance;
    private String CitizWishes;
    private String FollUpDate;
    private String ObservNote;
    private int FunctionalityType;
    private int Citizen;

    public CitizensAssessment(int id, String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) {
        this.id = id;
        Performance = performance;
        Importance = importance;
        CitizWishes = citizWishes;
        FollUpDate = follUpDate;
        ObservNote = observNote;
        FunctionalityType = functionalityType;
        Citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public String getPerformance() {
        return Performance;
    }

    public String getImportance() {
        return Importance;
    }

    public String getCitizWishes() {
        return CitizWishes;
    }

    public String getFollUpDate() {
        return FollUpDate;
    }

    public String getObservNote() {
        return ObservNote;
    }

    public int getFunctionalityType() {
        return FunctionalityType;
    }

    public int getCitizen() {
        return Citizen;
    }
}
