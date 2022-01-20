package model.util.data;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

public class HighScore {

    private final ListProperty listeHighScore = new SimpleListProperty();
        public Object getListeHighScore() { return listeHighScore.get(); }
        public void addScore(int score) { listeHighScore.add(score); }
        public ListProperty listeHighScoreProperty() { return listeHighScore; }
}
