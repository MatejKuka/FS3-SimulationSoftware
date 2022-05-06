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

    public GeneralInfo(int id, String mastery, String motivation, String resources, String roller, String habits,
                       String educationJob, String lifeStory, String healthInfo, String assistiveDevices,
                       String interiorOfDwelling, String network) {
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
}
