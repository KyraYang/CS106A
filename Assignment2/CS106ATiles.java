/*
 * File: CS106ATiles.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the starter file for the CS106ATiles problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class CS106ATiles extends GraphicsProgram {
	
	/** Amount of space (in pixels) between tiles */
	private static final int TILE_SPACE = 20;
	private static final int TILE_WIDTH = 90;
	private static final int TILE_HEIGHT = 50;

	public void run() {
		double screenHeight = getHeight();
		double screenWidth = getWidth();
		double centerX = screenWidth/2;
		double centerY= screenHeight/2;
		double moveXTop = TILE_SPACE/2+TILE_WIDTH;
		double moveYTop = TILE_SPACE/2+TILE_HEIGHT;
		//
		GRect leftTop = new GRect(centerX-moveXTop,centerY-moveYTop,TILE_WIDTH,TILE_HEIGHT);
		add(leftTop);
		GLabel leftTopText = new GLabel("CS106A");
		double labelWidth = leftTopText.getWidth();
		double labelHeight = leftTopText.getAscent();
		double labelFromTopConerX =  (TILE_WIDTH-labelWidth)/2;
		double labelFromTopConerY = (TILE_HEIGHT+labelHeight)/2;
		leftTopText.setLocation(centerX-moveXTop+labelFromTopConerX,centerY-moveYTop+labelFromTopConerY);
		add(leftTopText);
		//
		GRect rightTop = new GRect(centerX+TILE_SPACE/2,centerY-moveYTop,TILE_WIDTH,TILE_HEIGHT);
		add(rightTop);
		GLabel rightTopText = new GLabel("CS106A");
		rightTopText.setLocation(centerX+TILE_SPACE/2+labelFromTopConerX,centerY-moveYTop+labelFromTopConerY);
		add(rightTopText);
		//
		GRect leftBottom = new GRect(centerX-moveXTop,centerY+TILE_SPACE/2,TILE_WIDTH,TILE_HEIGHT);
		add(leftBottom);
		GLabel leftBottomText = new GLabel("CS106A");
		leftBottomText.setLocation(centerX-moveXTop+labelFromTopConerX,centerY+TILE_SPACE/2+labelFromTopConerY);
		add(leftBottomText);
		//
		GRect rightBottom = new GRect(centerX+TILE_SPACE/2,centerY+TILE_SPACE/2,TILE_WIDTH,TILE_HEIGHT);
		add(rightBottom);
		GLabel rightBottomText = new GLabel("CS106A");
		rightBottomText.setLocation(centerX+TILE_SPACE/2+labelFromTopConerX,centerY+TILE_SPACE/2+labelFromTopConerY);
		add(rightBottomText);
	}
	
}

