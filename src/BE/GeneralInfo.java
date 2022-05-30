package BE;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GeneralInfo {
    private int id;
    private StringProperty mastery = new SimpleStringProperty();
    private StringProperty motivation = new SimpleStringProperty();
    private StringProperty resources = new SimpleStringProperty();
    private StringProperty roller = new SimpleStringProperty();
    private StringProperty habits = new SimpleStringProperty();
    private StringProperty educationJob = new SimpleStringProperty();
    private StringProperty lifeStory = new SimpleStringProperty();
    private StringProperty healthInfo = new SimpleStringProperty();
    private StringProperty assistiveDevices = new SimpleStringProperty();
    private StringProperty interiorOfDwelling = new SimpleStringProperty();
    private StringProperty network;
    private int citizen;

    public GeneralInfo(int id, String mastery, String motivation, String resources, String roller, String habits,
                       String educationJob, String lifeStory, String healthInfo, String assistiveDevices,
                       String interiorOfDwelling, String network, int citizen) {
        this.id = id;
        setMastery(mastery);
        setMotivation(motivation);
        setResources(resources);
        setRoller(roller);
        setHabits(habits);
        setEducationJob(educationJob);
        setLifeStory(lifeStory);
        setHealthInfo(healthInfo);
        setAssistiveDevices(assistiveDevices);
        setInteriorOfDwelling(interiorOfDwelling);
        setNetwork(network);
        this.citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public String getMastery() {
        return mastery.get();
    }

    public String getMotivation() {
        return motivation.get();
    }

    public String getResources() {
        return resources.get();
    }

    public String getRoller() {
        return roller.get();
    }

    public String getHabits() {
        return habits.get();
    }

    public String getEducationJob() {
        return educationJob.get();
    }

    public String getLifeStory() {
        return lifeStory.get();
    }

    public String getHealthInfo() {
        return healthInfo.get();
    }

    public String getAssistiveDevices() {
        return assistiveDevices.get();
    }

    public String getInteriorOfDwelling() {
        return interiorOfDwelling.get();
    }

    public String getNetwork() {
        return network.get();
    }

    public int getCitizen() { return citizen;}

    public void setMastery(String mastery) {
        this.mastery.set(mastery);
    }

    public void setMotivation(String motivation) {
        this.motivation.set(motivation);
    }

    public void setResources(String resources) {
        this.resources.set(resources);
    }

    public void setRoller(String roller) {
        this.roller.set(roller);
    }

    public void setHabits(String habits) {
        this.habits.set(habits);
    }

    public void setEducationJob(String educationJob) {
        this.educationJob.set(educationJob);
    }

    public void setLifeStory(String lifeStory) {
        this.lifeStory.set(lifeStory);
    }

    public void setHealthInfo(String healthInfo) {
        this.healthInfo.set(healthInfo);
    }

    public void setAssistiveDevices(String assistiveDevices) {
        this.assistiveDevices.set(assistiveDevices);
    }

    public void setInteriorOfDwelling(String interiorOfDwelling) {
        this.interiorOfDwelling.set(interiorOfDwelling);
    }

    public void setNetwork(String network) {
        this.network.set(network);
    }

    @Override
    public String toString() {
        return "GeneralInfo " +
                "id=" + id +
                ", mastery='" + mastery +
                ", motivation='" + motivation +
                ", resources='" + resources +
                ", roller='" + roller +
                ", habits='" + habits +
                ", educationJob='" + educationJob +
                ", lifeStory='" + lifeStory +
                ", healthInfo='" + healthInfo +
                ", assistiveDevices='" + assistiveDevices +
                ", interiorOfDwelling='" + interiorOfDwelling +
                ", network='" + network;
    }
}
