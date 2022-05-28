package GUI.Controllers;

import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MTeacherStudentController implements Initializable {
    MainModel mainModel;


    public MTeacherStudentController() throws IOException {
        mainModel = new MainModel();
    }

    @FXML
    private Button btnLogOut;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Label labelCurrentFName, labelCurrentLName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelCurrentFName.setText(mainModel.getCurrentUser().getFirstName());
        labelCurrentLName.setText(mainModel.getCurrentUser().getLastName());
    }



    @FXML
    void toCasesPage(ActionEvent event) {
        setScene("/GUI/Views/AssignCasesView.fxml");
    }

    @FXML
    void toCitizensPage(ActionEvent event) {
        setScene("/GUI/Views/CitizensView.fxml");
    }

    @FXML
    void toLogOut(ActionEvent event) throws IOException {
        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Views/LoginView.fxml"));
        root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        Stage stageClose = (Stage) btnLogOut.getScene().getWindow();
        stageClose.close();
    }

    @FXML
    void toMyProfilePage(ActionEvent event) {
        setScene("/GUI/Views/EditProfile.fxml");
    }



    @FXML
    void toStuAssignPage(ActionEvent event) {
        setScene("/GUI/Views/AssignmentView.fxml");
    }

    @FXML
    public void toStudentsPage(ActionEvent event) throws Exception {
        mainModel.changeRoleId(3);
        mainModel.changeRoleName(3);
        setScene("/GUI/Views/Students.fxml");
    }


    public void setScene(String pathOfView) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(pathOfView));

        } catch (IOException ex) {
            System.out.println(ex);
        }
        borderPane.setCenter(root);
    }
}
