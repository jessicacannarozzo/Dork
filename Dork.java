import java.util.Scanner;

public class Dork {
  //AVAILABLE COMMANDS: help, look, go north, go south, go west, go east, take
  String input = "";
  Node current;
  Scanner s = new Scanner(System.in);

  public void formatRooms() {
    //starting room
    current = new Node(new Room("You arrive inside the mudroom of a large, haunted castle. There is a door to your west and a door north."));
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

  public void play() {
    System.out.println("\nWelcome to Dorkopeia, the land of the Dorks. What is your name?");
    Player p = new Player(s.nextLine());

    System.out.println("Nice to meet you, " + p.getName() +". Type 'help' for available commands.\n");

    while (!input.equalsIgnoreCase("quit")) {


      if (input.equalsIgnoreCase("help")) {
        System.out.println("Available commands: HELP, LOOK, GO NORTH, GO SOUTH, GO WEST, GO EAST, TAKE");
      } else if (input.equalsIgnoreCase("look")) {
        
      } else if (input.equalsIgnoreCase("go north")) {

      } else if (input.equalsIgnoreCase("go south")) {

      } else if (input.equalsIgnoreCase("go east")) {

      } else if (input.equalsIgnoreCase("go west")) {

      } else if (input.equalsIgnoreCase("take")) {

      }
    }
  }

  public static void main(String[] args) {
    Dork adventure = new Dork();
    adventure.formatRooms();
    adventure.play();
  }
}
