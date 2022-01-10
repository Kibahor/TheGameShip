package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launch.Launcher;

public class Settings {

    @FXML
    private Button ButtonReset;

    @FXML
    private Button ButtonLeaveAndApply;

    public void initialize() {

        ButtonReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: Peut être plus tard hein ;)
            }
        });

        ButtonLeaveAndApply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: Fixer ça..
            }
        });
    }
}
