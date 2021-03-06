package GUI.Controllers;

import BE.Citizen;
import BE.School;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizenBasicInfoController implements Initializable {
    @FXML
    private BorderPane firstNameContainer, lastNameContainer, schoolContainer;
    @FXML
    private HBox buttonsContainer;

    private final String placeholder = "----";

    private final Label firstNamePlaceholder = new Label(placeholder);
    private final Label lastNamePlaceholder = new Label(placeholder);
    private final Label schoolPlaceholder = new Label(placeholder);

    private final TextField firstNameTextField = new TextField();
    private final TextField lastNameTextField = new TextField();

    private Citizen citizen;
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

    //Method, which gets citizen from other controllers
    public void getCitizen(Citizen citizen) throws UserException {
        Citizen citizen1 = mainModel.getCitizenById(citizen.getId());
        this.citizen = citizen1;
        setupLabels(citizen1);
        setupTextFields(citizen1);
    }
    //
    private void setupInitialView() {
        clear();
        clearButtons();

        Button editButton = new Button("Edit");
        editButton.getStyleClass().clear();
        editButton.getStyleClass().addAll("btn-action", "padding");
        firstNameContainer.setCenter(firstNamePlaceholder);
        lastNameContainer.setCenter(lastNamePlaceholder);
        schoolContainer.setCenter(schoolPlaceholder);

        buttonsContainer.getChildren().add(editButton);
        editButton.setOnAction(event -> {
            clear();
            clearButtons();
            setupTextFields();
            setupButtons();
        });
    }
    // Clears the values from both border page
    private void clear() {
        firstNameContainer.getChildren().clear();
        lastNameContainer.getChildren().clear();
    }
    // Clears the buttons from the button container
    private void clearButtons() {
        buttonsContainer.getChildren().clear();
    }

    private void setupTextFields() {
        firstNameContainer.setCenter(firstNameTextField);
        lastNameContainer.setCenter(lastNameTextField);
    }

    private void setupButtons() {
        Button saveButton = new Button("Save");
        saveButton.getStyleClass().clear();
        saveButton.getStyleClass().addAll("btn-action", "padding");

        Button cancelButton = new Button("Cancel");

        cancelButton.getStyleClass().clear();
        cancelButton.getStyleClass().addAll("btn-action", "padding");

        buttonsContainer.getChildren().add(saveButton);
        buttonsContainer.getChildren().add(cancelButton);
        buttonsContainer.setSpacing(30);

        // Button actions
        cancelButton.setOnAction(event -> setupInitialView());

        saveButton.setOnAction(event -> {
            Citizen newCitizen = new Citizen(citizen.getId(), firstNameTextField.getText(), lastNameTextField.getText(), citizen.getSchool());
            try {
                mainModel.updateCitizen(newCitizen);
                citizen.setFirstName(firstNameTextField.getText());
                citizen.setLastName(lastNameTextField.getText());
            } catch (Exception | UserException e) {
                e.printStackTrace();
            }
            setupInitialView();
            firstNameContainer.getChildren().clear();
            firstNameContainer.setCenter(createLabel(newCitizen.getFirstName()));
            lastNameContainer.getChildren().clear();
            lastNameContainer.setCenter(createLabel(newCitizen.getLastName()));
        });
    }

    public void setupLabels(Citizen citizen) throws UserException {
        firstNamePlaceholder.setText(citizen.getFirstName());
        lastNamePlaceholder.setText(citizen.getLastName());
        School school = mainModel.getSchoolById(citizen.getSchool());
        schoolPlaceholder.setText(school.getName());
    }

    public void setupTextFields(Citizen citizen) {
        firstNameTextField.setText(citizen.getFirstName());
        firstNameTextField.getStyleClass().clear();
        firstNameTextField.getStyleClass().addAll("custom-text-field", "text-field-padding", "cursor-text");
        lastNameTextField.setText(citizen.getLastName());
        lastNameTextField.getStyleClass().clear();
        lastNameTextField.getStyleClass().addAll("custom-text-field", "text-field-padding", "cursor-text");
    }

    private Label createLabel(String title) {
        return new Label(title);
    }
}
