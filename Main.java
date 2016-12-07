/* 
   name: TicTacToe
   author: Pseuperior Coders
   date: 11/22/16 - 12/7/16
   description: a simple game of tic-tac-toe
*/

import java.util.Scanner;

public class Main{
	
	private final static int WIDTH = 3;
	private final static int HEIGHT = 3;
	private static int column = 0, row = 0;
	private static char token = 'x';	
	private static int turn = 0, win = 0;
	private static boolean input = false;
	private static String player = null;
	
	//board stores characters
	static char[][]board = new char[WIDTH][HEIGHT];
	
	// the main method is the entry point for a program
    	// inside methods the statements get executed in the order they appear in the code
	public static void main(String[] args){
		gameRules();
		setupBoard();
		userInput();	
		userInputToken(token);
		for(int turn=1; turn<10; turn++){
			while(input==false){
				userInputColumn();
				userInputRow();
				checkSpace(column,row);
			}
			gameLogic(column,row,token);
			win = checkWin(column,row);
			if (win>0){
				player="You";
				turn=10;
			}
			//gameAI(column,row);
			/*
			win = checkWin(column,row);
			if (win>0){
				player="The AI";
				turn=10;
			}
			*/
			displayBoard();
			input=false;
		}
		winMsg(player,win);
	}
	
	/*
	Author: Jack Carr
	Purpose: Prints Instructions
	Inputs: none
	Outputs: Instructions
	returns: none
	*/
	
	private static void gameRules(){
		System.out.println("------------------------------");
		System.out.println("Tic Tac Toe Game Rules:");
		System.out.println("In order to win, you must connect 3 x's or o's vertically, horizontally, or diagonally.");
		System.out.println();
		System.out.println(" You, the user, are given the choice of 'X' or 'O' for your your symbol.");
		System.out.println();
		System.out.println("If you pick an invalid column, one that is full or non-existent you will be asked to pick a new column.");
		System.out.println();
		System.out.println("That's all, enjoy the game!");
		System.out.println("------------------------------");
	}
	
	/*
	Author: Jack de la Motte
	Purpose: Asks if user is ready to begin, if not ready, then waits.
	Inputs: none
	Outputs: none
	Returns: none
	*/
	
	private static void userInput(){
		String response;
		boolean flag = false;
		
		//prompting
		System.out.println("Are you ready to begin? (yes or no)");
		Scanner input = new Scanner(System.in);
  
		// while loop used to continue prompting user until they are ready to play
		while(flag == false){
			response = input.nextLine();
			// set of if else statments to determine based off of user's input when they are ready to play
			if (response.equals("yes")){
				flag=true;
			}
			else if(response.equals("no")) {
				//program waits for user to be ready to begin
				System.out.println("Enter 'yes' when you are ready to begin.");
				// sets flag to false in order to run through loop again
				flag=false;
			}
			else {
				// if response is not yes or no, even accounts for integers and floats
				System.out.println("Try entering 'yes' or 'no'");
				// sets flag to false in order to run through loop again
				flag=false;
			}
		}
	}
	
	/*
	Author: Jack Carr
	Purpose: has user choose token they want, X or O
	Inputs: none
	Outputs: none
	Returns: what token the user chose
	*/
	private static void userInputToken(char token){
		String response;
		boolean letter = false;
			
		//prompting
		System.out.println("Choose a token: ('x'or'o')");
		Scanner input = new Scanner(System.in);
  
		while(letter == false){
			response = input.nextLine();
			// set of if else statments to determine based off of user's input when they are ready to play
			if (response.equals("x")){
				System.out.println("You selected token x");
				token = 'x';
				letter=true;
			}
			else if(response.equals("o")) {
				System.out.println("You selected token o");
				token = 'o';
				letter=true;
			}
			else {
				System.out.println("Try entering 'x' or 'o' ");
				letter=false;
			}
		}
	}
	
	
	/*
	Author: Jack de la Motte & Kellen Petersen 
	Purpose: has user input column location
	Inputs: none
	Outputs: none
	Returns: none
	*/
	private static int userInputColumn(){
		int iresponse;
		boolean flag = false;
		
		Scanner input = new Scanner(System.in);
			
		System.out.println("Enter a column (1-3)");
		
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
				System.out.println("Not a vaild column, try (1-3)");
				flag=false;
			}
		}
		
		return column;
	}
	
	/*
	Author: Jack de la Motte & Kellen Petersen 
	Purpose: has user input row location
	Inputs: none
	Outputs: none
	Returns: none
	*/
	private static int userInputRow(){
		int iresponse;
		boolean flag = false;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a row (1-3)");
				
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
				System.out.println("Not a vaild row, try (1-3)");
				flag=false;
			}
		}
		
		return row;
	}
	
	/*
	Author: Jack de la Motte & Kellen Petersen
	Purpose: checks to see if Space is filled
	Inputs: column, row
	Outputs: input
	Returns: none
	*/
	
	private static void checkSpace(int column, int row){
		if(board[column-1][row-1] == '-'){
			input=true;
		}
		else{
			System.out.println("This space has already been selected!");
			input=false;
		}
	}
		
	/*
	Author: Kellen Petersen
	Purpose: sets board with default parameters
	Inputs: none
	Outputs: none
	*/
	
	private static void setupBoard(){
		for(int width=0; width < WIDTH; width++){
			for(int height=0; height < HEIGHT; height++){
				board[width][height]='-';
			}
		}	
	}
	
	/*
	Author: Kellen Petersen & Jack de la Motte
	Purpose: gameLogic
	Inputs: column, row, token
	Outputs: postion of players token
	Returns: none
	*/
	
	private static void gameLogic(int column, int row, char token){
		board[column-1][row-1]=token;
	}
	
	/*
	Author: Jack Carr & Kellen Petersen
	Purpose: gameAI trys to win
	Inputs: turn
	Outputs: gameAI column and row
	Returns: none
	*/
	
	private static void gameAI(){
		;
	}
	
	/*
	Author: Jack Carr & Kellen Petersen
	Purpose: checksWin using last entered input
	Inputs: none
	Outputs: int of who won
	Returns: 
	*/
	
	private static int checkWin(int column, int row){
		for(int i = 1;  i<4; i++){
			if(board[column-1][i-1] != board[column-1][row-1]){
				break;
			}
			else if (i==board.length){
				return 1;
			}
		}

		for(int i=1; i<4; i++){
			if(board[i-1][row-1] != board[column-1][row-1]){
				break;
			}
			else if (i==board.length){
				return 2;
			}
		}

        //check diagonal
		if(row == column){
      		for(int i = 1; i <4; i++){
             	if(board[i-1][i-1] != board[column-1][row-1]){
					break;
               	}
            	else if(i-1 == WIDTH-1){
					return 3;
                }
        	}
		}

        //check anti-diagonal
		if((column-1) + (row-1) == (WIDTH-1)){
            for(int i = 1; i < 4; i++){
				if(board[i-1][(WIDTH-1)-(i-1)] != board[column-1][row-1]){
					break;
                }
               	else if(i == (WIDTH-1)){
					return 4;
                }
			}
        }

        //draw
		if(turn == 9){
			return 5;
        }
		
		//Nobody's won
		return 0;
		
	}
	
	/*
	Author: Kellen Petersen
	Purpose: displays "board" array visually
	Inputs: none
	Outputs: "board" array
	Returns: none
	*/
	
	private static void displayBoard(){
		for(int width=0; width < WIDTH; width++){
			for(int height=0; height < HEIGHT; height++){
				System.out.print(board[width][height]);
			}
			System.out.println("");
		}	
	}
	
	/*
	Author: Kellen Petersen
	Purpose: displays win method
	Inputs: win
	Outputs: none
	Returns: none
	*/
	
	private static void winMsg(String player, int win){
		switch (win) {
            case 1:  
				System.out.println(player+" won the game with 3-in-a-row!");
                break;
            case 2:  
				System.out.println(player+" won the game with 3-in-a-column!");
                break;
            case 3:  
				System.out.println(player+" won the game on a diagonal!");
                break;
            case 4:  
				System.out.println(player+" won the game on a diagonal!");
                break;
            case 5:  
				System.out.println("Cat's game...");
                break;				
            default: 
				System.out.println("The program is broken!");
                break;
        }
	}
}
