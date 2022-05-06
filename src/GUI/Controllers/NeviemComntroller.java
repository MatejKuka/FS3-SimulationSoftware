package GUI.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NeviemComntroller implements Initializable {
    @FXML
    private StackPane contentArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("../Views/Home.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);

        } catch (IOException e) {
            Logger.getLogger(ModuleLayer.Controller.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void handleHome(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("../Views/Home.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    public void handleAbout(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("../Views/About.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }
}
