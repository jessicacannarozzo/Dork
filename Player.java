public class Player {
  public String name;
  public String message;
  protected int health;
  protected int treasure;

//constructors
  Player(String name, int health, int treasure, String message) {
    this.name = name;
    this.health = health;
    this.treasure = treasure;
    this.message = message;
  }

  Player(String name, int health, int treasure) {
    this.name = name;
    this.health = health;
    this.treasure = treasure;
    this.message = "";
  }

  Player(String name, int health) {
    this.name = name;
    this.health = health;
    this.treasure = 0;
    this.message = "";
  }

  Player(String name) {
    this.name = name;
    this.health = 100;
    this.treasure = 0;
    this.message = "";
  }

  //getters
  public String getName(){return name;}
  public int getHealth(){return health;}
  public int getTreasure(){return treasure;}
  public String getMessage(){return message;}

//set health, enter a neg value to lower health
  public void setHealth(int h) {
    this.health += h;
  }

//set treasure, enter a neg value to lower treasure
  public void setTreasure(int t) {
    this.treasure += t;
  }
}
