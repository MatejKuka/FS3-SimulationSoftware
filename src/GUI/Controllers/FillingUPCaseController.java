package GUI.Controllers;

import BE.Citizen;
import BE.HealthConditions;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    void toCancel(ActionEvent event) {

    }

    @FXML
    void toSave(ActionEvent event) {

    }

    private String getTextComboBoxSave(int indexC) {
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

    private void setUpNodes(int numberOfIndex) throws Exception {
        HealthConditions healthConditions = mainModel.getHealthCondition(mainModel.getChosenCitizenFillUp().getId()).get(numberOfIndex);
        textAreaProfNote.setText(healthConditions.getProfessNote());
        textAreaCurrAss.setText(healthConditions.getCurrAssess());
        textAreaObsNotes.setText(healthConditions.getObservNote());
    }

    @FXML
    void toHC1(ActionEvent event) throws Exception {
        setUpNodes(0);
        setLabelName("Personal Care");
    }

    @FXML
    void toHC2(ActionEvent event)  throws Exception{
        setUpNodes(1);
        setLabelName("Daily Activities");
    }

    @FXML
    void toHC3(ActionEvent event) throws Exception{
        setUpNodes(2);
        setLabelName("Mobility and movement");
    }

    @FXML
    void toHC4(ActionEvent event) throws Exception {
        setUpNodes(3);
        setLabelName("Fluid intake");
    }

    @FXML
    void toHC5(ActionEvent event)  throws Exception{
        setUpNodes(4);
        setLabelName("Food intake");
    }

    @FXML
    void toHC6(ActionEvent event)  throws Exception{
        setUpNodes(5);
        setLabelName("Innapropriate weight change");
    }

    @FXML
    void toHC7(ActionEvent event)  throws Exception{
        setUpNodes(6);
        setLabelName("Problems with obesity");
    }

    @FXML
    void toHC8(ActionEvent event)  throws Exception{
        setUpNodes(7);
        setLabelName("Problems with underweight");
    }

    @FXML
    void toHC9(ActionEvent event) throws Exception {
        setUpNodes(8);
        setLabelName("Problems with surgical wounds");
    }

    @FXML
    void toHC10(ActionEvent event) throws Exception {
        setUpNodes(9);
        setLabelName("Problems with diabetic ulcers");
    }

    @FXML
    void toHC11(ActionEvent event) throws Exception {
        setUpNodes(10);
        setLabelName("Problems with cancerous lesions");
    }

    @FXML
    void toHC12(ActionEvent event) throws Exception {
        setUpNodes(11);
        setLabelName("Problems with pressure ulcers");
    }

    @FXML
    void toHC13(ActionEvent event) throws Exception {
        setUpNodes(12);
        setLabelName("Problems with arterial ulcer");
    }

    @FXML
    void toHC14(ActionEvent event) throws Exception {
        setUpNodes(13);
        setLabelName("Problems with venous ulcer");
    }

    @FXML
    void toHC15(ActionEvent event) throws Exception {
        setUpNodes(14);
        setLabelName("Problems with mixed wounds");
    }

    @FXML
    void toHC16(ActionEvent event) throws Exception {
        setUpNodes(15);
        setLabelName("Problems with trauma wounds");
    }

    @FXML
    void toHC17(ActionEvent event) throws Exception {
        setUpNodes(16);
        setLabelName("Other skin and mucous membrane problems");
    }

    @FXML
    void toHC18(ActionEvent event) throws Exception {
        setUpNodes(17);
        setLabelName("Problem with communication");
    }

    @FXML
    void toHC19(ActionEvent event) throws Exception {
        setUpNodes(18);
        setLabelName("Problems with socializing");
    }

    @FXML
    void toHC20(ActionEvent event) throws Exception {
        setUpNodes(19);
        setLabelName("Emotional problems");
    }

    @FXML
    void toHC21(ActionEvent event) throws Exception {
        setUpNodes(20);
        setLabelName("Problems with abuse");
    }

    @FXML
    void toHC22(ActionEvent event) throws Exception {
        setUpNodes(21);
        setLabelName("Mental problems");
    }

    @FXML
    void toHC23(ActionEvent event) throws Exception {
        setUpNodes(22);
        setLabelName("Problem with respiration");
    }

    @FXML
    void toHC24(ActionEvent event) throws Exception {
        setUpNodes(23);
        setLabelName("Problem with circulation");
    }

    @FXML
    void toHC25(ActionEvent event) throws Exception {
        setUpNodes(24);
        setLabelName("Problem with sexuality");
    }

    @FXML
    void toHC26(ActionEvent event) throws Exception {
        setUpNodes(25);
        setLabelName("Acute pain ");
    }

    @FXML
    void toHC27(ActionEvent event) throws Exception {
        setUpNodes(26);
        setLabelName("Periodic pain");
    }

    @FXML
    void toHC28(ActionEvent event) throws Exception {
        setUpNodes(27);
        setLabelName("Chronic pain");
    }

    @FXML
    void toHC29(ActionEvent event) throws Exception {
        setUpNodes(28);
        setLabelName("Problems with the sense of sight");
    }


    @FXML
    void toHC30(ActionEvent event) throws Exception {
        setUpNodes(29);
        setLabelName("Problems with the sense of smell");
    }

    @FXML
    void toHC31(ActionEvent event) throws Exception {
        setUpNodes(30);
        setLabelName("Hearing problems");
    }

    @FXML
    void toHC32(ActionEvent event) throws Exception {
        setUpNodes(31);
        setLabelName("Problems with the sense of taste");
    }

    @FXML
    void toHC33(ActionEvent event) throws Exception {
        setUpNodes(32);
        setLabelName("Problems with the sense of touch");
    }

    @FXML
    void toHC34(ActionEvent event) throws Exception {
        setUpNodes(33);
        setLabelName("Circadian rhythm problems");
    }

    @FXML
    void toHC35(ActionEvent event) throws Exception {
        setUpNodes(34);
        setLabelName("Sleep problems");
    }

    @FXML
    void toHC36(ActionEvent event) throws Exception {
        setUpNodes(35);
        setLabelName("Memory problems");
    }

    @FXML
    void toHC37(ActionEvent event) throws Exception {
        setUpNodes(36);
        setLabelName("Problems with insight into treatment purposes");
    }

    @FXML
    void toHC38(ActionEvent event) throws Exception {
        setUpNodes(37);
        setLabelName("Problems with disease insight");
    }

    @FXML
    void toHC39(ActionEvent event) throws Exception {
        setUpNodes(38);
        setLabelName("Problem with urination");
    }


    @FXML
    void toHC40(ActionEvent event) throws Exception {
        setUpNodes(39);
        setLabelName("Problem with urinary incontinence");
    }

    @FXML
    void toHC41(ActionEvent event) throws Exception {
        setUpNodes(40);
        setLabelName("Problems with stool incontinence");
    }

    @FXML
    void toHC42(ActionEvent event) throws Exception {
        setUpNodes(41);
        setLabelName("Stomach and intestinal problems");
    }

    @FXML
    void toHC43(ActionEvent event) throws Exception {
        setUpNodes(42);
        setLabelName("Problems with fluid from drains");
    }


}
