public class Room {
  public String description = "";
  private int treasure;
  private Player[] players = new Player[5];

  public Room(String description) {
    this.description = description;
    treasure = 0;
  }

  public Room(String description, Player[] a, int treasure) {
    this.description = description;
    this.treasure = treasure;

    //fill array of players currently in room
    for (int i = 0; i < players.length; i++) {
      players[i] = a[i];
    }
  }

  public Room(String description, Player a, int treasure) {
    this.description = description;
    this.treasure = treasure;
    players[0] = a;
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
    int count = 0;

    while (players[count] != null) {
      count++;
    }

    players[count] = p;


    //REMOVEREMOVEREMOVE
    for (int i = 0; i < players.length; i++) {
      System.out.println(players[i]);
    }
  }

  //determines if the room has treasure
  public boolean hasTreasure() {
    if (treasure > 0) {
      return true;
    } else return false;
  }

//determines if there is at least 1 human player in the room
  public boolean hasPlayer(Player p) {
    for (int i = 0; i < players.length; i++) {
      if (players[i] == p) {
        return true;
      }
    }
    return false;
  }

//allows player to take treasure if the above method returns true
  public void takeTreasure(Player p) {
    p.setTreasure(treasure);
    treasure = 0;
  }
}
