/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run(){
		while(facingEast()){
		while (facingEast()){
			putOrNot();
		}
		if (beepersPresent()){
			move();
			turnLeft();
			move();
			while(facingWest()){
				putOrNot();			
				}
		}else{
			move();
			turnLeft();
			while(facingWest()){
				putOrNot();			
				}
		}
		turnAround();
		move();
		turnRight();
		}
	}	
	private void putOrNot(){
		if (frontIsClear()){
			putBeeper();
			move();
			if(frontIsClear()){
				move();
			}else{
				turnLeft();
			}
		}else{
			putBeeper();
			turnLeft();
		}
	}
}
