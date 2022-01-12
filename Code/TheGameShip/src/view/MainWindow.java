package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import launch.Launcher;

public class MainWindow {
    @FXML
    private Pane pane;
    @FXML
    private Circle joueur;

    private Circle obstacle;

    public void initialize() throws Exception {
            //C'est au GameManager -> Niveau de bind les bonne propriété
            obstacle=new Circle(20, Color.DARKGRAY);
            Launcher.gameManager.BindProperties("Vaisseau",joueur.centerXProperty(),joueur.centerYProperty(),joueur.radiusProperty());
            Launcher.gameManager.BindProperties("Obstacle",obstacle.centerXProperty(),obstacle.centerYProperty(),obstacle.radiusProperty());
            pane.getChildren().add(obstacle);

    }
}
