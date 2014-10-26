package com.github.maximebonnet27.pong;

public class Physics {

  public static boolean checkCollisions(GameObject object1, GameObject object2) {

    // AABB collision

    // Get the distance between the centers
    float centerDistance_x = Math.abs(object1.getCenterX()
        - object2.getCenterX());
    float centerDistance_y = Math.abs(object1.getCenterY()
        - object2.getCenterY());


    // Check if the distance between the centers is more than
    // the sum of the half widths / heights
    boolean collisionX = (centerDistance_x <= (object1.width / 2 + object2.width / 2));
    boolean collisionY = (centerDistance_y <= (object1.height / 2 + object2.height / 2));

    // There's a collision only if both of the coordinates
    // are colliding
    return collisionX && collisionY;
  }
}
