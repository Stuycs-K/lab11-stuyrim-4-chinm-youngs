public class Brute extends Adventurer{
  int food, foodMax;

  public Brute(String name, int hp){
    super(name,hp);
    foodMax = 12;
    food = 6;
  }

  public Brute(String name){
    this(name,30);
  }

  public Brute(){
    this("Maddie");
  }

  public String getSpecialName(){
    return "food";
  }

  public int getSpecial(){
    return food;
  }

  public void setSpecial(int n){
    food = n;
  }

  public int getSpecialMax(){
    return foodMax;
  }

  public String attack(Adventurer other){
    int damage = (int)(Math.random()*6)+3;
    other.applyDamage(damage);
    return this + " attacked "+ other + " and dealt "+ damage +
    " points of damage.";
  }

  public String specialAttack(Adventurer other){
    if(getSpecial() >= 2){
      setSpecial(getSpecial()-2);
      int damage = (int)(Math.random()*9)+5;
	  int damage2 = damage / 2;
      other.applyDamage(damage);
	  this.applyDamage(damage2);
      return this + " used their power to attack "+ other + " , dealing " + damage + " points of damage. They suffered " + damage2 + " points of damage from recoil.";
    }else{
      return "Not enough food to use your power. Instead "+attack(other);
    }

  }

  public String support(Adventurer other){
      return this + " cannot support other adventurers :(";
    }

  public String support(){
    int hp = 6;
    setHP(getHP()+hp);
    return this+" eats to restore "+hp+" HP";
  }
}
