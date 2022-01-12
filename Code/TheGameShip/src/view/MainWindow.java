package view;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.WindowEvent;
import launch.Launcher;
import model.GameManager;

public class MainWindow {

    @FXML
    private Pane pane;

    @FXML
    private Circle joueur;

    @FXML
    private Circle obstacle;

    private GameManager gameManager;

    public void initialize() throws Exception {
        //C'est au GameManager -> Niveau de bind les bonne propriété
        System.out.println("LOAD");//DEBUG
        gameManager = new GameManager();
        joueur = new Circle (20, Color.BLACK);
        obstacle = new Circle(20, Color.DARKGRAY);

        gameManager.BindProperties("Vaisseau",joueur.centerXProperty(),joueur.centerYProperty(),joueur.radiusProperty());
        gameManager.BindProperties("Obstacle",obstacle.centerXProperty(),obstacle.centerYProperty(),obstacle.radiusProperty());

        pane.getChildren().add(joueur);
        pane.getChildren().add(obstacle);

        //TODO: Voir si il ne faudrait pas le faire autre part
        // Oui, il faut le mettre ailleur ^^
        gameManager.start();
        Launcher.getStage().setOnCloseRequest(e ->{
            gameManager.exit();
            System.out.println("EXIT");//DEBUG
        });
    }
}

//TODO: Code + Docs + Video (une demo vidéo d'1 min max) + Preuve de compétence (avec la feuille de compétence en expliquant)
