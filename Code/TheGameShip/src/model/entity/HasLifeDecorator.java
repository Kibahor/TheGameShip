package model.entity;

public class HasLifeDecorator extends EntityDecorator{
    int hp;
    boolean isDead;

    public HasLifeDecorator(Entity entity,int hp) {
        super(entity);
        this.hp=hp;
        this.isDead=false;
    }

    @Override
    public void draw() {
        decoratedEntity.draw();
        System.out.print("HasLife "); //DEBUG
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

