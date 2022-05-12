package GUI.Controllers;

import BE.User;
import GUI.Models.MainModel;
import GUI.Utils.SceneSetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    MainModel mainModel;
    MAdminStudentViewController menuController;
    User userToShow;
    SceneSetter sceneSetter;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnEdit;

    @FXML
    private Label labelNameView;

    @FXML
    private Label labelFirstName, labelUsername, labelLastName;

    @FXML
    private TableColumn<User, String> tableColFname;

    @FXML
    private TableColumn<User, String> tableColLname;

    @FXML
    private TableView<User> tableViewUsers;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sceneSetter = new SceneSetter();
        try {
            mainModel = new MainModel();
            menuController = new MAdminStudentViewController();
            updateTableView();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        labelNameView.setText(mainModel.getRoleName());
    }

    private void updateTableView() throws Exception {
        tableColFname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColLname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableViewUsers.getItems().setAll(mainModel.getUsersByRole(mainModel.getRoleId()));
    }

    @FXML
    void toCreateNewUser(ActionEvent event) throws IOException {
        //menuController.setScene("/GUI/Views/NewUserView.fxml");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/NewUserView.fxml"));
        sceneSetter.setScene(btnEdit, loader);
    }

    @FXML
    void toDeleteCurUser(ActionEvent event) throws Exception {
        User userToDelete = tableViewUsers.getSelectionModel().getSelectedItem();
        //mainModel.deleteUser(userToDelete);
        mainModel.getUsersByRole(mainModel.getRoleId()).remove(userToDelete);
        System.out.println("clicked!");
    }

    @FXML
    void toEditCurrentUser(ActionEvent event) throws IOException {
        System.out.println("click");
        //menuController.setScene("/GUI/Views/EditUserView.fxml");
        EditUserController editUserController = new EditUserController(userToShow); // TODO there is a mistake
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/EditUserView.fxml"));
        loader.setController(editUserController);
        sceneSetter.setScene(btnEdit, loader);
    }

    @FXML
    void toShowUser(MouseEvent event) {
        userToShow = tableViewUsers.getSelectionModel().getSelectedItem();
        labelFirstName.setText(userToShow.getFirstName());
        labelLastName.setText(userToShow.getLastName());
        labelUsername.setText(userToShow.getLoginName());
    }

    public static void setScene(Node node, FXMLLoader loader) {

        try {

            Parent root = loader.load();

            Scene scene = new Scene(root,800,600);
            Stage primaryStage = (Stage) node.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    } //TODO Matej - nefunguje načítavanie NewUserView a EditUserView. Má to problém načítať

}
