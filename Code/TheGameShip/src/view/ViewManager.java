package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Pair;
import launch.Launcher;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ViewManager {

    private Map<String,View> views = new HashMap<>();

    private void addView(String name,String path){
        View view = new View(path);
        views.put(name, view);
    }
    private void removeView(String name){ views.remove(name); }

    private final Scene main;
        public double getSceneHeight() { return main.getHeight(); }
        public double getSceneWidth(){ return main.getWidth(); }


    public ViewManager(String pathView,String defaultView) throws Exception {
        //Liste et ajoute les vues dans la map
        try {
            for (File file : new File(pathView).listFiles(File::isFile)) {
                Path path = Paths.get(file.getPath()); // path = /a/b/c/truc.fxml
                String name = file.getName().replace(".fxml", ""); // name = truc.fxml => truc
                addView(name, path.subpath(1,path.getNameCount()).toString()); // path = /a/b/c/truc.fxml => c/truc.fxml
            }
        }
        catch (Exception err) {
            throw new Exception("Aucune vue n'a été trouvé dans : "+pathView);
        }
        loadView(defaultView);
        main = new Scene(views.get(defaultView).getParent());
        Launcher.getStage().setTitle("TheGameShip");
        Launcher.getStage().setMaxHeight(720);
        Launcher.getStage().setMaxHeight(1280);
        Launcher.getStage().setResizable(false);
        //Launcher.getStage().getIcons().add(new Image("https://img2.freepng.fr/20180519/rya/kisspng-logo-phoenix-art-5afffc96998f80.692522331526725782629.jpg"));
        //Launcher.getStage().getIcons().add(new Image(getClass().getResourceAsStream(("Sprite/logo.png"))));   //TODO: Fix ce bug de merde qui throw une exception car le stream est vide !!
        Launcher.getStage().setScene(main);
    }

    private void loadView(String name) {
        View view = views.get(name);
        Parent parent = null;
        try{
            parent = FXMLLoader.load(getClass().getClassLoader().getResource(view.getPath()));
        }catch (IOException err) {
            err.printStackTrace(); //DEBUG
        }
        views.get(name).setParent(parent);
    }

    public void setView(String name) {
        View view=views.get(name);
        if(!view.isInitialize()){
            loadView(name);
        }
        main.setRoot(view.getParent());
    }

    //TODO : la refaire pour mettre toute les infos
    @Override
    public String toString() {
        /*
        for (String key: view.keySet()) {
            System.out.println(key+" -> "+view.get(key));
        }*/
        return super.toString();
    }
}
