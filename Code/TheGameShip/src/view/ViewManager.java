package view;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.HashMap;

public class ViewManager {
    private HashMap<String, Pane> view=new HashMap<>();
    private Scene main;

    public ViewManager(Scene main){
        this.main = main;
    }

    //TODO: Ajouter méthode autoAdd qui va être dans le constructeur et qui va charger toute les vue dans la Map
    public void addView(String name,Pane pane){
        view.put(name,pane);
    }

    public void removeView(String name){
        view.remove(name);
    }

    public Pane getView(String name){
        return (Pane) view.get(name);
    }
    //TODO: throw une exception si la scene n'est pas trouver
    public void setView(String name){
        main.setRoot(view.get(name));
    }

    public void listScene(){
        for (Object key: view.keySet()) {
            System.out.println(key);
        }
    }
}
