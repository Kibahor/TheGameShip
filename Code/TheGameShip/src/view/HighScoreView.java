package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import launch.Launcher;
import javafx.scene.control.ListView;

public class HighScoreView {

    @FXML private ListView<String> highScoreList;

    public void initialize() {
        highScoreList.setItems(Launcher.getHighScore().getListScore());
    }

    public void menu(ActionEvent actionEvent) { Launcher.getViewManager().setView("MenuView"); }
    public void clear(ActionEvent actionEvent) { Launcher.getHighScore().resetHighScore(); }
}
