/*
 * File: Histogram.java
 * ---------------------
 * Shows a histogram of a list of scores.
 */

import java.io.*;
import java.util.ArrayList;
import acm.program.*;

public class Histogram extends ConsoleProgram {
	
	private ArrayList<Integer> ImportFile(){
		ArrayList<Integer> s = new ArrayList<Integer>();
		try{
			BufferedReader rb = new BufferedReader(new FileReader("Scores.txt"));
			while(true){
				String i = rb.readLine();
				if (i == null) break;
				s.add(Integer.parseInt(i));
			}
			rb.close();
		} catch (IOException e){
			throw new RuntimeException(e);
		}
		return s;
	}
	private int[] RangedScores(ArrayList<Integer> s){
		int[] rs = new int[11];
		for (int i = 0; i<s.size();i++){
			for (int j = 0; j<11; j++){
				if (s.get(i)>=10*j && s.get(i)<=(10*j+9)){
					rs[j]+=1;
					}
				}
			}
		return rs;
		}
	
	public void run() {
		ArrayList<Integer> scores = ImportFile();
		int[] RangedScores = RangedScores(scores);
		println("00-09: "+ new String(new char[RangedScores[0]]).replaceAll("\0", "*"));
		for (int j = 1; j<11; j++){
			println(j*10 + "-" + (j*10+9) +": "+ new String(new char[RangedScores[j]]).replaceAll("\0", "*"));
			}
	}
}

