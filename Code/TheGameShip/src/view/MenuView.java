package view;

import javafx.event.ActionEvent;
import launch.Launcher;

public class MenuView {

    public void initialize() {
    }

    public void play(ActionEvent actionEvent) {
        Launcher.getViewManager().setView("GameView");
    }

    public void highScore(ActionEvent actionEvent) {
        Launcher.getViewManager().setView("HighScoreView");
    }

    public void settings(ActionEvent actionEvent) {
        Launcher.getViewManager().setView("SettingsView");
    }

    public void exit(ActionEvent actionEvent) {
        Launcher.getStage().close();
    }
}
