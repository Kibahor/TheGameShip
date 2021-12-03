package entity;

//import java.awt.font.ImageGraphicAttribute;

public class Entity {

    //private ImageGraphicAttribute sprite;
    private int X;
    private int Y;
    private float speed;
    private int life;
    private boolean isDead;


    private void lifeDown(int lifeDamage) {
        life = life - lifeDamage;
    }

    private void lifeUp(int lifeBonus) {
        life = life + lifeBonus;
    }

    private boolean isDead() {
        return isDead;
    }

    private void applyPower(PowerUp power) {

    }
}
