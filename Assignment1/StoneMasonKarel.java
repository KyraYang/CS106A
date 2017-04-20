/*
 * File: StoneMasonKarel.java
 * --------------------------
 * Karel will put beepers at where they are missing every four revenue.
 * 
 * Precondition: some beepers are missing
 * Postcondition: 
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void run(){
		while(facingEast()){
		turnLeft();
		int i = 0;
		while (facingNorth() != frontIsBlocked()){
			if (noBeepersPresent()){
				putBeeper();
				move();
			}else{
				move();
				}
			i++;
		}
		if (noBeepersPresent()){
			putBeeper();
			}
		turnAround();
		for (int a=0; a<i;a++){
			move();
			}
		turnLeft();
		for (int b=0;b<4;b++){
		move();
			}
		}	
	}//end of public
}//end of class
