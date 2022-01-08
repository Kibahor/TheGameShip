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
        //TODO: Faire fonctionner les déplacements
        //Déplacement
        /*
        Launcher.main.setOnKeyPressed(e -> {
            String code = e.getCode().toString();
            if (code.contains("LEFT")){
                joueur.setX(joueur.getX()-5);
                System.out.println("LEFT");
            }else if (code.contains("RIGHT")){
                joueur.setX(joueur.getX()+5);
                System.out.println("RIGHT");
            }else if (code.contains("DOWN")){
                joueur.setY(joueur.getY()+5);
                System.out.println("DOWN");
            }else if (code.contains("UP")){
                joueur.setY(joueur.getY()-5);
                System.out.println("UP");
            }else if (code.contains("A")){
                System.out.println("A");
            }
        });*/
        Entity e= (Entity) Launcher.entityManager.getEntity("Vaisseau");

        joueur.xProperty().bind(e.xProperty());
        joueur.yProperty().bind(e.yProperty());
        Input input=new Input("Vaisseau");
        //TODO : Le mettre dans le Launcher
        Thread b = new Thread(new Boucle() {
            @Override
            public void update() {
                input.update();
            }
        });
        b.start();
    }
}
