package GUI.Controllers;

import BE.Citizen;
import GUI.Models.MainModel;
import GUI.Utils.SceneSetter;
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

    @FXML
    void toShowCurrentCitizen(MouseEvent event) throws Exception {
        currentCitizen = tableViewCitizens.getSelectionModel().getSelectedItem();
        mainModel.setCurrentCitizen(currentCitizen);
        String textSelfCare = mainModel.getCitizenFunctionalityState(currentCitizen.getId()).get(2).getProfessNote();
        String textWash = mainModel.getCitizenFunctionalityState(currentCitizen.getId()).get(2).getProfessNote();
        String textMove = mainModel.getCitizenFunctionalityState(currentCitizen.getId()).get(2).getProfessNote();
        String textDailyRoutine = mainModel.getCitizenFunctionalityState(currentCitizen.getId()).get(2).getProfessNote();
        String textMobility = mainModel.getCitizenFunctionalityState(currentCitizen.getId()).get(2).getProfessNote();
        String textLifeStory = mainModel.getGeneralInfo(currentCitizen.getGeneralInfo()).getLifeStory();

        /*if (!textSelfCare.isEmpty()) labelSelfCare.setText(textSelfCare);
        else labelSelfCare.setText("empty");
        if (!textWash.isEmpty()) labelWash.setText(textWash);
        else labelWash.setText("empty");
        if (!textMove.isEmpty()) labelMove.setText(textMove);
        else labelMove.setText("empty");
        if (!textDailyRoutine.isEmpty()) labelDailyRoutine.setText(textDailyRoutine);
        else labelDailyRoutine.setText("empty");
        if (!textMobility.isEmpty()) labelMobility.setText(textMobility);
        else labelMobility.setText("empty");
        if (!textLifeStory.isEmpty()) labelLifeStory.setText(textLifeStory);
        else labelLifeStory.setText("empty");*/


    } // TODO Matej - needs to be changed because if the particular funcionality state is null, it will shows the error. I should create a method to check if it exists before I try to initialize.

}
