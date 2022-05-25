package GUI.Controllers;

import BE.Citizen;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    private Button btnFillCase;

    @FXML
    private Button btnSeeMore;

    @FXML
    private Label labelLifeStory;

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
            setUpTableView();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    void setUpTableView() throws Exception {
        tableColId.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableColFName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tableColLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        //tableViewCases.getItems().setAll();
    }


    @FXML
    void selectedCase(MouseEvent event) {
        clickedCitizen = tableViewCases.getSelectionModel().getSelectedItem();
    }

    @FXML
    void toFIllCase(ActionEvent event) {

    }

    @FXML
    void toSeeMore(ActionEvent event) {

    }


}
