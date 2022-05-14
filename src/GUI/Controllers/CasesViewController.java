package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CasesViewController implements Initializable {
    @FXML
    private VBox sidebar;
    @FXML
    private TextArea textArea;
    private ArrayList<Button> buttons = new ArrayList<>();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupGeneralButtons();
        System.out.println(buttons);
    }

    public void handleBasicInformation(ActionEvent event) {
//        if (sidebar.getChildren() !== null)
    }

    public void handleGeneralInformation(ActionEvent event) {
        //TODO Populate sidebar buttons
        buttons.forEach(button -> {
            sidebar.getChildren().add(button);
        });

    }

    public void handleFunctionalityState(ActionEvent event) {
        //TODO Populate sidebar buttons

    }

    private void setupGeneralButtons() {
        Button masteryButton = new Button("Mastery");
        Button motivationButton = new Button("Motivation");
        Button rollerButton = new Button("Roller");
        Button habitsButton = new Button("Habits");
        Button educationJobButton = new Button("Education/job");
        Button lifeStoryButton = new Button("Life story");
        Button healthInfoButton = new Button("Health info");
        Button networkButton = new Button("Network");

        buttons.add(masteryButton);
        buttons.add(motivationButton);
        buttons.add(rollerButton);
        buttons.add(habitsButton);
        buttons.add(educationJobButton);
        buttons.add(lifeStoryButton);
        buttons.add(healthInfoButton);
        buttons.add(networkButton);
    }
}
