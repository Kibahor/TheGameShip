package model.entity;

public interface IMovable extends IHasLocation {

    float getSpeedX();
    void setSpeedX(float speedX);

    float getSpeedY();
    void setSpeedY(float speedY);

    static IMovable cast(IEntity e) {
        if (!(e instanceof IMovable)){
            System.err.println("L'Entité \""+e.getName()+"\" n'implémente pas IMovable !");
            return null;
        }
        return (IMovable) e;
    }
}
