/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println("Enter values to compute the Pythogorean theorem.");
		double a = readDouble("a: ");
		double b = readDouble("b: ");
		double c = Math.sqrt(a*a+b*b);
		println("c = "+c);
	}
}
