/*
 * File: RandomCircles.java
 * -------------------
 * 
 *Draw ten circles with different sizes, positions and colors.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class RandomCircles extends GraphicsProgram{
	public void run(){
		for (int i = 0; i<10; i++){
			double diameter = rgen.nextDouble(5, 50);
			double x = rgen.nextDouble(0, getWidth()-diameter);
			double y = rgen.nextDouble(0, getHeight()-diameter);
		Color color = rgen.nextColor();
		GOval circle = new GOval(x,y,diameter,diameter);
		circle.setColor(color);
		circle.setFillColor(color);
		circle.setFilled(true);
		add(circle);
		}
	}
	private RandomGenerator rgen = new RandomGenerator();
}