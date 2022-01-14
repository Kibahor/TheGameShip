package model;

import model.entity.IEntity;

public class ColliderInfo {
    private boolean isCollison;
        public boolean IsCollision(){return isCollison;}
    private IEntity e;
        public IEntity getEntity(){return e;}

    public ColliderInfo(boolean isCollison){
        this.isCollison=isCollison;
    }

    public ColliderInfo(IEntity e){
        this(true);
        this.e=e;
    }
}
