package model.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Input {
    protected Map<ECommand, Boolean> keyPressed = new HashMap<>();

    //TODO : La map est surement superflu, autant faire une ArrayList qui ne contient que les touches pressées
    protected Input () //Initialise le tableau
    {
        for(ECommand e : ECommand.values()){
            keyPressed.put(e,false);
        }
    }

    public ArrayList<ECommand> getKeyPressed() {
        ArrayList<ECommand> list = new ArrayList<>();
        for (Map.Entry m: keyPressed.entrySet()) {
            if ((Boolean)m.getValue()) {
                list.add((ECommand) m.getKey());
            }
        }
        return list;
    }
}
