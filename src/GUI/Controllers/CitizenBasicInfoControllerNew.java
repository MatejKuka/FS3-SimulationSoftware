package GUI.Controllers;

import GUI.Models.MainModel;
import GUI.Utils.SceneSetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizenBasicInfoControllerNew implements Initializable {
    MainModel mainModel;
    SceneSetter sceneSetter;

    @FXML
    private Button buttonEdit;

    @FXML
    private HBox buttonsContainer;

    @FXML
    private Label labelFName;

    @FXML
    private Label labelLName;

    public CitizenBasicInfoControllerNew() throws IOException {
        mainModel = new MainModel();
        sceneSetter = new SceneSetter();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setLabels();
    }

    @FXML
    void toEdit(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizenBasicInfoViewNewEdit.fxml"));
        sceneSetter.setScene(loader);
    }

    public void setLabels() {
        labelFName.setText(mainModel.getCurrentCitizen().getFirstName());
        labelLName.setText(mainModel.getCurrentCitizen().getLastName());
    }

}
