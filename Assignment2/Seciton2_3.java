/*
 * File: CS106A rocks my socks.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * Drawing this text in center.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Seciton2_3 extends GraphicsProgram {

	public void run() {
		double cX = getWidth()/2;
		double cY= getHeight()/2;
		GLabel label = new GLabel("CS106A rocks my socks!");
		double lW=label.getWidth();
		double lH=label.getAscent();
		label.setLocation(cX-lW/2, cY+lH/2);
		label.setFont("SansSerif-28");
		add(label);
	}
	
}

