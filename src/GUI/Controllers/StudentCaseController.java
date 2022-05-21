package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentCaseController implements Initializable {

    @FXML
    private Button btnFillCase;

    @FXML
    private Button btnSeeMore;

    @FXML
    private Label labelLifeStory;

    @FXML
    private TableColumn<?, ?> tableColFName;

    @FXML
    private TableColumn<?, ?> tableColId;

    @FXML
    private TableColumn<?, ?> tableColLName;

    @FXML
    private TableView<?> tableViewCases;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    @FXML
    void selectedCase(MouseEvent event) {

    }

    @FXML
    void toFIllCase(ActionEvent event) {

    }

    @FXML
    void toSeeMore(ActionEvent event) {

    }


}
