public class Room {
  public String description = "";
  private int treasure;

  public Room(String description) {
    this.description = description;
    treasure = 0;
  }

  public Room(String description, int treasure) {
    this.description = description;
    this.treasure = treasure;
  }

  //getters
  public Room getRoom(){ return this; }
  public String getDescription() { return description; }
  public int getTreasure() { return treasure; }

  //determines if the room has treasure
  public boolean hasTreasure() {
    if (treasure > 0) {
      return true;
    } else return false;
  }

//allows plaer to take treasure if the above method returns true
  public void takeTreasure(Player p) {
    p.setTreasure(treasure);
    treasure = 0;
  }
}
