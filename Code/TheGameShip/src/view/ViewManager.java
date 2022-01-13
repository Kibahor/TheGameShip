package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import launch.Launcher;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;


public class ViewManager {

    private HashMap<String, String> view = new HashMap<>();
        private void addView(String name,String path){view.put(name,path);}
        private void removeView(String name){view.remove(name);}
        public void listView(){
            for (Object key: view.keySet()) {
                System.out.println(key+" -> "+view.get(key));
            }
        }

    private Scene main;
        public double getSceneHeight() { return main.getHeight() - 70; }
        public double getSceneWidth(){ return main.getWidth(); }


    public ViewManager(String pathView,String defaultView) throws Exception {
        //Liste et ajoute les vues dans la map
        try{
            for(File file : new File(pathView).listFiles(file -> file.isFile())) {
                Path path=Paths.get(file.getPath());
                String name=file.getName().replace(".fxml", ""); // name = truc.fxml => truc
                addView(name,path.subpath(1,path.getNameCount()).toString()); // path = /a/b/c/truc.fxml => c/truc.fxml
            }
        }catch(Exception err){
            err.printStackTrace();
                //throw new Exception("Aucune vue n'a été trouvé dans : "+pathView);
        }
        main = new Scene(loadView(defaultView));
        listView();
        Launcher.getStage().setTitle("TheGameShip");
        Launcher.getStage().setMaxHeight(720);
        Launcher.getStage().setMaxHeight(1280);
        Launcher.getStage().setResizable(false);
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/EdenCodingIcon.png")));
        Launcher.getStage().setScene(main);
    }
    private Parent loadView(String name){
        try{
            return FXMLLoader.load(getClass().getClassLoader().getResource(view.get(name)));
        }catch(Exception err){
            err.printStackTrace();
            return new Pane();//TODO: Charger une vue d'erreur par exemple
        }
    }
    public void setView(String name){ main.setRoot(loadView(name)); }
}
