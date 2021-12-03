package view;

import javafx.scene.paint.Color;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class Fenetre {

    @FXML
    private Button bouton1;

    @FXML
    private Rectangle rectangle1;

    public void initialize() {}

    @FXML
    private void Clicked(Event e) {
        bouton1.setText("Coucou");
    }

    @FXML
    private void rec_scroll(Event e){
        rectangle1.setX(rectangle1.getX()+100);
        rectangle1.setFill(Color.BEIGE);
    }
}
