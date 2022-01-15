package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import launch.Launcher;
import model.GameManager;
import model.IHasEntityCollection;
import model.entity.IEntity;
import model.entity.IHasLocation;

import java.util.Collection;

public class MainWindow {

    @FXML
    private Pane pane;

    private GameManager gameManager;

    public void initialize() throws Exception {

        gameManager = new GameManager();

        gameManager.init();
        loadEntity(((IHasEntityCollection)gameManager).getUnusedEntityCollection());
        loadEntity(((IHasEntityCollection)gameManager).getUsedEntityCollection());

        gameManager.start();

        Launcher.getStage().setOnCloseRequest(e -> {
            try {
                gameManager.exit();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    private void loadEntity(Collection<IEntity> c) throws Exception {
        for(IEntity e : c){
            addEntity(e);
        }
    }

    public void addEntity(IEntity e) throws Exception {
        if(!(e instanceof IHasLocation)){return;}
        IHasLocation h=IHasLocation.cast(e);
        Color color;
        switch(e.getType()){
            case Ennemy -> color=Color.RED;
            case Obstacle -> color=Color.GRAY;
            case Player -> color=Color.BLACK;
            default -> color=Color.GREY;
        }

        Circle c = new Circle(h.getHitbox_radius(),color);
        c.centerXProperty().bind(h.xProperty());
        c.centerYProperty().bind(h.yProperty());
        c.radiusProperty().bind(h.hitbox_radiusProperty());
        c.visibleProperty().bind(e.getVisibleBooleanProperty());
        pane.getChildren().add(c);
    }
}

//TODO: Code + Docs + Video (une demo vidéo d'1 min max) + Preuve de compétence (avec la feuille de compétence en expliquant)
//Todo: Utiliser du css pour le style de la vue