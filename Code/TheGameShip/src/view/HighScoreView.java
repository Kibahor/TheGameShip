package view;

import javafx.event.ActionEvent;
import launch.Launcher;
import model.util.data.HighScore;

public class HighScoreView {
    private static HighScore highscore;
    public void initialize() {
        highscore = new HighScore();
        //PersistenceManager.loadHighScore(highscore);
    }

    public void menu(ActionEvent actionEvent){
        Launcher.getViewManager().setView("MenuView");
    }

    public void clear(ActionEvent actionEvent) {
        //TODO: Si on a le temps..
        System.out.println("Un jour peut être ^^"); //DEBUG
    }
}
