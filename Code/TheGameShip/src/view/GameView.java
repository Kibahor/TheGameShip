package view;

import javafx.beans.value.ObservableValue;
import javafx.collections.SetChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import launch.Launcher;
import model.entity.componement.Life;
import model.entity.EEntityType;
import model.game.World;
import model.entity.IEntity;
import model.entity.componement.Location;
import model.entity.componement.Sprite;
import model.util.data.HighScore;

public class GameView {

    @FXML private Pane pane;
    @FXML private Label life;
    @FXML private Label score;

    private World world;

    public void initialize() {

        world = new World();

        world.getEntityCollection().addListener((SetChangeListener<IEntity>) e -> {
            if (e.wasAdded()){
                addEntity(e.getElementAdded());
            } else if(e.wasRemoved()){
                pane.getChildren().remove(e.getElementRemoved());
            }
        });

        world.init();
        world.start();

        life.textProperty().bind(Life.cast(world.getPlayer()).hpProperty().asString());
        score.textProperty().bind(world.getCurrentLevel().scoreProperty().asString());

        Launcher.getStage().setOnCloseRequest(e -> {
            world.exit();
        });
    }

    public void addEntity(IEntity e) {
        Location l = Location.cast(e);
        Sprite s = Sprite.cast(e);

        if (s.getSprite() != null) {
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
            } catch (Exception err) {
                err.printStackTrace();
            }

        } else {
            //Si pas de sprite
            Color color;
            switch (e.getEntityType()) {
                case Enemy -> color = Color.RED;
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

        if (e.getEntityType().equals(EEntityType.Player)) {
            Life life = Life.cast(e);
            life.isDeadProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) ->{
                if (newValue) {
                    Launcher.getStage().setUserData(world.getScore());
                    Launcher.getHighScore().addHighScore(world.getScore());
                    System.out.println(Launcher.getHighScore().toString());
                    world.exit();
                    Launcher.getViewManager().closeView("GameView");
                    Launcher.getViewManager().setView("EndGameView");
                }
            });
        }
    }
}