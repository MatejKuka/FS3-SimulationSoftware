package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MAdminStudentViewController {


    public MAdminStudentViewController() {

    }

    @FXML
    private BorderPane borderPane;


    @FXML
    void toAdminsPage(ActionEvent event) {

    }

    @FXML
    void toCasesPage(ActionEvent event) {

    }

    @FXML
    void toCitizensPage(ActionEvent event) {

    }

    @FXML
    void toGroup(ActionEvent event) {

    }

    @FXML
    void toLogOut(ActionEvent event) {

    }

    @FXML
    void toMyProfilePage(ActionEvent event) {

    }

    @FXML
    void toSchoolsPage(ActionEvent event) {

    }

    @FXML
    void toStuAssignPage(ActionEvent event) {

    }

    @FXML
    public void toStudentsPage(ActionEvent event) {
            setScene("/GUI/Views/Students.fxml");
    }

    @FXML
    void toTeachersPage(ActionEvent event) {

    }

    private  void setScene(String pathOfView) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(pathOfView));

        } catch (IOException ex) {
            System.out.println(ex);
        }
        borderPane.setCenter(root);
    }
}
