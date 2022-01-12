package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launch.Launcher;

public class Settings {

    public void initialize() {}

    public void reset(ActionEvent actionEvent){
        //TODO: Peut être plus tard hein ;)
        System.out.println("Un jour peut être ^^"); //DEBUG
    }

    public void menu(ActionEvent actionEvent){
        Launcher.getViewManager().setView("Menu");
    }
}
