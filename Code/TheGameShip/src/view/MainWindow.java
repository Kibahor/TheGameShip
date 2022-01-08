package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import launch.Launcher;

import java.util.ArrayList;

public class MainWindow {
    ArrayList<String> input=new ArrayList<String>();

    @FXML
    private Pane pane;

    @FXML
    private Rectangle joueur;

    public void initialize() {
        //TODO: Faire fonctionner les déplacements
        //Déplacement

        Launcher.main.setOnKeyPressed(e -> {
            String code = e.getCode().toString();
            input.add(code);
        });
        Launcher.main.setOnKeyReleased(e -> {
            String code = e.getCode().toString();
            if (input.contains("LEFT")){
                joueur.setX(joueur.getX()-5);
                System.out.println("LEFT");
            }else if (input.contains("RIGHT")){
                joueur.setX(joueur.getX()+5);
                System.out.println("RIGHT");
            }else if (input.contains("DOWN")){
                joueur.setY(joueur.getY()+5);
                System.out.println("DOWN");
            }else if (input.contains("UP")){
                joueur.setY(joueur.getY()-5);
                System.out.println("UP");
            }else if (input.contains("A")){
                System.out.println("A");
            }
            input.remove( code );
        });
    }
}
