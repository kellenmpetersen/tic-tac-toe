/* 

   name: TicTacToe
   author: Pseupier Coders
   date: 11/22/16
   description: a simple game of tic-tac-toe

*/

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
		;
	}
	private static void userInput(){
		;
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