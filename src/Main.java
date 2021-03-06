import BLL.exeptions.UserException;
import DAL.UserDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("GUI/Views/LoginView.fxml"));
            primaryStage.setTitle("FS3 simulation");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }

        public static void main(String[] args) throws IOException, UserException {
            UserDAO userDAO = new UserDAO();
            System.out.println(userDAO.getAllAdmins());
            launch(args);

        }


}
