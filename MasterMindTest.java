package masterMind;

public class MasterMindTest {
	
	public static void main(String[] args){
		Code c = new Code();
		System.out.println(c.isEmpty());
		c.convertString("GOYY");
		System.out.println(c.isEmpty());
	}
	
}
