package GUI.Controllers;

import BE.Citizen;
import BE.User;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import GUI.Utils.SceneSetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AssignmentController implements Initializable {
    MainModel mainModel;
    Citizen citizenToShow;
    User clickedStudent;
    SceneSetter sceneSetter;

    @FXML
    private TableColumn<Citizen, String> tableColCIFName;

    @FXML
    private Label labelMessage;

    @FXML
    private TableColumn<Citizen, Integer> tableColCitID;

    @FXML
    private TableColumn<Citizen, String> tableColCitLName;

    @FXML
    private TableColumn<User, String> tableColSTFirstName;

    @FXML
    private TableColumn<User, String> tableColSTLastName;

    @FXML
    private TableView<User> tableViewStudents;

    @FXML
    private TableView<Citizen> tableViewCitizen;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
            sceneSetter = new SceneSetter();
            updateTableViewStudent();
        } catch (IOException | UserException e) {
            e.printStackTrace();
        }
        labelMessage.setText(" ");
    }

    @FXML
    void toOpenAnswers() {
        citizenToShow = tableViewCitizen.getSelectionModel().getSelectedItem();
        if(citizenToShow != null) {
            ViewAnswersController viewAnswersController = new ViewAnswersController(citizenToShow, clickedStudent);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Views/ViewAnswersView.fxml"));
            loader.setController(viewAnswersController);
            SceneSetter.setScene(loader);
        } else labelMessage.setText("You have to choose a citizen to open the answers");
    }

    @FXML
    void toShowStudentCitizens() throws UserException {
        clickedStudent = tableViewStudents.getSelectionModel().getSelectedItem();
        tableColCitID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tableColCIFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColCitLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableViewCitizen.getItems().setAll(mainModel.getStudentCitizens(clickedStudent.getUserID()));
    }

    private void updateTableViewStudent() throws UserException {
        tableColCitID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tableColSTFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColSTLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableViewStudents.getItems().setAll(mainModel.getAllStudents());
    }


}
