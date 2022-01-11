package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launch.Launcher;

public class HighScore {

    public void initialize() {}

    public void menu(ActionEvent actionEvent){
        Launcher.viewManager.setView("Menu");
    }

    public void clear(ActionEvent actionEvent){
        //TODO: Si on a le temps..
        System.out.println("Un jour peut être ^^"); //DEBUG
    }
}
