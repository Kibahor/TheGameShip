package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launch.Launcher;

public class Menu {

    @FXML
    private Button ButtonQuit;

    @FXML
    private Button ButtonSettings;

    @FXML
    private Button ButtonHighScore;

    @FXML
    private Button ButtonPlay;


    public void initialize() {}

    public void play(ActionEvent actionEvent) {
        Launcher.viewManager.setView("MainWindow");
    }
    public void highScore(ActionEvent actionEvent) {
        Launcher.viewManager.setView("HighScore");
    }
    public void settings(ActionEvent actionEvent) {
        Launcher.viewManager.setView("Settings");
    }
    public void exit(ActionEvent actionEvent){
        Launcher.viewManager.exitStage();
    }
}
