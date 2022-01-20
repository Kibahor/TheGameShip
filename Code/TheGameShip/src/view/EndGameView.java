package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import launch.Launcher;

public class EndGameView {

    @FXML
    Label scoreLabel;

    private int Score;

    public void initialize() {
        Object obj = Launcher.getStage().getUserData();
        if (!(obj instanceof Integer) || obj == null) {
            System.err.println("Il y a une erreur dans la matrice ! (référence très subtile a un film cinématographique très connu de la pop culture)");
            return;
        }
        scoreLabel.setText("Your Score : " + obj);
    }

    public void GoToMenu(ActionEvent actionEvent) {
        Launcher.getViewManager().setView("MenuView");
    }

    public void Retry(ActionEvent actionEvent) {
        Launcher.getViewManager().setView("GameView");
    }
}
