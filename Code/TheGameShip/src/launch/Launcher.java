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

public class Launcher extends Application {
    public static Scene main;

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("TheGameShip");
        primaryStage.setMaxHeight(720);
        primaryStage.setMaxHeight(1280);
        primaryStage.setResizable(false);

        this.main=new Scene(FXMLLoader.load(getClass().getResource("/FXML/Fenetre2.fxml")));
        primaryStage.setScene(this.main);

        ViewManager viewManager=new ViewManager(this.main);
        viewManager.addView("Fenetre",FXMLLoader.load(getClass().getResource("/FXML/Fenetre.fxml")));
        viewManager.addView("Fenetre2",FXMLLoader.load(getClass().getResource("/FXML/Fenetre2.fxml")));
        viewManager.addView("tests", FXMLLoader.load(getClass().getResource("/FXML/tests.fxml")));
        viewManager.setView("Fenetre");

        primaryStage.show();
    }
}
