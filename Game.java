import java.util.*;
public class Game{
  private static final int WIDTH = 80;
  private static final int HEIGHT = 30;
  private static final int BORDER_COLOR = Text.BLACK;
  private static final int BORDER_BACKGROUND = Text.WHITE + Text.BACKGROUND;

  public static void main(String[] args) {
    run();
  }

  //Display the borders of your screen that will not change.
  //Do not write over the blank areas where text will appear or parties will appear.
  public static void drawBackground(){
    Text.clear();
    Text.go(2, 1);
    for(int i = 0; i < WIDTH; i++){
      System.out.print(Text.colorize(".", Text.WHITE, Text.WHITE+Text.BACKGROUND));
    }
    for(int i = 2; i < HEIGHT; i++){
      Text.go(i,1);
      System.out.print(Text.colorize(".", Text.WHITE, Text.WHITE+Text.BACKGROUND));
      Text.go(i, WIDTH);
      System.out.print(Text.colorize(".", Text.WHITE, Text.WHITE+Text.BACKGROUND));
    }
    Text.go(30, 1);
    for(int i = 1; i < 81; i++){
      System.out.print(Text.colorize(".", Text.WHITE, Text.WHITE+Text.BACKGROUND));
    }
  }


  //Display a line of text starting at a particular row and column
  //(columns and rows start at 1 (not zero) in the terminal)
  //use this method in your other text drawing methods to make things simpler.
  public static void drawText(String s,int startRow, int startCol){
    Text.go(startRow, startCol);
    System.out.print(s);
  }

  /*Use this method to place text on the screen at a particular location.
  *When the length of the text exceeds width, continue on the next line
  *for up to height lines.
  *All remaining locations in the text box should be written with spaces to
  *clear previously written text.
  *@param row the row to start the top left corner of the text box.
  *@param col the column to start the top left corner of the text box.
  *@param width the number of characters per row
  *@param height the number of rows
  */
  public static void TextBox(int row, int col, int width, int height, String text){
    int boxSize = width * height;
    int textSize = text.length();
    if(textSize > boxSize) text = text.substring(0, boxSize);
    if(textSize < boxSize){
      for(int i = 0; i < boxSize-textSize; i++){
        text = text + " ";
      }
    }
    Text.hideCursor();
    for(int j = 0; j < height; j++){
      int start = j * width;
      int end = Math.min(start + width, text.length());
      String line = text.substring(start, end);
      drawText(line, row + j, col);
    }
    Text.go(row+height,1);
	//put the terminal at the end of the output again before the program ends.
    Text.reset();
    Text.showCursor();
  }

    //return a random adventurer (choose between all available subclasses)
    //feel free to overload this method to allow specific names/stats.
    public static Adventurer createRandomAdventurer(){
      int rand = (int) (Math.random() * 3);
      if (rand == 0) {
        return new CodeWarrior();
      }
      else if (rand == 1) {
        return new Brute();
      }
      else {
        return new Thief();
      }
    }

    /*Display a List of 2-4 adventurers on the rows row through row+3 (4 rows max)
    *Should include Name HP and Special on 3 separate lines.
    *Note there is one blank row reserved for your use if you choose.
    *Format:
    *Bob          Amy        Jun
    *HP: 10       HP: 15     HP:19
    *Caffeine: 20 Mana: 10   Snark: 1
    * ***THIS ROW INTENTIONALLY LEFT BLANK***
    */
    public static void drawParty(ArrayList<Adventurer> party,int startRow){
      int col = 2;
      for (int y = 0; y < party.size(); y++) {
		String chealth = colorByPercent(party.get(y).getHP(), party.get(y).getmaxHP());
        drawText(party.get(y).getName(),startRow,col);
        drawText("HP: " + chealth + "\u001b[" + Text.WHITE + "m", startRow + 1, col);
        drawText("Special: " + party.get(y).getSpecial(), startRow + 2, col);
        col = col + 25;
      }
    }


  //Use this to create a colorized number string based on the % compared to the max value.
  public static String colorByPercent(int hp, int maxHP){
    String output = String.format("%2s", hp+"")+"/"+String.format("%2s", maxHP+"");
    //COLORIZE THE OUTPUT IF HIGH/LOW:
    // under 25% : red
    // under 75% : yellow
    // otherwise : white
    if (hp < (.25 * maxHP)) {
      //go to line and change it to red
	    output = "\u001b[" + Text.RED + "m" + output;
    }
    else if (hp < (.75 * maxHP)) {
      //go to line and change to yellow
	    output = "\u001b[" + Text.YELLOW + "m" + output;
    }
    else {
      //leave as white
	    output = "\u001b[" + Text.WHITE + "m" + output;
    }
	Text.reset();
    return output;
  }





  //Display the party and enemies
  //Do not write over the blank areas where text will appear.
  //Place the cursor at the place where the user will by typing their input at the end of this method.
  public static void drawScreen(ArrayList<Adventurer> players, ArrayList<Adventurer> enemies){

    drawBackground();

    //draw player party
    Text.go(26,2);
    System.out.println("Players:");
    drawParty(players, 27);

    //draw enemy party
    Text.go(3,2);
    System.out.println("Enemies:");
    drawParty(enemies, 4);
    
    Text.go(32,1);
    System.out.println();
  }

  public static String userInput(Scanner in){
      //Move cursor to prompt location
      Text.go(32,1);
      //show cursor
      Text.showCursor();
      String input = in.nextLine();

      //clear the text that was written
      Text.clear();
      return input;
  }

  public static void quit(){
    Text.reset();
    Text.showCursor();
    Text.go(32,1);
  }

  public static void run(){
    //Clear and initialize
    Text.hideCursor();
    Text.clear();

    Scanner inp = new Scanner(System.in);
	Text.go(32,1);
    System.out.println("Enter username");
    String name = userInput(inp);
	Text.go(32,1);
    System.out.println("Enter enemy count (1-3)");
    String count = userInput(inp);
    boolean bossFight = false;


    //Things to attack:
    //Make an ArrayList of Adventurers and add 1-3 enemies to it.
    //If only 1 enemy is added it should be the boss class.
    //start with 1 boss and modify the code to allow 2-3 adventurers later.
    ArrayList<Adventurer>enemies = new ArrayList<Adventurer>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    //int ram = (int) ((Math.random() * 2) + 1);
    int ram = Integer.parseInt(count);
    if (ram == 1) {
      Adventurer bobo = new Boss();
      enemies.add(bobo);
      bossFight = true;
    }
    else if (ram == 2){
      Adventurer mopu = createRandomAdventurer();
      Adventurer grof = createRandomAdventurer();
      enemies.add(mopu);
      enemies.add(grof);
    }
    else {
      Adventurer loun = createRandomAdventurer();
      Adventurer kreen = createRandomAdventurer();
      Adventurer frwon = createRandomAdventurer();
      enemies.add(loun);
      enemies.add(kreen);
      enemies.add(frwon);
    }
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    //Adventurers you control:
    //Make an ArrayList of Adventurers and add 2-4 Adventurers to it.
    ArrayList<Adventurer> party = new ArrayList<>();
    /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
    Adventurer you = new CodeWarrior(name);
    party.add(you);
    Adventurer fren = new Thief();
    Adventurer dilg = new Brute();
    //Adventurer fren = createRandomAdventurer();
    //Adventurer dilg = createRandomAdventurer();
    party.add(fren);
    party.add(dilg);
    /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/

    boolean partyTurn = true;
    int whichPlayer = 0;
    int whichOpponent = 0;
    int turn = 0;
    String input = "";//blank to get into the main loop.
    Scanner in = new Scanner(System.in);
    //Draw the window border

    //You can add parameters to draw screen!
    drawScreen(party,enemies);//initial state.

    //Main loop

    //display this prompt at the start of the game.
    int countB = 0;
	int countT = 0;


    while(! (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit"))){
  
	  //drawScreen(party,enemies);
	  String yap = "";
	 // TextBox(15,2,78,3,yap);
	  

   
		
		  if (partyTurn) {
			 // TextBox(15,2,78,3,yap);
			//  drawScreen(party,enemies);
			
			  String preprompt = "Enter command for "+party.get(whichPlayer)+": attack/a/special/sp/support/su/quit, and target (starting from 0)";
				Text.go(32,1);
				System.out.println(preprompt); 
			  input = userInput(in);
        while(input.equals("")){
          System.out.print(preprompt + " ex: attack 1, sp 2");
          input = userInput(in);
        }
			  
			  
			  if (input.equals("q") || input.equals("quit")) {
				  quit();
				  return;
			  }
			  
				  String[] inputs = input.split(" ");
			  String move = inputs[0];
        int aim = 0;

        if(inputs.length >= 2 && bossFight == false){
          aim = Integer.parseInt(inputs[1]);
        }
        else{
          if(bossFight && !(move.equals("su")||move.equals("support"))){
            aim = 0;
          }
          else{
            System.out.println("which enemy/person?");
            String inputput = userInput(in);
            aim = Integer.parseInt(inputput);
          }
        }

			  
			  if (party.get(whichPlayer).getHP() > 0) {
		  
		   
        //Process user input for the last Adventurer:
        if(move.equals("attack") || move.equals("a")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
			//drawScreen(party,enemies);
		// System.out.println("Which enemy?");
		//  input = userInput(in);
		//  int hit = Integer.parseInt(input);
		  if (party.get(whichPlayer).getName().equals("Maddie")) {
			   countB++;
		   }
		  
		   if (party.get(whichPlayer).getName().equals("Sophia")) {
			   countT++;
		   }
		   if (party.get(whichPlayer).getName().equals("Maddie") && countB == 3) {
			   party.get(whichPlayer).specialAttack(enemies.get(aim));
			   enemies.get(aim).setHP(enemies.get(aim).getHP() - 3);
			   yap = "It's a critical attack.";
			   countB = 0;
			   
		   }
		   else {
		   yap = party.get(whichPlayer).attack(enemies.get(aim));
		   }

		  drawScreen(party, enemies);
		   TextBox(15,2,78,3,yap);
		   
		  
		  
		 
		 /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(move.equals("special") || move.equals("sp")){
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
        //  System.out.println("Which enemy?");
		//  input = userInput(in);
		//  int hit = Integer.parseInt(input);
		   yap = party.get(whichPlayer).specialAttack(enemies.get(aim));
		  drawScreen(party,enemies);
		  TextBox(15,2,78,3,yap);
		  if (party.get(whichPlayer).getName().equals("Maddie")) {
			   countB = 0;
		   }
		   if (party.get(whichPlayer).getName().equals("Sophia")) {
			   countT = 0;
		   }
		         /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
        }
        else if(move.equals("su") || move.equals("support")){
          //"support 0" or "su 0" or "su 2" etc.
          //assume the value that follows su  is an integer.
          /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
         // System.out.println("Which player?");
		  //input = userInput(in);
		  //int hit = Integer.parseInt(input);
      if(whichPlayer == aim){
        yap = party.get(whichPlayer).support();
      }
      else{
		   yap = party.get(whichPlayer).support(party.get(aim));
      }
		  drawScreen(party, enemies);
		  TextBox(15,2,78,3,yap);
		  if (party.get(whichPlayer).getName().equals("Maddie")) {
			   countB = 0;
		   }
		   if (party.get(whichPlayer).getName().equals("Sophia")) {
			   countT = 0;
		   }
		 /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/
		   } }
		   else {
			   drawScreen(party,enemies);
			   yap = "That character is dead and cannot attack :(";
		   }

        //You should decide when you want to re-ask for user input
        //If no errors:
       TextBox(15,2,78,3,yap);
	   whichPlayer++;
	   
	   int alive = enemies.size();
	   for (int y = 0; y < enemies.size(); y++) {
		   if (enemies.get(y).getHP() < 0) {
			   alive--;
		   }
		   if (alive == 0) {
			   Text.clear();
			   Text.go(32,1);
			   System.out.println("Game over! You won.");
			   return;
		   }
	   }


     /*   if(whichPlayer < party.size() && party.get(whichPlayer).getHP() > 0){
          //This is a player turn.
          //Decide where to draw the following prompt:
           

        }*/ if (whichPlayer >= party.size()){
			partyTurn = false;
			whichPlayer = 0;
          whichOpponent = 0;
		  //turn++;
		}
		
        }
        //done with one party member
     
		  else {
			  String promptt = "press enter to see enemy's turn";
		  Text.go(32,1);
		  System.out.println(promptt); 
		  input = userInput(in);


        //enemy attacks a randomly chosen person with a randomly chosen attack.z`
        //Enemy action choices go here!
        /*>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>*/
	   if (enemies.get(whichOpponent).getHP() <= 0) {
		   drawScreen(party,enemies);
		   yap = "That character is dead and cannot attack :(";
	   }
		   else{
		int ran = (int) (Math.random() * 3) + 1;
		int hitt = (int) (Math.random() * party.size());
    while(party.get(hitt).getHP() < 1)
      {hitt = (int) (Math.random() * party.size());}
		//String yap = "";
		if (countT == 3) {
			//whichOpponent++;
			yap = "Sophia stole their move :(";
			countT = 0;
		}
		else {
	  if (ran == 1) {
		    yap = enemies.get(whichOpponent).attack(party.get(hitt));
	  }
	  else if (ran == 2) {
		  if (enemies.size() == 1) {
			  int oopsies = (int) (Math.random() * 5);
			  if (oopsies == 0) {
				  enemies.get(whichOpponent).specialAttack(party.get(hitt));
				  party.get(hitt).setHP(party.get(hitt).getHP() - 2);
				  yap = "Boss used their special attack and " + party.get(hitt) + " was burned!";
			  }
			  else {
				  yap = enemies.get(whichOpponent).specialAttack(party.get(hitt));
			  }
		  }
		  else {
		   yap = enemies.get(whichOpponent).specialAttack(party.get(hitt));
	  }}
	  else if (ran == 3) {
		    yap = enemies.get(whichOpponent).support();
	  }
		}
		
		  }
		
		drawScreen(party,enemies);
	  TextBox(15,2,78,3,yap);
        /*<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<*/


        whichOpponent++;
		int alive = party.size();
		 for (int y = 0; y < party.size(); y++) {
		   if (party.get(y).getHP() < 0) {
			   alive--;
		   }
		   if (alive == 0) {
			   Text.clear();
			   Text.go(32,1);
			   System.out.println("Game over! You lost.");
			   return;
		   }
	   }

      //end of one enemy.

      //modify this if statement.
      if(whichOpponent >= enemies.size()){
		  
        whichPlayer = 0;
		whichOpponent = 0;
        partyTurn=true;
       // String prompt = "Enter command for "+party.get(whichPlayer)+": attack/special/quit";
		//  Text.go(32,1);
		//  System.out.println(prompt);
		//  input = userInput(in);
		  }}

      //display the updated screen after input has been processed.
     // drawScreen(party,enemies);

		  
    }//end of main game loop


    //After quit reset things:
    quit();
  }
}
