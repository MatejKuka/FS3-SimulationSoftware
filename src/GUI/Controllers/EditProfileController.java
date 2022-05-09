package GUI.Controllers;

import BE.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {
    @FXML
    private BorderPane editBorderPane, deleteBorderPane, firstNameBorderPane, lastNameBorderPane, usernameBorderPane, roleBorderPane, passwordBorderPane;

    private User user;
    private TextField firstNameTextField, lastNameTextField, usernameTextField,  passwordTextField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user = new User(22, "Jozef", "Matus", "palenka", "tranzistor", 2);
        initializeTextFields();
        setupInitialView();

    }

    private void setupInitialView() {
        //Setup buttons we need
        Button editButton = new Button("Edit Profile");
        Button saveChangesButton = new Button("Save Changes");
        Button deleteButton = new Button("Delete Profile");
        Button cancelChangesButton = new Button("Cancel");

        setupInitBorderPanes(editButton, deleteButton);
        setupLabels();
        //action listeners
        editButton.setOnAction(event -> {
            cleanBorderPanes();
            cleanNodes();
            setupTextFields();

            editBorderPane.setCenter(saveChangesButton);
            deleteBorderPane.setCenter(cancelChangesButton);
        });

        cancelChangesButton.setOnAction(event -> {
            cleanBorderPanes();
            setupLabels();
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
    private void cleanNodes() {
        firstNameBorderPane.getChildren().clear();
        lastNameBorderPane.getChildren().clear();
        usernameBorderPane.getChildren().clear();
        passwordBorderPane.getChildren().clear();
    }

    private void setupTextFields() {
        firstNameBorderPane.setCenter(firstNameTextField);
        lastNameBorderPane.setCenter(lastNameTextField);
        usernameBorderPane.setCenter(usernameTextField);
        passwordBorderPane.setCenter(passwordTextField);
    }

    private void setupLabels() {
        cleanNodes();
        Text firstNameLabel = new Text(user.getFirstName());
        Text lastNameLabel = new Text(user.getLastName());
        Text usernameLabel = new Text(user.getLoginName());
        Text roleLabel = new Text(String.valueOf(user.getRoleID()));
        Text passwordLabel = new Text(user.getPassword());

        firstNameBorderPane.setCenter(firstNameLabel);
        lastNameBorderPane.setCenter(lastNameLabel);
        usernameBorderPane.setCenter(usernameLabel);
        roleBorderPane.setCenter(roleLabel);
        passwordBorderPane.setCenter(passwordLabel);
    }

    private void initializeTextFields() {
        firstNameTextField = new TextField();
        lastNameTextField = new TextField();
        usernameTextField = new TextField();
        passwordTextField = new TextField();
    }
}