package view;

import javafx.event.ActionEvent;
import launch.Launcher;

public class HighScoreView {

    public void initialize() {}

    public void menu(ActionEvent actionEvent){
        Launcher.getViewManager().setView("MenuView");
    }

    public void clear(ActionEvent actionEvent) {
        //TODO: Si on a le temps..
        System.out.println("Un jour peut être ^^"); //DEBUG
    }
}
