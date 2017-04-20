/*
 * File: ExtensionKarel.java
 * -------------------------------
 * If you finish your assignment feel free to write any Karel
 * program of your chosing. Writing an extension is not required
 * but encouraged!
 */

import stanford.karel.*;

public class Section1 extends SuperKarel {
	public void run() {
		while (frontIsClear()){
			  reachForBeeper();
			  buildHouse();	
			  moveToTheEdge();
			  if (frontIsBlocked()){
				  moveOneStepBack();
			  }else{
				  move();
			  }
		}	
	}
	private void moveToTheEdge(){
		move();
		move();
	}
	private void moveOutWall(){
		if (beepersPresent()){
			moveOneStepBack();
		}
	}
	private void moveOneStepBack(){
		turnAround();
		move();
		turnAround();
	}
	private void reachForNextDebris(){
		
	}
	private void reachForBeeper(){
		while(noBeepersPresent()){
			move();
		}
	}
	private void buildHouse(){
		cleanDebris();
		putBlocks();
	}
	private void cleanDebris(){
		pickBeeper();
	}
	private void putBlocks(){
		move();
		turnLeft();
		putThreeBlocks();
		turnLeft();
		move();
		turnLeft();
		putThreeBlocks();
		turnRight();
		move();
		turnRight();
		putThreeBlocks();
		turnAround();
		moveThreeSteps();
		turnLeft();
	}
	private void moveThreeSteps(){
		for (int i =0; i<3;i++){
			move();
		}
	}
	private void putThreeBlocks(){
		for (int i =0; i<3; i++){
			putBeeper();
			move();
		}
	}
}
