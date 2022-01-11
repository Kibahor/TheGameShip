package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import launch.Launcher;

public class MainWindow {
    @FXML
    private Pane pane;

    @FXML
    private Circle joueur;

    public void initialize() throws Exception {
            //C'est au GameManager -> Niveau de bind les bonne propriété
            Launcher.gameManager.BindPlayerProperties(joueur.centerXProperty(),joueur.centerYProperty(),joueur.radiusProperty());
    }
}
