package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import launch.Launcher;

import java.io.IOException;
import java.util.HashMap;

public class ViewManager {

    private HashMap<String, Pane> view = new HashMap<>();
        private void addView(String name,Pane pane){
        view.put(name,pane);
    }
        private void removeView(String name){
        view.remove(name);
    }
        private Pane getView(String name){
            Pane pane = (Pane) view.get(name);
            if(pane == null){
                return new Pane(); //TODO: Charger une vue d'erreur par exemple
            }
            return pane;
        }

        /*public void show() {
            stage.show();
        }*/

    private Scene main;
        public Scene getActualScene(){
        return main;
    }
        public void setView(String name){
        main.setRoot(this.getView(name));
    }
        public void listScene(){
            for (Object key: view.keySet()) {
                System.out.println(key);
            }
        }
        public double getSceneHeight() { return main.getHeight() - 70; }
        public double getSceneWidth(){
        return main.getWidth();
    }

    public ViewManager() throws IOException {
        Launcher.getStage().setTitle("TheGameShip");
        Launcher.getStage().setMaxHeight(720);
        Launcher.getStage().setMaxHeight(1280);
        Launcher.getStage().setResizable(false);
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/EdenCodingIcon.png")));
        this.addView("Menu", FXMLLoader.load(getClass().getResource("/FXML/Menu.fxml")));//DEBUG
        main = new Scene(getView("Menu"));
        Launcher.getStage().setScene(main);
    }

    //TODO: Ajouter méthode autoAdd qui va être dans le constructeur et qui va charger toute les vue dans la Map
    public void loadView() throws IOException {
        this.addView("MainWindow",FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml")));
        this.addView("HighScore", FXMLLoader.load(getClass().getResource("/FXML/HighScore.fxml")));
        this.addView("Settings", FXMLLoader.load(getClass().getResource("/FXML/Settings.fxml")));
        this.addView("tests",FXMLLoader.load(getClass().getResource("/FXML/tests.fxml")));
    }
}
