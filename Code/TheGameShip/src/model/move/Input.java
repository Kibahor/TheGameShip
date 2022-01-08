package model.move;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import launch.Launcher;

import java.util.*;

public class Input{
    private Map<String, Boolean> isPressed=new HashMap<>();
    private Move move;

    public Input(String entityName) throws Exception {
        move=new Move(entityName);
        //TODO : Un peu brut, trouver un moyen plus flexible
        isPressed.put("DOWN",false);
        isPressed.put("UP",false);
        isPressed.put("RIGHT",false);
        isPressed.put("LEFT",false);
        Launcher.main.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            String code = e.getCode().toString();
            System.out.println(code);//DEBUG
            if(isPressed.containsKey(code)){
                isPressed.replace(code,true);
            }
        });
    }

    //Quand la boucle la notifie
    public void update(){
        for(Map.Entry m: isPressed.entrySet()){
            if((Boolean)m.getValue()){
                switch ((String)m.getKey()) {
                    case "LEFT":
                        move.left();
                        isPressed.put("LEFT",false);
                        break;
                    case "RIGHT":
                        move.right();
                        isPressed.put("RIGHT",false);
                        break;
                    case "DOWN":
                        move.down();
                        isPressed.put("DOWN",false);
                        break;
                    case "UP":
                        move.up();
                        isPressed.put("UP",false);
                        break;
                }
            }
        }
    }
}
