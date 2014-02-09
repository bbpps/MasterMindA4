package masterMind;

import java.util.Scanner;

public class MasterMindOutput {
	
	//prints the intro of the game to the console
	public static void intro(){
		
	}
	
	//Asks the user to input a guess of the code
	public static String getUserGuess(){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What is your next guess?");
		System.out.println("Type in the characters for your guess and press enter.");
		System.out.print("Enter guess: ");
		return keyboard.next();
	}
	
	public static void printTurnResults(boolean printCode, String code){
		if(printCode)
			System.out.println("\nThe secret code is " + code+"\n");
		
		
	}
	
}
