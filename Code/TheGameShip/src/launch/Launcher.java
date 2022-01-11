//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Boucle;
import model.GameManager;
import model.entity.*;
import model.move.Input;
import model.move.Keyboard;
import model.move.MovePlayer;
import view.ViewManager;

public class Launcher extends Application {
    //TODO: Trouver un autre moyen que le singleton
    public static GameManager gameManager;
    public static ViewManager viewManager;

    @Override
    public void init(){
        gameManager=new GameManager();//DEBUG
    }

    public void start(Stage stage) throws Exception {
        viewManager = new ViewManager(stage);
        viewManager.loadView();
        viewManager.setView("Menu");//DEBUG
        viewManager.show();
        gameManager.start();//TODO:Voir si il ne faudrait pas le faire autre part
    }

    @Override
    public void stop() {
        gameManager.exit();
    }
}
