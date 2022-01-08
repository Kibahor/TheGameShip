package model.move;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import launch.Launcher;

public class Input{
    public Input(String entityName) throws Exception {
        Move move=new Move(entityName);
        EventHandler<KeyEvent> eventHandler= e -> {
            String code = e.getCode().toString();
            switch (code) {
                case "LEFT":
                    move.left();
                    System.out.println("LEFT");
                    break;
                case "RIGHT":
                    move.right();
                    System.out.println("RIGHT");
                    break;
                case "DOWN":
                    move.down();
                    System.out.println("DOWN");
                    break;
                case "UP":
                    move.up();
                    System.out.println("UP");
            }
        };
        Launcher.main.addEventFilter(KeyEvent.KEY_PRESSED, eventHandler);
    }
}
