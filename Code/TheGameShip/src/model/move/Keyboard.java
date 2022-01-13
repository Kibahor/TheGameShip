package model.move;

import javafx.scene.input.KeyEvent;
import launch.Launcher;
import model.GameManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Keyboard extends Input {
    private Map<String, Boolean> isPressed = new HashMap<>();
    private GameManager gameManager;

    public Keyboard(GameManager gameManager, String[] keys) {
        this.gameManager = gameManager;

        for(String key : keys){
            isPressed.put(key,false);
        }

        Launcher.getStage().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            String key = e.getCode().toString();
            if (isPressed.containsKey(key)) {
                isPressed.replace(key,true);
            }
        });
        Launcher.getStage().addEventFilter(KeyEvent.KEY_RELEASED, e -> {
            String key = e.getCode().toString();
            if (isPressed.containsKey(key)) {
                isPressed.replace(key,false);
            }
        });
    }

    @Override
    public void update() {
        for (Map.Entry m: isPressed.entrySet()) {
            if ((Boolean)m.getValue()) {
                gameManager.movePlayer((String)m.getKey());
            }
        }
    }
}
