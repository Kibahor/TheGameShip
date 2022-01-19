package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import launch.Launcher;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class ViewManager {

    private Map<String,View> views = new HashMap<>();

    private void addView(String name, String path){
        View view = new View(path);
        views.put(name, view);
    }
    private void removeView(String name) { views.remove(name); }

    private final Scene main;
        public double getSceneHeight() { return main.getHeight(); }
        public double getSceneWidth() { return main.getWidth(); }


    public ViewManager(String pathView, String defaultView) throws Exception {
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
        Launcher.getStage().setMinHeight(720);
        Launcher.getStage().setMinWidth(1280);

        Launcher.getStage().setHeight(720);
        Launcher.getStage().setWidth(1280);

        Launcher.getStage().setResizable(false);
        Launcher.getStage().getIcons().add(new Image("/Sprites/icone.png"));
        Launcher.getStage().setScene(main);
    }
    public ViewManager(String pathView, String defaultView, String cssPath) throws Exception {
        this(pathView, defaultView);
        main.getStylesheets().add(cssPath);
    }

    private void loadView(String name) {
        View view = views.get(name);
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getClassLoader().getResource(view.getPath()));
        }catch (IOException err) {
            err.printStackTrace(); //DEBUG
        }
        views.get(name).setParent(parent);
    }

    public void setView(String name) {
        View view = views.get(name);
        if (!view.isInitialize()){
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
