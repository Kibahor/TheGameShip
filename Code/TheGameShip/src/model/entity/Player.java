package model.entity;

import java.net.URISyntaxException;

public class Player extends Entity implements IHasLife,IMovable {
    //LIFE
    int hp;
        @Override
        public int getHp() {
        return hp;
    }
        @Override
        public void setHp(int hp) {
        this.hp = hp;
    }

    boolean isDead=false;
        @Override
        public boolean isDead() {
        return isDead;
    }
        @Override
        public void setDead(boolean dead) {
        isDead = dead;
    }

    //Movable
    private float speedX;
        @Override
        public float getSpeedX() {
            return speedX;
        }
        @Override
        public void setSpeedX(float speedX) {
            this.speedX=speedX;
        }

    private float speedY;
        @Override
        public float getSpeedY() {
            return speedY;
        }
        @Override
        public void setSpeedY(float speedY) {
            this.speedY=speedY;
        }


    public Player(String sprite, String nom, String type, double x, double y, double hitbox_radius) throws URISyntaxException {
        super(sprite, nom, type,x,y,hitbox_radius);
        this.hp=6;
        this.speedX=5;
        this.speedY=10;
    }

    public Player(String sprite, String nom, String type, double x, double y, double hitbox_radius, int hp, boolean isDead, float speedX, float speedY) throws URISyntaxException {
        super(sprite, nom, type, x, y, hitbox_radius);
        this.hp=hp;
        this.isDead=isDead;
        this.speedX=speedX;
        this.speedY=speedY;
    }


}
