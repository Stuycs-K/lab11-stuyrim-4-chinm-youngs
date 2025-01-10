public class Thief extends Adventurer{
  int money, moneyMax;
  String ability;

  //constructors
  public Thief(String name, int hp, String stealing){
    super(name,hp);
    moneyMax = 12;
    money = 6;
    ability = stealing;
  }

  public Thief(String name, int hp){
    this(name,hp,"healthTransfer");
  }

  public Thief(String name){
    this(name,30);
  }

  public Thief(){
    this("Sophia");
  }

//get and set
  public String getSpecialName(){
    return "money";
  }

  public int getSpecial(){
    return money;
  }

  public void setSpecial(int n){
    money = n;
  }

  public int getSpecialMax(){
    return moneyMax;
  }

  //actions
  //Deal 1-6 damage to opponent
  public String attack(Adventurer other){
    int damage = (int)(Math.random()*5)+1;
    other.applyDamage(damage);
    return this + " attacked "+ other + " and dealt "+ damage +
    " points of damage.";
  }
  /*Deal 1-6 damage to opponent, only if money is high enough.
  *Reduces money by 2.
  */
  public String specialAttack(Adventurer other){
    if(getSpecial() >= 2){
      setSpecial(getSpecial()-2);
      int damage = (int)(Math.random()*5) + 1;
      other.applyDamage(damage);
      this.setHP(getHP + damage);
      return this + " used their "+ability+
      " skills steal from an enemy."+
      " This made "+other+" broke, dealing "+ damage +" points of damage.";
    }else{
      return "Not enough money to steal. Instead "+attack(other);
    }
  }




}
