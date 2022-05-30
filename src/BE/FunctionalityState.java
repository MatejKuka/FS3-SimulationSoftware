package BE;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FunctionalityState {
    private int id;
    private IntegerProperty currLvl = new SimpleIntegerProperty();
    private IntegerProperty expectedLvl = new SimpleIntegerProperty();
    private StringProperty professNote = new SimpleStringProperty();
    private StringProperty saveAs = new SimpleStringProperty();
    private int functionalityType;
    private int citizen;

    public FunctionalityState(int id, int currLvl, int expectedLvl, String professNote, String saveAs, int functionalityType, int citizen) {
        this.id = id;
        setCurrLvl(currLvl);
        setExpectedLvl(expectedLvl);
        setProfessNote(professNote);
        setSaveAs(saveAs);
        this.functionalityType = functionalityType;
        this.citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public int getCurrLvl() {
        return currLvl.get();
    }

    public int getExpectedLvl() {
        return expectedLvl.get();
    }

    public String getProfessNote() {
        return professNote.get();
    }

    public String getSaveAs() {
        return saveAs.get();
    }

    public int getFunctionalityType() {
        return functionalityType;
    }

    public int getCitizen() {
        return citizen;
    }

    public void setCurrLvl(int currLvl) {
        this.currLvl.set(currLvl);
    }

    public void setExpectedLvl(int expectedLvl) {
        this.expectedLvl.set(expectedLvl);
    }

    public void setProfessNote(String professNote) {
        this.professNote.set(professNote);
    }

    public void setSaveAs(String saveAs) {
        this.saveAs.set(saveAs);
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
