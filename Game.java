package masterMind;


public class Game {


	// if showCode is true then the secret code is revealed before
	// the gane starts. This will be used by graders of the program
	// to test the feedback of guesses
	private boolean showCode;
	private int numGuessesLeft = 12;
	private boolean userWins = false;
	private Board board; 
	private Code solution;


	public Game(boolean easy){
		showCode = easy;
		solution = new Code();
		solution = getRandomCode();
		board = new Board(solution);

	}
	//Runs through 1 game of MasterMind
	public void runGames(){
		MasterMindOutput.intro();
		while(numGuessesLeft > 0 && !userWins){
			runTurn();
		}
	}

	//Randomly generates a code with random pegs
	private Code getRandomCode(){
		int randNum;
		Colors c;
		Code temp = new Code();
		for(int i=0; i<temp.getSize(); i++){
			randNum = (int)(Math.random()*5);
			c = Colors.values()[randNum];
			temp.set(i, new Peg(c));
		}

		return temp;
	}

	//Method to get an input from the user then compare that input to the randomly
	//generated code
	private void runTurn(){
		Code guess = new Code();
		String userGuess = MasterMindOutput.getUserGuess();
		guess.convertString(userGuess);
		board.setTurn(userGuess);
		board.scanRow();
		MasterMindOutput.printTurnResults(showCode, solution.convertCodetoString());
		if(guess.getBlackCount() == 4)
			userWins = true;
		
	}
}