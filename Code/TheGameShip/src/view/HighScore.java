package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launch.Launcher;

public class HighScore {

    @FXML
    private Button ButtonLeave;

    @FXML
    private Button ButtonClear;

    public void initialize() {

        ButtonLeave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Launcher.viewManager.setView("Menu");
            }
        });

        ButtonClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: Si on a le temps..
                System.out.println("Un jour peut être ^^");
            }
        });
    }
}
