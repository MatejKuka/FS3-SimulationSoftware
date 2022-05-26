package GUI.Controllers;

import BE.Citizen;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import GUI.Utils.SceneSetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class StudentCaseController implements Initializable {
    Citizen clickedCitizen;
    MainModel mainModel;
    SceneSetter sceneSetter;

    @FXML
    private Button btnFillCase;

    @FXML
    private Button btnSeeMore;

    @FXML
    private Label labelLifeStory;

    @FXML
    private Label labelMessage;

    @FXML
    private TableColumn<Citizen, String> tableColFName;

    @FXML
    private TableColumn<Citizen, Integer> tableColId;

    @FXML
    private TableColumn<Citizen, String> tableColLName;

    @FXML
    private TableView<Citizen> tableViewCases;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
            sceneSetter = new SceneSetter();
            setUpTableView();
        } catch (Exception | UserException e) {
            e.printStackTrace();
        }
        labelMessage.setText(" ");
    }

    void setUpTableView() throws UserException {
        tableColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableViewCases.getItems().setAll(mainModel.getStudentCitizens(mainModel.getCurrentUser().getUserID()));
    }


    @FXML
    void selectedCase(MouseEvent event) {
        clickedCitizen = tableViewCases.getSelectionModel().getSelectedItem();
        mainModel.setChosenCitizenFillUp(clickedCitizen);
    }

    @FXML
    void toFIllCase(ActionEvent event) {
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/NewUserView.fxml"));
        sceneSetter.setScene(loader);*/
    }

    @FXML
    void toSeeMore(ActionEvent event) {
        if (clickedCitizen != null) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/FillingUPCaseView.fxml"));
        sceneSetter.setScene(loader);
        labelMessage.setText(" ");
        } else labelMessage.setText("First you have to click in particular citizen");
    }


}
