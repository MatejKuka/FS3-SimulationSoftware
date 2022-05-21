package GUI.Controllers;

import BE.School;
import BE.User;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EditSchoolController implements Initializable {
    School school;
    MainModel mainModel;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnSave;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField txtFieldFName;

    @FXML
    private TextField txtFieldLName;

    public EditSchoolController(School school) throws IOException {
        this.school = school;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setFields(school);
        labelMessage.setText(" ");
    }

    @FXML
    void toCancelPage(ActionEvent event) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toCreateNewUser(ActionEvent event) throws Exception {
        if (!txtFieldFName.getText().isEmpty() && !txtFieldLName.getText().isEmpty()) {
            School newSchool = new School(school.getId() , txtFieldFName.getText(), txtFieldLName.getText());
            mainModel.updateSchool(newSchool);
            System.out.println("School updated" + newSchool);

            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.close();
        } else labelMessage.setText("One of the input is empty");
    }

    public void setFields(School schoolShow)
    {
        txtFieldFName.setText(schoolShow.getName());
        txtFieldLName.setText(schoolShow.getCity());

    }
}
