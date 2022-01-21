//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package launch;

import javafx.application.Application;
import javafx.stage.Stage;
import model.util.save.PersistenceManager;
import view.ViewManager;

public class Launcher extends Application {
    private static Stage stage;
    private static ViewManager viewManager;
    private static PersistenceManager persistenceManager;

    public void start(Stage stage) throws Exception {
        Launcher.stage = stage;
        viewManager = new ViewManager("TheGameShip", 720, 1280, "res/FXML/", "MenuView", "/Sprites/icone.png", "view/CSS/style.css");
        persistenceManager = new PersistenceManager();
        stage.show();
    }

    public static ViewManager getViewManager() {
        return viewManager;
    }
    public static Stage getStage() {
        return stage;
    }
    public static PersistenceManager getPersistenceManager() {
        return persistenceManager;
    }
}

// TODO : Faire une classe static DEBUG et set dans launcher si debug=true/false et remplacer toute les ligne de débug par la méthode

// il reste :
//- Résoudre le problème de tir
//- Faire la doc :
//   - Diagramme de cas d'utilisation (Valentin)
//   - Preuve de connaissance (grâce à la fiche de compétence) (Lukas & Valentin) + Marquer les différent patron de conception utilisés
//   - Commenter le code + Générer javadoc (Lukas & Valentin)
//
//  Optionnel :
//  -Ecrire le readme
//  - Modifier contrôle dans les settings
//  - Ajouter un bouton pause et retour vers le menu
//  - Ajouter du son
//  - Ajout des power - up
//  - Ajouter contrôle avec la manette
//  - Faire des fichiers de config, pour générer les niveaux
//  - Implémenter poids mouche si on a le temps
// https://pixlwalkr.itch.io/space-shooter-pixel-art-pack
