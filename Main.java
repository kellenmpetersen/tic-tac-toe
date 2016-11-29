/* 

   name: TicTacToe
   author: Pseupier Coders
   date: 11/22/16
   description: a simple game of tic-tac-toe

*/

import java.util.Scanner;

public class Main{
	
	private final static int WIDTH = 3;
	private final static int HEIGHT = 3;
	private static int column = 0, row = 0;
	
	//if board space is blank
	private final static int BLANK = 0;
	
	//board stores characters
	static char[][]board = new char[WIDTH][HEIGHT];
	
	// the main method is the entry point for a program
    	// inside methods the statements get executed in the order they appear in the code
	public static void main(String[] args){
		//while (booleanexpression) {
			gameRules();
			userInput();
			userInputColumn(column);
			userInputRow(row);
			System.out.println(column);
			System.out.println(row);
			setupBoard();
			gameLogic();
			checkWin();
			gameAI();
			checkWin();
			clearBoard();
			displayBoard();
		//}
    }
	/*
	Author: JC
	Purpose: Instructions
	Inputs: none
	Outputs: Instructions
	*/
	
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
	
	/*
	Author: JD
	Purpose: Gets users input on rows and columns
	Inputs: columns, and rows
	Outputs: columns, and rows
	*/
	
	private static void userInput()
	{
		String response;
		boolean flag = false;
		
		//prompting
		System.out.println("Now that you know how to play, are you ready to begin? (yes or no)");
		Scanner input = new Scanner(System.in);
  
		// while loop used to continue prompting user until they are ready to play
		while(flag == false){
			response = input.nextLine();
			// set of if else statments to determine based off of user's input when they are ready to play
			if (response.equals("yes")){
				flag=true;
			}
			else if(response.equals("no")) {
				System.out.println("enter 'yes' when you are ready to begin.");
				flag=false;
			}
			else {
				System.out.println("that didn't work try entering 'yes' or 'no' ");
				flag=false;
			}
		}
	}
	
	private static int userInputColumn(){
		int iresponse;
		boolean flag = false;
		
		Scanner input = new Scanner(System.in);
			
		System.out.println("enter a column in which you would like to place your location (1-3)");
		
		while(flag == false){
			while (!input.hasNextInt()) {
				//tell user to enter in an integer value, and give them a chance to do so. Repeat as many times as nessacary until they do.	
				System.out.println("Enter an integer, please!");
				input.nextLine();
			}
			
			iresponse = input.nextInt();
			
			if (iresponse < 4 && iresponse > 0){
				column = iresponse;
				flag=true;
			}
			else  {
				System.out.println("that's not a vaild column, try entering a number 1-3");
				flag=false;
			}
		}
		
		return column;
	}
	
	private static int userInputRow(){
		int iresponse;
		boolean flag = false;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("enter a row in which you would like to place your location (1-3)");
				
		while(flag == false){
			while (!input.hasNextInt()) {
				//tell user to enter in an integer value, and give them a chance to do so. Repeat as many times as nessacary until they do.	
				System.out.println("Enter an integer, please!");
				input.nextLine();
			}
			
			iresponse = input.nextInt();
			
			if (iresponse < 4 && iresponse > 0){
				row = iresponse;
				flag=true;
			}
			else  {
				System.out.println("that's not a vaild row, try entering a number 1-3");
				flag=false;
			}
		}
		
		return row;
	}
	
	private static void setupBoard(){
		for(int width=0; width < WIDTH; width++){
			for(int height=0; height < HEIGHT; height++){
				board[width][height]='-';
			}
		}	
	}

	private static void gameLogic(){
		for(int width=0; width < WIDTH; width++){
			for(int height=0; height < HEIGHT; height++){
				System.out.print(board[width][height]);
			}
			System.out.println("");
		}	
	}
	
	
	/*
	Author: JC & KP
	Purpose: checksWin
	Inputs: none
	Outputs: int of who won
	*/
	
	private static int checkWin(){
		//for loop that checks across all columns if players tokens match
		//for loop that checks across all rows if players token match
		//nested for loop that checks diagonals. (two)
	}
	private static void gameAI(){
		;
	}
	private static void clearBoard(){
		;
	}
	private static void displayBoard(){
		;
		//see ABOVE
	}
}
