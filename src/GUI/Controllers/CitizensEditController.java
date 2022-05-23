package GUI.Controllers;

import BE.Citizen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizensEditController implements Initializable {

    @FXML
    private BorderPane borderPaneContent;

    private Citizen citizen;
    private CitizensController citizensController;

    public void setCitizensController(CitizensController citizensController) {
        this.citizensController = citizensController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void getCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void handleBasicInformation(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizenBasicInfoView.fxml"));
        Parent root = loader.load();
        CitizenBasicInfoController citizenBasicInfoController = loader.getController();
        citizenBasicInfoController.setCitizensEditController(this);
        citizenBasicInfoController.getCitizen(citizen);

        borderPaneContent.setCenter(root);
    }

    public void handleGeneralInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizenGeneralInfoView.fxml"));
        Parent root = loader.load();

        borderPaneContent.setCenter(root);
    }

    public void handleFunctionalityState(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizenFunctionalityStateView.fxml"));
        Parent root = loader.load();

        borderPaneContent.setCenter(root);
    }
}
