package GUI.Controllers;

import GUI.Models.MainModel;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewUserController implements Initializable {

    MAdminStudentViewController menuController;
    MainModel mainModel;


    @FXML
    private ComboBox<?> comboBoxRole;

    @FXML
    private TextField txtFieldFName, txtFieldLName, txtFieldPass, txtFieldUName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            menuController = new MAdminStudentViewController();
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void toCancelPage(ActionEvent event) {
        menuController.setScene("/GUI/Views/Students.fxml");
    }

    @FXML
    void toCreateNewUser(ActionEvent event) {
        System.out.println("user created by clicked on button CREATED");
        menuController.setScene("/GUI/Views/Students.fxml");
    }

}
