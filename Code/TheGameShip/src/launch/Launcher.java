//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import model.GameManager;
import model.entity.*;
import view.ViewManager;

public class Launcher extends Application {
    //TODO: Trouver un autre moyen que le singleton
    public static GameManager gameManager;
    public static ViewManager viewManager;
    public static EntityManager entityManager;

    @Override
    public void init(){
        gameManager=new GameManager();//DEBUG
    }

    public void start(Stage stage) throws Exception {
        viewManager = new ViewManager(stage);
        viewManager.loadView();
        viewManager.setView("Menu");//DEBUG
        viewManager.show();
    }

    @Override
    public void stop() {
        gameManager.exit();
    }
}
