package model.entity.Componement;

public class Score extends Componement{

    private int score = 0;

    public int getScore() { return score; }

    public Score() {
        super(EComponementType.Score);
    }
}
