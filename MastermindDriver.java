package masterMind;


/*  Student information for assignment:
*
*  On <MY|OUR> honor, <NAME1> and <NAME2), this programming assignment is <MY|OUR> own work
*  and <I|WE> have not provided this code to any other student.
*
*  Number of slip days used:
*
*  Student 1 (Student whose turnin account is being used)
*  UTEID:
*  email address:
*  Grader name:
*  Section number:
*  
*  Student 2 
*  UTEID:
*  email address:
*  Grader name:
*  Section number:
*  
*/

public class MastermindDriver {

   public static void main(String[] args){
       Game g = new Game(true);
       g.runGames();
       g = new Game(false);
       g.runGames();
   }

}