package GUI.Controllers;

import BE.User;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    MainModel mainModel;
    String errorMessage = "Your username or password is wrong";

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelBadInput;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private TextField textFieldUsername;



    public LoginController() throws IOException {
        mainModel = new MainModel();
    }



    public void toSubmitLogin(ActionEvent actionEvent) throws UserException {
        User user= mainModel.compareLogins(textFieldUsername.getText(), textFieldPassword.getText());
        if(user != null) {
            if (user.getRoleID() == 1) {
                mainModel.setCurrentUser(user);
                mainModel.setCurrentSchoolId(user);
                startAdminPage();
            }
            else if (user.getRoleID()== 2) {
                mainModel.setCurrentUser(user);
                mainModel.setCurrentSchoolId(user);
                startTeacherPage();
            }
            else if (user.getRoleID()== 3) {
                mainModel.setCurrentUser(user);
                mainModel.setCurrentSchoolId(user);
                startStudentPage();
            }
        } else labelBadInput.setText(errorMessage);

    } // TODO Matej - need to reset user because after log out, I cannot log in as different user

    private void startStudentPage() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/MStudentMenuView.fxml"));
        setScene(textFieldPassword,loader);
    }

    private void startTeacherPage() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/MTeacherStudentView.fxml"));
        setScene(textFieldPassword,loader);
    }

    private void startAdminPage() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/MAdminStudentView.fxml"));
        setScene(textFieldPassword, loader);
    }

    public void setScene(Node node, FXMLLoader loader) {
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage primaryStage = (Stage) node.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
