package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import launch.Launcher;

import java.util.ArrayList;
import java.util.HashSet;

public class Fenetre {
    @FXML
    private Pane pane;

    @FXML
    private Rectangle joueur;

    public void initialize() {
        //TODO: Faire fonctionner les déplacements
        //Déplacement
        Launcher.main.setOnKeyPressed(e -> {
            String code = e.getCode().toString();
            if (code.contains("LEFT")){
                joueur.setX(joueur.getX()-5);
                System.out.println("LEFT");
            }else if (code.contains("RIGHT")){
                joueur.setX(joueur.getX()+5);
                System.out.println("RIGHT");
            }else if (code.contains("DOWN")){
                joueur.setY(joueur.getY()+5);
                System.out.println("DOWN");
            }else if (code.contains("UP")){
                joueur.setY(joueur.getY()-5);
                System.out.println("UP");
            }else if (code.contains("A")){
                System.out.println("A");
            }
        });
    }
}
