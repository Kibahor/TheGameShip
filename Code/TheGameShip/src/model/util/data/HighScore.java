package model.util.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class HighScore {

    private final ObservableList<Integer> highScore;

    public HighScore() { highScore = FXCollections.observableArrayList(); }

    public void addHighScore(int score) { highScore.add(score); }
    public void removeHighScore(int score) { highScore.remove(score); }
    public ObservableList<Integer> getScore() { return highScore; }
    public void resetHighScore() {
        if (!highScore.isEmpty()) {
            for (Integer s : highScore) {
                removeHighScore(s);
            }
        }
    }

    @Override
    public String toString() {
        String str = "Scores :\n";
        for (Integer e : highScore) {
            str = str + e + "\n";
        }
        return str;
    }
}
