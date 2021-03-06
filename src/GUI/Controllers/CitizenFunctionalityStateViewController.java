package GUI.Controllers;

import BE.Citizen;
import BE.CitizensAssessment;
import BE.FunctionalityState;
import BLL.exeptions.UserException;
import GUI.Models.MainModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    final ComboBox<String> relevantBox = new ComboBox<>();
    final ComboBox<String> saveAsComboBox = new ComboBox<>();

    final TextArea professionalArea = new TextArea();
    final TextArea observationalArea = new TextArea();
    final DatePicker datePicker = new DatePicker();
    final TextArea wishesTextarea = new TextArea();

    private final String placeholder = "Label";
    private final Label currentLevelData = new Label(placeholder);
    private final Label expectedLevelData = new Label(placeholder);
    private final Label professionalNoteData = new Label(placeholder);
    private final Label saveAsData = new Label(placeholder);
    private final Label performanceData = new Label(placeholder);
    private final Label importanceData = new Label(placeholder);
    private final Label citizenWishesData = new Label(placeholder);
    private final Label followUpDateData = new Label(placeholder);
    private final Label observationalNotes = new Label(placeholder);

    private MainModel mainModel;
    private FunctionalityState functionalityStateData;
    private CitizensAssessment citizensAssessmentData;

    private Button editButton, saveButton, cancelButton;
    List<FunctionalityState> functionalityStateList;
    List<CitizensAssessment> citizensAssessmentList;

    private boolean isFunctionalityStateCreated = false;
    private boolean isCitizenAssessmentCreated = false;
    private Citizen citizen;

    public void getCitizen(Citizen citizen) throws UserException {
        this.citizen = citizen;

        functionalityStateList = mainModel.getFunctionalityStateById(citizen.getId());
        citizensAssessmentList = mainModel.getCitizenAssessmentsById(citizen.getId());

        // placeholder values
        int integerPlaceholder = 4;
        String stringPlaceholder = "Lorem ipsum";
        String datePlaceholder = "18-9-2022";

        // creating array for looping and then creating placeholders
        int[] functionalityTypes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        // checking if the functionality state or assessment list exists
        if (functionalityStateList.size() != 0) {
            isFunctionalityStateCreated = true;
        }
        if (citizensAssessmentList.size() != 0) {
            isCitizenAssessmentCreated = false;
        }

        // if it doesn't exist then we create placeholders for all the cases
        if (!isFunctionalityStateCreated) {
            for (int functionalityType :
                    functionalityTypes) {
                functionalityStateList.add(mainModel.createFunctionalityState(integerPlaceholder, integerPlaceholder, stringPlaceholder, stringPlaceholder, functionalityType, citizen.getId()));
            }
        }
        if (!isCitizenAssessmentCreated) {
            for (int functionalityType :
                    functionalityTypes) {
                citizensAssessmentList.add(mainModel.createCitizensAssessments(stringPlaceholder, stringPlaceholder, stringPlaceholder, datePlaceholder, stringPlaceholder, functionalityType, citizen.getId()));
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Creating buttons
        editButton = new Button("Edit");
        saveButton = new Button("Save");
        cancelButton = new Button("Cancel");
        // Styling
        wishesTextarea.getStyleClass().add("custom-textarea");
        professionalArea.getStyleClass().add("custom-textarea");
        observationalArea.getStyleClass().add("custom-textarea");
        editButton.getStyleClass().addAll("btn-action", "padding");
        saveButton.getStyleClass().addAll("btn-action", "padding");
        cancelButton.getStyleClass().addAll("btn-action", "padding");

        try {
            mainModel = new MainModel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Button click handlers
    public void handleSelfCare() {
        handleNewView("Body Care", 2);
    }

    public void handleDrinking() {
        handleNewView("Drinking", 4);
    }

    public void handleEating() {
        handleNewView("Eating", 6);
    }

    public void handleFoodIntake() {
        handleNewView("Food Intake", 5);
    }

    public void handleWalking() {
        handleNewView("Walking", 20);
    }

    public void handleBathroom() {
        handleNewView("Bathroom", 8);
    }

    public void handleBodyPosition() {
        handleNewView("Body Position", 18);
    }

    public void handleCommunication() {
        handleNewView("Communication", 22);
    }

    public void handleWash() {
        handleNewView("Wash", 1);
    }

    public void handleCareHealth() {
        handleNewView("Care of own health", 7);
    }

    public void handleHousework() {
        handleNewView("Housework", 9);
    }

    public void handleCook() {
        handleNewView("Cook", 10);
    }

    public void handleDailyRoutine() {
        handleNewView("Daily routine", 11);
    }

    public void handleGoodsServices() {
        handleNewView("Goods and services", 12);
    }

    public void handleLiftCarry() {handleNewView("Lift and carry", 13);}

    public void handleMoveAround() {
        handleNewView("Move around", 14);
    }

    public void handleUsingTransport() {
        handleNewView("Using transport", 15);
    }

    public void handleEnvironment() {
        handleNewView("Moving in different environment", 16);
    }

    public void handleMove() {
        handleNewView("Move", 17);
    }

    public void handleMusclesStrenght() {handleNewView("Muscles strenght", 19);}

    public void handleEndurance() {
        handleNewView("Endurance", 21);
    }

    public void handleEmotionalMemory() {
        handleNewView("Memory", 23);
    }

    public void handleOrientationAbility() {
        handleNewView("Orientation Ability", 24);
    }

    public void handleCognitiveFunctions() {
        handleNewView("Cognitive functions", 25);
    }

    public void handleEnergyAndfunctions() {
        handleNewView("Energy and functions", 27);
    }

    public void handleAcquireSkills() {
        handleNewView("Acquire skills", 28);
    }

    public void handleProblemSolving() {
        handleNewView("Problem solving", 29);
    }

    public void handleHavePaidEmployment() {
        handleNewView("Have paid employment", 30);
    }

    public void handleDressing () {
        handleNewView("Dressing", 3);
    }

    // Function that is responsible for displaying the content after different cases button is clicked
    public void handleNewView(String labelName, int functionalityType) {
        // we filter through all functionality states in clicked user and check for specific case using filter and parameter functionality type
        List<FunctionalityState> filteredFunctionalityStateList = functionalityStateList.stream().filter(functionalityState1 -> functionalityState1.getFunctionalityType() == functionalityType).collect(Collectors.toList());
        functionalityStateData = filteredFunctionalityStateList.get(0);

        List<CitizensAssessment> filteredCitizensAssessmentList = citizensAssessmentList.stream().filter(citizensAssessment -> citizensAssessment.getFunctionalityType() == functionalityType).collect(Collectors.toList());
        citizensAssessmentData = filteredCitizensAssessmentList.get(0);

        label.setText(labelName);

        setInitView();

        // Setting content
        currentLevelData.setText(String.valueOf(functionalityStateData.getCurrLvl()));
        expectedLevelData.setText(String.valueOf(functionalityStateData.getExpectedLvl()));
        professionalNoteData.setText(functionalityStateData.getProfessNote());
        saveAsData.setText(functionalityStateData.getSaveAs());

        performanceData.setText(citizensAssessmentData.getPerformance());
        importanceData.setText(citizensAssessmentData.getImportance());
        citizenWishesData.setText(citizensAssessmentData.getCitizWishes());
        followUpDateData.setText(citizensAssessmentData.getFollUpDate());
        observationalNotes.setText(citizensAssessmentData.getObservNote());

        // Button actions
        editButton.setOnAction(evt -> setupEditFields());

        cancelButton.setOnAction(evt -> {
            clearButtons();
            clearMainView();
            setInitView();
        });

        saveButton.setOnAction(evt -> {

            String formattedDate = datePicker.getValue().format(DateTimeFormatter.ofPattern("dd-M-yyyy"));
            FunctionalityState newFunctionalityState = new FunctionalityState(functionalityStateData.getId(), Integer.parseInt(currentBox.getValue()), Integer.parseInt(expectedBox.getValue()), professionalArea.getText(), saveAsComboBox.getValue(), functionalityType, citizen.getId());
            CitizensAssessment newCitizensAssessment = new CitizensAssessment(citizensAssessmentData.getId(), performanceBox.getValue(), importanceBox.getValue(), wishesTextarea.getText(), formattedDate, observationalArea.getText(), functionalityType, citizen.getId());
            // Updating functionality state and citizen assessment, updating ui as well
            try {
                mainModel.updateFunctionalityState(newFunctionalityState);
                mainModel.updateCitizensAssessment(newCitizensAssessment);

                citizensAssessmentList = mainModel.getCitizenAssessmentsById(citizen.getId());

                currentLevelData.setText(String.valueOf(newFunctionalityState.getCurrLvl()));
                expectedLevelData.setText(String.valueOf(newFunctionalityState.getExpectedLvl()));
                professionalNoteData.setText(newFunctionalityState.getProfessNote());
                saveAsData.setText(newFunctionalityState.getSaveAs());
                functionalityStateList = mainModel.getFunctionalityStateById(citizen.getId());
                performanceData.setText(newCitizensAssessment.getPerformance());
                importanceData.setText(newCitizensAssessment.getImportance());
                citizenWishesData.setText(newCitizensAssessment.getCitizWishes());
                observationalNotes.setText(newCitizensAssessment.getObservNote());


            } catch (Exception | UserException e) {
                e.printStackTrace();
            }
            setInitView();
        });
    }

    private void setupEditFields() {
        // Styling
        importanceBox.getStyleClass().add("custom-combobox");
        currentBox.getStyleClass().add("custom-combobox");
        expectedBox.getStyleClass().add("custom-combobox");
        saveAsComboBox.getStyleClass().add("custom-combobox");
        performanceBox.getStyleClass().add("custom-combobox");
        observationalArea.setMaxWidth(400);
        observationalArea.setMinHeight(150);
        professionalArea.setMaxWidth(400);
        professionalArea.setMinHeight(200);

        // Setting values
        importanceBox.getItems().setAll("does not experience limitations", "experiencing limitations");
        performanceBox.getItems().setAll("performs yourself", "performs semi yourself", "do not performs yourself", "not applicable");
        currentBox.getItems().setAll("0", "1", "2", "3", "4", "9");
        relevantBox.getItems().setAll("bad", "normal", "good");
        expectedBox.getItems().setAll("0", "1", "2", "3", "4", "9");
        saveAsComboBox.getItems().setAll("Save as active", "Save as potential", "Save as not relevant");
        currentBox.setValue(String.valueOf(functionalityStateData.getCurrLvl()));
        expectedBox.setValue(String.valueOf(functionalityStateData.getExpectedLvl()));
        professionalArea.setText(functionalityStateData.getProfessNote());
        saveAsComboBox.setValue(functionalityStateData.getSaveAs());
        performanceBox.setValue(citizensAssessmentData.getPerformance());
        importanceBox.setValue(citizensAssessmentData.getImportance());
        wishesTextarea.setText(citizensAssessmentData.getCitizWishes());
        datePicker.setEditable(false);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
        LocalDate localDate = LocalDate.parse(citizensAssessmentData.getFollUpDate(), formatter);

        datePicker.setValue(localDate);
        observationalArea.setText(citizensAssessmentData.getObservNote());

        // Setting components inside HBoxes
        container1.getChildren().set(1, currentBox);
        container2.getChildren().set(1, expectedBox);
        container6.getChildren().set(1, performanceBox);
        container7.getChildren().set(1, importanceBox);
        container8.getChildren().set(1, wishesTextarea);
        container9.getChildren().set(1, datePicker);
        container10.getChildren().set(1, observationalArea);
        container3.getChildren().set(1, professionalArea);
        container4.getChildren().set(1, saveAsComboBox);

        // Setting buttons
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
        mainView.getChildren().add(container6);
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

    // Shows the labels version of view
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
