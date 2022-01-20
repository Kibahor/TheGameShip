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

    private Map<String, View> views = new HashMap<>();

    private void addView(String name, String path) {
        View view = new View(path);
        views.put(name, view);
    }
    private void removeView(String name) { views.remove(name); }

    private final Scene main;
        public double getSceneHeight() { return main.getHeight(); }
        public double getSceneWidth() { return main.getWidth(); }


    public ViewManager(String title, int height, int width, String pathView, String nameStartView, String pathIcon, String cssPath) throws Exception {
        //Scene
        loadAllViews(pathView);
        loadView(nameStartView);
        main = new Scene(views.get(nameStartView).getParent());
        main.getStylesheets().add(cssPath);

        //Stage
        Launcher.getStage().setTitle(title); //Title
        Launcher.getStage().setMinHeight(height); //Windows Size
        Launcher.getStage().setMinWidth(width);
        Launcher.getStage().setHeight(height);
        Launcher.getStage().setWidth(width);
        Launcher.getStage().setResizable(false); //isResizable ?
        Launcher.getStage().getIcons().add(new Image(pathIcon)); //Application Icon
        Launcher.getStage().setScene(main); //Set Scene to Stage
    }

    private void loadAllViews(String pathView) throws Exception{
        //Liste et ajoute les vues dans la map
        try {
            for (File file : new File(pathView).listFiles(File::isFile)) {
                Path path = Paths.get(file.getPath()); // path = /a/b/c/truc.fxml
                String name = file.getName().replace(".fxml", ""); // name = something.fxml => something
                addView(name, path.subpath(1,path.getNameCount()).toString()); // path = /a/b/c/something.fxml => c/something.fxml
            }
        } catch (Exception err) {
            throw new Exception("Aucune vue n'a été trouvé dans : "+pathView);
        }
    }

    private void loadView(String name) {
        View view = views.get(name);
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getClassLoader().getResource(view.getPath()));
        } catch (IOException err) {
            System.err.println("La vue \""+name+"\" n'existe pas ! (ou a eu un problème lors de son chargement)"); //DEBUG
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

    public void closeView(String name) {
        View view = views.get(name);
        view.setParent(null);
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
