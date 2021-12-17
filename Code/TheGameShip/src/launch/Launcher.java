//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package launch;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class Launcher extends Application {

    public void start(Stage primaryStage) throws IOException {
        Parent racine = (Parent)FXMLLoader.load(this.getClass().getResource("/FXML/Fenetre.fxml"));
        Scene scene = new Scene(racine);
        //Déplacement
        ArrayList<String> input = new ArrayList<String>();
        scene.setOnKeyPressed(e -> {
            String code = e.getCode().toString();
            if (!input.contains(code))
                input.add(code);
        });
        scene.setOnKeyReleased((EventHandler<KeyEvent>) e -> {
            String code = e.getCode().toString();
            if (input.contains("LEFT")){
                System.out.println("LEFT");
            }else if (input.contains("RIGHT")){
                System.out.println("RIGHT");
            }
            input.remove( code );
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("TheGameShip");
        primaryStage.show();
    }
}
