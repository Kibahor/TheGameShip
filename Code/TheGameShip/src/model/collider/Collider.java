package model.collider;

import launch.Launcher;
import model.ILevel;
import model.entity.*;

public class Collider implements ICollider { //http://sdz.tdct.org/sdz/eorie-des-collisions.html
    protected final ILevel level;

    public Collider(ILevel level){
        this.level = level;
    } //TODO: au lieu de passer le level il faudrait donner directement la collection

    @Override
    public ColliderInfo isCollision(IEntity e, String direction) throws Exception {
        if(isCollisionScene(IHasLocation.cast(e), direction)){
            System.out.println("Collision scene");
           return new ColliderInfo(true);
        }
        ColliderInfo entity=isCollisionEntity(e,direction);
        if(entity.IsCollision()){
            System.out.println("Collision entity");
            return entity;
        }
        return new ColliderInfo(false);
    }

    protected boolean isCollisionScene(IHasLocation h, String direction){
        double x1 = h.getX();
        double y1 = h.getY();
        double height1 = h.getHeight();
        double width1 = h.getWidth();
        double height = Launcher.getViewManager().getSceneHeight();
        double width = Launcher.getViewManager().getSceneWidth();

        //Collison scene
        return switch (direction) {
            case "UP" -> (y1 <= 0);
            case "LEFT" -> (x1 <= 0);
            case "DOWN" -> (y1 + height1 >= height);
            case "RIGHT" -> (x1 + width1 >= width);
            default -> false;
        };
    }

    protected ColliderInfo isCollisionEntity(IEntity e1, String direction) throws Exception{
        IHasLocation h1=IHasLocation.cast(e1);
        double x1 = h1.getX();
        double y1 = h1.getY();
        double height1 = h1.getHeight();
        double width1 = h1.getWidth();
        double speedX1= IMovable.cast(e1).getSpeedX();
        double speedY1= IMovable.cast(e1).getSpeedY();

        for(IEntity e2: level.getUsedEntityCollection()){
            //TODO: beaucoup de code se répéte (=source de bug), il faudrait trouver un moyen d'unifier les codes et d'ajouter les particularité de chacun
            //Empêche que le joueur soit bloquer par ces propre tir

            boolean isAtOriginOfShoot=false;/*
            if(e2 instanceof IShoot){
                isAtOriginOfShoot=((IShoot) e2).getOwnerId().equals(e1.getId());
            }*/
            if(!e1.equals(e2) && !isAtOriginOfShoot) {
                IHasLocation h2 =IHasLocation.cast(e2);
                double x2 = h2.getX();
                double y2 = h2.getY();
                double height2 = h2.getHeight();
                double width2 = h2.getWidth();
                 //Général
                    if((x2 >= x1 + width1)      // trop à droite
                            || (x2 + width2 <= x1) // trop à gauche
                            || (y2 >= y1 + height1) // trop en bas
                            || (y2 + height2 <= y1))  // trop en haut
                        return new ColliderInfo(false);
                    else
                        return new ColliderInfo(e2
                        );

                //todo : Collision entre entité un peu foireuse
            }
        }
        return new ColliderInfo(false);
    }
}
