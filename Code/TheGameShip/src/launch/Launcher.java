//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import model.save.PersistenceManager;
import model.util.settings.Settings;
import view.ViewManager;

public class Launcher extends Application {

    private static ViewManager viewManager;
    private static Stage stage;
    private static Settings settings;

    public void start(Stage stage) throws Exception {
        this.stage = stage;
        viewManager = new ViewManager("TheGameShip",720,1280,"res/FXML/","MenuView", "/Sprites/icone.png", "view/CSS/style.css");
        settings = new Settings();
        PersistenceManager.loadSettings(settings);
        stage.show();
    }

    public static ViewManager getViewManager() { return viewManager; }
    public static Stage getStage() { return stage; }
    public static Settings getSettings() { return settings; }
}

// TODO: Code + Docs + Video (une demo vidéo d'1 min max) + Preuve de compétence (avec la feuille de compétence en expliquant)
// TODO : Faire une classe static DEBUG et set dans launcher si debug=true/false et remplacer toute les ligne de débug par la méthode

// Réflexion :
// - Au lieu d'adapter le model à la vue (double -> DoubleProperty), il faudrait faire l'inverse (même si en soit cela n'empêche pas de l'utiliser telle qu'elle)
// - Changer fonctionnement des interfaces d'entité : Voir si il ne faut l'appliquer qu'aux interfaces (au lieu des entités)
// - Les interface deviendrait package private et seul les class créé plus tôt pourrait les implémenter
//  Ensuite au lieu d'implémenter une interface dans l'entités on met une instance de l'objet
//  - Ou faire une fabrique qui selon le type choisis les bon composant
// https://pixlwalkr.itch.io/space-shooter-pixel-art-pack
