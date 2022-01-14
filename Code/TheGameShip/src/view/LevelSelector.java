package view;

import javafx.event.ActionEvent;
import launch.Launcher;

public class LevelSelector {

    public void initialize() {}

    public void BackToMenu(ActionEvent actionEvent) { Launcher.getViewManager().setView("Menu"); }
}
