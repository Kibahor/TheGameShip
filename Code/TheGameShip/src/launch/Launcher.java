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
    private static Stage stage;

    @Override
    public void init(){
        //gameManager=new GameManager();//DEBUG
    }

    public void start(Stage stage) throws Exception {
        this.stage=stage;
        viewManager = new ViewManager();
        viewManager.loadView();
        viewManager.setView("Menu");//DEBUG
        Launcher.getStage().show();
    }

    @Override
    public void stop() {
        //TODO : attacher la fonction a l'événement quitter de la scene
        //gameManager.exit();
    }

    public static ViewManager getViewManager(){
        return viewManager;
    }
    public static Stage getStage(){return stage;}
}
