import java.util.Scanner;

public class Dork {
  public String input = "";
  public Node current;
  Scanner s = new Scanner(System.in);

  public boolean quit() {
    System.out.println("Are you sure you would like to quit? Type 'Y' for yes, 'N' for no.");

    if (s.nextLine().equalsIgnoreCase("y")) {
      return true;
    }
    else return false;
  }

  public void formatRooms() {
    //starting room
    current = new Node(new Room("You arrive inside the mudroom of a large, haunted castle. There is a door to your west and a door north."));
    current.setNorth(new Node(new Room("You are now in a large common room. There are doors all around you. You see a man standing in the middle of the room, looking confused.")));
    current.getNorth().setSouth(current);
    current.getNorth().getCurrent().playerEnters(new Player("Bob", false, "What do you call a fake noodle? An impasta!!!!")); //populate with NPC
    current.setWest(new Node(new Room("You are in a kitchen. There is a door to your east.")));
    current.getWest().setEast(current);

    current = current.getNorth(); //change current
    current.setNorth(new Node(new Room("The room is dark. You can see light coming from the door to your east.")));
    current.getNorth().setSouth(current);
    current.setWest(new Node(new Room("You are in a large dining room. There is plenty of food and you notice someone's left their wallet behind!", 50, 30)));
    current.getWest().setEast(current);
    current.setEast(new Node(new Room("You are in a small library with old books. There is a door to the north.")));
    Node temp = current.getEast();
    current.getEast().setWest(current);

    current = current.getNorth(); //change current
    current.setEast(new Node(new Room("You are in a small room with a rope ladder at the corner. There is also an exit to the south.")));
    current.getEast().setWest(current);

    current = current.getEast();
    current.setSouth(temp);
    current.getSouth().setNorth(current);

    //reset current
    current = current.getSouth().getWest().getSouth();

    System.out.println("Map formatted.");
  }

  public void play() {
    System.out.println("\nWelcome to Dorkopeia, the land of the Dorks. What is your name?");
    Player p = new Player(s.nextLine(), true);

    System.out.println("Nice to meet you, " + p.getName() +". Type 'help' for available commands.\n");
    System.out.println(current.getCurrent().getDescription());
    current.getCurrent().playerEnters(p);
    while (p.getHealth() > 0) {
      input = s.nextLine();
      if (input.equalsIgnoreCase("help")) {
        System.out.println("Available commands: HELP, LOOK, GO NORTH, GO SOUTH, GO WEST, GO EAST, TAKE, STATUS, TALK, FIGHT, QUIT");
      } else if (input.equalsIgnoreCase("look")) {
        System.out.println(current.getCurrent().getDescription());
      } else if (input.equalsIgnoreCase("go north")) {
        if (current.getNorth() != null) {
          current.getCurrent().playerExits();
          current = current.getNorth();
          current.getCurrent().playerEnters(p);
          System.out.println(current.getCurrent().getDescription());
        } else {
          System.out.println("There is no way to go north.");
        }
      } else if (input.equalsIgnoreCase("go south")) {
        if (current.getSouth() != null) {
          current.getCurrent().playerExits();
          current = current.getSouth();
          current.getCurrent().playerEnters(p);
          System.out.println(current.getCurrent().getDescription());
        } else {
          System.out.println("There is no way to go south.");
        }
      } else if (input.equalsIgnoreCase("go east")) {
        if (current.getEast() != null) {
          current.getCurrent().playerExits();
          current = current.getEast();
          current.getCurrent().playerEnters(p);
          System.out.println(current.getCurrent().getDescription());
        } else {
          System.out.println("There is no way to go east.");
        }
      } else if (input.equalsIgnoreCase("go west")) {
        if (current.getWest() != null) {
          current.getCurrent().playerExits();
          current = current.getWest();
          current.getCurrent().playerEnters(p);
          System.out.println(current.getCurrent().getDescription());
        } else {
          System.out.println("There is no way to go west.");
        }
      } else if (input.equalsIgnoreCase("take")) {
        if (current.getCurrent().hasTreasure()) {
        System.out.println("You received " + current.getCurrent().getTreasure() + " gold coins!");
          current.getCurrent().takeTreasure(p);
        } else {
          System.out.println("There is no treasure!");
        }
        if (current.getCurrent().hasFood()) {
        System.out.println("You restored " + current.getCurrent().getFood() + " health!");
            current.getCurrent().takeFood(p);
        } else {
          System.out.println("There is no food!");
        }
      } else if (input.equalsIgnoreCase("status")) {
          System.out.println(p.status());
      } else if (input.equalsIgnoreCase("talk")) {
          current.getCurrent().talk();
      } else if (input.equalsIgnoreCase("fight")) {
        System.out.println("Who would you like to fight with?");
        input = s.nextLine();

        if (input.equalsIgnoreCase("me")) {
          if (Math.random() > 0.5) {
            System.out.println("Suicide is never the answer.");
          } else {
            System.out.println("Ha-ha, very funny.");
          }
        } else {
          current.getCurrent().fight(p, input);
        }
      } else if (input.equalsIgnoreCase("quit")) {
          if (this.quit()) {
            break;
          }
      } else {
        System.out.println("Unknown command.");
      }
    }

      if (p.getHealth() < 1) {
        System.out.println("You died!");
      } else {
        System.out.println("Quitters never prosper...");
      }
  }

  public static void main(String[] args) {
    Dork adventure = new Dork();
    adventure.formatRooms();
    adventure.play();
  }
}
