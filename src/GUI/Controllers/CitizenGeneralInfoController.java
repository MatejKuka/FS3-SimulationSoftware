package GUI.Controllers;

import BE.Citizen;
import BE.GeneralInfo;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizenGeneralInfoController implements Initializable {
    @FXML
    private VBox mainView;

    private final Label nameLabel = new Label("Label");
    private final Label mainText = new Label(" ");
    private Button editButton;
    private final Button cancelButton = new Button("Cancel");
    private final Button saveButton = new Button("Save");
    private TextArea textArea;

    private final BorderPane buttonPane = new BorderPane();
    private GeneralInfo generalInfo;
    private final HBox hBox = new HBox();
    private boolean isCreated = false;


    // Function, which is passed to get the clicked citizen
    // checking if general info is created if yes then set the general info to be the one that has been found, if it hasn't been found we create
    // new general info with placeholder values
    public void getCitizen(Citizen citizen) throws UserException {
        mainModel.getAllGeneralInfo().forEach(generalInfo1 -> {
            if (citizen.getId() == generalInfo1.getCitizen()) {
                isCreated = true;
                generalInfo = generalInfo1;
            }
        });
        if (!isCreated) {
            String placeholder = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eget magna nisl. Vivamus hendrerit justo pulvinar orci malesuada tincidunt. Sed vitae porttitor leo, eget pellentesque sapien. Mauris porttitor, orci vel convallis pellentesque, eros turpis ullamcorper nibh, eget eleifend lectus turpis fermentum lorem.";
            generalInfo = mainModel.createGeneralInfo(placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, citizen.getId());
        }
    }

    private MainModel mainModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // styling to the buttons and button container
        cancelButton.getStyleClass().addAll("btn-action", "padding");
        saveButton.getStyleClass().addAll("btn-action", "padding");
        hBox.setSpacing(20);
        hBox.getChildren().add(cancelButton);
        hBox.getChildren().add(saveButton);
    }

    //setting view depending on which button has been clicked
    @FXML
    void toAssistDevSec() {
        setupViewChange("Assistive devices", generalInfo.getAssistiveDevices(), "assistiveDevices", "Equipment, products and technology such as used by the citizen in daily activities, incl. such as are customized or specially made for, implanted in,located on or near the person who apply them. (Incl. Regular objects and aids and technology for personal use).");
    }

    @FXML
    void toDwelSec() {
        setupViewChange("Interior of dwelling", generalInfo.getInteriorOfDwelling(), "dwelling", "A description of the physical environment of the home and environments that matter the citizen's everyday life and ability to function. ");
    }

    @FXML
    void toEduJobSec() {
        setupViewChange("Education/Job", generalInfo.getEducationJob(), "educationJob", "Current or previous educational and / or professional background.Eg primary school, vocational education andHigher Education.");
    }

    @FXML
    void toHabitSec() {
        setupViewChange("Habits", generalInfo.getHabits(), "habits", " Regular behavior that the citizen has learned through constant repetition and execution completely or partially unconsciously.Habits are, for example, the circadian rhythm, the way of becoming accused of, contact with fellow human beings and relationships, way of looking at the world.");
    }

    @FXML
    void toHealthInfoSec() {
        setupViewChange("Health Information", generalInfo.getHealthInfo(), "healthInfo", "Current or past illnesses and disability that matters the situation of the citizen.Health professional contacts:Employee or units within the healthcare system the citizen is affiliated with,eg ophthalmologist, dentist, podiatrist or department / outpatient clinic.");
    }

    @FXML
    void toLifeStorySec() {
        setupViewChange("Life Story", generalInfo.getLifeStory(), "lifeStory", "A description of the citizen's experience of significant events, interests and chores throughout life.\n");
    }

    @FXML
    void toMasterySec() {
        setupViewChange("Mastery", generalInfo.getMastery(), "mastery", "The conscious or unconscious of the citizen management of life / illness - both challenges and opportunities. ");
    }

    @FXML
    void toMotivationSec() {
        setupViewChange("Motivation", generalInfo.getMotivation(), "motivation", " The driving force behind the citizen acting ona certain way or get started with / maintains a task / effort.");
    }

    @FXML
    void toNetworkSec() {
        setupViewChange("Network", generalInfo.getNetwork(), "network", " People who are close to the citizen, and which provides practical and / or emotional support and care towards the citizen. Networking can be public or private.A public network consists of personal helpers, health professionals and others professionals primarily caregivers.Private network is family, relative,friends and acquaintances.");
    }

    @FXML
    void toResourceSec() {
        setupViewChange("Resources", generalInfo.getResources(), "resources", "The physical or mental forces that the citizen to a certain extent has to available and can take advantage of. Physical forces can for example be in the form of physical health and strength. Mental forces can, for example, be inform of mental health and strength,including thoughts and ways of behaving to situations and other people on.");
    }

    @FXML
    void toRollerSec() {
        setupViewChange("Roller", generalInfo.getRoller(), "roller", "The roles that are particularly important for the citizen in relation to family, work and community.");
    }

    private void setupCancelButton(Button editButton) {
        cancelButton.setOnAction(event -> {
            mainView.getChildren().set(2, mainText);
            buttonPane.getChildren().clear();
            buttonPane.setRight(editButton);
        });
    }


    private void setNameLabel(String newTitle) {
        nameLabel.setText(newTitle);
        nameLabel.getStyleClass().add("text-decorated");
    }

    private void clearMainView(String descriptionLabel) {
        mainView.getChildren().clear();
        mainView.getChildren().add(nameLabel);
        mainView.getChildren().add(createLabel(descriptionLabel));
        mainText.setWrapText(true);
        mainView.getChildren().add(mainText);
        mainView.getChildren().add(buttonPane);
        buttonPane.getChildren().clear();
    }

    private void setupViewChange(String label, String mainTextLabel, String updateView, String description) {
        clearMainView(description);
        textArea = new TextArea();
        textArea.getStyleClass().add("custom-textarea");
        textArea.setMinHeight(360);
        editButton = new Button("Edit");
        editButton.getStyleClass().addAll("btn-action", "padding");
        buttonPane.setRight(editButton);
        setNameLabel(label);

        mainText.setText(mainTextLabel);
        editButton.setOnAction(evt -> {
            mainView.getChildren().set(2, textArea);
            buttonPane.getChildren().clear();
            buttonPane.setRight(hBox);
        });

        saveButton.setOnAction(event -> {
            switch (updateView) {
                case "mastery" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), textArea.getText(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "dwelling" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), textArea.getText(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "assistiveDevices" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), textArea.getText(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "educationJob" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), textArea.getText(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "habits" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), textArea.getText(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "healthInfo" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), textArea.getText(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "lifeStory" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), textArea.getText(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "motivation" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), textArea.getText(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "network" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), textArea.getText(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "resources" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), textArea.getText(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                case "roller" -> {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), textArea.getText(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                }
                default -> System.out.println("error");
            }
            mainText.setText(textArea.getText());
            mainView.getChildren().set(2, mainText);
            buttonPane.getChildren().clear();
            buttonPane.setRight(editButton);
        });

        setupCancelButton(editButton);
    }

    private void handleSaveButtonSave(GeneralInfo generalInfo) throws UserException {
        mainModel.updateGeneralInfo(generalInfo);
        this.generalInfo = generalInfo;
    }

    private Label createLabel(String title) {
        return new Label(title);
    }
}
