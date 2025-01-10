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
  }
}
