package masterMind;

public class Peg {
	private Colors color;

	public Peg(Colors color) {
		this.color = color;
	}

	//returns the color of the peg
	public Colors getColor(){
		return color;
	}

	@Override
	public boolean equals(Object other) {
		if(other == null)
			return false;
		else if(this.getClass() != other.getClass())
			return false;
		else if(!((Peg)other).color.equals(this.color))
			return false;
		else
			return true;
	}

	//Mutator method to set the color of a peg
	public void setColor(Colors c){
		this.color = c;
	}

	public String toString(){
		if(color.equals(Colors.BLUE))
			return "B";
		else if(color.equals(Colors.GREEN))
			return "G";
		else if(color.equals(Colors.ORANGE))
			return "O";
		else if(color.equals(Colors.PURPLE))
			return "P";
		else if(color.equals(Colors.RED))
			return "R";
		else if(color.equals(Colors.YELLOW))
			return "Y";
		else
			return ".";

	}

}
