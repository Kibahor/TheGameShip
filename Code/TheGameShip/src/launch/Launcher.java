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
        primaryStage.setTitle("TheGameShip");

        Scene scene=new Scene(FXMLLoader.load(getClass().getResource("/FXML/Fenetre.fxml")));
        primaryStage.setScene(scene);

        ViewManager viewManager=new ViewManager(scene);
        viewManager.addView("Fenetre",FXMLLoader.load(getClass().getResource("/FXML/Fenetre.fxml")));
        viewManager.addView("Fenetre2",FXMLLoader.load(getClass().getResource("/FXML/Fenetre2.fxml")));
        viewManager.setView("Fenetre");

        primaryStage.show();
    }
}
