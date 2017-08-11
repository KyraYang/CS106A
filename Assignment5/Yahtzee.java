/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import java.util.Arrays;

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		while (true){
			nPlayers = dialog.readInt("Enter number of players (1-4)");
			if (nPlayers>0 && nPlayers<5) break;
		}
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		int[][] Score = new int[nPlayers][N_CATEGORIES]; 
		boolean[][] Recorded = new boolean[nPlayers][N_CATEGORIES];
		for (int i =0; i< N_SCORING_CATEGORIES;i++){
			for (int p = 1; p<=nPlayers; p++){
				int[] Dice = new int[N_DICE];
				display.printMessage(playerNames[p-1]+"'s turn!, Click the \"Roll Dice\" button to roll the dice.");
				display.waitForPlayerToClickRoll(p);
				Dice=RollDice(Dice);
				for (int r=0; r<2;r++){
					display.printMessage("Select the dice you wish to re-roll and click \"Roll Again\",");
					display.waitForPlayerToSelectDice();
					Dice = RollAgain(Dice);
					}
				while(true){
					display.printMessage("Select a category for this roll");
					int category = display.waitForPlayerToSelectCategory();
						if (!Recorded[p-1][category-1]){
							Score = Update(p,category,Score,Dice);
							Recorded[p-1][category-1]=true;
							break;
							}
						}
				}
			}
		FinalScore(Score);
		}
		
	
	
/* Method */
	private int[] RollDice(int[] d){
		for (int i = 0; i<N_DICE;i++){
			d[i]=rgen.nextInt(1, 6);
		}
		display.displayDice(d);
		return d;
	}
	private int[] RollAgain(int[] d){
		for (int i = 0; i<N_DICE;i++){
			if (display.isDieSelected(i)){
			d[i]=rgen.nextInt(1, 6);
			}
		}
		display.displayDice(d);
		return d;
	}
	private int OfAKind(int[] d,int n){
		int s =0;
		for (int i=0;i<=N_DICE-n;i++){
			int same=0;
			for (int j=0;j<N_DICE;j++) {
				if (d[i]==d[j]) same++;
			}
			if (same>=n) s = d[i]*same;
		}
		return s;
	}
	private int FullHouse(int[] d){
		int s = 0;
		for (int i=0;i<=N_DICE-3;i++){
			int[] arranged= new int[N_DICE];
			int p = 0;
			int n = 0;
			for (int j=0;j<N_DICE;j++) {
				if (d[i]==d[j]) {
					arranged[p]=d[j];
					p++;
				}
				if(d[i]!=d[j]) {
					arranged[N_DICE-1-n]=d[j];
					n++;
				}
			}
			if (arranged[0]==arranged[1]&&arranged[0]==arranged[2]&&arranged[0]!=arranged[3]&&arranged[3]==arranged[4]) {
				s = 25;
				break;
			}
		}
		return s;
	}
	private int Straight(int[]d,int n){
		int s = 0;
		Arrays.sort(d);
		for (int j = 0; j<N_DICE-1;j++) {
			if(d[j]==d[j+1]) {
				d[j]=0;
			}
		}
		Arrays.sort(d);
		int[] arrDice = {1,2,3,4,5,6};
		for (int i=0; i<=N_DICE-n;i++) {
			for(int j=0; j<=6-n;j++) {
				int[] c1 = Arrays.copyOfRange(d, i, i+n);
				int[] c2 = Arrays.copyOfRange(arrDice, j, j+n);
				if (Arrays.equals(c1, c2)) {
					s=(n-1)*10;
					break;
				}else {
					continue;
				}
					}
				}
		return s;
		}
	private int[][] Update(int p,int c, int[][] s,int[] d){
		int score = 0;
		if (c<7){
			for (int i = 0; i<N_DICE; i++){
				if (d[i]==c){
					score = score+d[i];
				}
			}
		}else{
			switch (c){
			case 9:
				score = OfAKind(d,3);
				break;
			case 10:
				score = OfAKind(d,4);
				break;
			case 11:
				score = FullHouse(d);
				break;
			case 12:
				score = Straight(d,4);
				break;
			case 13:
				score = Straight(d,5);
				break;
			case 14:
				if(d[0]==d[1]&&d[0]==d[2]&&d[0]==d[3]&&d[0]==d[4]){
					score = 50;}
					break;
			case 15:
				score = d[0]+d[1]+d[2]+d[3]+d[4];
				break;
		}
			}
		s[p-1][c-1]=score;
		display.updateScorecard(c, p, score);
		display.updateScorecard(17, p, Total(s,p-1,N_CATEGORIES));
		return s;			
	}
	private void FinalScore(int[][] s){
		for (int i=0;i<nPlayers;i++) {
			s[i][16]=Total(s,i,N_CATEGORIES);
			s[i][6] = Total(s,i,6);
			if (s[i][6]>=63) s[i][7]=35;
			s[i][15] =s[i][16]-s[i][6];
			s[i][16]=s[i][16]+s[i][7];
			display.updateScorecard(7,i+1, s[i][6]);
			display.updateScorecard(8,i+1, s[i][7]);
			display.updateScorecard(16,i+1, s[i][15]);
			display.updateScorecard(17,i+1, s[i][16]);
			}
		int LI = 0;
		for (int j=0; j<nPlayers;j++) {
			if(s[LI][16]<s[j][16]) LI=j;
		}
		display.printMessage("Congratulation, "+ playerNames[LI]+", you're the winner with a total score of "+s[LI][16]+"!");
	}
		
	private int Total(int[][] s,int p,int l){
		int total = 0;
		for (int j=0; j<l;j++){
			total = total+s[p][j];
			}
			return total;
		}
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
