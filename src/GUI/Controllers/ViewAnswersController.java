package GUI.Controllers;

import BE.Citizen;
import BE.HealthConditions;
import BE.User;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ViewAnswersController implements Initializable {

    private final Citizen citizenToShow;
    private final User userToShow;
    MainModel mainModel;
    HealthConditions healthConditions;
    List<String> namesHC;

    @FXML
    private Label labelCurrAss, labelObsNotes, labelProffNote, labelSaved, labelNameHC, labelLNameST, labelLName, labelFollDate, labelFNameST, labelFName, labelExpLev;


    public ViewAnswersController(Citizen citizenToShow, User userToShow) {
        this.citizenToShow = citizenToShow;
        this.userToShow = userToShow;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        labelFName.setText(citizenToShow.getFirstName());
        labelLName.setText(citizenToShow.getLastName());
        labelFNameST.setText(userToShow.getFirstName());
        labelLNameST.setText(userToShow.getLastName());

        namesHC = Arrays.asList("Personal Care", "Daily Activities", "Mobility and movement", "Fluid intake",
                "Food intake", "Innapropriate weight change", "Problems with obesity", "Problems with underweight",
                "Problems with surgical wounds", "Problems with diabetic ulcers", "Problems with cancerous lesions",
                "Problems with pressure ulcers", "Problems with arterial ulcer", "Problems with venous ulcer", "Problems with mixed wounds",
                "Problems with trauma wounds", "Other skin and mucous membrane problems", "Problem with communication",
                "Problems with socializing", "Emotional problems", "Problems with abuse", "Mental problems", "Problem with respiration",
                "Problem with circulation", "Problem with sexuality", "Acute pain", "Periodic pain", "Chronic pain",
                "Problems with the sense of sight", "Problems with the sense of smell", "Hearing problems", "Problems with the sense of taste",
                "Problems with the sense of touch", "Circadian rhythm problems", "Sleep problems", "Memory problems",
                "Problems with insight into treatment purposes", "Problems with disease insight", "Problem with urination",
                "Problem with urinary incontinence", "Problems with stool incontinence", "Stomach and intestinal problems",
                "Problems with fluid from drains");
    }

    private void setUpNodes(int idTypeHC) throws UserException {
        healthConditions = mainModel.getHealthCondition(citizenToShow.getId()).get(idTypeHC);
        labelCurrAss.setText(healthConditions.getCurrAssess());
        labelExpLev.setText(healthConditions.getExpectedLvl());
        labelFollDate.setText(healthConditions.getFollUpDate());
        labelNameHC.setText(namesHC.get(idTypeHC));
        labelObsNotes.setText(healthConditions.getObservNote());
        labelProffNote.setText(healthConditions.getProfessNote());
        labelSaved.setText(healthConditions.getSaveAs());

    }

    @FXML
    void toHC1(ActionEvent event) throws UserException {
        setUpNodes(0);
    }

    @FXML
    void toHC10(ActionEvent event) throws UserException {
        setUpNodes(9);
    }

    @FXML
    void toHC11(ActionEvent event) throws UserException {
        setUpNodes(10);
    }

    @FXML
    void toHC12(ActionEvent event) throws UserException {
        setUpNodes(11);
    }

    @FXML
    void toHC13(ActionEvent event) throws UserException  {
        setUpNodes(12);
    }

    @FXML
    void toHC14(ActionEvent event) throws UserException  {
        setUpNodes(13);
    }

    @FXML
    void toHC15(ActionEvent event) throws UserException  {
        setUpNodes(14);
    }

    @FXML
    void toHC16(ActionEvent event) throws UserException  {
        setUpNodes(15);
    }

    @FXML
    void toHC17(ActionEvent event) throws UserException  {
        setUpNodes(16);
    }

    @FXML
    void toHC18(ActionEvent event)  throws UserException {
        setUpNodes(17);
    }

    @FXML
    void toHC19(ActionEvent event) throws UserException  {
        setUpNodes(18);
    }

    @FXML
    void toHC2(ActionEvent event) throws UserException {
        setUpNodes(1);
    }

    @FXML
    void toHC20(ActionEvent event) throws UserException  {
        setUpNodes(19);
    }

    @FXML
    void toHC21(ActionEvent event) throws UserException  {
        setUpNodes(20);
    }

    @FXML
    void toHC22(ActionEvent event) throws UserException  {
        setUpNodes(21);
    }

    @FXML
    void toHC23(ActionEvent event) throws UserException  {
        setUpNodes(22);
    }

    @FXML
    void toHC24(ActionEvent event) throws UserException  {
        setUpNodes(23);
    }

    @FXML
    void toHC25(ActionEvent event) throws UserException  {
        setUpNodes(24);
    }

    @FXML
    void toHC26(ActionEvent event) throws UserException  {
        setUpNodes(25);
    }

    @FXML
    void toHC27(ActionEvent event)  throws UserException {
        setUpNodes(26);
    }

    @FXML
    void toHC28(ActionEvent event) throws UserException  {
        setUpNodes(27);
    }

    @FXML
    void toHC29(ActionEvent event)  throws UserException {
        setUpNodes(28);
    }

    @FXML
    void toHC3(ActionEvent event)  throws UserException {
        setUpNodes(2);
    }

    @FXML
    void toHC30(ActionEvent event) throws UserException  {
        setUpNodes(29);
    }

    @FXML
    void toHC31(ActionEvent event) throws UserException  {
        setUpNodes(30);
    }

    @FXML
    void toHC32(ActionEvent event) throws UserException  {
        setUpNodes(31);
    }

    @FXML
    void toHC33(ActionEvent event) throws UserException  {
        setUpNodes(32);
    }

    @FXML
    void toHC34(ActionEvent event)  throws UserException {
        setUpNodes(33);
    }

    @FXML
    void toHC35(ActionEvent event)  throws UserException {
        setUpNodes(34);
    }

    @FXML
    void toHC36(ActionEvent event)  throws UserException {
        setUpNodes(35);
    }

    @FXML
    void toHC37(ActionEvent event)  throws UserException {
        setUpNodes(36);
    }

    @FXML
    void toHC38(ActionEvent event) throws UserException  {
        setUpNodes(37);
    }

    @FXML
    void toHC39(ActionEvent event)  throws UserException {
        setUpNodes(38);
    }

    @FXML
    void toHC4(ActionEvent event) throws UserException  {
        setUpNodes(3);
    }

    @FXML
    void toHC40(ActionEvent event) throws UserException {
        setUpNodes(39);
    }

    @FXML
    void toHC41(ActionEvent event) throws UserException  {
        setUpNodes(40);
    }

    @FXML
    void toHC42(ActionEvent event) throws UserException  {
        setUpNodes(41);
    }

    @FXML
    void toHC43(ActionEvent event)  throws UserException {
        setUpNodes(42);
    }

    @FXML
    void toHC5(ActionEvent event)  throws UserException {
        setUpNodes(4);
    }

    @FXML
    void toHC6(ActionEvent event)  throws UserException {
        setUpNodes(5);
    }

    @FXML
    void toHC7(ActionEvent event)  throws UserException {
        setUpNodes(6);
    }

    @FXML
    void toHC8(ActionEvent event)  throws UserException {
        setUpNodes(7);
    }

    @FXML
    void toHC9(ActionEvent event) throws UserException {
        setUpNodes(8);
    }

}
