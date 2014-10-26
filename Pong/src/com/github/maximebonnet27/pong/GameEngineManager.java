package com.github.maximebonnet27.pong;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class GameEngineManager {

  // Game managed by this class
  private static Game game;
  private static int FPS = 60;

  public static void main(String[] args) {
    initProgram();
    initGame();
    gameLoop();
    cleanUp();
  }

  private static void initProgram() {
    initDisplay();
    initGL();

  }

  public static void initDisplay() {
    try {
      Display.setDisplayMode(new DisplayMode(800, 600));
      Display.create();
      // Try to set the refresh rate to the monitor's
      Display.setVSyncEnabled(true);

      Keyboard.create();
    } catch (LWJGLException e) {
      e.printStackTrace();
    }
  }
  
  public static void initGL() {
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
    glMatrixMode(GL_MODELVIEW);
    glClearColor(0, 0, 0, 1);
    glDisable(GL_DEPTH_TEST);
  }

  private static void initGame() {
    game = new Game();
  }

  private static void gameLoop() {
    while (!Display.isCloseRequested()) {
      getInput();
      render();
      update();
    }
  }

  private static void getInput() {
    game.getInput();
  }

  private static void update() {
    game.update();

  }

  private static void render() {
    glClear(GL_COLOR_BUFFER_BIT);
    glLoadIdentity();
    
    game.render();
    
    Display.update();
    Display.sync(FPS);

  }

  private static void cleanUp() {
    Display.destroy();
    Keyboard.destroy();
      
  }

}
