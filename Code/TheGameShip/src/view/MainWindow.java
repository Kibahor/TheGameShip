package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import launch.Launcher;
import model.entity.Entity;

public class MainWindow {
    @FXML
    private Pane pane;

    @FXML
    private Rectangle joueur;

    public void initialize() throws Exception {
            //C'est au GameManager -> Niveau de bind les bonne propriété
            Launcher.gameManager.BindPlayerProperties(joueur.xProperty(),joueur.yProperty(),joueur.heightProperty(),joueur.widthProperty());
    }
}
