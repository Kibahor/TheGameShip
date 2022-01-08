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
import model.entity.*;
import view.ViewManager;

public class Launcher extends Application {
    public static Scene main;
    public static ViewManager viewManager;
    public static EntityManager entityManager;

    @Override
    public void init() throws Exception {
        main=new Scene(FXMLLoader.load(getClass().getResource("/FXML/tests.fxml")));

        ViewManager viewManager=new ViewManager(this.main);
        viewManager.addView("MainWindow",FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml")));
        viewManager.addView("Menu", FXMLLoader.load(getClass().getResource("/FXML/Menu.fxml")));
        viewManager.addView("Settings", FXMLLoader.load(getClass().getResource("/FXML/Settings.fxml")));
        viewManager.addView("tests",FXMLLoader.load(getClass().getResource("/FXML/tests.fxml")));

        entityManager=new EntityManager();
        entityManager.add(new EntityDecorator(new HasLifeDecorator(new MovableDecorator(new Entity("file://test.jpg","Vaisseau","Joueur"),5, 5),10)));

    }

    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("TheGameShip");
        primaryStage.setMaxHeight(720);
        primaryStage.setMaxHeight(1280);
        primaryStage.setResizable(false);
        primaryStage.setScene(main);

        viewManager.setView("Menu");

        primaryStage.show();
    }
}
