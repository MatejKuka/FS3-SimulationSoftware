package GUI.Controllers;

import BE.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {
    @FXML
    private BorderPane root;
    private User user;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupView();
        user = new User(22, "gastanovec", "ronaldo", 2);
    }

    private void setupView() {
        Text text = new Text("Test");

    }
}
