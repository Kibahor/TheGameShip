package model.collider;

import model.entity.IEntity;

public class ColliderInfo {
    private boolean isCollison;
        public boolean IsCollision(){return isCollison;}
    private IEntity e;
        public IEntity getEntity(){return e;}

    public ColliderInfo(boolean isCollison, IEntity e){
        this.e=e;
        this.isCollison= e!=null || isCollison; //Si e est attribué alors c'est en collision
    }

    @Override
    public String toString() {
        String entityname="null";
        if(e != null){
            entityname=e.getName();
        }
        return "isCollison : "+isCollison+"\nAvec l'entité : "+entityname+"\n";
    }
}
