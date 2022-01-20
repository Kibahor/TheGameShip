package model.util.save;

import model.util.data.HighScore;
import java.util.ArrayList;

public class SerializeHighScore {

    private ArrayList<String> listHighScore;

    public SerializeHighScore() {
        listHighScore.add("No Score Yet");
    }

    public SerializeHighScore(HighScore highScore) {
        listHighScore.addAll(highScore.getListScore());
    }

    public ArrayList<String> getListHighScore() { return listHighScore; }
        public void setListHighScore(ArrayList<String> listHighScore) { this.listHighScore = listHighScore; }


    @Override
    public String toString() {
        return super.toString();
    }
}
