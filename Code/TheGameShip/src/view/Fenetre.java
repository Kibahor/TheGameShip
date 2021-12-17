package view;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Fenetre {
    ArrayList<String> input;
    @FXML
    private Rectangle joueur;

    public void initialize() {
        input= new ArrayList<String>();
    }
}
