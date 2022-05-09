package GUI.Controllers;

import BE.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {
    @FXML
    private BorderPane root, editBorderPane, deleteBorderPane;
    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupInitialView();
        user = new User(22, "Jozef", "Matus", "palenka", "tranzistor", 2);
    }

    private void setupInitialView() {
        //Setup buttons we need
        Button editButton = new Button("Edit Profile");
        Button saveChangesButton = new Button("Save Changes");
        Button deleteButton = new Button("Delete Profile");
        Button cancelChangesButton = new Button("Cancel");

        setupInitBorderPanes(editButton, deleteButton);

        //action listeners
        editButton.setOnAction(event -> {
            cleanBorderPanes();
            editBorderPane.setCenter(saveChangesButton);
            deleteBorderPane.setCenter(cancelChangesButton);
        });

        cancelChangesButton.setOnAction(event -> {
            cleanBorderPanes();

            setupInitBorderPanes(editButton, deleteButton);
        });
    }

    private void setupInitBorderPanes(Node editButton, Node deleteButton) {
        editBorderPane.setCenter(editButton);
        deleteBorderPane.setCenter(deleteButton);
    }
    // Clear border panes so we can add new ones
    private void cleanBorderPanes() {
        editBorderPane.getChildren().clear();
        deleteBorderPane.getChildren().clear();
    }
}
