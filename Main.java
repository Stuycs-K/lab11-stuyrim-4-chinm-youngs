import java.util.*;
public class Main {
  public static void main (String[] args) {
    Adventurer a = new Brute();
    Adventurer b = new Brute();
    System.out.println(a);
    System.out.println(a.getSpecial());
    System.out.println(a.getSpecialName());
    System.out.println(a.getSpecialMax());
    System.out.println(a.support());
    System.out.println(a.support(b));
    Adventurer c = new Thief();
    Thief d = new Thief();
    System.out.println(c);
    System.out.println(c.getSpecial());
    System.out.println(c.getSpecialName());
    System.out.println(c.getSpecialMax());
    System.out.println(d.support());
    System.out.println(c.support(d));
    System.out.println("current hp c: " + c.getHP() + "   d: " + d.getHP());

    Adventurer e = Game.createRandomAdventurer();
    System.out.println(e);
    //Game.drawBackground(); 
    Text.clear();
	Game.TextBox(5, 5, 4, 10, "HELPMEPLEASEIMMAFAILTHISCSLABHORAYYYYY");
     //Game.drawText("abcdefghijklmnopqrstuvwxyz", 10, 3);
     //Game.TextBox(6, 29, 3, 4, "abcdefg");
	 ArrayList<Adventurer> wuh = new ArrayList<>();
	 wuh.add(a);
	 wuh.add(b);
	 wuh.add(d);
	 Text.clear();
	 Game.drawParty(wuh, 5);
	 
	 Text.clear();
	 Game.drawScreen(wuh, wuh);
  }
}
