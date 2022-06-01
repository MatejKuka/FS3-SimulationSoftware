package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HealthConditions {
    private int id;
    private StringProperty SaveAs = new SimpleStringProperty();
    private StringProperty ProfessNote = new SimpleStringProperty();
    private StringProperty CurrAssess = new SimpleStringProperty();
    private StringProperty ExpectedLvl = new SimpleStringProperty();
    private StringProperty FollUpDate = new SimpleStringProperty();
    private StringProperty ObservNote = new SimpleStringProperty();
    private int TypeOfCase;
    private int Citizen;

    public HealthConditions(int id, String saveAs, String professNote, String currAssess,
                            String expectedLvl, String follUpDate, String observNote,
                            int typeOfCase, int citizen) {
        this.id = id;
        setSaveAs(saveAs);
        setProfessNote(professNote);
        setCurrAssess(currAssess);
        setExpectedLvl(expectedLvl);
        setFollUpDate(follUpDate);
        setObservNote(observNote);
        TypeOfCase = typeOfCase;
        Citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public String getSaveAs() {
        return SaveAs.get();
    }

    public String getProfessNote() {
        return ProfessNote.get();
    }

    public String getCurrAssess() {
        return CurrAssess.get();
    }

    public String getExpectedLvl() {
        return ExpectedLvl.get();
    }

    public String getFollUpDate() {
        return FollUpDate.get();
    }

    public String getObservNote() {
        return ObservNote.get();
    }

    public int getCitizen() {
        return Citizen;
    }

    public void setSaveAs(String saveAs) {
        this.SaveAs.set(saveAs);
    }

    public void setProfessNote(String professNote) {
        this.ProfessNote.set(professNote);
    }

    public void setCurrAssess(String currAssess) {
        this.CurrAssess.set(currAssess);
    }

    public void setExpectedLvl(String expectedLvl) {
        this.ExpectedLvl.set(expectedLvl);
    }

    public void setFollUpDate(String follUpDate) {
        this.FollUpDate.set(follUpDate);
    }

    public void setObservNote(String observNote) {
        this.ObservNote.set(observNote);
    }

    @Override
    public String toString() {
        return "HealthConditions{" +
                "id=" + id +
                ", SaveAs='" + SaveAs + '\'' +
                ", ProfessNote='" + ProfessNote + '\'' +
                ", CurrAssess='" + CurrAssess + '\'' +
                ", ExpectedLvl='" + ExpectedLvl + '\'' +
                ", FollUpDate='" + FollUpDate + '\'' +
                ", ObservNote='" + ObservNote + '\'' +
                ", TypeOfCase=" + TypeOfCase +
                ", Citizen=" + Citizen +
                '}';
    }
}
