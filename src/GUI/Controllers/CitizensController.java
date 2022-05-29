package GUI.Controllers;

import BE.Citizen;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
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
    MAdminStudentViewController adminStudentViewController;

    public CitizensController() throws IOException {
        mainModel = new MainModel();
        adminStudentViewController = new MAdminStudentViewController();
    }

    @FXML
    private Button generalEditButton, deleteButton;

    @FXML
    private TableColumn<Citizen, String> tableColumnFName, tableColumnLName;

    @FXML
    private TableColumn<Citizen, Integer> tableColumnId;

    @FXML
    private TableView<Citizen> tableViewCitizens;

    private Citizen citizen;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTableView();
        try {
            updateTableView();
        } catch (Exception | UserException e) {
            e.printStackTrace();
        }
    }

    private void updateTableView() throws UserException {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColumnLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableViewCitizens.getItems().setAll(mainModel.getAllCitizenFromOneSchool(mainModel.getCurrentSchoolId()));
        System.out.println(mainModel.getCurrentSchoolId());
    }

    private void setupTableView() {
        tableViewCitizens.setRowFactory(tv -> {
            TableRow<Citizen> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                    citizen = row.getItem();
                    generalEditButton.setDisable(false);
                    deleteButton.setDisable(false);
                }
            });
            return row;
        });
    }

    public void handleEditButton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CitizensEditView.fxml"));
        Parent root = loader.load();

        CitizensEditController citizensEditController = loader.getController();
        citizensEditController.getCitizen(citizen);

        Stage stage = new Stage();
        stage.setTitle("Editing citizen");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleCreateButton() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CreateCitizen.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Create new citizen");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleDeleteButton() throws UserException {
        mainModel.deleteCitizen(citizen);
    }
}
