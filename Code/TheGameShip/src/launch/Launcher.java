//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;

public class Launcher extends Application {
    private static ViewManager viewManager;
    private static Stage stage;
    //todo :Faire une classe static DEBUG et set dans launcher si debug=true/false et remplacer toute les ligne de débug par la méthode

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        viewManager = new ViewManager("res/FXML/","Menu");
        stage.show();
    }

    public static ViewManager getViewManager() { return viewManager; }
    public static Stage getStage() { return stage; }
}
