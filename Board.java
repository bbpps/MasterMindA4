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
		if(line.length() != 4 && !hasValidChars(line))
			throw new IllegalArgumentException("Pre conditions violated: " + line.length() + ", " + line);
		Code c = board[row];
		c.convertString(line);
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
		for(int codeIndex=0; codeIndex<board[row].getSize(); codeIndex++){
			Peg currentPeg = board[row].get(codeIndex);
			if(currentPeg.equals(board[0].get(codeIndex))){
				//increment counter for a black peg
				board[row].incrementBlack();
			}
			//we know the color pegs aren't the same at position "codeIndex"
			//check if the color at codeIndex is in the solution
			else if(board[0].contains(currentPeg)){
				//increment counter for a white peg
				board[row].incrementWhite();
			}
		}
		row++;
	}
	
	public String toString(Code c){
		StringBuilder sb = new StringBuilder();
		sb.append(".... Secret Code\n");
		for(int boardIndex = 1; boardIndex < board.length; boardIndex++){
			
			//checks if row has a past user guess in it and adds the correct number of white and black pegs to the String
			//if(){
				sb.append(board[boardIndex].toString());
				sb.append(" Result: ");
				for(int numBlacks = 0; numBlacks < board[boardIndex].getBlackCount(); numBlacks++)
					sb.append("Black ");
				for(int numWhite = 0; numWhite < board[boardIndex].getWhiteCount(); numWhite++)
					sb.append("White ");
				if(c.getBlackCount() == 0 && board[boardIndex].getWhiteCount() == 0)
					sb.append("No Pegs");
				sb.append("\n");
			//}
			//else
				sb.append(board[boardIndex].toString() + "\n");
		}
		return sb.toString();
	}
}
