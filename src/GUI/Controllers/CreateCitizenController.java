package GUI.Controllers;

import BE.School;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CreateCitizenController implements Initializable {
    @FXML
    private ComboBox<String> comboBox;

    private MainModel mainModel;
    private List<School> schoolList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
            schoolList = mainModel.getAllSchools();

            schoolList.forEach(school -> {
                comboBox.getItems().add(school.getName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
