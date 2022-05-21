package GUI.Controllers;

import BE.Citizen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CitizensEditController implements Initializable {

    @FXML
    private BorderPane borderPaneContent;

    @FXML
    private Button btnBasicInfo;

    @FXML
    private Button btnFState;

    @FXML
    private Button btnGeneralInfo;

//    @FXML
//    void toBasicInfo(ActionEvent event) {
//        //setScene("/GUI/Views/CitizenBasicInfoViewNew.fxml");
//        setScene("/GUI/Views/CitizenBasicInfoView.fxml");
//    }
//
//    @FXML
//    void toFState(ActionEvent event) {
//        setScene("/GUI/Views/CitizenFunctionalityStateView.fxml");
//    }
//
//    @FXML
//    void toGeneralInfo(ActionEvent event) {
//        setScene("/GUI/Views/CitizenGeneralInfoView.fxml");
//    }

//    public void setScene(String pathOfView) {
//
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource(pathOfView));
//
//        } catch (IOException ex) {
//            System.out.println(ex);
//        }
//        borderPaneContent.setCenter(root);
//    }


    CitizensController citizensController;

    private Citizen citizen;

    public void setCitizensController(CitizensController citizensController) {
        this.citizensController = citizensController;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void getCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public void handleBasicInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizenBasicInfoView.fxml"));
        Parent root = loader.load();
        CitizenBasicInfoController citizenBasicInfoController = loader.getController();
        citizenBasicInfoController.setCitizensEditController(this);
        citizenBasicInfoController.getCitizen(citizen);

        borderPaneContent.setCenter(root);
    }

    public void handleGeneralInformation(ActionEvent event) {
    }

    public void handleFunctionalityState(ActionEvent event) {
    }
}
