package model.move;

import javafx.scene.input.KeyEvent;
import launch.Launcher;
import java.util.HashMap;
import java.util.Map;

public class Keyboard extends Input {
    private Map<String, Boolean> isPressed = new HashMap<>();
    private IMove move;

    public Keyboard(IMove move) {
        this.move = move;

        //TODO : Un peu brut, trouver un moyen plus flexible

        //Set1
        isPressed.put("UP",false);
        isPressed.put("LEFT",false);
        isPressed.put("DOWN",false);
        isPressed.put("RIGHT",false);

        //Set2
        isPressed.put("Z",false);
        isPressed.put("Q",false);
        isPressed.put("S",false);
        isPressed.put("D",false);

        isPressed.put("SPACE",false);

        Launcher.viewManager.getActualScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            String key = e.getCode().toString();
            if (isPressed.containsKey(key)) {
                isPressed.replace(key,true);
            }
        });
        Launcher.viewManager.getActualScene().addEventFilter(KeyEvent.KEY_RELEASED, e -> {
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
                String key = (String)m.getKey();
                switch (key) {
                    case "UP", "Z" -> move.up();
                    case "LEFT", "Q" -> move.left();
                    case "DOWN", "S" -> move.down();
                    case "RIGHT", "D" -> move.right();
                    case "SPACE" -> move.shoot(); //TODO: Faire ça ailleur !
                }
            }
        }
    }
}
