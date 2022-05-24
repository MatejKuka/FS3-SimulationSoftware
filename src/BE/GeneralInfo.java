package BE;

public class GeneralInfo {
    private int id;
    private String mastery;
    private String motivation;
    private String resources;
    private String roller;
    private String habits;
    private String educationJob;
    private String lifeStory;
    private String healthInfo;
    private String assistiveDevices;
    private String interiorOfDwelling;
    private String network;
    private int citizen;

    public GeneralInfo(int id, String mastery, String motivation, String resources, String roller, String habits,
                       String educationJob, String lifeStory, String healthInfo, String assistiveDevices,
                       String interiorOfDwelling, String network, int citizen) {
        this.id = id;
        this.mastery = mastery;
        this.motivation = motivation;
        this.resources = resources;
        this.roller = roller;
        this.habits = habits;
        this.educationJob = educationJob;
        this.lifeStory = lifeStory;
        this.healthInfo = healthInfo;
        this.assistiveDevices = assistiveDevices;
        this.interiorOfDwelling = interiorOfDwelling;
        this.network = network;
        this.citizen = citizen;
    }

    public int getId() {
        return id;
    }

    public String getMastery() {
        return mastery;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getResources() {
        return resources;
    }

    public String getRoller() {
        return roller;
    }

    public String getHabits() {
        return habits;
    }

    public String getEducationJob() {
        return educationJob;
    }

    public String getLifeStory() {
        return lifeStory;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public String getAssistiveDevices() {
        return assistiveDevices;
    }

    public String getInteriorOfDwelling() {
        return interiorOfDwelling;
    }

    public String getNetwork() {
        return network;
    }

    public int getCitizen() { return citizen;}

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
