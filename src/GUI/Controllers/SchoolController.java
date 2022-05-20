package GUI.Controllers;

import BE.School;
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

public class SchoolController implements Initializable {
    MainModel mainModel;
    School clickedSchool;
    SceneSetter sceneSetter;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnEdit;

    @FXML
    private Label labelNameView;

    @FXML
    private TableColumn<School, String> tableColCity;

    @FXML
    private TableColumn<School, String> tableColName;

    @FXML
    private TableView<School> tableViewSchools;

    public SchoolController() throws IOException {
        mainModel = new MainModel();
        sceneSetter = new SceneSetter();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            updateTableView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void toCreateNewSchool(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/GUI/Views/CreateSchoolView.fxml"));
        sceneSetter.setScene(loader);
    }

    @FXML
    void toDeleteCurSchool(ActionEvent event) throws Exception {
        mainModel.deleteSchool(clickedSchool);
        System.out.println("school is about to delete: " + clickedSchool);
    }

    @FXML
    void toEditCurrentSchool(ActionEvent event) throws IOException {

        EditSchoolController editSchoolController = new EditSchoolController(mainModel.getCurrentSchool());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/Views/EditSchoolView.fxml"));
        loader.setController(editSchoolController);
        sceneSetter.setScene(loader);
    }

    @FXML
    void toShowUser(MouseEvent event) {
        clickedSchool = tableViewSchools.getSelectionModel().getSelectedItem();
        mainModel.setCurrentSchool(clickedSchool);
    }

    public void updateTableView() throws Exception {
        tableViewSchools.getItems().clear();
        tableColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        tableViewSchools.getItems().setAll(mainModel.getAllSchools());
    }


}
