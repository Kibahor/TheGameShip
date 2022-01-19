package view;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import launch.Launcher;
import model.World;
import model.entity.IHasEntityCollection;
import model.entity.IEntity;
import model.entity.IHasLocation;

import java.util.Collection;

public class MainWindow {

    @FXML
    private Pane pane;

    private World gameManager;

    public void initialize() throws Exception {

        gameManager = new World();

        gameManager.init();
        loadEntity(((IHasEntityCollection)gameManager).getEntityCollection());
        loadEntity(((IHasEntityCollection)gameManager).getUsedEntityCollection());

        gameManager.start();

        Launcher.getStage().setOnCloseRequest(e -> {
            gameManager.exit();
        });
    }

    private void loadEntity(Collection<IEntity> c) throws Exception {
        for(IEntity e : c){
            addEntity(e);
        }
    }

    public void addEntity(IEntity e) throws Exception {
        if(!(e instanceof IHasLocation)) { return; }
        IHasLocation h=IHasLocation.cast(e);

        if(!e.getSprite().equals("null")){
            ImageView imgview=new ImageView();
            imgview.setImage(new Image(String.valueOf(getClass().getResource(e.getSprite()).toURI().toURL())));
            imgview.setSmooth(true);
            imgview.xProperty().bind(((IHasLocation) e).xProperty());
            imgview.yProperty().bind(((IHasLocation) e).yProperty());
            imgview.fitHeightProperty().bind(((IHasLocation) e).heightProperty());
            imgview.fitWidthProperty().bind(((IHasLocation) e).widthProperty());
            imgview.visibleProperty().bind(e.getVisibleBooleanProperty());
            pane.getChildren().add(imgview);

        } else {
            //Si pas de sprite
            Color color;
            switch (e.getType()) {
                case Ennemy -> color = Color.RED;
                case Shoot -> color = Color.YELLOW;
                case Obstacle -> color = Color.GRAY;
                case Player -> color = Color.BLACK;
                default -> color = Color.GREY;
            }

            Rectangle r = new Rectangle();
            r.setFill(color);
            r.heightProperty().bind(h.heightProperty());
            r.widthProperty().bind(h.widthProperty());
            r.xProperty().bind(h.xProperty());
            r.yProperty().bind(h.yProperty());
            r.visibleProperty().bind(e.getVisibleBooleanProperty());
            pane.getChildren().add(r);
        }
    }
}