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
        Launcher.viewManager.getScene().addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            String key = e.getCode().toString();
            if(isPressed.containsKey(key)){
                isPressed.replace(key,true);
            }
        });
        Launcher.viewManager.getScene().addEventFilter(KeyEvent.KEY_RELEASED, e ->{
            String key = e.getCode().toString();
            if(isPressed.containsKey(key)){
                isPressed.replace(key,false);
            }
        });
    }

    //Quand la boucle la notifie
    public void update(){
        for(Map.Entry m: isPressed.entrySet()){
            if((Boolean)m.getValue()){
                String key=(String)m.getKey();
                if(key.contains("LEFT")) {
                    move.left();
                }else if(key.contains("RIGHT")) {
                    move.right();
                }else if(key.contains("UP")) {
                    move.up();
                }else if(key.contains("DOWN")) {
                    move.down();
                }
            }
        }
    }
}
