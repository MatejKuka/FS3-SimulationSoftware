package GUI.Controllers;

import BE.User;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditUserController implements Initializable {

    MAdminStudentViewController menuController;
    MainModel mainModel;
    User user;

    @FXML
    private Button btnCancel, btnSave;

    @FXML
    private ComboBox<?> comboBoxRole;

    @FXML
    private TextField txtFieldFName, txtFieldLName, txtFieldPass, txtFieldUName;

    public EditUserController(User userController) {
        //this.user = user;
        setFields(userController);
        System.out.println(userController);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            menuController = new MAdminStudentViewController();
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
            setFields(user);
        }

    }

    @FXML
    void toCancelPage(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toCreateNewUser(ActionEvent event) {
        System.out.println("user updated by clicked on button CREATED");
        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();
    }

    public void setFields(User userShow)
    {
        txtFieldFName.setText(userShow.getFirstName());
        txtFieldLName.setText(userShow.getLastName());
        txtFieldPass.setText(user.getPassword());
        txtFieldUName.setText(userShow.getLoginName());

    }


} // textFields cannot set text because  there is some mistake
