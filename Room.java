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
}
