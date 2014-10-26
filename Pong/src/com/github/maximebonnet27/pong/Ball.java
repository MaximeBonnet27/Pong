package com.github.maximebonnet27.pong;

import org.lwjgl.opengl.Display;

public class Ball extends GameObject {

  public static final int SIZE = 16;
  public float velocityX, velocityY;

  private Game game;
  private float startingX;
  private float startingY;

  public Ball(float x, float y, Game game) {
    this.x = x;
    this.y = y;
    startingX = x;
    startingY = y;
    width = SIZE;
    height = SIZE;

    velocityX = - MAX_SPEED_X;
    velocityY = 0;

    this.game = game;
  }



  @Override
  public void update() {

    // Update position
    x += velocityX;
    y += velocityY;

    wallBounce();

  }

  private void reset() {
    
    x = startingX;
    y = startingY;
    
    velocityY = 0;
  }

  public void bounce(float center) {
    velocityX = - velocityX;
    velocityY += (getCenterY() - center) / (MAX_SPEED_Y * 2);
    if (velocityY > MAX_SPEED_Y) velocityY = MAX_SPEED_Y;
    if (velocityY < - MAX_SPEED_Y) velocityY = - MAX_SPEED_Y;
  }

  public void wallBounce(){
    if(getCenterY() < 0 || getCenterY() > Display.getHeight())
      velocityY = - velocityY;
    if(getCenterX() < 0 || getCenterX() > Display.getWidth()){
      velocityX = - velocityX;
      if(getCenterX() < 0){
        game.opponentScored();
      }else{
        game.playerScored();
      }
      reset();
    }
  }





}
