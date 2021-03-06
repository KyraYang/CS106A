/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hangman extends ConsoleProgram {

	/***********************************************************
	 *              CONSTANTS                                  *
	 ***********************************************************/
	
	/* The number of guesses in one game of Hangman */
	private static int N_GUESSES = 7;
	/* The width and the height to make the karel image */
	private static final int KAREL_SIZE = 150;
	/* The y-location to display karel */
	private static final int KAREL_Y = 230;
	/* The width and the height to make the parachute image */
	private static final int PARACHUTE_WIDTH = 300;
	private static final int PARACHUTE_HEIGHT = 130;
	/* The y-location to display the parachute */
	private static final int PARACHUTE_Y = 50;
	/* The y-location to display the partially guessed string */
	private static final int PARTIALLY_GUESSED_Y = 430;
	/* The y-location to display the incorrectly guessed letters */
	private static final int INCORRECT_GUESSES_Y = 460;
	/* The fonts of both labels */
	private static final String PARTIALLY_GUESSED_FONT = "Courier-36";
	private static final String INCORRECT_GUESSES_FONT = "Courier-26";
	
	/***********************************************************
	 *              Instance Variables                         *
	 ***********************************************************/
	
	/* An object that can produce pseudo random numbers */
	private RandomGenerator rg = new RandomGenerator();
	
	private GCanvas canvas = new GCanvas();
	
	private boolean rightGuess = false;
	
	private String Guessed;
	private int cutLines = 0;
	/***********************************************************
	 *                    Methods                              *
	 ***********************************************************/
	public void init(){
		add(canvas);
		drawBackground();
	}
	
	public void run() {
		GObject karel = drawKarel("karel.png");
		println("Welcome to Hangman");
		String guessWord = getRandomWord();
		String toGuess = new String(new char[guessWord.length()]).replaceAll("\0", "-");
		Guessed = toGuess;
		String wrong = new String("");
		println("Your word now looks like this: "+Guessed);
		GLabel lGuessed = initLabel(PARTIALLY_GUESSED_Y,PARTIALLY_GUESSED_FONT,Guessed);
		GLabel lWrong = initLabel(INCORRECT_GUESSES_Y,INCORRECT_GUESSES_FONT,wrong);
		for (int i = N_GUESSES;i > 0;i--){
		println("You have "+ i +" guesses left.");
		String guess = askForGuess();
		 if (checkGuess(guessWord,guess)){
			 lGuessed.setLabel(Guessed);
			 i++;
			 rightGuess=false;
		 }else{
			 wrong = wrong+guess;
			 lWrong.setLabel(wrong);
			 lWrong.setLocation((canvas.getWidth()-lWrong.getWidth())/2, lWrong.getY());
		 }
		if (Guessed.equals(guessWord)){
			println("You win.");
			println("The word was: "+ guessWord);
			break;
		}
		if (i ==1){
			println("You're completely hung.");
			println("The word was: "+ guessWord);
			karel.setVisible(false);
			drawKarel("karelFlipped.png");
			break;
		}
		}
		String restart = readLine("Do you want to play again? Y/N").toUpperCase();
		if (restart.charAt(0)=='N' ){
			System.exit(0);
		}else {
			canvas.removeAll();
			cutLines = 0;
			init();
			run();
		}
	}
	
	private void drawBackground(){
		GImage bg = new GImage("background.jpg");
		bg.setSize(canvas.getWidth(), canvas.getHeight());
		canvas.add(bg,0,0);
		GImage pc = new GImage("parachute.png");
		pc.setSize(PARACHUTE_WIDTH, PARACHUTE_HEIGHT);
		canvas.add(pc, (canvas.getWidth()-PARACHUTE_WIDTH)/2, PARACHUTE_Y);
		for (int i = 0; i<N_GUESSES; i++){
				GLine l = new  GLine(canvas.getWidth()/2,KAREL_Y,(canvas.getWidth()-PARACHUTE_WIDTH)/2+PARACHUTE_WIDTH/6*i,PARACHUTE_Y+PARACHUTE_HEIGHT);
			canvas.add(l);
		}
	}
 	private GObject drawKarel(String fileName){
 		GImage karel = new GImage(fileName);
		karel.setSize(KAREL_SIZE, KAREL_SIZE);
		canvas.add(karel, (canvas.getWidth()-KAREL_SIZE)/2, KAREL_Y);
		return karel;
 	}
	private GLabel initLabel(int y, String f,String toL){
		GLabel l = new GLabel(toL);
		l.setLocation(canvas.getWidth()/2-1.5*l.getWidth(), y);
		l.setFont(f);
		canvas.add(l);
		return l;
	}
	private String askForGuess(){
		String str = readLine("Your guess: ");
		while (str.length()!= 1 || str.charAt(0)<'A' || str.charAt(0)>'z'){
			println("Please one A-Z letter");
			str = readLine("Your guess: ");}
		return str.toUpperCase();
		}
	private boolean checkGuess(String gw, String g){
		for (int i = 0; i< gw.length(); i++){
			if (gw.charAt(i)==g.charAt(0)){
				if (i ==0){
					Guessed = g+Guessed.substring(1);
				}else{
				Guessed = Guessed.substring(0, i)+g+Guessed.substring(i+1);
				}
				rightGuess = true;
			}
		}
		if (rightGuess){
			println("That guess is correct.");
			println("Your word now looks lie this: "+ Guessed);
		}else {
			println("There are no " + g +"'s in the word.");
			println("Your word now looks like this: "+ Guessed);
			GObject line = canvas.getElementAt((canvas.getWidth()-PARACHUTE_WIDTH)/2+PARACHUTE_WIDTH/6*cutLines,PARACHUTE_Y+PARACHUTE_HEIGHT);
			cutLines++;
			line.setVisible(false);
		}
		return rightGuess;
	}
	
	
	
	/**
	 * Method: Get Random Word
	 * -------------------------
	 * This method returns a word to use in the hangman game. It randomly 
	 * selects from among 10 choices.
	 */
	private String getRandomWord() {
		ArrayList<String> list = new ArrayList<String>();
		try{
			BufferedReader br = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while(true){
				String line = br.readLine();
				if (line == null) break;
				list.add(line);
			}
			br.close();
		} catch (IOException e){
			throw new RuntimeException(e);
		}
		int index = rg.nextInt(list.size());
		return list.get(index);
	}

}
