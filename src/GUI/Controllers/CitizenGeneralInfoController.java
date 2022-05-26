package GUI.Controllers;

import BE.Citizen;
import BE.GeneralInfo;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizenGeneralInfoController implements Initializable {

    @FXML
    private Button btnAssistDevSec;

    @FXML
    private Button btnDwelSec, btnEduJobSec, btnHabitsSec, btnHealtInfoSec, btnLifeStorySec, btnMasterySec, btnMotivationSec, btnNetworkSec, btnResourcesSec, btnRollerSec;

    @FXML
    private VBox mainView;

    private Label nameLabel = new Label("Label");
    private Label descriptionLabel = new Label("---****--TOTO BY SOM UROBIL AKO LEN PLACEHOLDER ---***---");
    private Label mainText = new Label(" ");
    private Button editButton;
    private Button cancelButton = new Button("Cancel");
    private Button saveButton = new Button("Save");
    private TextArea textArea;

    private BorderPane buttonPane = new BorderPane();
    private GeneralInfo generalInfo;
    HBox hBox = new HBox();
    private boolean isCreated = false;
    private Citizen citizen;

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
        this.citizen = citizen;
    }

    private MainModel mainModel;
    private CitizensEditController citizensEditController;

    public void setCitizensEditController(CitizensEditController citizensEditController) {
        this.citizensEditController = citizensEditController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cancelButton.getStyleClass().addAll("btn-action", "padding");
        saveButton.getStyleClass().addAll("btn-action", "padding");
        hBox.setSpacing(20);
        hBox.getChildren().add(cancelButton);
        hBox.getChildren().add(saveButton);
    }

    @FXML
    void toAssistDevSec(ActionEvent event) throws Exception {
        setupViewChange("Assistive devices", generalInfo.getAssistiveDevices(), "assistiveDevices");
    }

    @FXML
    void toDwelSec(ActionEvent event) throws Exception {
        setupViewChange("Interior of dwelling", generalInfo.getInteriorOfDwelling(), "dwelling");
    }

    @FXML
    void toEduJobSec(ActionEvent event) throws Exception {
        setupViewChange("Education/Job", generalInfo.getEducationJob(), "educationJob");
    }

    @FXML
    void toHabitSec(ActionEvent event) throws Exception {
        setupViewChange("Habits", generalInfo.getHabits(), "habits");
    }

    @FXML
    void toHealthInfoSec(ActionEvent event) throws Exception {
        setupViewChange("Health Information", generalInfo.getHealthInfo(), "healthInfo");
    }

    @FXML
    void toLifeStorySec(ActionEvent event) throws Exception {
        setupViewChange("Life Story", generalInfo.getLifeStory(), "lifeStory");
    }

    @FXML
    void toMasterySec(ActionEvent event) throws Exception {
        setupViewChange("Mastery", generalInfo.getMastery(), "mastery");
    }

    @FXML
    void toMotivationSec(ActionEvent event) throws Exception {
        setupViewChange("Motivation", generalInfo.getMotivation(), "motivation");
    }

    @FXML
    void toNetworkSec(ActionEvent event) throws Exception {
        setupViewChange("Network", generalInfo.getNetwork(), "network");
    }

    @FXML
    void toResourceSec(ActionEvent event) throws Exception {
        setupViewChange("Resources", generalInfo.getResources(), "resources");
    }

    @FXML
    void toRollerSec(ActionEvent event) throws Exception {
        setupViewChange("Roller", generalInfo.getRoller(), "roller");
    }

    private void setupCancelButton(Button editButton) {
        cancelButton.setOnAction(event -> {
            mainView.getChildren().set(2, mainText);
            buttonPane.getChildren().clear();
            buttonPane.setRight(editButton);
        });
    }

    //TODO -> setupSaveButton()

    private void setNameLabel(String newTitle) {
        nameLabel.setText(newTitle);
        nameLabel.getStyleClass().add("text-decorated");
    }

    private void clearMainView() {
        mainView.getChildren().clear();
        mainView.getChildren().add(nameLabel);
        mainView.getChildren().add(descriptionLabel);
        mainText.setWrapText(true);
        mainView.getChildren().add(mainText);
        mainView.getChildren().add(buttonPane);
        buttonPane.getChildren().clear();
    }

    private void setupViewChange(String label, String mainTextLabel, String updateView) throws Exception {
        clearMainView();
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
                case "mastery": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), textArea.getText(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "dwelling": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), textArea.getText(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "assistiveDevices": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), textArea.getText(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "educationJob": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), textArea.getText(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "habits": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), textArea.getText(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "healthInfo": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), textArea.getText(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "lifeStory": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), textArea.getText(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "motivation": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), textArea.getText(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "network": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), textArea.getText(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "resources": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), textArea.getText(), this.generalInfo.getRoller(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "roller": {
                    GeneralInfo generalInfo = new GeneralInfo(this.generalInfo.getId(), this.generalInfo.getMastery(), this.generalInfo.getMotivation(), this.generalInfo.getResources(), textArea.getText(), this.generalInfo.getHabits(), this.generalInfo.getEducationJob(), this.generalInfo.getLifeStory(), this.generalInfo.getHealthInfo(), this.generalInfo.getAssistiveDevices(), this.generalInfo.getInteriorOfDwelling(), this.generalInfo.getNetwork(), this.generalInfo.getCitizen());
                    try {
                        handleSaveButtonSave(generalInfo);
                    } catch (Exception | UserException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                default:
                    System.out.println("error");
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
}
