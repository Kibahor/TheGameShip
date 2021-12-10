package model.entity;

public class hasLifeDecorator extends EntityDecorator{
    int hp;
    boolean isDead;

    public hasLifeDecorator(Entity entity,int hp) {
        super(entity);
        this.hp=hp;
        this.isDead=false;
    }

    @Override
    public void draw() {
        decoratedEntity.draw();
        //ajouter autre chose ...
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
