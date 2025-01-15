public class Boss extends Adventurer{
  int fire, fireMax;
  public Boss(String name, int hp){
    super(name,hp);
    fireMax = 20;
    fire = 10;
  }

  public Boss(String name){
    this(name,90);
  }

  public Boss(){
    this("Boss");
  }

  public String getSpecialName(){
    return "fire";
  }

  public int getSpecial(){
    return fire;
  }

  public void setSpecial(int n){
    fire = n;
  }

  public int getSpecialMax(){
    return fireMax;
  }

  public String attack(Adventurer other){
    int damage = (int)(Math.random()*5)+4;
    other.applyDamage(damage);
    return this + " attacked "+ other + " and dealt "+ damage +
    " points of damage.";
  }

  public String specialAttack(Adventurer other){
    if(getSpecial() >= 4){
      setSpecial(getSpecial()-4);
      int damage = (int)(Math.random()*5)+8;
      other.applyDamage(damage);
      return this + " used their fire to burn "+ other + " , dealing " + damage + " points of damage.";
    }else{
      return "Not enough fire to use Boss' power. Instead "+attack(other);
    }

  }

  public String support(Adventurer other){
      return this + " cannot support other adventurers :(";
    }

  public String support(){
    int hp = 6;
    setHP(getHP()+hp);
    return this+" uses their power to restore "+hp+" HP and " + restoreSpecial(6) + " " + getSpecialName();
  }
}
