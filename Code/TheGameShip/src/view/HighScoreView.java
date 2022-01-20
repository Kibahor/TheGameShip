package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import launch.Launcher;
import javafx.scene.control.ListView;
import model.util.data.HighScore;

public class HighScoreView {

    @FXML private ListView<Integer> highScoreList;

    private static HighScore highscore;

    public void initialize() {
        highscore = new HighScore();
        //PersistenceManager.loadHighScore(highscore);

        highScoreList = new ListView<Integer>(highscore.getScore());
    }

    public void menu(ActionEvent actionEvent) { Launcher.getViewManager().setView("MenuView"); }
    public void clear(ActionEvent actionEvent) { highscore.resetHighScore(); }
}
