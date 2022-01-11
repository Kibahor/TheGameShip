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
        Entity e= (Entity) Launcher.entityManager.getEntity("Vaisseau");
        joueur.xProperty().bind(e.xProperty());
        joueur.yProperty().bind(e.yProperty());
        joueur.widthProperty().bind(e.hitbox_radiusProperty());
        joueur.heightProperty().bind(e.hitbox_radiusProperty());
    }
}
