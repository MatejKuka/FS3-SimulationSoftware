package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CitizensAssessment {
    private int id;
    private StringProperty Performance = new SimpleStringProperty();
    private StringProperty Importance = new SimpleStringProperty();
    private StringProperty CitizWishes = new SimpleStringProperty();
    private StringProperty FollUpDate = new SimpleStringProperty();
    private StringProperty ObservNote = new SimpleStringProperty();
    private int FunctionalityType;
    private int Citizen;

    public CitizensAssessment(int id, String performance, String importance, String citizWishes, String follUpDate, String observNote, int functionalityType, int citizen) {
        this.id = id;
        setPerformance(performance);
        setImportance(importance);
        setCitizWishes(citizWishes);
        setFollUpDate(follUpDate);
        setObservNote(observNote);
        FunctionalityType = functionalityType;
        Citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public String getPerformance() {
        return Performance.get();
    }

    public String getImportance() {
        return Importance.get();
    }

    public String getCitizWishes() {
        return CitizWishes.get();
    }

    public String getFollUpDate() {
        return FollUpDate.get();
    }

    public String getObservNote() {
        return ObservNote.get();
    }

    public int getFunctionalityType() {
        return FunctionalityType;
    }

    public int getCitizen() {
        return Citizen;
    }

    public void setPerformance(String performance) {
        this.Performance.set(performance);
    }

    public void setImportance(String importance) {
        this.Importance.set(importance);
    }

    public void setCitizWishes(String citizWishes) {
        this.CitizWishes.set(citizWishes);
    }

    public void setFollUpDate(String follUpDate) {
        this.FollUpDate.set(follUpDate);
    }

    public void setObservNote(String observNote) {
        this.ObservNote.set(observNote);
    }

    @Override
    public String toString() {
        return  "Id=" + id +
                ", Performance=" + Performance +
                ", Importance=" + Importance +
                ", CitizenWishes='" + CitizWishes +
                ", FollUpDate='" + FollUpDate +
                ", ObservNote=" + ObservNote +
                ", FunctionalityType=" + FunctionalityType +
                ", Citizen=" + Citizen;
    }
}
