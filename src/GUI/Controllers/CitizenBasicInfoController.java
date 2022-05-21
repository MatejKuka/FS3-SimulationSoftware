package GUI.Controllers;

import BE.Citizen;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CitizenBasicInfoController implements Initializable {
    MainModel model;

    @FXML
    private BorderPane firstNameContainer, lastNameContainer, ageContainer;
    @FXML
    private HBox buttonsContainer;

    public CitizenBasicInfoController() throws IOException {
        model = new MainModel();
    }
//    private Citizen citizen;

    private final String placeholder = "----";

    private Label firstNamePlaceholder = new Label(placeholder);
    private Label lastNamePlaceholder = new Label(placeholder);
    private Label agePlaceholder = new Label(placeholder);

    private TextField firstNameTextField = new TextField();
    private TextField lastNameTextField = new TextField();
    private TextField ageTextField = new TextField();

    private CitizensEditController citizensEditController;

    public void setCitizensEditController(CitizensEditController citizensEditController) {
        this.citizensEditController = citizensEditController;
    }
    private Citizen citizen;
    public void getCitizen(Citizen citizen) {
        this.citizen = citizen;
        setupLabels(citizen);
        setupTextFields(citizen);
//        setupTextFields(citizen);
    }
    private MainModel mainModel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setupInitialView();
    }

    private void setupInitialView() {
        clear();
        clearButtons();

        Button editButton = new Button("Edit");
        firstNameContainer.setCenter(firstNamePlaceholder);
        lastNameContainer.setCenter(lastNamePlaceholder);
        ageContainer.setCenter(agePlaceholder);
        buttonsContainer.getChildren().add(editButton);
        editButton.setOnAction(event -> {
            clear();
            clearButtons();
            setupTextFields();
            setupButtons();
        });
    }
    private void clear() {
        firstNameContainer.getChildren().clear();
        lastNameContainer.getChildren().clear();
        ageContainer.getChildren().clear();
    }

    private void clearButtons() {
        buttonsContainer.getChildren().clear();
    }
    private void setupTextFields() {
        firstNameContainer.setCenter(firstNameTextField);
        lastNameContainer.setCenter(lastNameTextField);
        ageContainer.setCenter(ageTextField);
    }
   private void setupButtons() {
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        buttonsContainer.getChildren().add(saveButton);
        buttonsContainer.getChildren().add(cancelButton);

        cancelButton.setOnAction(event -> {
            setupInitialView();
        });
        saveButton.setOnAction(event -> {
//            if (Objects.equals(firstNameTextField.getText(), "")) {
//                firstNamePlaceholder.setText("-");
//            } else {
//                firstNamePlaceholder.setText(firstNameTextField.getText());
//            }
//            if (Objects.equals(lastNameTextField.getText(), "")) {
//                lastNamePlaceholder.setText("-");
//            } else {
//                lastNamePlaceholder.setText(lastNameTextField.getText());
//            }
//            if (Objects.equals(ageTextField.getText(), "")) {
//                agePlaceholder.setText("-");
//            } else {
//                agePlaceholder.setText(ageTextField.getText());
//            }
            Citizen newCitizen = new Citizen(citizen.getId(), firstNameTextField.getText(), lastNameTextField.getText(), citizen.getSchool(), citizen.getGeneralInfo());
            try {
                mainModel.updateCitizen(newCitizen);
            } catch (Exception e) {
                e.printStackTrace();
            }
            setupInitialView();

        });
   }
   public void setupLabels(Citizen citizen) {
        firstNamePlaceholder.setText(citizen.getFirstName());
        lastNamePlaceholder.setText(citizen.getLastName());
   }
   public void setupTextFields(Citizen citizen) {
        firstNameTextField.setText(citizen.getFirstName());
        lastNameTextField.setText(citizen.getLastName());
   }
    private Label createLabel(String title) {
        return new Label(title);
    }
}
