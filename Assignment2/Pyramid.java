/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		double screenWidth = getWidth();
		double screenHeight = getHeight();
		double midpoint = screenWidth/2;
		double baseLength = BRICK_WIDTH*BRICKS_IN_BASE;
		double startX=midpoint-baseLength/2;
		double startY= screenHeight-BRICK_HEIGHT;
		for (int i=0;i<BRICKS_IN_BASE;i++){
			startX = startX+(BRICK_WIDTH/2);
			int BaseBricks = BRICKS_IN_BASE-i;
			for (int j=0;j<BaseBricks;j++){
				GRect brick = new GRect(startX+BRICK_WIDTH*(BaseBricks-j),startY-BRICK_HEIGHT*i,BRICK_WIDTH,BRICK_HEIGHT);
				add(brick);	
			}
		}
	}
}

