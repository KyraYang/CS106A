/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels.  IMPORTANT NOTE:
  * ON SOME PLATFORMS THESE CONSTANTS MAY **NOT** ACTUALLY BE THE DIMENSIONS
  * OF THE GRAPHICS CANVAS.  Use getWidth() and getHeight() to get the 
  * dimensions of the graphics canvas. */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board.  IMPORTANT NOTE: ON SOME PLATFORMS THESE 
  * CONSTANTS MAY **NOT** ACTUALLY BE THE DIMENSIONS OF THE GRAPHICS
  * CANVAS.  Use getWidth() and getHeight() to get the dimensions of
  * the graphics canvas. */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		/**set up the playground*/
    	double Window_Width = getWidth();
    	double Window_Height = getHeight();
		String[] StartPoint = WhereToPutTheFirstBrick(Window_Width, Window_Height);
		double StarX = Double.parseDouble(StartPoint[0]);
		double StarY = Double.parseDouble(StartPoint[1]);
		DrawBricks(StarX,StarY,Color.red);
		StarY=StarY+16+BRICK_SEP*2;
		DrawBricks(StarX,StarY,Color.orange);
		StarY=StarY+16+BRICK_SEP*2;
		DrawBricks(StarX,StarY,Color.yellow);
		StarY=StarY+16+BRICK_SEP*2;
		DrawBricks(StarX,StarY,Color.green);
		StarY=StarY+16+BRICK_SEP*2;
		DrawBricks(StarX,StarY,Color.cyan);
		/**set paddle to position*/
		Paddle = DrawPaddle(Window_Width);
		/**set ball to position*/
		addMouseListeners();
		/** Ask for a start*/
		GLabel Start = Banner("Click To Start!");
		for (int i=0; i<NTURNS;i++){
			GOval Ball = DrawBall(Window_Width,Window_Height);
			waitForClick();
			remove(Start);
		/**Ball moves*/
			vx = rgen.nextDouble(2.0, 5.0);
			vy = 5;
			if(rgen.nextBoolean(0.5)) vx = -vx;
			while (BallInThePlayGround(Ball)){
				if(BallHitLeftOrRightWall(Ball)){
					vx = -vx;
			}
			if (BallHitPaddleUpper(Ball)){
				vy = -vy;
			}
			/*if (BallHitPaddleTwoSides(Ball)){
				vx = -vx;
			}*/
			if (BallHitBrick(Ball)){
				HittedBrickDisappear(Ball);
				vy = -vy;
				TotalBricks+=1;
				while (TotalBricks == NBRICKS_PER_ROW*NBRICK_ROWS ){
					Banner("You Win!");
					System.exit(0);	
				}
			}
			if (BallHitTopWall(Ball)){
				vy = -vy;
			}
			Ball.move(vx, vy);
			pause(30);
			}
		}
		/**Game over*/
		Banner("Game Over!");
		}
	/**paddle tracks mouse*/		
	public void mouseMoved(MouseEvent e){
		if (e.getX()>PADDLE_WIDTH/2&&e.getX()<getWidth()-PADDLE_WIDTH/2){
		Paddle.setLocation(e.getX()-PADDLE_WIDTH/2, HEIGHT-PADDLE_Y_OFFSET);
		}
		}
	
	
	
	
private GObject Paddle;		
private RandomGenerator rgen = RandomGenerator.getInstance(); 		
private double vx, vy;
private int TotalBricks = 0;

 

	private boolean BallInThePlayGround(GObject Ball){
		boolean passed =true;
		if (Ball.getY()>HEIGHT){
			passed = false;
			Ball.setVisible(false);	
		}
		return passed;
	}
	

	private boolean BallHitLeftOrRightWall(GObject Ball){
		boolean hit = false;
		if(Ball.getX()<=0 || Ball.getX()+2*BALL_RADIUS>=WIDTH){
			hit = true;
		}
		return hit;
	}
	

	private boolean BallHitPaddleUpper(GObject Ball){
		boolean hit = false;
		if (Ball.getY()+2*BALL_RADIUS>=HEIGHT-PADDLE_Y_OFFSET &&Ball.getY()+2*BALL_RADIUS <= HEIGHT-PADDLE_Y_OFFSET+PADDLE_HEIGHT && Ball.getX()>=Paddle.getX()&&Ball.getX()<=Paddle.getX()+PADDLE_WIDTH){
			hit = true;
		}
		return hit;
	}
	

	private boolean BallHitBrick(GObject Ball){
		boolean hit = false;
		if ((getElementAt(Ball.getX(),Ball.getY())!= null
				|| getElementAt(Ball.getX()+2*BALL_RADIUS, Ball.getY())!=null
				|| getElementAt(Ball.getX(),Ball.getY()+2*BALL_RADIUS)!=null
				|| getElementAt(Ball.getX()+2*BALL_RADIUS,Ball.getY()+2*BALL_RADIUS)!=null)
				&& Ball.getY()+2*BALL_RADIUS< HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT){
			hit = true;
		}
		return hit;	
	}
	
	private void HittedBrickDisappear(GObject Ball){
		if ((getElementAt(Ball.getX(),Ball.getY()))!= null && Ball.getY()+2*BALL_RADIUS< HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT){
			remove(getElementAt(Ball.getX(),Ball.getY()));
		}
		if (getElementAt(Ball.getX()+2*BALL_RADIUS, Ball.getY())!=null&& Ball.getY()+2*BALL_RADIUS< HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT){
			remove(getElementAt(Ball.getX()+2*BALL_RADIUS, Ball.getY()));
		}
		if (getElementAt(Ball.getX(),Ball.getY()+2*BALL_RADIUS)!=null && Ball.getY()+2*BALL_RADIUS< HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT){
			remove(getElementAt(Ball.getX(), Ball.getY()+2*BALL_RADIUS));
		}
		if (getElementAt(Ball.getX()+2*BALL_RADIUS,Ball.getY()+2*BALL_RADIUS)!=null
			&& Ball.getY()+2*BALL_RADIUS< HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT){
				remove(getElementAt(Ball.getX()+2*BALL_RADIUS,Ball.getY()+2*BALL_RADIUS));
			}
	}
	
	private boolean BallHitTopWall(GObject Ball){
		boolean hit = false;
		if (Ball.getY()<= 0){
			hit = true;
			}
		return hit;
	}
	
private boolean BallHitPaddleTwoSides(GObject Ball){
		boolean hit = false;
		if (Ball.getY()+BALL_RADIUS>=HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT
				&& Ball.getY()+BALL_RADIUS<= HEIGHT-PADDLE_Y_OFFSET
				&& Ball.getX()+2*BALL_RADIUS==Paddle.getX()){
			hit = true;
		}
		return hit;
	}
	
	private GLabel Banner(String str){
	GLabel Start = new GLabel(str);
	Start.setFont("Courier-bold-30");
	double w = Start.getWidth();
	double h = Start.getAscent();
	Start.setLocation((WIDTH-w)/2, (HEIGHT-h)/2);
	add(Start);
	return Start;
}
	private GOval DrawBall(double w, double h){
		double X = w/2-BALL_RADIUS;
		double Y = h/2-BALL_RADIUS;
		GOval Ball = new GOval(X,Y,BALL_RADIUS*2,BALL_RADIUS*2);
		Ball.setFilled(true);
		Ball.setFillColor(Color.BLACK);
		Ball.setColor(Color.BLACK);
		add(Ball);
		return Ball;
	}
	private GRect DrawPaddle(double w){
	double X = w/2-PADDLE_WIDTH/2;
	double Y = HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT;
	GRect Paddle = new GRect(X,Y,PADDLE_WIDTH,PADDLE_HEIGHT);
	Paddle.setFilled(true);
	Paddle.setFillColor(Color.BLACK);
	Paddle.setColor(Color.BLACK);
	add(Paddle);
	return Paddle;
}
	private String[] WhereToPutTheFirstBrick(double x, double y){
	String StartPoint[] = new String[2];
	StartPoint[0]=Double.toString(x/2-WIDTH/2);
	StartPoint[1]=Double.toString(y-HEIGHT+BRICK_Y_OFFSET);
	return StartPoint;
	}
	private void DrawBricks(double x, double y, Color color){
	double sp = x;
	for (int n =0; n < 2; n++){
		for (int i=0; i<NBRICKS_PER_ROW; i++){
		DrawOneBricks(x,y,color);
		x=x+BRICK_WIDTH+BRICK_SEP;
		}
		y=y+8+BRICK_SEP;
		x = sp;
		}
	}
	private void DrawOneBricks(double x, double y, Color color){
	GRect Brick = new GRect(x,y,BRICK_WIDTH,BRICK_HEIGHT);
	Brick.setFilled(true);
	Brick.setColor(color);
	Brick.setFillColor(color);
	add(Brick);
	}

}
