package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launch.Launcher;

public class Menu {

    @FXML
    private Button ButtonQuit;

    @FXML
    private Button ButtonSettings;

    @FXML
    private Button ButtonHighScore;

    @FXML
    private Button ButtonPlay;


    public void initialize() {

        ButtonQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: récupérer le primary stage pour le détruire
            }
        });

        ButtonSettings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Launcher.viewManager.setView("Settings");
            }
        });

        ButtonHighScore.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Launcher.viewManager.setView("HighScore");
            }
        });

        ButtonPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Launcher.viewManager.setView("MainWindow");
            }
        });
    }
}
