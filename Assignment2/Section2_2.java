/*
 * File: Drawing a face.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This program will draw a robot-looking face.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Section2_2 extends GraphicsProgram {	
	private static final int HEAD_WIDTH = 150;
	private static final int HEAD_HEIGHT = 250;
	private static final int EYE_RADIUS = 15;
	private static final int MOUTH_WIDTH = 60;
	private static final int MOUTH_HEIGHT = 20;
	public void run() {
		double screenHeight = getHeight();
		double screenWidth = getWidth();
		add(drawHead(screenHeight,screenWidth));
		add(drawLeftEye(screenHeight,screenWidth));
		add(drawRightEye(screenHeight,screenWidth));
		add(drawMouth(screenHeight,screenWidth));
	  }
	private GRect drawHead(double screenHeight,double screenWidth){
		double headStartX = screenWidth/2-HEAD_WIDTH/2;
		double headStartY = screenHeight/2 - HEAD_HEIGHT/2;
		GRect head = new GRect(headStartX,headStartY,HEAD_WIDTH,HEAD_HEIGHT);
		head.setFilled(true);
		head.setColor(Color.BLACK);
		head.setFillColor(Color.GRAY);
		return head;
	}
	private GOval drawLeftEye(double screenHeight,double screenWidth){
		double headStartX = screenWidth/2-HEAD_WIDTH/2;
		double headStartY = screenHeight/2 - HEAD_HEIGHT/2;
		double startXL = headStartX+HEAD_WIDTH/4-EYE_RADIUS;
		double startYL = headStartY+HEAD_HEIGHT/4-EYE_RADIUS;
		GOval eyeL = new GOval(startXL,startYL,EYE_RADIUS*2,EYE_RADIUS*2);
		eyeL.setFilled(true);
		eyeL.setColor(Color.yellow);
		eyeL.setFillColor(Color.yellow);
		return eyeL;
	}
	private GOval drawRightEye(double screenHeight,double screenWidth){
		double headStartX = screenWidth/2-HEAD_WIDTH/2;
		double headStartY = screenHeight/2 - HEAD_HEIGHT/2;
		double startXR = headStartX+HEAD_WIDTH/4*3-EYE_RADIUS;
		double startYR = headStartY+HEAD_HEIGHT/4-EYE_RADIUS;
		GOval eyeR = new GOval(startXR,startYR,EYE_RADIUS*2,EYE_RADIUS*2);
		eyeR.setFilled(true);
		eyeR.setColor(Color.yellow);
		eyeR.setFillColor(Color.yellow);
		return eyeR;
	}
	private GRect drawMouth(double screenHeight,double screenWidth){
		double mouthStartX = screenWidth/2-MOUTH_WIDTH/2;
		double mouthStartY = screenHeight/2 + HEAD_HEIGHT/4-MOUTH_HEIGHT/2;
		GRect mouth = new GRect(mouthStartX,mouthStartY,MOUTH_WIDTH,MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.white);
		mouth.setFillColor(Color.white);
		return mouth;
	}
}
