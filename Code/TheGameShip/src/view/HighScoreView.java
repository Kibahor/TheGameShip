package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import launch.Launcher;
import model.util.data.HighScore;

public class HighScoreView {

    @FXML private ListView<String> highScoreList;

    private HighScore highScore;

    public void initialize() {
        highScore = Launcher.getPersistenceManager().getHighScore();
        highScoreList.setItems(highScore.getListScore());
    }

    public void menu(ActionEvent actionEvent) {
        //Launcher.getPersistenceManager().saveHighScore(highScore);
        Launcher.getViewManager().setView("MenuView");
    }
    public void clear(ActionEvent actionEvent) {
        Launcher.getPersistenceManager().getHighScore().resetHighScore();
    }
}
