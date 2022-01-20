package model.util.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.util.HashSet;

public class HighScore {

    private final ObservableSet<Integer> highScore;

    public HighScore() { highScore = FXCollections.observableSet(new HashSet<>());}

    public void addScore(int score) { highScore.add(score); }
    public void removeScore(int score) { highScore.remove(score); }

    @Override
    public String toString() {
        String str = "Scores :\n";
        for (Integer e : highScore) {
            str = str + e + "\n";
        }
        return str;
    }
}
