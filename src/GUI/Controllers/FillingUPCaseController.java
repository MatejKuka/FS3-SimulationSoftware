package GUI.Controllers;

import BE.HealthConditions;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FillingUPCaseController implements Initializable {

    MainModel mainModel;
    HealthConditions healthConditions;
    int typeOfCase;

    @FXML
    private ComboBox<String> comboBoxExpLevel;

    @FXML
    private ComboBox<String> comboBoxSaving;

    @FXML
    private TextField datePickerFollDate;

    @FXML
    private TextArea textAreaCurrAss;

    @FXML
    private TextArea textAreaObsNotes;

    @FXML
    private TextArea textAreaProfNote;

    @FXML
    private Label labelFName;

    @FXML
    private Label labelLName;

    @FXML
    private Label labelNameHC;

    @FXML
    private Label labelMessage;

    public FillingUPCaseController() {
    }

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
        labelMessage.setText(" ");
    }

    private void setTypeOfCase(int number) {
        typeOfCase = number;
    }

    private int getTypeOfCase() {
        return typeOfCase;
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

    void setLabelName(String labelko) {
        labelNameHC.setText(labelko);
    }

    @FXML
    void toCancel() {
        labelMessage.setText(" ");
    }

    @FXML
    void toSave() throws UserException {
        if (comboBoxSaving.getSelectionModel().getSelectedIndex() != -1 && !textAreaProfNote.getText().isEmpty() && !textAreaCurrAss.getText().isEmpty() &&
                comboBoxExpLevel.getSelectionModel().getSelectedIndex() != -1 && !datePickerFollDate.getText().isEmpty() && !textAreaObsNotes.getText().isEmpty()) {
            HealthConditions healthConditionsUpdated = new HealthConditions(healthConditions.getId(),
                    comboBoxSaving.getSelectionModel().getSelectedItem().toLowerCase(),
                    textAreaProfNote.getText(),
                    textAreaCurrAss.getText(),
                    comboBoxExpLevel.getSelectionModel().getSelectedItem().toLowerCase(),
                    datePickerFollDate.getText(),
                    textAreaObsNotes.getText(),
                    getTypeOfCase(),
                    mainModel.getChosenCitizenFillUp().getId());
            mainModel.updateHealthConditions(healthConditionsUpdated);
            System.out.println(healthConditionsUpdated);
            labelMessage.setText(" ");
        } else {
            System.out.println("mistake");
            labelMessage.setText("One of the input is empty");
        }
    }


    private void setUpNodes(int numberOfIndex) throws UserException {
        healthConditions = mainModel.getHealthCondition(mainModel.getChosenCitizenFillUp().getId()).get(numberOfIndex);
        textAreaProfNote.setText(healthConditions.getProfessNote());
        textAreaCurrAss.setText(healthConditions.getCurrAssess());
        textAreaObsNotes.setText(healthConditions.getObservNote());
        datePickerFollDate.setText(healthConditions.getFollUpDate());
        comboBoxSaving.getSelectionModel().select(setTextComboBoxSave(healthConditions.getSaveAs()));
        comboBoxExpLevel.getSelectionModel().select(setTextComboBoxLevel(healthConditions.getExpectedLvl()));
    }

    private int setTextComboBoxSave(String savedAs) {
        return switch (savedAs) {
            case "potential" -> 1;
            case "relevant" -> 2;
            default -> 0;
        };
    }

    private int setTextComboBoxLevel(String expectedLevel) {
        return switch (expectedLevel) {
            case "remains unchanged" -> 1;
            case "disappeared" -> 2;
            default -> 0;
        };
    }

    @FXML
    void toHC1() throws UserException {
        setUpNodes(0);
        setLabelName("Personal Care");
        setTypeOfCase(1);
    }

    @FXML
    void toHC2() throws UserException {
        setUpNodes(1);
        setLabelName("Daily Activities");
        setTypeOfCase(2);
    }

    @FXML
    void toHC3() throws UserException {
        setUpNodes(2);
        setLabelName("Mobility and movement");
        setTypeOfCase(3);
    }

    @FXML
    void toHC4() throws UserException {
        setUpNodes(3);
        setLabelName("Fluid intake");
        setTypeOfCase(4);
    }

    @FXML
    void toHC5() throws UserException {
        setUpNodes(4);
        setLabelName("Food intake");
        setTypeOfCase(5);
    }

    @FXML
    void toHC6() throws UserException {
        setUpNodes(5);
        setLabelName("Innapropriate weight change");
        setTypeOfCase(6);
    }

    @FXML
    void toHC7() throws UserException {
        setUpNodes(6);
        setLabelName("Problems with obesity");
        setTypeOfCase(7);
    }

    @FXML
    void toHC8() throws UserException {
        setUpNodes(7);
        setLabelName("Problems with underweight");
        setTypeOfCase(8);
    }

    @FXML
    void toHC9() throws UserException {
        setUpNodes(8);
        setLabelName("Problems with surgical wounds");
        setTypeOfCase(9);
    }

    @FXML
    void toHC10() throws UserException {
        setUpNodes(9);
        setLabelName("Problems with diabetic ulcers");
        setTypeOfCase(10);
    }

    @FXML
    void toHC11() throws UserException {
        setUpNodes(10);
        setLabelName("Problems with cancerous lesions");
        setTypeOfCase(11);
    }

    @FXML
    void toHC12() throws UserException {
        setUpNodes(11);
        setLabelName("Problems with pressure ulcers");
        setTypeOfCase(12);
    }

    @FXML
    void toHC13() throws UserException {
        setUpNodes(12);
        setLabelName("Problems with arterial ulcer");
        setTypeOfCase(13);
    }

    @FXML
    void toHC14() throws UserException {
        setUpNodes(13);
        setLabelName("Problems with venous ulcer");
        setTypeOfCase(14);
    }

    @FXML
    void toHC15() throws UserException {
        setUpNodes(14);
        setLabelName("Problems with mixed wounds");
        setTypeOfCase(15);
    }

    @FXML
    void toHC16() throws UserException {
        setUpNodes(15);
        setLabelName("Problems with trauma wounds");
        setTypeOfCase(16);
    }

    @FXML
    void toHC17() throws UserException {
        setUpNodes(16);
        setLabelName("Other skin and mucous membrane problems");
        setTypeOfCase(17);
    }

    @FXML
    void toHC18() throws UserException {
        setUpNodes(17);
        setLabelName("Problem with communication");
        setTypeOfCase(18);
    }

    @FXML
    void toHC19() throws UserException {
        setUpNodes(18);
        setLabelName("Problems with socializing");
        setTypeOfCase(19);
    }

    @FXML
    void toHC20() throws UserException {
        setUpNodes(19);
        setLabelName("Emotional problems");
        setTypeOfCase(20);
    }

    @FXML
    void toHC21() throws UserException {
        setUpNodes(20);
        setLabelName("Problems with abuse");
        setTypeOfCase(21);
    }

    @FXML
    void toHC22() throws UserException {
        setUpNodes(21);
        setLabelName("Mental problems");
        setTypeOfCase(22);
    }

    @FXML
    void toHC23() throws UserException {
        setUpNodes(22);
        setLabelName("Problem with respiration");
        setTypeOfCase(23);
    }

    @FXML
    void toHC24() throws UserException {
        setUpNodes(23);
        setLabelName("Problem with circulation");
        setTypeOfCase(24);
    }

    @FXML
    void toHC25() throws UserException {
        setUpNodes(24);
        setLabelName("Problem with sexuality");
        setTypeOfCase(25);
    }

    @FXML
    void toHC26() throws UserException {
        setUpNodes(25);
        setLabelName("Acute pain");
        setTypeOfCase(26);
    }

    @FXML
    void toHC27() throws UserException {
        setUpNodes(26);
        setLabelName("Periodic pain");
        setTypeOfCase(27);
    }

    @FXML
    void toHC28() throws UserException {
        setUpNodes(27);
        setLabelName("Chronic pain");
        setTypeOfCase(28);
    }

    @FXML
    void toHC29() throws UserException {
        setUpNodes(28);
        setLabelName("Problems with the sense of sight");
        setTypeOfCase(29);
    }


    @FXML
    void toHC30() throws UserException {
        setUpNodes(29);
        setLabelName("Problems with the sense of smell");
        setTypeOfCase(30);
    }

    @FXML
    void toHC31() throws UserException {
        setUpNodes(30);
        setLabelName("Hearing problems");
        setTypeOfCase(31);
    }

    @FXML
    void toHC32() throws UserException {
        setUpNodes(31);
        setLabelName("Problems with the sense of taste");
        setTypeOfCase(32);
    }

    @FXML
    void toHC33() throws UserException {
        setUpNodes(32);
        setLabelName("Problems with the sense of touch");
        setTypeOfCase(33);
    }

    @FXML
    void toHC34() throws UserException {
        setUpNodes(33);
        setLabelName("Circadian rhythm problems");
        setTypeOfCase(34);
    }

    @FXML
    void toHC35() throws UserException {
        setUpNodes(34);
        setLabelName("Sleep problems");
        setTypeOfCase(35);
    }

    @FXML
    void toHC36() throws UserException {
        setUpNodes(35);
        setLabelName("Memory problems");
        setTypeOfCase(36);
    }

    @FXML
    void toHC37() throws UserException {
        setUpNodes(36);
        setLabelName("Problems with insight into treatment purposes");
        setTypeOfCase(37);
    }

    @FXML
    void toHC38() throws UserException {
        setUpNodes(37);
        setLabelName("Problems with disease insight");
        setTypeOfCase(38);
    }

    @FXML
    void toHC39() throws UserException {
        setUpNodes(38);
        setLabelName("Problem with urination");
        setTypeOfCase(39);
    }

    @FXML
    void toHC40() throws UserException {
        setUpNodes(39);
        setLabelName("Problem with urinary incontinence");
        setTypeOfCase(40);
    }

    @FXML
    void toHC41() throws UserException {
        setUpNodes(40);
        setLabelName("Problems with stool incontinence");
        setTypeOfCase(41);
    }

    @FXML
    void toHC42() throws UserException {
        setUpNodes(41);
        setLabelName("Stomach and intestinal problems");
        setTypeOfCase(42);
    }

    @FXML
    void toHC43() throws UserException {
        setUpNodes(42);
        setLabelName("Problems with fluid from drains");
        setTypeOfCase(43);
    }


}
