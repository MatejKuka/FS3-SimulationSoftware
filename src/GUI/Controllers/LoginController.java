package GUI.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button buttonLogin;

    @FXML
    private Label labelBadInput;

    @FXML
    private TextField textFieldPassword;

    @FXML
    private TextField textFieldUsername;

    String errorMessage = "Your username or password is wrong";


}
