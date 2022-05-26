package GUI.Controllers;

import BE.Citizen;
import BE.CitizensAssessment;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class CitizenFunctionalityStateViewController implements Initializable {
    @FXML
    private VBox mainView;
    @FXML
    private Label label, label1;
    @FXML
    private HBox container1, container2, container3, container4, container5, container6, container7, container8, container9, container10, container12;
    final ComboBox<String> currentBox = new ComboBox<>();
    final ComboBox<String> expectedBox = new ComboBox<>();
    final ComboBox<String> performanceBox = new ComboBox<>();
    final ComboBox<String> importanceBox = new ComboBox<>();
    final ComboBox<String> citizenWishesBox = new ComboBox<>();
    final ComboBox<String> relevantBox = new ComboBox<>();
    final ComboBox<String> saveAsComboBox = new ComboBox<>();

    final TextArea professionalArea = new TextArea();
    final TextArea observationalArea = new TextArea();
    final DatePicker datePicker = new DatePicker();

    private String placeholder = "Label";
    private Label currentLevelData = new Label(placeholder);
    private Label expectedLevelData = new Label(placeholder);
    private Label professionalNoteData = new Label(placeholder);
    private Label saveAsData = new Label(placeholder);
    private Label performanceData = new Label(placeholder);
    private Label importanceData = new Label(placeholder);
    private Label citizenWishesData = new Label(placeholder);
    private Label followUpDateData = new Label(placeholder);
    private Label observationalNotes = new Label(placeholder);
    private MainModel mainModel;


    private Button editButton, saveButton, cancelButton;

    private CitizensEditController citizensEditController;
    List<FunctionalityState> functionalityStateList;
    List<CitizensAssessment> citizensAssessmentList;

    public void setCitizensEditController(CitizensEditController citizensEditController) {
        this.citizensEditController = citizensEditController;
    }
    private boolean isFunctionalityStateCreated = false;
    private boolean isCitizenAssessmentCreated = false;

    public void getCitizen(Citizen citizen) throws Exception {
        functionalityStateList = mainModel.getFunctionalityStateById(citizen.getId());
        citizensAssessmentList = mainModel.getCitizenAssessmentsById(citizen.getId());

        int integerPlaceholder = 4;
        String stringPlaceholder = "Lorem ipsum";
        int[] functionalityTypes = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        if (functionalityStateList.size() != 0) {
            isFunctionalityStateCreated = true;
        }
        if (citizensAssessmentList.size() != 0) {
            isCitizenAssessmentCreated = false;
        }

        if (!isFunctionalityStateCreated) {
            for (int functionalityType :
                    functionalityTypes) {
                functionalityStateList.add(mainModel.createFunctionalityState(integerPlaceholder, integerPlaceholder, stringPlaceholder, stringPlaceholder, functionalityType, citizen.getId()));
            }
        }
        if (!isCitizenAssessmentCreated) {
            for (int functionalityType :
                    functionalityTypes) {
                citizensAssessmentList.add(mainModel.createCitizensAssessments(stringPlaceholder, stringPlaceholder, stringPlaceholder, stringPlaceholder,stringPlaceholder, functionalityType, citizen.getId()));
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        editButton = new Button("Edit");
        editButton.getStyleClass().addAll("btn-action", "padding");
//        editButton.setDisable(true); //TODO -> Zrobic a potom vymazat
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
        List<FunctionalityState> filteredFunctionalityStateList = functionalityStateList.stream().filter(functionalityState1 -> functionalityState1.getFunctionalityType() == functionalityType).collect(Collectors.toList());
        FunctionalityState functionalityStateData = filteredFunctionalityStateList.get(0);

        List<CitizensAssessment> filteredCitizensAssessmentList = citizensAssessmentList.stream().filter(citizensAssessment -> citizensAssessment.getFunctionalityType() == functionalityType).collect(Collectors.toList());
        CitizensAssessment citizensAssessmentData = filteredCitizensAssessmentList.get(0);

        label.setText(labelName);
        setInitView();

        currentLevelData.setText(String.valueOf(functionalityStateData.getCurrLvl()));
        expectedLevelData.setText(String.valueOf(functionalityStateData.getExpectedLvl()));
        professionalNoteData.setText(functionalityStateData.getProfessNote());
        saveAsData.setText(functionalityStateData.getProfessNote());

        importanceData.setText(citizensAssessmentData.getImportance());
        citizenWishesData.setText(citizensAssessmentData.getCitizWishes());
        followUpDateData.setText(citizensAssessmentData.getFollUpDate());
        observationalNotes.setText(citizensAssessmentData.getObservNote());

        editButton.setOnAction(evt -> {
            setupEditFields();
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

    private void setupEditFields() {
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
//        container5.getChildren().set(1, performanceBox);
//        container6.getChildren().set(1, importanceBox);
//        container7.getChildren().set(1, citizenWishesBox);
//        container10.getChildren().set(1, relevantBox);
//        container8.getChildren().set(1, datePicker);
        container3.getChildren().set(1, professionalArea);
        container4.getChildren().set(1, saveAsComboBox);
//        container9.getChildren().set(1, observationalArea);

        clearButtons();

        container12.getChildren().add(saveButton);
        container12.getChildren().add(cancelButton);
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
        mainView.getChildren().add(container12);

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
        container12.setSpacing(spacing);
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

        container4.getChildren().add(createLabel("Save as:"));
        container4.getChildren().add(saveAsData);

        container5.getChildren().add(label1);

        container6.getChildren().add(createLabel("Performance:"));
        container6.getChildren().add(performanceData);

        container7.getChildren().add(createLabel("Importance:"));
        container7.getChildren().add(importanceData);

        container8.getChildren().add(createLabel("Citizen wishes:"));
        container8.getChildren().add(citizenWishesData);

        container9.getChildren().add(createLabel("Follow-up date:"));
        container9.getChildren().add(followUpDateData);

        container10.getChildren().add(createLabel("Observational notes:"));
        container10.getChildren().add(observationalNotes);

        container12.getChildren().add(editButton);
    }

    private void clearButtons() {
        container12.getChildren().clear();
    }

    private Label createLabel(String title) {
        return new Label(title);
    }

}
