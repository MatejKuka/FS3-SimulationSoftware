package GUI.Controllers;

import BE.User;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {
    private MainModel model;


    @FXML
    private BorderPane editBorderPane, deleteBorderPane, firstNameBorderPane, lastNameBorderPane, usernameBorderPane, roleBorderPane, passwordBorderPane;

    private User user;
    private TextField firstNameTextField, lastNameTextField, usernameTextField, passwordTextField;

    /*public EditProfileController(User userToShow) throws IOException {
        model = new MainModel();
    }*/


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            model = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        user = MainModel.currrentUser;
        initializeTextFields();
        setupInitialView();

    }

    private void setupInitialView() {
        //Setup buttons we need
        Button editButton = new Button("Edit Profile");
        editButton.getStyleClass().addAll("btn-action", "padding");
        Button saveChangesButton = new Button("Save Changes");
        saveChangesButton.getStyleClass().addAll("btn-action", "padding");
        Button deleteButton = new Button("Delete Profile");
        deleteButton.getStyleClass().addAll("btn-action-error", "padding");
        Button cancelChangesButton = new Button("Cancel");
        cancelChangesButton.getStyleClass().addAll("btn-action-error", "padding");

        setupInitBorderPanes(editButton, deleteButton);
        setupLabels(user.getFirstName(), user.getLastName(), user.getLoginName(), user.getRoleID(), user.getPassword());
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
            setupLabels(user.getFirstName(), user.getLastName(), user.getLoginName(), user.getRoleID(), user.getPassword());
            setupInitBorderPanes(editButton, deleteButton);
        });

        saveChangesButton.setOnAction(event -> {
            try {
                model.updateUser(user.getUserID(), firstNameTextField.getText(), lastNameTextField.getText(), usernameTextField.getText(), passwordTextField.getText());
                user = MainModel.currrentUser;
            } catch (UserException e) {
                e.printStackTrace();
            }
            setupLabels(firstNameTextField.getText(), lastNameTextField.getText(), usernameTextField.getText(), user.getRoleID(), passwordTextField.getText());
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

    private void setupLabels(String firstName, String lastName, String username, int roleId, String password) {
        cleanNodes();
        Text firstNameLabel = new Text(firstName);
        Text lastNameLabel = new Text(lastName);
        Text usernameLabel = new Text(username);
        Text roleLabel = new Text(String.valueOf(roleId));
        Text passwordLabel = new Text(password);

        firstNameBorderPane.setCenter(firstNameLabel);
        lastNameBorderPane.setCenter(lastNameLabel);
        usernameBorderPane.setCenter(usernameLabel);
        roleBorderPane.setCenter(roleLabel);
        passwordBorderPane.setCenter(passwordLabel);
    }

    private void initializeTextFields() {
        firstNameTextField = new TextField();
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField = new TextField();
        lastNameTextField.setText(user.getLastName());
        usernameTextField = new TextField();
        usernameTextField.setText(user.getLoginName());
        passwordTextField = new TextField();
        passwordTextField.setText(user.getPassword());

        firstNameTextField.getStyleClass().add("custom-text-field");
        lastNameTextField.getStyleClass().add("custom-text-field");
        usernameTextField.getStyleClass().add("custom-text-field");
        passwordTextField.getStyleClass().add("custom-text-field");
    }
}
