package GUI.Controllers;

import BE.Citizen;
import GUI.Models.MainModel;
import com.sun.tools.javac.Main;
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
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CitizensController implements Initializable {
    MainModel mainModel;
    Citizen currentCitizen;

    public CitizensController() throws IOException {
        mainModel = new MainModel();
    }

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
        try {
            updateTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateTableView() throws Exception {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColumnLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableViewCitizens.getItems().setAll(mainModel.getAllCitizenFromOneSchool(mainModel.getCurrentSchoolId()));
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

    @FXML
    void toShowCurrentCitizen(MouseEvent event) throws Exception {
        currentCitizen = tableViewCitizens.getSelectionModel().getSelectedItem();
        /*labelSelfCare.setText(mainModel.getGeneralInfo(currentCitizen.getGeneralInfo()).getLifeStory());
        labelWash;
        labelMove;
        labelDailyRoutine;
        labelMobility.setText(mainModel.getCitizenFunctionalityState(currentCitizen.getId).get) ; */
        labelLifeStory.setText(mainModel.getGeneralInfo(currentCitizen.getGeneralInfo()).getLifeStory());
    }

}
