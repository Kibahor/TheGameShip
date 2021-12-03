package launch;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    @Override
    public void start (Stage primaryStage) throws java.io.IOException {
        Parent racine = FXMLLoader.load(getClass().getResource("/FXML/Fenetre.fxml"));
        Scene scene=new Scene(racine);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Awesome Window");
        primaryStage.show();
    }
}
