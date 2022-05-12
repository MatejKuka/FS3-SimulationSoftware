package GUI.Controllers;

import BE.User;
import GUI.Models.MainModel;
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
        showWindowUser(btnCreate, "/GUI/Views/NewUserView.fxml");
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
        showWindowUser(btnEdit, "/GUI/Views/EditUserView.fxml");
    }

    @FXML
    void toShowUser(MouseEvent event) {
        User userToShow = tableViewUsers.getSelectionModel().getSelectedItem();
        labelFirstName.setText(userToShow.getFirstName());
        labelLastName.setText(userToShow.getLastName());
        labelUsername.setText(userToShow.getLoginName());
    }

    public void showWindowUser(Node node, String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) node.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
