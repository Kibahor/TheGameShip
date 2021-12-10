//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package launch;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {

    public void start(Stage primaryStage) throws IOException {
        Parent racine = (Parent)FXMLLoader.load(this.getClass().getResource("/FXML/Fenetre.fxml"));
        Scene scene = new Scene(racine);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Awesome Window");
        primaryStage.show();
    }
}
