package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import launch.Launcher;
import javafx.scene.control.ListView;
import model.util.data.HighScore;
import model.util.save.PersistenceManager;

public class HighScoreView {

    @FXML private ListView<String> highScoreList;

    private HighScore highScore;

    public void initialize() {
        highScore = new HighScore();
        PersistenceManager.loadHighScore(highScore);
        highScoreList.setItems(Launcher.getHighScore().getListScore());
    }

    public void menu(ActionEvent actionEvent) {
        PersistenceManager.saveHighScore(highScore);
        Launcher.getViewManager().setView("MenuView");
    }
    public void clear(ActionEvent actionEvent) {
        Launcher.getHighScore().resetHighScore();
    }
}
