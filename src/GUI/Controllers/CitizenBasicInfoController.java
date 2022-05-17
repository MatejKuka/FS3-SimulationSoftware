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
import java.util.ResourceBundle;

public class CitizenBasicInfoController implements Initializable {
    @FXML
    private BorderPane firstNameContainer, lastNameContainer, ageContainer;
    @FXML
    private HBox buttonsContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupInitialView();
    }

    private void setupInitialView() {
        clear();
        clearButtons();
        Label firstNamePlaceholder = new Label("-");
        Label lastNamePlaceholder = new Label("-");
        Label agePlaceholder = new Label("-");
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
        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();
        TextField ageTextField = new TextField();

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
   }
}
