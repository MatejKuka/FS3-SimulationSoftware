package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CitizenFunctionalityStateViewController implements Initializable {
    @FXML
    private VBox mainView;
    @FXML
    private Label label;

    private String placeholder = "Label";
    private Label currentLevelData = new Label(placeholder);
    private Label expectedLevelData = new Label(placeholder);
    private Label professionalNoteData = new Label(placeholder);
    private Label performanceData = new Label(placeholder);
    private Label importanceData = new Label(placeholder);
    private Label citizenWishesData = new Label(placeholder);
    private Label followUpDateData = new Label(placeholder);
    private Label observationalNotes = new Label(placeholder);
    private Label relevantData = new Label(placeholder);
    @FXML
    private HBox container1, container2, container3, container4, container5, container6;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleSelfCare(ActionEvent event) {
        clearMainView();
        container1.getChildren().add(createLabel("Current level"));
        container1.getChildren().add(currentLevelData);

        container2.getChildren().add(createLabel("Expected level"));
        container2.getChildren().add(expectedLevelData);

        container3.getChildren().add(createLabel("Professional note"));
        container3.getChildren().add(professionalNoteData);


    }

    public void handleDrinking(ActionEvent event) {
    }

    public void handleEating(ActionEvent event) {
    }

    public void handleFoodIntake(ActionEvent event) {
    }

    public void handleWalking(ActionEvent event) {
    }

    public void handleBathroom(ActionEvent event) {
    }

    public void handleBodyPosition(ActionEvent event) {
    }

    public void handleCommunication(ActionEvent event) {
    }

    public void handleEmotionalFunctions(ActionEvent event) {
    }

    private void clearMainView() {
        mainView.getChildren().clear();
        mainView.getChildren().add(label);
        addContainers();
        clearContainers();
    }

    private void addContainers() {
        mainView.getChildren().add(container1);
        mainView.getChildren().add(container2);
        mainView.getChildren().add(container3);
        mainView.getChildren().add(container4);
        mainView.getChildren().add(container5);
        mainView.getChildren().add(container6);

        container1.setSpacing(30);
        container2.setSpacing(30);
        container3.setSpacing(30);
        container4.setSpacing(30);
        container5.setSpacing(30);
        container6.setSpacing(30);
    }

    private void clearContainers() {
        container1.getChildren().clear();
        container2.getChildren().clear();
        container3.getChildren().clear();
        container4.getChildren().clear();
        container5.getChildren().clear();
        container6.getChildren().clear();
    }

    private Label createLabel(String title) {
        return new Label(title);
    }

}
