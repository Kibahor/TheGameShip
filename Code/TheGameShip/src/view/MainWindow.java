package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import launch.Launcher;
import model.GameManager;

public class MainWindow {
    @FXML
    private Pane pane;
    @FXML
    private Circle joueur;

    private Circle obstacle;

    private GameManager gameManager;

    public void initialize() throws Exception {
            //C'est au GameManager -> Niveau de bind les bonne propriété
            gameManager=new GameManager();
            obstacle=new Circle(20, Color.DARKGRAY);
            gameManager.BindProperties("Vaisseau",joueur.centerXProperty(),joueur.centerYProperty(),joueur.radiusProperty());
            gameManager.BindProperties("Obstacle",obstacle.centerXProperty(),obstacle.centerYProperty(),obstacle.radiusProperty());
            pane.getChildren().add(obstacle);
            gameManager.start();//TODO:Voir si il ne faudrait pas le faire autre part
    }
}
