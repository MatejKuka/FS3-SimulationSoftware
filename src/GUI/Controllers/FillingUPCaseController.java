package GUI.Controllers;

import BE.Citizen;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FillingUPCaseController implements Initializable {

    MainModel mainModel;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> comboBoxExpLevel;

    @FXML
    private ComboBox<String> comboBoxSaving;

    @FXML
    private DatePicker datePickerFollDate;

    @FXML
    private Label labelCurrAss;

    @FXML
    private Label labelFName;

    @FXML
    private Label labelLName;

    @FXML
    private Label labelNameHC;

    @FXML
    private Label labelObNotes;

    @FXML
    private Label labelProfNote;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        labelFName.setText(mainModel.getChosenCitizenFillUp().getFirstName());
        labelLName.setText(mainModel.getChosenCitizenFillUp().getLastName());
        setLabelName(" ");
        setComboBoxSave();
        setComboBoxExpLevel();
    }

    private void setComboBoxSave() {
        comboBoxSaving.getItems().add("Active");
        comboBoxSaving.getItems().add("Potential");
        comboBoxSaving.getItems().add("Relevant");
    }

    private void setComboBoxExpLevel() {
        comboBoxExpLevel.getItems().add("Decreasing");
        comboBoxExpLevel.getItems().add("Remains unchanged");
        comboBoxExpLevel.getItems().add("Disappeared");
    }

    public FillingUPCaseController() {

    }

    void setLabelName(String labelko) {
        labelNameHC.setText(labelko);
    }

    @FXML
    void toCancel(ActionEvent event) {

    }

    @FXML
    void toEdit(ActionEvent event) {

    }

    private String getSaveAsComboBox(int indexC) {
        String output = "Active";
        switch (indexC) {
            case 0:
                output = "Active";
                break;
            case 1:
                output = "Potential";
                break;
            case 2:
                output = "Relevant";
                break;
        }
        System.out.println(indexC + " " + output);
        return output;
    }

    @FXML
    void toHC1(ActionEvent event) {
        //mainModel.createHealthCondition(getSaveAsComboBox(comboBoxSaving.getSelectionModel().getSelectedIndex()), );
        setLabelName("Personal Care");
    }

    @FXML
    void toHC2(ActionEvent event) {

    }

    @FXML
    void toHC3(ActionEvent event) {

    }

    @FXML
    void toHC4(ActionEvent event) {

    }

    @FXML
    void toHC5(ActionEvent event) {

    }

    @FXML
    void toHC6(ActionEvent event) {

    }

    @FXML
    void toHC7(ActionEvent event) {

    }

    @FXML
    void toHC8(ActionEvent event) {

    }

    @FXML
    void toHC9(ActionEvent event) {

    }

    @FXML
    void toHC10(ActionEvent event) {

    }

    @FXML
    void toHC11(ActionEvent event) {

    }

    @FXML
    void toHC12(ActionEvent event) {

    }

    @FXML
    void toHC13(ActionEvent event) {

    }

    @FXML
    void toHC14(ActionEvent event) {

    }

    @FXML
    void toHC15(ActionEvent event) {

    }

    @FXML
    void toHC16(ActionEvent event) {

    }

    @FXML
    void toHC17(ActionEvent event) {

    }

    @FXML
    void toHC18(ActionEvent event) {

    }

    @FXML
    void toHC19(ActionEvent event) {

    }

    @FXML
    void toHC20(ActionEvent event) {

    }

    @FXML
    void toHC21(ActionEvent event) {

    }

    @FXML
    void toHC22(ActionEvent event) {

    }

    @FXML
    void toHC23(ActionEvent event) {

    }

    @FXML
    void toHC24(ActionEvent event) {

    }

    @FXML
    void toHC25(ActionEvent event) {

    }

    @FXML
    void toHC26(ActionEvent event) {

    }

    @FXML
    void toHC27(ActionEvent event) {

    }

    @FXML
    void toHC28(ActionEvent event) {

    }

    @FXML
    void toHC29(ActionEvent event) {

    }


    @FXML
    void toHC30(ActionEvent event) {

    }

    @FXML
    void toHC31(ActionEvent event) {

    }

    @FXML
    void toHC32(ActionEvent event) {

    }

    @FXML
    void toHC33(ActionEvent event) {

    }

    @FXML
    void toHC34(ActionEvent event) {

    }

    @FXML
    void toHC35(ActionEvent event) {

    }

    @FXML
    void toHC36(ActionEvent event) {

    }

    @FXML
    void toHC37(ActionEvent event) {

    }

    @FXML
    void toHC38(ActionEvent event) {

    }

    @FXML
    void toHC39(ActionEvent event) {

    }


    @FXML
    void toHC40(ActionEvent event) {

    }

    @FXML
    void toHC41(ActionEvent event) {

    }

    @FXML
    void toHC42(ActionEvent event) {

    }

    @FXML
    void toHC43(ActionEvent event) {

    }

    @FXML
    void toSave(ActionEvent event) {

    }


}
