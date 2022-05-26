package GUI.Controllers;

import BE.Citizen;
import BE.FunctionalityState;
import GUI.Models.MainModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CitizenFunctionalityStateViewController implements Initializable {
    @FXML
    private VBox mainView;
    @FXML
    private Label label, label1;

    final ComboBox<String> currentBox = new ComboBox<>();
    final ComboBox<String> expectedBox = new ComboBox<>();
    final ComboBox<String> performanceBox = new ComboBox<>();
    final ComboBox<String> importanceBox = new ComboBox<>();
    final ComboBox<String> citizenWishesBox = new ComboBox<>();
    final ComboBox<String> relevantBox = new ComboBox<>();

    final TextArea professionalArea = new TextArea();
    final TextArea observationalArea = new TextArea();
    final DatePicker datePicker = new DatePicker();

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
    private MainModel mainModel;
    @FXML
    private HBox container1, container2, container3, container4, container5, container6, container7, container8, container9, container10, container11;

    private Button editButton, saveButton, cancelButton;

    FunctionalityState functionalityState = new FunctionalityState(1, 3, 2, "In good shape", "23/5/2022", 4, 22);

    private CitizensEditController citizensEditController;
    List<FunctionalityState> functionalityStateList;
    public void setCitizensEditController(CitizensEditController citizensEditController) {
        this.citizensEditController = citizensEditController;
    }
    private boolean isCreated = false;

    public void getCitizen(Citizen citizen) throws Exception {
//        mainModel.getAllGeneralInfo().forEach(generalInfo1 -> {
//            if (citizen.getId() == generalInfo1.getCitizen()) {
//                isCreated = true;
//                generalInfo = generalInfo1;
//            }
//        });
//        if (!isCreated) {
//            String placeholder = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam eget magna nisl. Vivamus hendrerit justo pulvinar orci malesuada tincidunt. Sed vitae porttitor leo, eget pellentesque sapien. Mauris porttitor, orci vel convallis pellentesque, eros turpis ullamcorper nibh, eget eleifend lectus turpis fermentum lorem.";
//            generalInfo = mainModel.createGeneralInfo(placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, placeholder, citizen.getId());
//        }
//        this.citizen = citizen;
        functionalityStateList = mainModel.getFunctionalityStateById(citizen.getId());
        int integerPlaceholder = 4;
        String stringPlaceholder = "Lorem ipsum";
        int[] functionalityTypes = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        if (functionalityStateList.size() != 0) {
            isCreated = true;
        }
        System.out.println(functionalityStateList);
        if (!isCreated) {
            System.out.println("test");
            for (int functionalityType :
                    functionalityTypes) {
                functionalityStateList.add(mainModel.createFunctionalityState(integerPlaceholder, integerPlaceholder, stringPlaceholder, stringPlaceholder, functionalityType, citizen.getId()));
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editButton = new Button("Edit");
        saveButton = new Button("Save");
        cancelButton = new Button("Cancel");
        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void handleSelfCare(ActionEvent event) {
        handleNewView("Self Care", 1);
    }

    public void handleDrinking(ActionEvent event) {
        handleNewView("Drinking", 2);
    }

    public void handleEating(ActionEvent event) {
        handleNewView("Eating", 3);
    }

    public void handleFoodIntake(ActionEvent event) {
        handleNewView("Food Intake", 4);
    }

    public void handleWalking(ActionEvent event) {
        handleNewView("Walking", 5);
    }

    public void handleBathroom(ActionEvent event) {
        handleNewView("Bathroom", 6);
    }

    public void handleBodyPosition(ActionEvent event) {
        handleNewView("Body Position", 7);
    }

    public void handleCommunication(ActionEvent event) {
        handleNewView("Communication", 8);
    }

    public void handleEmotionalFunctions(ActionEvent event) {
        handleNewView("Emotional Functions", 9);
    }

    public void handleNewView(String labelName, int functionalityType) {
        List<FunctionalityState> filteredList = functionalityStateList.stream().filter(functionalityState1 -> functionalityState1.getFunctionalityType() == functionalityType).collect(Collectors.toList());
        FunctionalityState functionalityStateData = filteredList.get(0);
        System.out.println(functionalityStateData);
        label.setText(labelName);
        setInitView();
        currentLevelData.setText(String.valueOf(functionalityStateData.getCurrLvl()));
        expectedLevelData.setText(String.valueOf(functionalityStateData.getExpectedLvl()));
        professionalNoteData.setText(functionalityState.getProfessNote());

        editButton.setOnAction(evt -> {
            setupSelfCareEditFields();
        });

        cancelButton.setOnAction(evt -> {
            clearButtons();
            clearMainView();
            setInitView();
        });

        saveButton.setOnAction(evt -> {
            String formattedDate = datePicker.getValue().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
            FunctionalityState newFunctionalityState = new FunctionalityState(2, Integer.parseInt(currentBox.getValue()), Integer.parseInt(expectedBox.getValue()), professionalArea.getText(), formattedDate, 5, 22);
            currentLevelData.setText(String.valueOf(newFunctionalityState.getCurrLvl()));
            expectedLevelData.setText(String.valueOf(newFunctionalityState.getExpectedLvl()));
            professionalNoteData.setText(newFunctionalityState.getProfessNote());
            setInitView();
        });
    }

    private void setupSelfCareEditFields() {
        importanceBox.getItems().setAll("bad", "normal", "good");
        performanceBox.getItems().setAll("bad", "normal", "good");
        currentBox.getItems().setAll("1", "2", "3");
        citizenWishesBox.getItems().setAll("bad", "normal", "good");
        relevantBox.getItems().setAll("bad", "normal", "good");
        expectedBox.getItems().setAll("1", "2", "3");
        observationalArea.setMaxWidth(400);
        observationalArea.setMinHeight(150);
        professionalArea.setMaxWidth(400);
        professionalArea.setMinHeight(200);

        container1.getChildren().set(1, currentBox);
        container2.getChildren().set(1, expectedBox);
        container5.getChildren().set(1, performanceBox);
        container6.getChildren().set(1, importanceBox);
        container7.getChildren().set(1, citizenWishesBox);
        container10.getChildren().set(1, relevantBox);
        container8.getChildren().set(1, datePicker);
        container3.getChildren().set(1, professionalArea);
        container9.getChildren().set(1, observationalArea);

        clearButtons();

        container11.getChildren().add(saveButton);
        container11.getChildren().add(cancelButton);
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
        mainView.getChildren().add(container11);

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
        container11.setSpacing(spacing);
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
        clearButtons();
    }

    private void setInitView() {
        clearMainView();
        container1.getChildren().add(createLabel("Current level:"));
        container1.getChildren().add(currentLevelData);

        container2.getChildren().add(createLabel("Expected level:"));
        container2.getChildren().add(expectedLevelData);

        container3.getChildren().add(createLabel("Professional note:"));
        container3.getChildren().add(professionalNoteData);

        container4.getChildren().add(label1);

        container5.getChildren().add(createLabel("Performance:"));
        container5.getChildren().add(performanceData);

        container6.getChildren().add(createLabel("Importance:"));
        container6.getChildren().add(importanceData);

        container7.getChildren().add(createLabel("Citizen wishes:"));
        container7.getChildren().add(citizenWishesData);

        container8.getChildren().add(createLabel("Follow-up date:"));
        container8.getChildren().add(followUpDateData);

        container9.getChildren().add(createLabel("Observational notes:"));
        container9.getChildren().add(observationalNotes);

        container10.getChildren().add(createLabel("Relevant:"));
        container10.getChildren().add(relevantData);

        container11.getChildren().add(editButton);
    }

    private void clearButtons() {
        container11.getChildren().clear();
    }

    private Label createLabel(String title) {
        return new Label(title);
    }

}
