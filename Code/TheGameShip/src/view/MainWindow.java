package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import launch.Launcher;
import model.Boucle;
import model.entity.Entity;
import model.move.Input;

public class MainWindow {
    @FXML
    private Pane pane;

    @FXML
    private Rectangle joueur;

    public void initialize() throws Exception {
        Entity e= (Entity) Launcher.entityManager.getEntity("Vaisseau");
        joueur.xProperty().bind(e.xProperty());
        joueur.yProperty().bind(e.yProperty());
    }
}
