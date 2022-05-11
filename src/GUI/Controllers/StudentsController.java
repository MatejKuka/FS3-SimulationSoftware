package GUI.Controllers;

import BE.User;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentsController implements Initializable {
    MainModel mainModel;
    MAdminStudentViewController menuController;

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
    void toCreateNewUser(ActionEvent event) {
        menuController.setScene("/GUI/Views/NewUserView.fxml");
    }

    @FXML
    void toDeleteCurUser(ActionEvent event) throws Exception {
        mainModel.deleteUser(tableViewUsers.getSelectionModel().getSelectedItem());
    }

    @FXML
    void toEditCurrentUser(ActionEvent event) {
        menuController.setScene("/GUI/Views/NewUserView.fxml");
    }
}
