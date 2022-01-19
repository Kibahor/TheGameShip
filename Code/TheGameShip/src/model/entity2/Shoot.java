package model.entity2;

import java.util.UUID;

public class Shoot extends Componement {
    private UUID ownerId;
        public UUID getOwnerId() { return ownerId; }
        public void setOwnerId(UUID ownerId) { this.ownerId = ownerId; }

    public Shoot(){
            super(EType.Shoot);
    }

    public static Shoot cast(IHasComponements e){
            return (Shoot) e.getComponement(EType.Shoot);
    }
    /*
    public void applyToEntity(Entity e, ECommand direction) {
        if (ownerId != null) {
            System.err.println("Le tir appartient déjà a une entité qui a pour id : "+getOwnerId().toString());
            return;
        }
        setOwnerId(e.getId());
        if(e.isTypeOf(EType.Location)){
            //mettre une direction
        }
        if (e.getType() == EType.Player) { setX(((IHasLocation)e).getX() + ((IHasLocation)e).getWidth() + 5); }
        else { setX(((IHasLocation)e).getX() + ((IHasLocation)e).getWidth() - 5); }
        setY(((IHasLocation)e).getY() + (((IHasLocation) e).getHeight() / 2) - 5);
    }*/
}
