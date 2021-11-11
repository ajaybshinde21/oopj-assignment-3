import java.util.ArrayList;
import java.util.Scanner;

class Console {

  static Scanner input = new Scanner(System.in);

  public static int getIntegerInput() {
    return input.nextInt();
  }

  public static String getStringInput() {
    return input.next();
  }

  public static void notify(String action) {
    System.out.println(action);
    System.exit(0);
  }

  public static void notify(String action, int index, String playerName) {
    System.out.println(action + " " + playerName + " at index :" + index);
    addEmptyLine(1);
  }

  public static void addEmptyLine(int numberOfEmptyLines) {
    while (numberOfEmptyLines != 0) {
      System.out.println();
      numberOfEmptyLines -= 1;
    }
  }

  public static void displayPlayers(ArrayList<Player> playerArrayList) {
    if (playerArrayList.size() == 0) {
      System.out.println("Player ArrayList is empty");
    } else {
      for (Player p : playerArrayList) {
        System.out.println(p);
      }
      addEmptyLine(1);
    }
  }
}
