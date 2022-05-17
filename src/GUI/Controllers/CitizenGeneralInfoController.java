package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class CitizenGeneralInfoController {

    @FXML
    private Button btnAssistDevSec;

    @FXML
    private Button btnDwelSec, btnEduJobSec, btnHabitsSec, btnHealtInfoSec, btnLifeStorySec, btnMasterySec, btnMotivationSec, btnNetworkSec, btnResourcesSec, btnRollerSec;

    @FXML
    private VBox mainView;

    private Label nameLabel = new Label("Label");
    private Label descriptionLabel = new Label("---****--TOTO BY SOM UROBIL AKO LEN PLACEHOLDER ---***---");
    private Label mainText = new Label(" Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque neque ante, ultrices nec gravida quis, pharetra eget quam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Vestibulum tristique neque ac sem vehicula auctor. Sed vulputate dui at urna consequat, et vehicula erat rutrum. Sed interdum mi nec tellus fringilla, et hendrerit tellus efficitur. Pellentesque porta ornare urna non efficitur. Nulla vitae risus lobortis, pellentesque tortor ac, bibendum leo. Praesent justo risus, dignissim vel ante ullamcorper, molestie accumsan magna. Maecenas eleifend, nunc nec porttitor ultrices, neque lorem interdum velit, ut luctus sem purus a nibh. Aenean convallis ante id enim posuere bibendum. Pellentesque non justo malesuada, ornare lacus sit amet, placerat nisi. Sed quam felis, vestibulum ac convallis a, hendrerit id ipsum. Aenean nisl quam, laoreet at dolor ac, feugiat dignissim ante. Nulla tempor felis massa, id egestas enim aliquam et.\n" +
            "\n" +
            "Aliquam eget erat nunc. Sed hendrerit tincidunt euismod. Vivamus vehicula aliquet libero, et gravida erat tempor in. Morbi consequat libero vehicula nisl fermentum fermentum. Ut ex ex, eleifend eget elementum sed, viverra in libero. In sit amet metus posuere felis molestie dignissim sed sed metus. Cras ut faucibus risus, lobortis congue mauris. Suspendisse felis arcu, ornare sit amet lorem vehicula, ultricies luctus ipsum. Sed ut odio finibus, mollis arcu nec, congue enim. Cras aliquam venenatis maximus. Curabitur quis sodales arcu. Phasellus mauris ligula, feugiat ac volutpat quis, lacinia faucibus massa. Integer in sem et est cursus elementum ac ut sem. Nulla commodo, tortor ut aliquam tempor, nulla tortor feugiat nunc, nec condimentum mauris nunc id sem. Quisque nec posuere nibh, sit amet rhoncus arcu. In ac pretium nisi, id elementum nisi. ");
    private Button editButton;
    private Button cancelButton = new Button("Cancel");
    private TextArea textArea;

    private BorderPane buttonPane = new BorderPane();

    @FXML
    void toAssistDevSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Assistive devices");
    }

    @FXML
    void toDwelSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Interior of Dwelling");
    }

    @FXML
    void toEduJobSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Education/Job");
    }

    @FXML
    void toHabitSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Habits");
    }

    @FXML
    void toHealthInfoSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Health Info");
    }

    @FXML
    void toLifeStorySec(ActionEvent event) {
        clearMainView();
        setNameLabel("Life story");
    }

    @FXML
    void toMasterySec(ActionEvent event) {
        clearMainView();

        textArea = new TextArea();
        textArea.setMinHeight(360);

        editButton = new Button("Edit");

        buttonPane.setRight(editButton);
        setNameLabel("Mastery");

        editButton.setOnAction(evt -> {
            mainView.getChildren().set(2, textArea);
            buttonPane.getChildren().clear();

            buttonPane.setRight(cancelButton);
        });
        setupCancelButton(editButton);
    }

    @FXML
    void toMotivationSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Motivation");
    }

    @FXML
    void toNetworkSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Network");
    }

    @FXML
    void toResourceSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Resources");
    }

    @FXML
    void toRollerSec(ActionEvent event) {
        clearMainView();
        setNameLabel("Roller");
    }

    private void setupCancelButton(Button editButton) {
        cancelButton.setOnAction(event -> {
            mainView.getChildren().set(2, mainText);
            buttonPane.getChildren().clear();
            buttonPane.setRight(editButton);
        });
    }

    private void setNameLabel(String newTitle) {
        nameLabel.setText(newTitle);
    }

    private void clearMainView() {
        mainView.getChildren().clear();
        mainView.getChildren().add(nameLabel);
        mainView.getChildren().add(descriptionLabel);
        mainText.setWrapText(true);
        mainView.getChildren().add(mainText);
        mainView.getChildren().add(buttonPane);
        buttonPane.getChildren().clear();
    }
}
