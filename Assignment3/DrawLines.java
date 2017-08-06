/* 
* File: DrawLines.java
 * -------------------
 * 
 *Allow the user to draw lines on the canvas.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class DrawLines extends GraphicsProgram{
	public void run(){
		addMouseListeners();
		getMouseMotionListeners();
	}
	private double x1,y1,x2,y2;
	private GLine line = new GLine(x1,y1,x2,y2);
	public void mousePressed(MouseEvent e){
		x1 = e.getX();
		y1 = e.getY();
	}
	public void mouseDragged(MouseEvent e){
		x2 = e.getX();
		y2 = e.getY();
		line.setStartPoint(x1, y1);
		line.setEndPoint(x2, y2);
		add(line);
	}
	}