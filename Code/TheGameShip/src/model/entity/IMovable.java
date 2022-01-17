package model.entity;

public interface IMovable extends IHasLocation {

    float getSpeedX();
    void setSpeedX(float speedX);

    float getSpeedY();
    void setSpeedY(float speedY);

    static IMovable cast(IEntity e) throws Exception {
        if(!(e instanceof IMovable)){
            throw new Exception("L'Entité \""+e.getName()+"\" n'implémente pas IMovable !");
        }
        return (IMovable) e;
    }
}
