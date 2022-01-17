package model.collider;

import java.util.UUID;

public interface ICollider {
    ColliderInfo isCollision(double nextX, double next, double height, double width, UUID id) throws Exception;
}
