package GUI.Controllers;

import BE.Student;
import BE.User;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GroupsViewController implements Initializable {
    @FXML
    private TableView<User> studentsTableView;
    @FXML
    private TableColumn<User, String> firstNameCol, lastNameCol;
    private MainModel mainModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            setupStudentsTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupStudentsTableView() throws Exception {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        studentsTableView.setItems(mainModel.getUsersByRole(mainModel.getRoleId()));
    }
}
