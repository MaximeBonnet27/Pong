package com.github.maximebonnet27.pong;

import org.lwjgl.opengl.Display;

public class Pad extends GameObject {

  public static final int SIZE_X = 16;
  public static final int SIZE_Y = SIZE_X * 8;
  public static final float SPEED = 8f;
  protected static final int UP = 1;
  protected static final int DOWN = -1;

  protected Ball ball;

  public Pad(float x, float y, Ball ball) {
    this.x = x;
    this.y = y;
    width = SIZE_X;
    height = SIZE_Y;

    this.ball = ball;
  }

  @Override
  public void update() {

    if (Physics.checkCollisions(this, ball)) {
      ball.bounce(getCenterY());
    }

    float speed = (ball.getCenterY() - getCenterY()) / SPEED;
    if (speed > MAX_SPEED_Y)
      speed = MAX_SPEED_Y;
    if (speed < -MAX_SPEED_Y)
      speed = -MAX_SPEED_Y;
    if(! ((speed > 0 && (y + height) >= Display.getHeight())
        || (speed < 0 && y <= 0)))
    y += speed;

  }


}
