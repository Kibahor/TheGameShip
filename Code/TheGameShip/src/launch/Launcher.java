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
    private static ViewManager viewManager; //C'est bien (équivalent a passer le en static primaryStage)

    @Override
    public void init(){
        //gameManager=new GameManager();//DEBUG
    }

    public void start(Stage stage) throws Exception {
        viewManager = new ViewManager(stage);
        viewManager.loadView();
        viewManager.setView("Menu");//DEBUG
        viewManager.show();
    }

    @Override
    public void stop() {
        //TODO : attacher la fonction a l'événement quitter de la scene
        //gameManager.exit();
    }

    public static ViewManager getViewManager(){
        return viewManager;
    }
}
