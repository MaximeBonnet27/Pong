package com.github.maximebonnet27.pong;

import static org.lwjgl.opengl.GL11.*;

public class Draw {

  public static void rectangle(float x, float y, float width, float height){
    rectangle(x, y, width, height, 0);
  }

  public static void rectangle(float x, float y, float width, float height,
      float angle) {

    glColor3f(1f, 1f, 1f);
    
    // Add a matrix (to a stack)
    glPushMatrix();
    // Translate the drawing (the matrix !!)
    glTranslatef(x, y, 0);
    glRotatef(angle, 0, 0, 1);
    // Beginning the drawing of a quad
    glBegin(GL_QUADS);
    {
      glVertex2f(0, 0);
      glVertex2f(0, height);
      glVertex2f(width, height);
      glVertex2f(width, 0);
    }
    glEnd();
    // Delete the matrix we created
    glPopMatrix();
  }

  
}
