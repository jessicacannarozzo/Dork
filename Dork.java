public class Dork {

  public void formatRooms() {
    //starting room
    Node current = new Node(new Room("Room 1"));
    current.setNorth(new Node(new Room("Room 2")));
    current.getNorth().setSouth(current);
    current.setWest(new Node(new Room("Room 3")));
    current.getWest().setEast(current);

    current = current.getNorth(); //change current
    current.setNorth(new Node(new Room("Room 4")));
    current.getNorth().setSouth(current);
    current.setWest(new Node(new Room("Room 5")));
    current.getWest().setEast(current);
    current.setEast(new Node(new Room("Room 6")));
    current.getEast().setWest(current);

    current = current.getNorth();
    current.setWest(new Node(new Room("Room 7")));
    current.getWest().setEast(current);

    System.out.println("Rooms formatted.");
  }

  public static void main(String[] args) {
    String input = "";
    Adventure game = new Adventure();

    while (!input.equalsIgnoreCase("quit")) {
      game.play();
    }
  }
}
