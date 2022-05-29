package GUI.Controllers;

import GUI.Models.MainModel;
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
import java.util.Objects;
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
    void toCasesPage() throws IOException {
        setScene("/GUI/Views/AssignCasesView.fxml");
    }

    @FXML
    void toCitizensPage() throws IOException {
        setScene("/GUI/Views/CitizensView.fxml");
    }

    @FXML
    void toLogOut() throws IOException {

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
    void toMyProfilePage() throws IOException {
        setScene("/GUI/Views/EditProfile.fxml");
    }



    @FXML
    void toStuAssignPage() throws IOException {
        setScene("/GUI/Views/AssignmentView.fxml");
    }

    @FXML
    public void toStudentsPage() throws IOException {
        mainModel.changeRoleId(3);
        mainModel.changeRoleName(3);
        setScene("/GUI/Views/Students.fxml");
    }


    public void setScene(String pathOfView) throws IOException {
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(pathOfView)));
        borderPane.setCenter(root);
    }
}
