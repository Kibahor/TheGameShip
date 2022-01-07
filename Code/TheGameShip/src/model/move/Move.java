package model.move;

import model.entity.Entity;

public class Move {

    public double deplacementX(Entity e, float speedX) throws Exception
    {
        if (!(e instanceof Entity)) {
            throw new Exception("L'entitée n'est pas une SimpleEntity, il ne possède donc pas de x, ni de y");
        }
        double X = e.getX();
        return (X * speedX);
    }

    public double deplacementY(Entity e, float speedY) throws Exception
    {
        if (!(e instanceof Entity)) {
            throw new Exception("L'entitée n'est pas une SimpleEntity, il ne possède donc pas de x, ni de y");
        }
        double Y = e.getY();
        return (Y * speedY);
    }
}
