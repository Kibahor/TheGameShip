package view;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Fenetre {
    ArrayList<String> input;
    @FXML
    private Rectangle joueur;

    public void initialize() {
        input= new ArrayList<String>();
        //Déplacement
        Set<String> input = new HashSet<String>();
        /*
        //Déplacements
        scene.setOnKeyPressed(e -> {
            String code = e.getCode().toString();
            input.add(code);
        });
        scene.setOnKeyReleased((EventHandler<KeyEvent>) e -> {
            String code = e.getCode().toString();
            if (input.contains("LEFT")){
                System.out.println("LEFT");
            }else if (input.contains("RIGHT")){
                System.out.println("RIGHT");
            }else if (input.contains("DOWN")){
                System.out.println("DOWN");
            }else if (input.contains("UP")){
                System.out.println("UP");
            }else if (input.contains("A")){
                System.out.println("A");
            }
            input.remove( code );
        });*/
    }
}
