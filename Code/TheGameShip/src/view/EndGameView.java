package view;

import javafx.event.ActionEvent;
import launch.Launcher;

public class EndGameView {

    public void initialize() {}

    public void GoToMenu(ActionEvent actionEvent) { Launcher.getViewManager().setView("Menu"); }
    public void RageQuit(ActionEvent actionEvent) { Launcher.getStage().close(); }
}