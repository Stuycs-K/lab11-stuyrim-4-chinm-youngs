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
      this.setHP(getHP() + damage);
      return this + " used their "+ability+
      " skills steal from an enemy."+
      " This made "+other+" broke, dealing "+ damage +" points of damage.";
    }else{
      return "Not enough money to steal. Instead "+attack(other);
    }
  }

   /*Restores 5 special to other*/
  public String support(Adventurer other){
    other.setHP(other.getHP() + 5);
    return "Gives money to "+other+" and restores 5 HP";
  }
  /*Restores 5 hp to self*/
  public String support(){
    setHP(getHP()+5);
    return this+" uses money to restore 5 HP";
  }




}
