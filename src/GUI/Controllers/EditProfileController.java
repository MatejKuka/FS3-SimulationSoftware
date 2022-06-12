package GUI.Controllers;

import BE.User;
import BLL.exeptions.UserException;
import BLL.utils.UserFactory;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditProfileController implements Initializable {
    private MainModel model;

    @FXML
    private BorderPane editBorderPane, deleteBorderPane, firstNameBorderPane, lastNameBorderPane, usernameBorderPane, roleBorderPane, passwordBorderPane;

    private User user;
    private TextField firstNameTextField, lastNameTextField, usernameTextField, passwordTextField;
    private UserFactory userFactory;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            userFactory = new UserFactory();
            model = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        user = MainModel.currentUser;
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
            // we get the static instance of user from main model then we update or catch errors
            try {
                user = MainModel.currentUser;
                model.updateUser(user.getUserID(), firstNameTextField.getText(), lastNameTextField.getText(), usernameTextField.getText(), passwordTextField.getText());

                User newUser = userFactory.createUser(user.getUserID(), firstNameTextField.getText(), lastNameTextField.getText(), usernameTextField.getText(), passwordTextField.getText(), getEnum(user.getRoleID()));
                model.setCurrentUser(newUser);
            } catch (UserException e) {
                e.printStackTrace();
            }
            // returning to initial ui state
            setupLabels(firstNameTextField.getText(), lastNameTextField.getText(), usernameTextField.getText(), user.getRoleID(), passwordTextField.getText());
            cleanBorderPanes();
            setupInitBorderPanes(editButton, deleteButton);
        });
        //deleting user and redirecting to log in view
        deleteButton.setOnAction(event -> {
            try {
                model.deleteUser(user);
            } catch (UserException e) {
                e.printStackTrace();
            }
            Parent root;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Views/LoginView.fxml"));
            try {
                root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                Stage stageClose = (Stage) deleteButton.getScene().getWindow();
                stageClose.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    // Setting up initial state of buttons located under labels
    private void setupInitBorderPanes(Node editButton, Node deleteButton) {
        editBorderPane.setCenter(editButton);
        deleteBorderPane.setCenter(deleteButton);
    }

    // Clear border panes so we can add new ones
    private void cleanBorderPanes() {
        editBorderPane.getChildren().clear();
        deleteBorderPane.getChildren().clear();
    }
    // Clear border panes that contain info about user
    private void cleanNodes() {
        firstNameBorderPane.getChildren().clear();
        lastNameBorderPane.getChildren().clear();
        usernameBorderPane.getChildren().clear();
        passwordBorderPane.getChildren().clear();
    }
    // Setting text-fields after edit button is hit
    private void setupTextFields() {
        firstNameBorderPane.setCenter(firstNameTextField);
        lastNameBorderPane.setCenter(lastNameTextField);
        usernameBorderPane.setCenter(usernameTextField);
        passwordBorderPane.setCenter(passwordTextField);
    }
    // First we clean all border panes then we create labels, and finally we set them to be in center of border panes
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
    // creating text fields and assigning css.
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
    private UserFactory.UserType getEnum(int roleId) {
        if (roleId == 1) {
            return UserFactory.UserType.ADMIN;
        }
        if (roleId == 2) {
            return UserFactory.UserType.TEACHER;
        }
        else return UserFactory.UserType.STUDENT;
    }

}
