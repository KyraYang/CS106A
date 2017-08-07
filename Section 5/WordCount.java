/*
 * File: WordcCount.java
 * ---------------------
 * Count lines, words and chars.
 */

import acm.program.*;
import java.io.*;
import java.util.ArrayList;


public class WordCount extends ConsoleProgram {
	
	private ArrayList<String> ImprotFile(String fn){
		ArrayList<String> ls = new ArrayList<String>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(fn));
			while (true){
				String line = br.readLine();
				if (line == null) break;
				ls.add(line);
			}
			br.close();
		} catch (IOException e){
			throw new RuntimeException(e);
		}
		return ls;
	}
	private void CountLines(ArrayList<String> ls){
		println("Lines = "+ ls.size());
	}
	private void CountWords(ArrayList<String> ls, int ws){
		for (int i=0; i< ls.size();i++){
			String line = ls.get(i);
			for (int j = 0; j< line.length();j++){
				if (line.charAt(j)==' ' || line.charAt(j) == '\'' ){
					ws++;
				}
			}
		}
		println("Words = " + (ws+ls.size()));
	}
	private void CountChars(ArrayList<String> ls, int c){
		for (int i=0; i< ls.size();i++){
			String line = ls.get(i);
			c = c+line.length();
				}
		println("Chars = " + c);
	}
	
	public void run() {
		String fileName = readLine("File: ");
		ArrayList<String> lines = ImprotFile(fileName);
		CountLines(lines);
		int whiteSpace = 0;
		CountWords(lines, whiteSpace);
		int chars = 0;
		CountChars(lines, chars);
	}
}

