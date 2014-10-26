package com.github.maximebonnet27.pong;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;

public class Game {

  private Player player;
  private ArrayList<GameObject> gameObjects;

  private int playerScore;
  private int opponentScore;
  
  public Game() {
    
    playerScore = 0;
    opponentScore = 0;
    
    gameObjects = new ArrayList<GameObject>();
    // Creates a ball and put it at the center of the screen
    Ball ball = new Ball(Display.getWidth() / 2 - Ball.SIZE / 2, Display.getHeight()
        / 2 - Ball.SIZE / 2, this);

    // Creates a player pad and put it a the left of the screen
    player = new Player(0, Display.getHeight() / 2 - Player.SIZE_Y / 2, ball);
    Pad opponent = new Pad(Display.getWidth() - Pad.SIZE_X, Display.getHeight() / 2 - Pad.SIZE_Y / 2, ball);
    gameObjects.add(ball);
    gameObjects.add(player);
    gameObjects.add(opponent);
  }

  public void getInput() {
    player.getInput();
  }

  public void update() {
    for (GameObject object : gameObjects)
      object.update();
  }

  public void render() {
    for (GameObject object : gameObjects)
      object.render();

    Display.setTitle("SCORE : Player " + playerScore + " || " + opponentScore +" CPU");
    
  }
  public void opponentScored() {
    opponentScore++;
  }

  public void playerScored() {
    playerScore++;
  }


}
