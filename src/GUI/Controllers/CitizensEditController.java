package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class CitizensEditController {

    @FXML
    private BorderPane borderPaneContent;

    @FXML
    private Button btnBasicInfo;

    @FXML
    private Button btnFState;

    @FXML
    private Button btnGeneralInfo;

    @FXML
    void toBasicInfo(ActionEvent event) {
        setScene("/GUI/Views/CitizenBasicInfoView.fxml");
    }

    @FXML
    void toFState(ActionEvent event) {

    }

    @FXML
    void toGeneralInfo(ActionEvent event) {
        setScene("/GUI/Views/CitizenGeneralInfoView.fxml");
    }

    public void setScene(String pathOfView) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(pathOfView));

        } catch (IOException ex) {
            System.out.println(ex);
        }
        borderPaneContent.setCenter(root);
    }

}
