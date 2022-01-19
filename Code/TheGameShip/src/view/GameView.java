package view;

import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import launch.Launcher;
import model.game.World;
import model.entity.IEntity;
import model.entity.Componement.Location;
import model.entity.Componement.Sprite;

public class GameView {

    @FXML
    private Pane pane;

    private World world;

    public void initialize() {

        world = new World();

        world.getEntityCollection().addListener((SetChangeListener<IEntity>) e ->{
            if(e.wasAdded()){
                addEntity(e.getElementAdded());
            }else if(e.wasRemoved()){
                pane.getChildren().remove(e.getElementRemoved());
            }
        });

        world.init();

        world.start();

        Launcher.getStage().setOnCloseRequest(e -> {
            world.exit();
        });
    }

    public void addEntity(IEntity e) {
        /* TODO : ajouter ce genre de message dans les méthodes de casts
        if(!e.isTypeOf(EComponementType.Life)){
            System.err.println("Impossible d'ajouter l'entité : \""+e.getName()+"\" car elle n'implémente pas Location");
        }*/
        Location l=Location.cast(e);
        Sprite s= Sprite.cast(e);

        if(s.getSprite() != null){
            try {
                ImageView imgview = new ImageView();
                imgview.setImage(new Image(String.valueOf(getClass().getResource(s.getSprite()).toURI().toURL())));
                imgview.setSmooth(true);
                imgview.xProperty().bind(l.xProperty());
                imgview.yProperty().bind(l.yProperty());
                imgview.fitHeightProperty().bind(l.heightProperty());
                imgview.fitWidthProperty().bind(l.widthProperty());
                imgview.visibleProperty().bind(s.getVisibleBooleanProperty());
                pane.getChildren().add(imgview);
            } catch(Exception err) {
                err.printStackTrace();
            }

        } else {
            //Si pas de sprite
            Color color;
            switch (e.getEntityType()) {
                case Ennemy -> color = Color.RED;
                case Shoot -> color = Color.YELLOW;
                case Obstacle -> color = Color.GRAY;
                case Player -> color = Color.BLACK;
                default -> color = Color.GREY;
            }

            Rectangle r = new Rectangle();
            r.setFill(color);
            r.heightProperty().bind(l.heightProperty());
            r.widthProperty().bind(l.widthProperty());
            r.xProperty().bind(l.xProperty());
            r.yProperty().bind(l.yProperty());
            r.visibleProperty().bind(s.getVisibleBooleanProperty());
            pane.getChildren().add(r);
        }
    }
}