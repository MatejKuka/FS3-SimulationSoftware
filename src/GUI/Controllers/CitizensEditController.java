package GUI.Controllers;

import BE.Citizen;
import BLL.exeptions.UserException;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void handleBasicInformation() throws UserException, IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizenBasicInfoView.fxml"));
        Parent root = loader.load();
        CitizenBasicInfoController citizenBasicInfoController = loader.getController();
        citizenBasicInfoController.getCitizen(citizen);
        borderPaneContent.setCenter(root);
    }

    public void handleGeneralInformation() throws Exception, UserException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizenGeneralInfoView.fxml"));
        Parent root = loader.load();
        CitizenGeneralInfoController citizenBasicInfoController = loader.getController();
        citizenBasicInfoController.getCitizen(citizen);
        borderPaneContent.setCenter(root);
    }

    public void handleFunctionalityState() throws Exception, UserException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizenFunctionalityStateView.fxml"));
        Parent root = loader.load();
        CitizenFunctionalityStateViewController citizenFunctionalityStateViewController = loader.getController();
        citizenFunctionalityStateViewController.getCitizen(citizen);
        borderPaneContent.setCenter(root);
    }
}
