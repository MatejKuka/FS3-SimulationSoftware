package GUI.Controllers;

import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MAdminStudentViewController {
    MainModel mainModel;


    public MAdminStudentViewController() throws IOException {
        mainModel = new MainModel();
    }

    @FXML
    private BorderPane borderPane;


    @FXML
    void toAdminsPage(ActionEvent event) {
        mainModel.changeRoleId(1);
        mainModel.changeRoleName(1);
        setScene("/GUI/Views/Students.fxml");
    }

    @FXML
    void toCasesPage(ActionEvent event) {

    }

    @FXML
    void toCitizensPage(ActionEvent event) {
        setScene("/GUI/Views/CitizensView.fxml");
    }

    @FXML
    void toGroup(ActionEvent event) {

    }

    @FXML
    void toLogOut(ActionEvent event) {

    }

    @FXML
    void toMyProfilePage(ActionEvent event) {
        setScene("/GUI/Views/EditProfile.fxml");
    }

    @FXML
    void toSchoolsPage(ActionEvent event) {

    }

    @FXML
    void toStuAssignPage(ActionEvent event) {

    }

    @FXML
    public void toStudentsPage(ActionEvent event) throws Exception {
        mainModel.changeRoleId(3);
        mainModel.changeRoleName(3);
        setScene("/GUI/Views/Students.fxml");
    }

    @FXML
    void toTeachersPage(ActionEvent event) {
        mainModel.changeRoleId(2);
        mainModel.changeRoleName(2);
        setScene("/GUI/Views/Students.fxml");
    }

    private void setScene(String pathOfView) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(pathOfView));

        } catch (IOException ex) {
            System.out.println(ex);
        }
        borderPane.setCenter(root);
    }
}
