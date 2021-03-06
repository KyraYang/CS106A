/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	private static final int One_Inch = 72;
	public void run() {
		double screenHeight = getHeight();
		double screenWidth = getWidth();
		double midHeight = screenHeight/2;
		double midWidth = screenWidth/2;
	  GOval outRed = new GOval(midWidth-One_Inch/2,midHeight-One_Inch/2,One_Inch,One_Inch);
	  outRed.setFilled(true);
	  outRed.setColor(Color.red);
	  outRed.setFillColor(Color.red);
	  add(outRed);
	  GOval whiteCircle = new GOval(midWidth-One_Inch/2+One_Inch*0.35/2,midHeight-One_Inch/2+One_Inch*0.35/2,One_Inch*0.65,One_Inch*0.65);
	  whiteCircle.setFilled(true);
	  whiteCircle.setColor(Color.white);
	  whiteCircle.setFillColor(Color.white);
	  add(whiteCircle);
	  GOval innerRed = new GOval(midWidth-One_Inch/2+One_Inch*0.7/2,midHeight-One_Inch/2+One_Inch*0.7/2,One_Inch*0.3,One_Inch*0.3);
	  innerRed.setFilled(true);
	  innerRed.setColor(Color.red);
	  innerRed.setFillColor(Color.red);
	  add(innerRed);
	  }
}
