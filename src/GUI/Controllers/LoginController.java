package GUI.Controllers;

import BE.User;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    MainModel mainModel;

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelBadInput;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private TextField textFieldUsername;



    String errorMessage = "Your username or password is wrong";


    public LoginController() throws IOException {
        mainModel = new MainModel();
    }



    public void toSubmitLogin(ActionEvent actionEvent) throws Exception{
        User user= mainModel.compareLogins(textFieldUsername.getText(), textFieldPassword.getText());
        if(user != null)
        {
            if (user.getRoleID() == 1) {
                startAdminPage();
            }
            else if (user.getRoleID()== 2)
            {
                startTeacherPage();
            }
            else if (user.getRoleID()== 3)
            {
                startStudentPage();
            }
        }
        else
        {
            labelBadInput.setText(errorMessage);
        }
    }

    private void startStudentPage() {
        System.out.println("student page");
    }

    private void startTeacherPage() {
        System.out.println("teacher page");
    }

    private void startAdminPage() {
        System.out.println("admin page");
    }

}
