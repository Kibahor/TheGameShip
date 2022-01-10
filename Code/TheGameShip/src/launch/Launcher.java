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
import model.Boucle;
import model.entity.*;
import view.ViewManager;

public class Launcher extends Application {
    //TODO: Faire des fonction pour attacher des événements a une scène dans ViewManager
    public static Scene main;
    public static ViewManager viewManager;
    public static EntityManager entityManager;

    public void start(Stage primaryStage) throws Exception {
        entityManager=new EntityManager();
        entityManager.add(new Entity("file://test.jpg","Vaisseau","Joueur"));

        primaryStage.setTitle("TheGameShip");
        primaryStage.setMaxHeight(720);
        primaryStage.setMaxHeight(1280);
        primaryStage.setResizable(false);
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/EdenCodingIcon.png")));

        main=new Scene(FXMLLoader.load(getClass().getResource("/FXML/tests.fxml")));

        ViewManager viewManager=new ViewManager(main);
        viewManager.addView("MainWindow",FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml")));
        viewManager.addView("Menu", FXMLLoader.load(getClass().getResource("/FXML/Menu.fxml")));
        viewManager.addView("Settings", FXMLLoader.load(getClass().getResource("/FXML/Settings.fxml")));
        viewManager.addView("tests",FXMLLoader.load(getClass().getResource("/FXML/tests.fxml")));

        primaryStage.setScene(main);

        viewManager.setView("MainWindow");

        primaryStage.show();
    }
}
