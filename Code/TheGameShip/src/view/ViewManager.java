package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import launch.Launcher;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class ViewManager {

    private Map<String, String> view = new HashMap<>();
        private void addView(String name,String path){ view.put(name,path); }
        private void removeView(String name){ view.remove(name); }
        public void listView() {
            for (String key: view.keySet()) {
                System.out.println(key+" -> "+view.get(key));
            }
        }

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
        main = new Scene(loadView(defaultView));
        Launcher.getStage().setTitle("TheGameShip");
        Launcher.getStage().setMaxHeight(720);
        Launcher.getStage().setMaxHeight(1280);
        Launcher.getStage().setResizable(false);
        //Launcher.getStage().getIcons().add(new Image("https://img2.freepng.fr/20180519/rya/kisspng-logo-phoenix-art-5afffc96998f80.692522331526725782629.jpg"));
        //Launcher.getStage().getIcons().add(new Image(getClass().getResourceAsStream(("Sprite/logo.png"))));   //TODO: Fix ce bug de merde qui throw une exception car le stream est vide !!
        Launcher.getStage().setScene(main);
    }

    private Parent loadView(String name) {
        try {
            return FXMLLoader.load(getClass().getClassLoader().getResource(view.get(name)));
        }
        catch (Exception err) {
            int fontsize = 20;
            Pane pane = new Pane();
            Text texte = new Text(0,fontsize,"Impossible de charger la vue : "+name);
            texte.setFill(Color.RED);
            texte.setFont(new Font(fontsize));
            pane.getChildren().add(texte);
            return pane;
        }
    }

    public void setView(String name){ main.setRoot(loadView(name)); }
}
