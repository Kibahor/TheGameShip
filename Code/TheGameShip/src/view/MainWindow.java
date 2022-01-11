package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import launch.Launcher;
import model.entity.Entity;

public class MainWindow {
    @FXML
    private Pane pane;

    @FXML
    private Circle joueur;

    public void initialize() throws Exception {
        Entity e = (Entity) Launcher.gameManager.getEntityManager().getEntity("Vaisseau"); //TODO:Pas foufou
        joueur.centerXProperty().bind(e.xProperty());
        joueur.centerXProperty().bind(e.yProperty());
        joueur.radiusProperty().bind(e.hitbox_radiusProperty());
    }
}
