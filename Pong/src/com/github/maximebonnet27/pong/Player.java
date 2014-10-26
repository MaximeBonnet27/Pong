package com.github.maximebonnet27.pong;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Player extends Pad {

  public static final int SIZE_X = 16;
  public static final int SIZE_Y = SIZE_X * 8;


  public Player(float x, float y, Ball ball) {
    super(x, y, ball);

  }

  @Override
  public void update(){
    if (Physics.checkCollisions(this, ball)) {
      ball.bounce(getCenterY());
    }
  }

  public void getInput() {

    if (Keyboard.isKeyDown(Keyboard.KEY_UP)
        || Keyboard.isKeyDown(Keyboard.KEY_Z)) {
      move(UP);
    } else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)
        || Keyboard.isKeyDown(Keyboard.KEY_S)) {
      move(DOWN);
    }

  }
  
  public void move(int dir) {
    if ((dir == UP && (y + height) >= Display.getHeight())
        || (dir == DOWN && y <= 0))
      return;
    y += dir * SPEED;
  }

}
