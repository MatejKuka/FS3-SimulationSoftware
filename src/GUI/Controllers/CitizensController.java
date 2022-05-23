package GUI.Controllers;

import BE.Citizen;
import GUI.Models.MainModel;
import GUI.Utils.SceneSetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    private Citizen citizen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTableView();
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
        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizensEditView.fxml"));
        sceneSetter.setScene(loader);*/
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
        CitizensEditController citizensEditController = loader.getController();
        System.out.println(citizensEditController);
//        citizensEditController.setCitizensController(this);
//        citizensEditController.print(citizen);

        sceneSetter.setScene(loader);
    }


    private void setupTableView() {
        tableViewCitizens.setRowFactory(tv -> {
            TableRow<Citizen> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    citizen = row.getItem();
                }
            });
            return row;
        });
    }

    public void handleEditButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizensEditView.fxml"));
        Parent root = loader.load();

        CitizensEditController citizensEditController = loader.getController();
        citizensEditController.setCitizensController(this);
        citizensEditController.getCitizen(citizen);

        Stage stage = new Stage();
        stage.setTitle("New/Edit Event");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
