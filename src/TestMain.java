import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TestMain extends Application {
    double x, y;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI/Views/Neviem.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMousePressed(event -> {
            primaryStage.setX(event.getSceneX() - x);
            primaryStage.setY(event.getSceneY() - y);
        });

        primaryStage.setScene(new Scene(root, 788, 555));
        primaryStage.show();
    }
}
