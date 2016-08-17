import java.util.LinkedList;
import java.util.ArrayList;

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
}
