package model.move;

import model.entity.SimpleEntity;

public class Move {

    public double deplacementX(SimpleEntity e, float speedX) throws Exception
    {
        if (!(e instanceof SimpleEntity)) {
            throw new Exception("L'entitée n'est pas une SimpleEntity, il ne possède donc pas de x, ni de y");
        }
        double X = e.getX();
        return (X * speedX);
    }

    public double deplacementY(SimpleEntity e, float speedY) throws Exception
    {
        if (!(e instanceof SimpleEntity)) {
            throw new Exception("L'entitée n'est pas une SimpleEntity, il ne possède donc pas de x, ni de y");
        }
        double Y = e.getY();
        return (Y * speedY);
    }
}
