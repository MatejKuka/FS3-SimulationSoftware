package GUI.Controllers;

import BE.School;
import BE.User;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import GUI.Utils.SceneSetter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SchoolController implements Initializable {
    private final MainModel mainModel;
    private School clickedSchool;
    private User chosenUser;

    @FXML
    private Label labelMessage;

    @FXML
    private TableColumn<School, String> tableColCity, tableColName;

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, Integer> tableColID;

    @FXML
    private TableColumn<User, String> tableColLogName, tableColFirstName;

    @FXML
    private TableView<School> tableViewSchools;

    public SchoolController() throws IOException {
        mainModel = new MainModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            updateTableView();
            updateTableView1();
        } catch (Exception | UserException e) {
            e.printStackTrace();
        }
        labelMessage.setText(" ");
    }

    @FXML
    void toCreateNewSchool() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CreateSchoolView.fxml"));
        SceneSetter.setScene(loader);
    }

    @FXML
    void toDeleteCurSchool() throws UserException {
        mainModel.deleteSchool(clickedSchool);
    }

    @FXML
    void toEditCurrentSchool() throws IOException {
        EditSchoolController editSchoolController = new EditSchoolController(mainModel.getCurrentSchool());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Views/EditSchoolView.fxml"));
        loader.setController(editSchoolController);
        SceneSetter.setScene(loader);
    }

    @FXML
    void toShowUser() {
        clickedSchool = tableViewSchools.getSelectionModel().getSelectedItem();
        mainModel.setCurrentSchool(clickedSchool);
    }

    public void updateTableView() throws UserException {
        tableViewSchools.getItems().setAll(mainModel.getAllSchools());
        tableColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColCity.setCellValueFactory(new PropertyValueFactory<>("city"));
    }

    public void updateTableView1() throws UserException {
        tableColID.setCellValueFactory(new PropertyValueFactory<>("userID"));
        tableColLogName.setCellValueFactory(new PropertyValueFactory<>("loginName"));
        tableColFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableView.getItems().setAll(mainModel.getAllAdmins());
    }

    @FXML
    void toAssignAdmin() throws UserException {
        chosenUser = tableView.getSelectionModel().getSelectedItem();
        if (chosenUser != null && clickedSchool != null) {
            mainModel.addUserToSchool(chosenUser);
            labelMessage.setText(" ");
        } else labelMessage.setText("You have to choose school and admin to assign");
    }

    @FXML
    void toDeleteAdmin() throws UserException {
        chosenUser = tableView.getSelectionModel().getSelectedItem();
        if (chosenUser != null) {
            mainModel.deleteUser(chosenUser);
        } else labelMessage.setText("You have to choose a user to be deleted");
    }


}
