package GUI.Controllers;

import GUI.Models.MainModel;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewUserController implements Initializable {

    MAdminStudentViewController menuController;
    MainModel mainModel;

    @FXML
    private Label labelMessage;

    @FXML
    private Button btnCancel, btnSave;

    @FXML
    private ComboBox<String> comboBoxRole;

    @FXML
    private TextField txtFieldFName, txtFieldLName, txtFieldPass, txtFieldUName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            menuController = new MAdminStudentViewController();
            mainModel = new MainModel();
            labelMessage.setText(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setComboBoxRole();
    }

    @FXML
    void toCancelPage(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toCreateNewUser(ActionEvent event) throws Exception {
        if (comboBoxRole.getSelectionModel().getSelectedIndex() != -1 && !txtFieldFName.getText().isEmpty() && !txtFieldLName.getText().isEmpty() && !txtFieldPass.getText().isEmpty() && !txtFieldUName.getText().isEmpty()) {
            if (comboBoxRole.getSelectionModel().getSelectedIndex() == 0) mainModel.createAdmin(txtFieldFName.getText(), txtFieldLName.getText(), txtFieldUName.getText(), txtFieldPass.getText());
            if (comboBoxRole.getSelectionModel().getSelectedIndex() == 1) mainModel.createTeacher(txtFieldFName.getText(), txtFieldLName.getText(), txtFieldUName.getText(), txtFieldPass.getText());
            if (comboBoxRole.getSelectionModel().getSelectedIndex() == 2) mainModel.createStudent(txtFieldFName.getText(), txtFieldLName.getText(), txtFieldUName.getText(), txtFieldPass.getText());
            Stage stage = (Stage) btnSave.getScene().getWindow();
            stage.close();
        } else labelMessage.setText("One of the input is empty");
    }

    private void setComboBoxRole(){
        comboBoxRole.getItems().add("Admin");
        comboBoxRole.getItems().add("Teacher");
        comboBoxRole.getItems().add("Student");
    }


} // TODO Matej - when Oliver put school Id in parameters for creating new Admin, new Student, ..., I should alter these current methods
