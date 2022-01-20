package model.entity.componement;

public class Score extends Componement{

    private int score = 0;

    public int getScore() { return score; }

    public Score() {
        super(EComponementType.Score);
    }
}
