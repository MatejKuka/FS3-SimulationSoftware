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
    private Label labelAge, labelFirstName, labelLastName;
    @FXML
    private BorderPane firstNameContainer, lastNameContainer, ageContainer;
    @FXML
    private HBox buttonsContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void toBack(ActionEvent event) {

    }

    public void handleEditButton(ActionEvent event) {
        clearLabels();
        clearButtons();
        setupTextFields();
    }

    private void clearLabels() {
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
   }
}
