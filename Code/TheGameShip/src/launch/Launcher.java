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

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        viewManager = new ViewManager("res/FXML/","Menu");
        stage.show();
    }

    public static ViewManager getViewManager() { return viewManager; }
    public static Stage getStage() { return stage; }
}
