/*
 * File: Fibonacci sequence.java
 * Name: 
 * Section Leader: 
 * -----------------
 * Display the terms in the Fibonacci sequence, till the terms are more than 10,000.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Section2_1 extends ConsoleProgram {	
	private static final int MAX_TERM_VALUE = 10000;
	public void run() {
		println("This program lists the Fibonacci sequence.");
		println(0);
		println(1);
		int Fibi_2 = 0;
		int Fibi_1 = 1;
		int Fib = Fibi_1+Fibi_2;
		while (Fib < MAX_TERM_VALUE){
			println(Fib);
			Fibi_2 = Fibi_1;
			Fibi_1 = Fib;
			Fib = Fibi_1+Fibi_2;
		}		
	}
}
