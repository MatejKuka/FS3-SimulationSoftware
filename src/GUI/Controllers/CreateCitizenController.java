package GUI.Controllers;

import BE.Citizen;
import BE.School;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CreateCitizenController implements Initializable {
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField firstNameTextField, lastNameTextField;

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

    public void handleSaveButton(ActionEvent event) {
        String selectedComboBoxItem = comboBox.getValue();
        List<School> filteredSchoolList = schoolList.stream().filter(school -> Objects.equals(school.getName(), selectedComboBoxItem)).collect(Collectors.toList());
        Citizen newCitizen = new Citizen()
    }
}
