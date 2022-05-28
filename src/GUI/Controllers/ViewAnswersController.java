package GUI.Controllers;

import BE.Citizen;
import BE.User;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewAnswersController implements Initializable {

    private final Citizen citizenToShow;
    private final User userToShow;
    MainModel mainModel;

    @FXML
    private Label labelCurrAss;

    @FXML
    private Label labelExpLev;

    @FXML
    private Label labelFName;

    @FXML
    private Label labelFNameST;

    @FXML
    private Label labelFollDate;

    @FXML
    private Label labelLName;

    @FXML
    private Label labelLNameST;

    @FXML
    private Label labelNameHC;

    @FXML
    private Label labelObsNotes;

    @FXML
    private Label labelProffNote;

    @FXML
    private Label labelSaved;

    public ViewAnswersController(Citizen citizenToShow, User userToShow) {
        this.citizenToShow = citizenToShow;
        this.userToShow = userToShow;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelFName.setText(citizenToShow.getFirstName());
        labelLName.setText(citizenToShow.getLastName());
        labelFNameST.setText(userToShow.getFirstName());
        labelLNameST.setText(userToShow.getLastName());
    }

    private void setUpNodes(int idTypeHC){
        
    }

    @FXML
    void toHC1(ActionEvent event) {

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
    void toHC2(ActionEvent event) {

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
    void toHC3(ActionEvent event) {

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
    void toHC4(ActionEvent event) {

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

}
