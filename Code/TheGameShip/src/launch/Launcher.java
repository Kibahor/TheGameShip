package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Boucle;
import model.entity.*;
import model.move.Input;
import view.ViewManager;

public class Launcher extends Application {
    //TODO: Faire des fonction pour attacher des événements a une scène dans ViewManager
    public static ViewManager viewManager;
    public static EntityManager entityManager;

    public void start(Stage stage) throws Exception {
        entityManager = new EntityManager();
        entityManager.add(new Entity("file://test.jpg","Vaisseau","Joueur"));

        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/EdenCodingIcon.png")));

        viewManager = new ViewManager(stage);
        viewManager.loadView();
        viewManager.setView("Menu");

        Input input = new Input("Vaisseau");
        Thread b = new Thread(new Boucle() {
            @Override
            public void update() {
                input.update();
            }
        });
        b.start();
        stage.show();
    }
}
