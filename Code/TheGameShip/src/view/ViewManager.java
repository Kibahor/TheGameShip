package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ViewManager {
    private HashMap<String, Pane> view=new HashMap<>();
    private Stage stage;
    private Scene main;

    public ViewManager(Stage stage) throws IOException {
        this.stage = stage;
        this.stage.setTitle("TheGameShip");
        this.stage.setMaxHeight(720);
        this.stage.setMaxHeight(1280);
        this.stage.setResizable(false);
        main=new Scene(FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml")));
        stage.setScene(main);
    }

    //TODO: Ajouter méthode autoAdd qui va être dans le constructeur et qui va charger toute les vue dans la Map
    private void addView(String name,Pane pane){
        view.put(name,pane);
    }

    private void removeView(String name){
        view.remove(name);
    }

    private Pane getView(String name){
        Pane pane=(Pane) view.get(name);
        if(pane==null){
            return new Pane(); //TODO: Charger une vue d'erreur par exemple
        }
        return pane;
    }

    public void setView(String name){
        main.setRoot(view.get(name));
    }

    public void listScene(){
        for (Object key: view.keySet()) {
            System.out.println(key);
        }
    }

    public Scene getScene(){
        return main;
    }
    public Stage getStage(){
        return stage;
    }
    public void loadView() throws IOException {
        this.addView("MainWindow",FXMLLoader.load(getClass().getResource("/FXML/MainWindow.fxml")));
        this.addView("Menu", FXMLLoader.load(getClass().getResource("/FXML/Menu.fxml")));
        this.addView("HighScore", FXMLLoader.load(getClass().getResource("/FXML/HighScore.fxml")));
        this.addView("Settings", FXMLLoader.load(getClass().getResource("/FXML/Settings.fxml")));
        this.addView("tests",FXMLLoader.load(getClass().getResource("/FXML/tests.fxml")));
    }
    public void show(){
        stage.show();
    }
}
