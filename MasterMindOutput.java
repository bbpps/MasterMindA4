package masterMind;

import java.util.Scanner;

public class MasterMindOutput {
	
	
	//prints the intro of the game to the console
	public static void intro(boolean showCode, String code){
		System.out.println("Welcome to Mastermind.\n");
		System.out.println("This is a text version of the classic board game Mastermind.\n"
				+ "The computer will think of a secret code.\n"
				+ "The code consists of 4 colored pegs.\n"
				+ "The pegs may be one of sixe colors: blue, green , orange, purple, red, or yellow.\n"
				+ "A color may appear more than once in the code.\n\n"
				+ "You try to guess what colored pegs are in the code and what order they are in\n"
				+ "After making a guess the result will be displayed.\n"
				+ "A result consists of a black peg for each peg you have exactly correct (color and position) in your guess.\n"
				+ "For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n\n"
				+ "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n"
				+ "When entering guesses you only need to enter the first character of the color as a capital letter.\n\n"
				+ "You have 12 to guess the answer or you lose the game.\n"
				+ "Generating secret code ....");
		if(showCode)
			System.out.println("The secret code is " + code);
		System.out.println("You have 12 guesses left.\n");
	}
	
	//Asks the user to input a guess of the code
	public static String getUserGuess(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is your next guess?");
		System.out.println("Type in the characters for your guess and press enter.");
		System.out.print("Enter guess: ");
		String userGuess = keyboard.next();
		System.out.println();
		return userGuess;
	}
	
	public static void printTurnResults(boolean printCode, String code, Board b, int numGuessesLeft, Code c){
		if(printCode)
			System.out.println("The secret code is " + code);
		System.out.println();
		System.out.println(b.toString(c));
		System.out.println("You have " + numGuessesLeft + " guesses left.\n");
	}
	
}
