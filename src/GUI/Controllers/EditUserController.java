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

public class EditUserController implements Initializable{

    MAdminStudentViewController menuController;
    MainModel mainModel;
    User user;
    StudentsController studentsController;

    @FXML
    private Button btnCancel, btnSave;

    @FXML
    private ComboBox<?> comboBoxRole;

    @FXML
    private TextField txtFieldFName, txtFieldLName, txtFieldPass, txtFieldUName;

    public EditUserController(User user) throws IOException {
        this.user = user;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            this.mainModel = new MainModel();
            studentsController = new StudentsController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setFields(user);
    }


    @FXML
    void toCancelPage(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();

    }

    @FXML
    void toCreateNewUser(ActionEvent event) throws Exception {
        User userCreated = new User(user.getUserID(), txtFieldFName.getText(), txtFieldLName.getText(), txtFieldUName.getText(), txtFieldPass.getText(), user.getRoleID());
        mainModel.updateUser(userCreated);
        //studentsController.updateTableView();
        System.out.println("User updated");
        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();

    }

    public void setFields(User userToShow)
    {
        txtFieldPass.setText(userToShow.getPassword());
        txtFieldFName.setText(userToShow.getFirstName());
        txtFieldLName.setText(userToShow.getLastName());
        txtFieldUName.setText(userToShow.getLoginName());
    }



}
