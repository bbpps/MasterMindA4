package masterMind;

public class Board {
	private Code[] board;
	private int row;
	final static int NUM_TURNS = 12;

	public Board(Code solution){
		board = new Code[NUM_TURNS + 1];
		board[0] = solution;
		row = 1;
		for(int i=1; i<board.length; i++){
			board[i] = new Code();
		}
	}

	//pre: line.length == 4 && hasValidChars()
	//converts the chars (BGOPRY) to a Code object and then
	//stores them into next available row
	public void setTurn(String line){
		if(line.length() != 4 || !hasValidChars(line))
			throw new IllegalArgumentException("Pre conditions violated: " + line.length() + ", " + line);
		Code c = board[row];
		c.convertString(line);
	}
	
	//Returns the most current guess by the user
	public Code getCurrentGuess(){
		return board[row-1];
	}

	//makes sure the characters in the string are valid "color" chars
	public boolean hasValidChars(String code){
		for(int i=0; i<code.length(); i++){
			if(!"BGOPRY".contains(code.charAt(i) + ""))
				return false;
		}
		return true;
	}

	//scans the current row and compares it to the real
	//code. Then returns count of the black and white pegs
	public void scanRow(){
		Code solution = deepCopy(board[0]);
		Code guess = deepCopy(board[row]);
		for(int codeIndex=0; codeIndex<guess.getSize(); codeIndex++){
			Peg currentPeg = guess.get(codeIndex);
			if(currentPeg.equals(solution.get(codeIndex))){
				//increment counter for a black peg
				board[row].incrementBlack();
				solution.set(codeIndex, null); //set it to null so that it doesn't get counted twice
				guess.set(codeIndex, null);
			}
		}
		for(int i=0; i<guess.getSize(); i++){
			Peg currentPeg = guess.get(i);
			//check if the color at codeIndex is in the solution
			int index = solution.indexOf(currentPeg);
			if(index >= 0){
				//increment counter for a white peg
				board[row].incrementWhite();
				solution.set(index, null);
			}
		}
		row++;
	}
	
	private Code deepCopy(Code c){
		Code copy = new Code();
		for(int codeIndex = 0; codeIndex < c.getSize(); codeIndex++){
			copy.set(codeIndex, c.get(codeIndex));
		}
		return copy;
	}
	
	public String toString(Code c){
		StringBuilder sb = new StringBuilder();
		sb.append(".... Secret Code\n");
		for(int boardIndex = 1; boardIndex < board.length; boardIndex++){
			
			//checks if row has a past user guess in it and adds the correct number of white and black pegs to the String
			if(!board[boardIndex].isEmpty()){
				sb.append(board[boardIndex].toString());
				sb.append(" Result: ");
				for(int numBlacks = 0; numBlacks < board[boardIndex].getBlackCount(); numBlacks++)
					sb.append("Black ");
				for(int numWhite = 0; numWhite < board[boardIndex].getWhiteCount(); numWhite++)
					sb.append("White ");
				if(board[boardIndex].getBlackCount() == 0 && board[boardIndex].getWhiteCount() == 0 )
					sb.append("No Pegs");
				sb.append("\n");
			}
			else
				sb.append(board[boardIndex].toString() + "\n");
		}
		return sb.toString();
	}
	
	//Returns the part of the board that has guesses inputted to it
	public String getAllGuessOnBoard(){
		StringBuilder sb = new StringBuilder();
		for(int boardIndex = 1; boardIndex < row; boardIndex++){
			//checks if row has a past user guess in it and adds the correct number of white and black pegs to the String
			if(!board[boardIndex].isEmpty()){
				sb.append(board[boardIndex].toString());
				sb.append(" Result: ");
				for(int numBlacks = 0; numBlacks < board[boardIndex].getBlackCount(); numBlacks++)
					sb.append("Black ");
				for(int numWhite = 0; numWhite < board[boardIndex].getWhiteCount(); numWhite++)
					sb.append("White ");
				if(board[boardIndex].getBlackCount() == 0 && board[boardIndex].getWhiteCount() == 0 )
					sb.append("No Pegs");
				sb.append("\n");
			}
			else
				sb.append(board[boardIndex].toString() + "\n");
		}
		
		return sb.toString();
	}

	//checks if the user has won a game or not
	public boolean checkForWin() {                        
		if(board[row-1].getBlackCount() == 4)
			return true;
		return false;
	}
}
