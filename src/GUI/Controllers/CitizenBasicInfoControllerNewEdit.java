package GUI.Controllers;

import BE.Citizen;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizenBasicInfoControllerNewEdit implements Initializable {
    MainModel mainModel;
    Citizen currentCitizen;
    CitizenBasicInfoControllerNew citizenBasicInfoControllerNew;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonSave;

    @FXML
    private HBox buttonsContainer;

    @FXML
    private TextField txtFieldFName;

    @FXML
    private TextField txtFieldLName;

    public CitizenBasicInfoControllerNewEdit() throws IOException {
        mainModel = new MainModel();
        currentCitizen = mainModel.getCurrentCitizen();
        citizenBasicInfoControllerNew = new CitizenBasicInfoControllerNew();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtFieldFName.setText(currentCitizen.getFirstName());
        txtFieldLName.setText(currentCitizen.getLastName());
    }

    @FXML
    void toCancel(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toSave(ActionEvent event) throws Exception {
        Citizen citizen = new Citizen(currentCitizen.getId(), txtFieldFName.getText(), txtFieldLName.getText(), mainModel.getCurrentSchoolId(), currentCitizen.getGeneralInfo());
        mainModel.updateCitizen(citizen);
        mainModel.setCurrentCitizen(citizen);

        System.out.println("Citizen updated: " + citizen);
        Stage stage = (Stage) buttonSave.getScene().getWindow();
        stage.close();
    }


}
