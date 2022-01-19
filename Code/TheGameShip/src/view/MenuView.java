package view;

import javafx.event.ActionEvent;;
import launch.Launcher;

public class MenuView {

    //TODO: Afficher les contrôle sur le menu
    //TODO: Faire un menu plus joli (bouton centrer au milieu sur la Vbox de droite et a droite demo du jeu/animation gameplay/image du jeu)
    public void initialize() {}

    public void play(ActionEvent actionEvent) {
        Launcher.getViewManager().setView("GameView");
    }
    public void highScore(ActionEvent actionEvent) {
        Launcher.getViewManager().setView("HighScoreView");
    }
    public void settings(ActionEvent actionEvent) { Launcher.getViewManager().setView("SettingsView"); }
    public void exit(ActionEvent actionEvent) { Launcher.getStage().close(); }
}
