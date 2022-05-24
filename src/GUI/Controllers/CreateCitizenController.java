package GUI.Controllers;

import BE.School;
import GUI.Models.MainModel;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreateCitizenController implements Initializable {
    private MainModel mainModel;
    private List<School> schoolList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
            schoolList = mainModel.getAllSchools();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
