package view;

import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import launch.Launcher;
import model.GameManager;
import model.entity.IEntity;

public class MainWindow {

    @FXML
    private Pane pane;

    private GameManager gameManager;

    public void initialize() {
        //C'est au GameManager -> Niveau de bind les bonne propriété
        System.out.println("LOAD");//DEBUG
        gameManager = new GameManager();

        gameManager.getSetEntity().addListener(new SetChangeListener<IEntity>() {
            @Override
            public void onChanged(Change<? extends IEntity> change) {
                if(change.wasAdded()){
                    addEntity(change.getElementAdded());
                }
            }
        });
        gameManager.initEntity();

        gameManager.start();
        Launcher.getStage().setOnCloseRequest(e -> {
            gameManager.exit();
            System.out.println("EXIT");//DEBUG
        });

    }
    public void addEntity(IEntity e) {
        Circle c = new Circle(e.getHitbox_radius(),Color.BLACK);
        c.centerXProperty().bind(e.xProperty());
        c.centerYProperty().bind(e.yProperty());
        c.radiusProperty().bind(e.hitbox_radiusProperty());
        c.visibleProperty().bind(e.getVisibleBooleanProperty());
        pane.getChildren().add(c);
    }
}

//TODO: Code + Docs + Video (une demo vidéo d'1 min max) + Preuve de compétence (avec la feuille de compétence en expliquant)
