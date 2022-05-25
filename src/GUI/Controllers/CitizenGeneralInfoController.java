package GUI.Controllers;

import BE.Citizen;
import BE.GeneralInfo;
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
    private Label mainText = new Label(" Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque neque ante, ultrices nec gravida quis, pharetra eget quam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Vestibulum tristique neque ac sem vehicula auctor. Sed vulputate dui at urna consequat, et vehicula erat rutrum. Sed interdum mi nec tellus fringilla, et hendrerit tellus efficitur. Pellentesque porta ornare urna non efficitur. Nulla vitae risus lobortis, pellentesque tortor ac, bibendum leo. Praesent justo risus, dignissim vel ante ullamcorper, molestie accumsan magna. Maecenas eleifend, nunc nec porttitor ultrices, neque lorem interdum velit, ut luctus sem purus a nibh. Aenean convallis ante id enim posuere bibendum. Pellentesque non justo malesuada, ornare lacus sit amet, placerat nisi. Sed quam felis, vestibulum ac convallis a, hendrerit id ipsum. Aenean nisl quam, laoreet at dolor ac, feugiat dignissim ante. Nulla tempor felis massa, id egestas enim aliquam et.\n" +
            "\n" +
            "Aliquam eget erat nunc. Sed hendrerit tincidunt euismod. Vivamus vehicula aliquet libero, et gravida erat tempor in. Morbi consequat libero vehicula nisl fermentum fermentum. Ut ex ex, eleifend eget elementum sed, viverra in libero. In sit amet metus posuere felis molestie dignissim sed sed metus. Cras ut faucibus risus, lobortis congue mauris. Suspendisse felis arcu, ornare sit amet lorem vehicula, ultricies luctus ipsum. Sed ut odio finibus, mollis arcu nec, congue enim. Cras aliquam venenatis maximus. Curabitur quis sodales arcu. Phasellus mauris ligula, feugiat ac volutpat quis, lacinia faucibus massa. Integer in sem et est cursus elementum ac ut sem. Nulla commodo, tortor ut aliquam tempor, nulla tortor feugiat nunc, nec condimentum mauris nunc id sem. Quisque nec posuere nibh, sit amet rhoncus arcu. In ac pretium nisi, id elementum nisi. ");
    private Button editButton;
    private Button cancelButton = new Button("Cancel");
    private Button saveButton = new Button("Save");
    private TextArea textArea;

    private BorderPane buttonPane = new BorderPane();
    private GeneralInfo generalInfo;
    HBox hBox = new HBox();
    private boolean isCreated = false;

    public void getCitizen(Citizen citizen) throws Exception {
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
    private CitizensEditController citizensEditController;

    public void setCitizensEditController(CitizensEditController citizensEditController) {
        this.citizensEditController = citizensEditController;
    }

    private Citizen citizen;

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
    void toAssistDevSec(ActionEvent event) {
        setupViewChange("Assistive devices", generalInfo.getAssistiveDevices(), "assistiveDevices");
    }

    @FXML
    void toDwelSec(ActionEvent event) {
        setupViewChange("Interior of dwelling", generalInfo.getInteriorOfDwelling(), "dwelling");
    }

    @FXML
    void toEduJobSec(ActionEvent event) {
        setupViewChange("Education/Job", generalInfo.getEducationJob(), "educationJob");
    }

    @FXML
    void toHabitSec(ActionEvent event) {
        setupViewChange("Habits", generalInfo.getHabits(), "habits");
    }

    @FXML
    void toHealthInfoSec(ActionEvent event) {
        setupViewChange("Health Information", generalInfo.getHealthInfo(), "healthInfo");
    }

    @FXML
    void toLifeStorySec(ActionEvent event) {
        setupViewChange("Life Story", generalInfo.getLifeStory(), "lifeStory");
    }

    @FXML
    void toMasterySec(ActionEvent event) {
        setupViewChange("Mastery", generalInfo.getMastery(), "mastery");
    }

    @FXML
    void toMotivationSec(ActionEvent event) {
        setupViewChange("Motivation", generalInfo.getMotivation(), "motivation");
    }

    @FXML
    void toNetworkSec(ActionEvent event) {
        setupViewChange("Network", generalInfo.getNetwork(), "network");
    }

    @FXML
    void toResourceSec(ActionEvent event) {
        setupViewChange("Resources", generalInfo.getResources(), "resources");
    }

    @FXML
    void toRollerSec(ActionEvent event) {
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

    private void setupViewChange(String label, String mainTextLabel, String updateView) {
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
                        mainModel.updateGeneralInfo(generalInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "dwelling": {
                    System.out.println("test");
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

}
