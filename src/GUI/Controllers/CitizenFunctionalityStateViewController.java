package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CitizenFunctionalityStateViewController implements Initializable {
    @FXML
    private VBox mainView;
    @FXML
    private Label label, label1;

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
    private HBox container1, container2, container3, container4, container5, container6, container7, container8, container9, container10;

    private Button editButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleSelfCare(ActionEvent event) {
        final ComboBox<String> currentBox = new ComboBox<>();
        final ComboBox<String> expectedBox = new ComboBox<>();
        final ComboBox<String> performanceBox = new ComboBox<>();
        final ComboBox<String> importanceBox = new ComboBox<>();
        final ComboBox<String> citizenWishesBox = new ComboBox<>();
        final ComboBox<String> relevantBox = new ComboBox<>();

        clearMainView();
        container1.getChildren().add(createLabel("Current level"));
        container1.getChildren().add(currentLevelData);

        container2.getChildren().add(createLabel("Expected level"));
        container2.getChildren().add(expectedLevelData);

        container3.getChildren().add(createLabel("Professional note"));
        container3.getChildren().add(professionalNoteData);

        container4.getChildren().add(label1);

        container5.getChildren().add(createLabel("Performance"));
        container5.getChildren().add(performanceData);

        container6.getChildren().add(createLabel("Importance"));
        container6.getChildren().add(importanceData);

        container7.getChildren().add(createLabel("Citizen wishes"));
        container7.getChildren().add(citizenWishesData);

        container8.getChildren().add(createLabel("Follow-up date"));
        container8.getChildren().add(followUpDateData);

        container9.getChildren().add(createLabel("Observational notes"));
        container9.getChildren().add(observationalNotes);

        container10.getChildren().add(createLabel("Relevant"));
        container10.getChildren().add(relevantData);

        editButton = new Button("Edit button");
        mainView.getChildren().add(editButton);

        editButton.setOnAction(evt -> {
            container1.getChildren().set(1, currentBox);
            container2.getChildren().set(1, expectedBox);
            container5.getChildren().set(1, performanceBox);
            container6.getChildren().set(1, importanceBox);
            container7.getChildren().set(1, citizenWishesBox);
            container10.getChildren().set(1, relevantBox);
        });
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
        int spacing = 30;
        mainView.getChildren().add(container1);
        mainView.getChildren().add(container2);
        mainView.getChildren().add(container3);
        mainView.getChildren().add(container4);
        mainView.getChildren().add(container5);
        mainView.getChildren().add(container7);
        mainView.getChildren().add(container8);
        mainView.getChildren().add(container9);
        mainView.getChildren().add(container10);

        container1.setSpacing(spacing);
        container2.setSpacing(spacing);
        container3.setSpacing(spacing);
        container4.setSpacing(spacing);
        container5.setSpacing(spacing);
        container6.setSpacing(spacing);
        container7.setSpacing(spacing);
        container8.setSpacing(spacing);
        container9.setSpacing(spacing);
        container10.setSpacing(spacing);

    }

    private void clearContainers() {
        container1.getChildren().clear();
        container2.getChildren().clear();
        container3.getChildren().clear();
        container4.getChildren().clear();
        container5.getChildren().clear();
        container6.getChildren().clear();
        container7.getChildren().clear();
        container8.getChildren().clear();
        container9.getChildren().clear();
        container10.getChildren().clear();
    }

    private Label createLabel(String title) {
        return new Label(title);
    }

}
