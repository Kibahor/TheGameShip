package model.input;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;
import java.util.Map;

public class Keyboard extends Input implements EventHandler<KeyEvent> {
    private Map<KeyCode,ECommand> matchKey = new HashMap<>()
        {
            {
                put(KeyCode.UP, ECommand.UP);
                put(KeyCode.Z, ECommand.UP);
                put(KeyCode.DOWN, ECommand.DOWN);
                put(KeyCode.S, ECommand.DOWN);
                put(KeyCode.RIGHT, ECommand.RIGHT);
                put(KeyCode.D, ECommand.RIGHT);
                put(KeyCode.LEFT, ECommand.LEFT);
                put(KeyCode.Q, ECommand.RIGHT);
                put(KeyCode.SPACE, ECommand.SHOOT);
            }
        };
    public Keyboard(){
        super();
    }

    @Override
    public void handle(KeyEvent event) {
        if (KeyEvent.KEY_PRESSED.equals(event.getEventType())) {
            KeyCode key = event.getCode();
            if(matchKey.containsKey(key)){
                keyPressed.replace(matchKey.get(key),true);
            }
        }else if(KeyEvent.KEY_RELEASED.equals(event.getEventType())){
            KeyCode key = event.getCode();
            if(matchKey.containsKey(key)){
                keyPressed.replace(matchKey.get(key),false);
            }
        }
    }
}
