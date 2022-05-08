package GUI.Controllers;

import BE.Citizen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CitizensController implements Initializable {

    @FXML
    private Button btnEditFS, btnEditGI, btnSeeMoreFS, btnSeeMoreGI;

    @FXML
    private Label labelDailyRoutine, labelLifeStory, labelMobility, labelMove, labelSelfCare, labelWash;

    @FXML
    private TableColumn<Citizen, String> tableColumnFName;

    @FXML
    private TableColumn<Citizen, Integer> tableColumnId;

    @FXML
    private TableColumn<Citizen, String> tableColumnLName;

    @FXML
    private TableView<Citizen> tableViewCitizens;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void updateTableView() throws Exception {
        tableColumnFName.setCellValueFactory(new PropertyValueFactory<>("fName"));
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnLName.setCellValueFactory(new PropertyValueFactory<>("lName"));
        tableViewCitizens.getItems().setAll(mainModel.getUsersByRole(mainModel.getRoleId()));
    }

    @FXML
    void toEditFS(ActionEvent event) {

    }

    @FXML
    void toEditGI(ActionEvent event) {

    }

    @FXML
    void toSeeMoreFS(ActionEvent event) {

    }

    @FXML
    void toSeeMoreGI(ActionEvent event) {

    }

}
