package GUI.Controllers;

import BE.Citizen;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateCitizenController implements Initializable {
    @FXML
    private TextField firstNameTextField, lastNameTextField;
    @FXML
    private Button cancelButton, saveButton;

    private MainModel mainModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleSaveButton() throws UserException {
        if (firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("")) {
            if (firstNameTextField.getText().equals("")) firstNameTextField.getStyleClass().add("custom-text-field-error");
            if (lastNameTextField.getText().equals("")) lastNameTextField.getStyleClass().add("custom-text-field-error");
        } else {
           Citizen citizenNew = mainModel.createCitizen(firstNameTextField.getText(), lastNameTextField.getText(), mainModel.getCurrentSchoolId());
            String initialStringHC = "empty";
            for (int i = 1; i < 43; i++) {
                mainModel.createHealthCondition(initialStringHC, initialStringHC, initialStringHC, initialStringHC, initialStringHC, initialStringHC, i, citizenNew.getId());
           }
            Stage stage = (Stage) saveButton.getScene().getWindow();
            stage.close();
        }
    }

    public void handleCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
