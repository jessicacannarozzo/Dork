public class Node {
  private Node north;
  private Node south;
  private Node east;
  private Node west;
  private Room current; //current room

  public Node(Room r) {
    this.current = r;
    north = null;
    south = null;
    east = null;
    west = null;
  }

  //getters
  public Node getNorth(){ return north; }
  public Node getSouth(){ return south; }
  public Node getEast(){ return east; }
  public Node getWest(){ return west; }
  public Room getCurrent(){ return current; }

  //setters
  public void setNorth(Node n) { this.north = n; }
  public void setSouth(Node n) { this.south = n; }
  public void setEast(Node n) { this.east = n; }
  public void setWest(Node n) { this.west = n; }

}
