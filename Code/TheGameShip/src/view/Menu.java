package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launch.Launcher;
import model.GameManager;

public class Menu {
    private GameManager gameManager;
    public void initialize() {
        gameManager=new GameManager();
    }

    public void play(ActionEvent actionEvent) {
        Launcher.gameManager.start();//TODO:Voir si il ne faudrait pas le faire autre part
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
