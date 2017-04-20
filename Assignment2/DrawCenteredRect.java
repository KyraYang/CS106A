/*
 * File: DrawCenteredRect.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the DrawCenteredRect problem.
 * A blue rectangle will be drawn in the center of the screen.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawCenteredRect extends GraphicsProgram {
	
	/** Size of the centered rect */
	private static final int WIDTH = 350;
	private static final int HEIGHT = 270;

	public void run() {
		double screenHeight = getHeight();
		double screenWidth = getWidth();
		GRect blueRect = new GRect((screenWidth-WIDTH)/2,
				(screenHeight-HEIGHT)/2,WIDTH,HEIGHT);
		blueRect.setFilled(true);
		blueRect.setFillColor(Color.blue);
		add(blueRect);
	}
}

