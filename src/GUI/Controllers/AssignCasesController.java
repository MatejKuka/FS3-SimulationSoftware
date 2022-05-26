package GUI.Controllers;

import BE.Citizen;
import BE.Student;
import BE.User;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AssignCasesController implements Initializable {
    MainModel mainModel;
    Citizen clickedCitizen;
    Student clickedUser;
    String initialStringHC = "empty";

    @FXML
    private Button btnAssign;

    @FXML
    private Label labelFirstname;

    @FXML
    private Label labelID;

    @FXML
    private Label labelLastName;

    @FXML
    private Label labelStudentName;

    @FXML
    private Label labelMessage;

    @FXML
    private TableView<Citizen> tableViewCitizen;

    @FXML
    private TableView<User> tableViewStudents;

    @FXML
    private TableColumn<Citizen, String> tcFNameCitizen;

    @FXML
    private TableColumn<User, String> tcFNameStudent;

    @FXML
    private TableColumn<Citizen, Integer> tcIdCitizen;

    @FXML
    private TableColumn<Citizen, String> tcLNameCitizen;

    @FXML
    private TableColumn<User, String> tcLNameStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
            setUpTableViewStudent();
            setUpTableViewCases();
        } catch (Exception | UserException e) {
            e.printStackTrace();
        }
        labelStudentName.setText(" ");
        labelID.setText(" ");
        labelFirstname.setText(" ");
        labelLastName.setText(" ");
        labelMessage.setText(" ");
    }

    @FXML
    void toAssignCitizen(ActionEvent event) throws UserException {
        if (clickedUser != null && clickedCitizen != null) {
            mainModel.addCitizenToStudent(clickedUser, clickedCitizen);
            System.out.println(clickedUser + " user got assinged " + clickedCitizen);
        } else labelMessage.setText("Something went wrong!");
    }

    @FXML
    void handleClickedCitizen(MouseEvent event) {
        clickedCitizen = tableViewCitizen.getSelectionModel().getSelectedItem();
        labelFirstname.setText(clickedCitizen.getFirstName());
        labelLastName.setText(clickedCitizen.getLastName());
        labelID.setText(String.valueOf(clickedCitizen.getId()));
    }

    @FXML
    void handleClickedStudent(MouseEvent event) {
        clickedUser = (Student) tableViewStudents.getSelectionModel().getSelectedItem();
        labelStudentName.setText(clickedUser.getFullName());
    }

    void setUpTableViewStudent() throws UserException {
        tcFNameStudent.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLNameStudent.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableViewStudents.getItems().setAll(mainModel.getAllStudents());
    }
    void setUpTableViewCases() throws UserException {
        tcIdCitizen.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcFNameCitizen.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tcLNameCitizen.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableViewCitizen.getItems().setAll(mainModel.getAllCitizenFromOneSchool(mainModel.getCurrentSchoolId()));
    }

}
