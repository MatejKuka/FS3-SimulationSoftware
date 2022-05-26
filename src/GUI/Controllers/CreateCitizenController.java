package GUI.Controllers;

;
import BE.Citizen;
import BE.School;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CreateCitizenController implements Initializable {
    @FXML
    private TextField firstNameTextField, lastNameTextField;
    @FXML
    private Button cancelButton, saveButton;

    private MainModel mainModel;
    private List<School> schoolList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
            schoolList = mainModel.getAllSchools();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleSaveButton(ActionEvent event) throws Exception {
        if (firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("")) {
            if (firstNameTextField.getText().equals("")) firstNameTextField.getStyleClass().add("custom-text-field-error");
            if (lastNameTextField.getText().equals("")) lastNameTextField.getStyleClass().add("custom-text-field-error");
        } else {
            mainModel.createCitizen(firstNameTextField.getText(), lastNameTextField.getText(), mainModel.getCurrentSchoolId());
//            String initialStringHC = "empty";
//            for (int i = 0; i < 43; i++) {
//                mainModel.createHealthCondition(initialStringHC, initialStringHC, initialStringHC, initialStringHC, initialStringHC, initialStringHC, i, citizenNew.getId());
//            }
//            // TODO Test this
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        }
    }

    public void handleCancelButton(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
