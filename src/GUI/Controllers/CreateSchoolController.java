package GUI.Controllers;

import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CreateSchoolController implements Initializable {
    MainModel mainModel;

    @FXML
    private Button btnSave;

    @FXML
    private Label labelMessage;

    @FXML
    private TextField txtFieldCity, txtFieldName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        labelMessage.setText(" ");
    }

    @FXML
    void toCancelPage() {
        Stage stage = (Stage) btnSave.getScene().getWindow();
        stage.close();
    }

    @FXML
    void toCreateNewSchool() throws UserException {
        if (!txtFieldName.getText().isEmpty() && !txtFieldCity.getText().isEmpty()){
            mainModel.createSchool(txtFieldName.getText(), txtFieldCity.getText());
            System.out.println("Created new school");
            Stage stage = (Stage) btnSave.getScene().getWindow();
            stage.close();
        }

        labelMessage.setText("One of the input is empty");
    }

}
