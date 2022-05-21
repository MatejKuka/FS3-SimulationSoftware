package GUI.Controllers;

import BE.Citizen;
import BE.Group;
import BE.User;
import GUI.Models.MainModel;
import GUI.Utils.SceneSetter;
import com.sun.tools.javac.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CitizensController implements Initializable {
    MainModel mainModel;
    Citizen currentCitizen;
    MAdminStudentViewController adminStudentViewController;
    SceneSetter sceneSetter;

    public CitizensController() throws IOException {
        mainModel = new MainModel();
        adminStudentViewController = new MAdminStudentViewController();
        sceneSetter = new SceneSetter();
    }

    @FXML
    private Button btnEditFS, btnEditGI, btnSeeMoreFS, btnSeeMoreGI;

    @FXML
    private Label labelDailyRoutine, labelLifeStory, labelMobility, labelMove, labelSelfCare, labelWash;

    @FXML
    private TableColumn<Citizen, String> tableColumnFName, tableColumnLName;

    @FXML
    private TableColumn<Citizen, Integer> tableColumnId;

    @FXML
    private TableView<Citizen> tableViewCitizens;

    @FXML
    private Button btnCreate, btnDelete, btnEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            setupTableView();
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizensEditView.fxml"));
        sceneSetter.setScene(loader);
    }

    @FXML
    void toEditGI(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizensEditView.fxml"));
        sceneSetter.setScene(loader);
    }

    @FXML
    void toSeeMoreFS(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizensEditView.fxml"));
        sceneSetter.setScene(loader);
    }

    @FXML
    void toSeeMoreGI(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizensEditView.fxml"));
        sceneSetter.setScene(loader);
    }

//    @FXML
//    void toShowCurrentCitizen(MouseEvent event) throws Exception {
//        currentCitizen = tableViewCitizens.getSelectionModel().getSelectedItem();
//        System.out.println(currentCitizen);
////        mainModel.setCurrentCitizen(currentCitizen);
//
//    } // TODO Matej - needs to be changed because if the particular funcionality state is null, it will shows the error. I should create a method to check if it exists before I try to initialize.


    @FXML
    void toCreate(ActionEvent event) {

    }

    @FXML
    void toDelete(ActionEvent event) throws Exception {
        System.out.println("Citizen is about to delete: " + currentCitizen + " " + currentCitizen.getGeneralInfo());
        //mainModel.deleteCitizen(currentCitizen, currentCitizen.getGeneralInfo());
    } //TODO Error - this needs to be fixed (Matej)

    @FXML
    void toEdit(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizensEditView.fxml"));
        sceneSetter.setScene(loader);
    }


    private void setupTableView() {
        TableRow<Citizen> row = new TableRow<>();
        row.setOnMouseClicked(event -> {
            if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                Citizen clickedRow = row.getItem();
                System.out.println(clickedRow);
            }
        });
    }
}
