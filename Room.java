import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class Room {
  public String description = "";
  private int treasure;
  private LinkedList<Player> players = new LinkedList<Player>();

  public Room(String description) {
    this.description = description;
    treasure = 0;
  }

  public Room(String description, ArrayList<Player> a, int treasure) {
    this.description = description;
    this.treasure = treasure;
    this.players.addAll(a);
  }

  public Room(String description, Player a, int treasure) {
    this.description = description;
    this.treasure = treasure;
    this.players.add(a);
  }

  public Room(String description, int treasure) {
    this.description = description;
    this.treasure = treasure;
  }

  //getters
  public Room getRoom(){ return this; }
  public String getDescription() { return description; }
  public int getTreasure() { return treasure; }

  //add player to room
  public void playerEnters(Player p) {
    players.add(p);
  }

  //remove player from room
  public void playerExits() {
    players.removeLast();
  }

  //determines if the room has treasure
  public boolean hasTreasure() {
    if (treasure > 0) {
      return true;
    } else return false;
  }

//determines if there is at least 1 human player in the room
  public boolean hasPlayer(Player p) {
    if (players.indexOf(p) != -1) {
      return true;
    }
    else return false;
  }

//allows player to take treasure if the above method returns true
  public void takeTreasure(Player p) {
    p.setTreasure(treasure);
    treasure = 0;
  }

//allow ncps to TALK.
  public void talk() {
    for (int i = 0; i < players.size(); i++) {
      if (!players.get(i).isHuman()) {
        System.out.println(players.get(i).getName() + " says: '" + players.get(i).getMessage() + "''");
      } else if (players.size() <= 1){
        System.out.println("There is no one around to talk.");
      }
    }
  }

  public void fight(Player a, String b) {
    boolean fight = false;
    Player x = null;
    String input = null;
    Scanner s = new Scanner(System.in);
    int damageA = 0;
    int damageX = 0;

    for (int i = 0; i < players.size(); i++) {
        if (!players.get(i).isHuman() && players.get(i).getName().equalsIgnoreCase(b)) {
          x = players.get(i);
          fight = true;
        }
    }

    if (!fight) {
      System.out.println(b + " does not exist.");
    }

    while (fight && x.getHealth() > 0 && a.getHealth() > 0) {
      damageA = (int)(Math.random()*100);
      System.out.println("You did " + damageA + " damage to " + x.getName() + ".\n");

      x.setHealth(damageA*-1);

      if (x.getHealth() > 0 && a.getHealth() > 0) {
        damageX = (int)(Math.random()*100);
        System.out.println(x.getName() + " did " + damageX + " damage to you.\n");
        a.setHealth(damageX*-1);

        System.out.println("Would you like to continue fighting? Y or N.");
        input = s.next();

        if (input.equalsIgnoreCase("n")) {
          System.out.println("Attempting to run away...");
          if (Math.random() * a.getHealth() > 20) {
            System.out.println("Success!");
            fight = false;
          } else {
            System.out.println("Failed!");
          }
        }

      } else {
        System.out.println("You killed " + x.getName() + "!\n");
        players.remove(x);
        damageA = (int)(50 + (Math.random() * 200)); //recycling variables
        a.setTreasure(damageA);
        System.out.println("You are awarded " + damageA + " gold!");
        fight = false;
      }
    }
  }
}
