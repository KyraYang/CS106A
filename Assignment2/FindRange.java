/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	public void run() {
		println("This program finds the largest and smallest numbers.");
		int x = readInt("? ");
		if (x == 0){
			println("No values have been entered.");
		}
		int s = x;
		int l = x;	
		int y = readInt("? ");
		while (y !=0){
				if (l-y<=0){
					l = y;
				} 
				if (s-y>=0) {
					s = y;
				}
				y = readInt("? ");
		}
		if (y ==0){
			println("smallest: "+s);
			println("largest: "+l);
		}	
	}
}

