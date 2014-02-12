package masterMind;

public class Code {
	private Peg[] elements;
	private int bCount, wCount;

	public Code() {
		elements = new Peg[4];
		bCount = 0;
		wCount = 0;
	}

	// gets the Peg at position "index"
	public Peg get(int index) {
		return elements[index];
	}

	// returns the size of the Code
	public int getSize() {
		return elements.length;
	}

	// getters for the counters
	public int getBlackCount() {
		return bCount;
	}

	public int getWhiteCount() {
		return wCount;
	}

	// converts a string of the Color chars (BGOPRY)
	// into Pegs which is then stored into elements
	public void convertString(String code) {
		for (int c = 0; c < code.length(); c++) {
			switch (code.toUpperCase().charAt(c)) {
			case 'B':
				elements[c] = new Peg(Colors.BLUE);
				break;
			case 'G':
				elements[c] = new Peg(Colors.GREEN);
				break;
			case 'O':
				elements[c] = new Peg(Colors.ORANGE);
				break;
			case 'P':
				elements[c] = new Peg(Colors.PURPLE);
				break;
			case 'R':
				elements[c] = new Peg(Colors.RED);
				break;
			case 'Y':
				elements[c] = new Peg(Colors.YELLOW);
				break;
			}
		}
	}

	// converts the code from an array of pegs to a string
	public String convertCodetoString() {
		String result = "";
		for (int c = 0; c < elements.length; c++) {
			if (elements[c].getColor().equals(Colors.BLUE))
				result += "B";
			else if (elements[c].getColor().equals(Colors.GREEN))
				result += "G";
			else if (elements[c].getColor().equals(Colors.ORANGE))
				result += "O";
			else if (elements[c].getColor().equals(Colors.PURPLE))
				result += "P";
			else if (elements[c].getColor().equals(Colors.RED))
				result += "R";
			else if (elements[c].getColor().equals(Colors.YELLOW))
				result += "Y";
		}
		return result;
	}

	// checks if the current peg is within elements
	public boolean contains(Peg peg) {
		for (int i = 0; i < elements.length; i++) {
			if (peg.equals(elements[i]))
				return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		else if (this.getClass() != other.getClass())
			return false;
		else {
			Code otherCode = (Code) other;
			// check if elements are the same
			for (int codeIndex = 0; codeIndex < this.getSize(); codeIndex++) {
				if (!this.get(codeIndex).equals(otherCode.get(codeIndex))) {
					return false;
				}
			}
		}
		return true;
	}

	// increments the black counter for this Code instance
	public void incrementBlack() {
		bCount++;
	}

	// increments the white counter for this Code instance
	public void incrementWhite() {
		wCount++;
	}

	// sets the element at pos to peg
	public void set(int pos, Peg peg) {
		elements[pos] = peg;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int codeIndex = 0; codeIndex < elements.length; codeIndex++) {
			if (elements[codeIndex] == null)
				sb.append(".");
			else
				sb.append(elements[codeIndex].toString() + "");
		}
		return sb.toString();
	}
}
