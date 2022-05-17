package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CitizenBasicInfoController implements Initializable {
    @FXML
    private BorderPane firstNameContainer, lastNameContainer, ageContainer;
    @FXML
    private HBox buttonsContainer;

    private final String placeholder = "-";

    private Label firstNamePlaceholder = new Label(placeholder);
    private Label lastNamePlaceholder = new Label(placeholder);
    private Label agePlaceholder = new Label(placeholder);

    private TextField firstNameTextField = new TextField();
    private TextField lastNameTextField = new TextField();
    private TextField ageTextField = new TextField();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
            if (Objects.equals(firstNameTextField.getText(), "")) {
                firstNamePlaceholder.setText("-");
            } else {
                firstNamePlaceholder.setText(firstNameTextField.getText());
            }
            if (Objects.equals(lastNameTextField.getText(), "")) {
                lastNamePlaceholder.setText("-");
            } else {
                lastNamePlaceholder.setText(lastNameTextField.getText());
            }
            if (Objects.equals(ageTextField.getText(), "")) {
                agePlaceholder.setText("-");
            } else {
                agePlaceholder.setText(ageTextField.getText());
            }

            setupInitialView();
        });
   }
}
