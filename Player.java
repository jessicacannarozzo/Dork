import java.util.LinkedList;

public class Player {
  protected String name;
  protected String message;
  protected boolean isHuman;
  protected int health;
  protected int treasure;
  protected LinkedList<String> items;

//constructors
  Player(String name, int health, int treasure, String message, boolean h) {
    this.name = name;
    this.health = health;
    this.treasure = treasure;
    this.message = message;
    this.isHuman = h;
  }

  Player(String name, int health, int treasure, boolean h) {
    this.name = name;
    this.health = health;
    this.treasure = treasure;
    this.message = "Hi, my name is " + this.name;
    this.isHuman = h;
  }

  Player(String name, int health, boolean h) {
    this.name = name;
    this.health = health;
    this.treasure = 0;
    this.message = "Hi, my name is " + this.name;
    this.isHuman = h;
  }

  Player(String name, boolean h, String m) {
    this.name = name;
    this.health = 100;
    this.treasure = 0;
    this.message = m;
    this.isHuman = h;
  }

  Player(String name, boolean h) {
    this.name = name;
    this.health = 100;
    this.treasure = 0;
    this.message = "Hi, my name is " + this.name;
    this.isHuman = h;
  }

  //getters
  public String getName(){return name;}
  public int getHealth(){return health;}
  public int getTreasure(){return treasure;}
  public String getMessage(){return message;}
  public boolean isHuman() {if (isHuman) return true; else return false;}

//set health, enter a neg value to lower health
  public void setHealth(int h) {
    this.health += h;
  }

//set treasure, enter a neg value to lower treasure
  public void setTreasure(int t) {
    this.treasure += t;
  }

//displays player status
  public String status() {
    String status = "";
      if (this.health >= 75) {
        status += "You are in good health!\n";
      } else if (this.health < 75 && this.health >= 25) {
        status += "You are in OK health.\n";
      } else {
        status += "You are near death!\n";
      }
      status += "Treasure found: " + this.treasure + " gold";
    return status;
  }

//take items
  public void takeItem(String i) {
    items.add(i);
    System.out.println(i + " was successfully added to your collection.");
  }

//view player's items
  public String viewItems() {
    return items.toString();
  }
}
