package model.entity;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Player extends Entity implements IHasLife,IMovable,IShoot {
    //LIFE
    int hp;
        @Override public int getHp() {
        return hp;
    }
        @Override public void setHp(int hp) {
        this.hp = hp;
    }

    boolean isDead=false;
        @Override public boolean isDead() {
        return isDead;
    }
        @Override public void setDead(boolean dead) {
        isDead = dead;
    }

    //Movable
    private float speedX;
        @Override public float getSpeedX() {
            return speedX;
        }
        @Override public void setSpeedX(float speedX) {
            this.speedX=speedX;
        }

    private float speedY;
        @Override public float getSpeedY() {
            return speedY;
        }
        @Override public void setSpeedY(float speedY) {
            this.speedY=speedY;
        }

    //Shoot
    //TODO:Voir si il faut faire autrement pour la gestion des tirs (list obsvervable et quand ajout d'un tir MoveShoot.update() (qui sera abonner a la boucle))
    //TODO: Limite le nombre de tirs créer par seconde (par exemple mettre un timer)
    private ArrayList<Shoot> shoots;
        @Override public ArrayList<Shoot> getShoots(){
            return shoots;
        }
        @Override public void addShoot(String sprite, double radius){
            shoots.add(new Shoot(getId(),sprite, getX(), getY(), radius));
            System.out.println("Shoot Add on player : "+getName());//DEBUG
        }

    public Player(String sprite, String nom, double x, double y, double hitbox_radius){
        super(sprite, nom, "Joueur", x, y, hitbox_radius);
        this.hp=6;
        this.speedX=5;
        this.speedY=10;
        this.shoots = new ArrayList<>();
    }

    public Player(String sprite, String nom, double x, double y, double hitbox_radius, int hp, float speedX, float speedY) throws URISyntaxException {
        this(sprite,nom,x,y,hitbox_radius);
        this.hp=hp;
        this.speedX=speedX;
        this.speedY=speedY;
    }


}
