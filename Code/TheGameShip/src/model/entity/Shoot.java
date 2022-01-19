package model.entity;

import java.util.UUID;

public class Shoot extends Entity implements IMovable, IShoot {

    private static int nbShoot = 0;
    private UUID ownerId;
        @Override public UUID getOwnerId() { return ownerId; }
        @Override public void setOwnerId(UUID ownerId) { this.ownerId = ownerId; }

    //IMovable
    private float speedX;
        @Override public float getSpeedX() {
        return speedX;
    }
        @Override public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    private float speedY;
        @Override public float getSpeedY() {
        return speedY;
    }
        @Override public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public Shoot() {
        super("Shoot"+Integer.toString(nbShoot),"null", EType.Shoot,10,30,1);
        setSpeedX(15);
        setSpeedY(0);
        nbShoot++;
    }

    public Shoot(String sprite, double height, double width, double hp, double x, double y, float speedX, float speedY, UUID ownerId) {
        super(Integer.toString(nbShoot), sprite, EType.Shoot, height, width, hp, x, y);
        setOwnerId(ownerId);
        setSpeedX(speedX);
        setSpeedY(speedY);
        nbShoot++;
    }

    @Override
    public void applyToEntity(IEntity e) {
        if (ownerId != null) {
                System.err.println("Le tir appartient déjà a une entité qui a pour id : "+getOwnerId().toString());
        }
        setOwnerId(e.getId());

        if (e.getType() == EType.Player) { setX(((IHasLocation)e).getX() + ((IHasLocation)e).getWidth() + 5); }
        else { setX(((IHasLocation)e).getX() - ((IHasLocation)e).getWidth()); }
        setY(((IHasLocation)e).getY() + (((IHasLocation) e).getHeight() / 2) - 5);      // TODO: rendre ce recalcul automatique     |   5 = la moitié de la hauteur du projectile
    }

    @Override
    public void reset() {
        super.reset();
        setOwnerId(null);
    }
}
