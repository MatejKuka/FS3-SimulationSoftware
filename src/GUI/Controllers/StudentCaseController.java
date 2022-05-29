package GUI.Controllers;

import BE.Citizen;
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
import java.net.URL;
import java.util.ResourceBundle;

public class StudentCaseController implements Initializable {
    Citizen clickedCitizen;
    MainModel mainModel;

    @FXML
    private Label labelMessage;

    @FXML
    private TableColumn<Citizen, String> tableColFName,tableColLName;

    @FXML
    private TableColumn<Citizen, Integer> tableColId;

    @FXML
    private TableView<Citizen> tableViewCases;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
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
    void selectedCase() {
        clickedCitizen = tableViewCases.getSelectionModel().getSelectedItem();
        mainModel.setChosenCitizenFillUp(clickedCitizen);
    }

    @FXML
    void toSeeMore() {
        if (clickedCitizen != null) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/FillingUPCaseView.fxml"));
        SceneSetter.setScene(loader);
        labelMessage.setText(" ");
        } else labelMessage.setText("First you have to click in particular citizen");
    }


}
