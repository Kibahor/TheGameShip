//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package launch;

import java.io.IOException;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.ViewManager;

import java.util.HashSet;
import java.util.Set;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import model.entity.*;

public class Launcher extends Application {

    public void start(Stage primaryStage) throws IOException {
        Scene defaultScene=new Scene(FXMLLoader.load(this.getClass().getResource("/FXML/Fenetre.fxml")));
        ViewManager viewManager=new ViewManager();
        viewManager.addScene("Fenetre",defaultScene);
        viewManager.addScene("Fenetre2",new Scene(FXMLLoader.load(this.getClass().getResource("/FXML/Fenetre2.fxml"))));

        primaryStage.setScene(viewManager.getScene("Fenetre2",defaultScene));
        primaryStage.setTitle("TheGameShip");
        primaryStage.show();
    }
}
