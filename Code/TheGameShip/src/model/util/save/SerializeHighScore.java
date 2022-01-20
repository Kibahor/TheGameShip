package model.util.save;

import model.util.data.HighScore;
import java.util.ArrayList;

public class SerializeHighScore {

    private ArrayList<String> listHighScore =  new ArrayList<>();

    public ArrayList<String> getListHighScore() { return listHighScore; }
    public SerializeHighScore() {
        listHighScore.add("No Score Yet");
    }
    public SerializeHighScore(HighScore highScore) {
        /*if(highScore.getListScore().isEmpty()){
             listHighScore.add("No Score Yet");
        }*/
        listHighScore.addAll(highScore.getListScore());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
