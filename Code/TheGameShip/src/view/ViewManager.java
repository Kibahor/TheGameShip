package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ViewManager {
    private Map view;

    public ViewManager(){
        this.view = new HashMap();
    }

    public void addScene(String name,Scene scene){
        view.put(name,scene);
    }

    public void removeScene(String name){
        view.remove(name);
    }

    public Scene getScene(String name,Scene DefaultScene){
        return (Scene) view.getOrDefault(name,DefaultScene);
    }

    public void listScene(){
        for (Object key: view.keySet()) {
            System.out.println(key);
        }
    }
}
