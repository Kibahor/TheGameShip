package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import launch.Launcher;
import model.GameManager;

public class MainWindow {

    @FXML
    private Pane pane;

    private GameManager gameManager;

    public void initialize() {
        //C'est au GameManager -> Niveau de bind les bonne propriété
        System.out.println("LOAD");//DEBUG
        gameManager = new GameManager();

        Circle joueur = new Circle (20, Color.BLACK);

        addEntity("Vaisseau", joueur);
        addEntity("Obstacle1", new Circle(20, Color.DARKGRAY));

        Rectangle lifeBar = new Rectangle(0, 0, 10, 30);
        gameManager.BindLifeBar("Vaisseau", joueur.strokeWidthProperty());
        pane.getChildren().add(lifeBar);

        gameManager.start();
        Launcher.getStage().setOnCloseRequest(e -> {
            gameManager.exit();
            System.out.println("EXIT");//DEBUG
        });
    }
    public void addEntity(String entityName, Circle c) {
        gameManager.BindProperties(entityName, c.centerXProperty(), c.centerYProperty(), c.radiusProperty());
        pane.getChildren().add(c);
    }
}

//TODO: Code + Docs + Video (une demo vidéo d'1 min max) + Preuve de compétence (avec la feuille de compétence en expliquant)
