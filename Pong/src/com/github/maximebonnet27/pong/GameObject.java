package com.github.maximebonnet27.pong;

public abstract class GameObject {

  public static final float MAX_SPEED_X = 8f;
  public static final float MAX_SPEED_Y = 8f;

  
  protected float x, y;
  protected float width, height;

  public abstract void update();

  public void render(){
    Draw.rectangle(x, y, width, height);
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }

  public float getCenterX(){
    return x + width / 2;
  }
  
  public float getCenterY(){
    return y + height / 2;
  }
  
  
}
