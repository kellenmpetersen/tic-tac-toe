/* 

   name: TicTacToe
   author: Pseupier Coders
   date: 11/22/16
   description: a simple game of tic-tac-toe

*/

import java.util.Scanner;

public class Main{
	
	final static int WIDTH = 3;
	final static int HEIGHT = 3;
	
	static char[][]board = new char[WIDTH][HEIGHT];
	
	// the main method is the entry point for a program
    // inside methods the statements get executed in the order they appear in the code
	public static void main(String[] args){
		//while (booleanexpression) {
			gameRules();
			userInput();
			gameLogic();
			checkWin();
			gameAI();
			checkWin();
			clearBoard();
			displayBoard();
		//}
    }
	
	private static void gameRules(){
		System.out.println("------------------------------");
		System.out.println("Tic Tac Toe Game Rules:");
		System.out.println("In order to win, you must connect 3");
		System.out.println("of x's or o's vertically, ");
		System.out.println("horizontally, or diagonally. You, the user,");
		System.out.println("are given the choice of 'X' ");
		System.out.println("or 'O' for your your symbol. ");
		System.out.println("If you pick an invalid column,");
		System.out.println("(one that is full or non-existent),");
		System.out.println("your will be asked to pick a new column.");
		System.out.println("Lastly, the program will clear itself");
		System.out.println("as you continue throughout the game");
		System.out.println("so that your game space does not");
		System.out.println("become over crowded.");
		System.out.println("That's all, enjoy the game!");
		System.out.println("------------------------------");
	}
	
	public static void userInput(){
		String a;
		int b;
		int c; 
  
		System.out.println("Now that you know how to play, are you ready to begin?");
		Scanner input = new Scanner(System.in);
		//do some reasearch on Scanner method class thingy
		a = keyboard.nextString();
  
		if (a == "yes"){
			;
		
		}
		else if(a == "no") {
			System.out.println("the program will wait until you are ready to begin.");
			Scanner input = new Scanner(System.in);
		}
		else {
			System.out.println("that didn't work try entering 'yes or 'no' ");
			Scanner input = new Scanner(System.in);
		}
}
	private static void gameLogic(){
		;
	}
	private static void checkWin(){
		;
	}
	private static void gameAI(){
		;
	}
	private static void clearBoard(){
		;
	}
	private static void displayBoard(){
		;
	}
}