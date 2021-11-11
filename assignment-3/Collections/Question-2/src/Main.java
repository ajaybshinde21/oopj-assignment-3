import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

  static ArrayList<Player> playerArrayList = null;

  public static void main(String[] args) {
    while (true) {
      displayOperations();
      int t = Console.getIntegerInput();
      performOperation(t);
    }
  }

  public static void displayOperations() {
    System.out.println("1. Add Players");
    System.out.println("2. Remove Players");
    System.out.println("3. Update Players");
    System.out.println("4. Display All Players");
    System.out.println("5. Display Single Player");
    System.out.println("6. Display Highest ScoringPlayer");
    System.out.println("7. Sort by run");
    System.out.println("8. Sort by name");
    System.out.println("9. Update categories");
    System.out.println("10. Remove Players having less than 100 runs");

    Console.addEmptyLine(1);
  }

  public static void performOperation(int t) {
    switch (t) {
      case 1: // add elements
        playerArrayList = getPlayerArrayList();
        break;
      case 2:
        // remove element
        playerArrayList = removePlayerFromList();
        break;
      case 3:
        // update element
        playerArrayList = updatePlayerArrayList();
        break;
      case 4:
        // display all employee
        if (playerArrayList == null) Console.notify(
          "player Arrray List is empty"
        );
        Console.displayPlayers(playerArrayList);
        break;
      case 5: // display single employee
        displayPlayer();
        break;
      case 6:
        // Display Highest ScoringPlayer
        displayHighestScoringPlayer();
        break;
      case 7:
        // sort by run
        Comparator<Player> totalRunComparatorObj = new TotalRunComparator();
        Collections.sort(playerArrayList, totalRunComparatorObj);
        Collections.reverse(playerArrayList);
        System.out.println("Player list sorted by descending order of runs");
        Console.addEmptyLine(1);
        break;
      case 8:
        // Sort by name
        Comparator<Player> nameComparatorObj = new NamePlayerComparator();
        Collections.sort(playerArrayList, nameComparatorObj);
        System.out.println("Player list sorted by ascending order of Name");
        Console.addEmptyLine(1);
        break;
      case 9:
        // Update categories
        updateCategory();
        break;
      case 10:
        removePlayersLessThanHundredRuns();
        break;
      default:
        Console.notify("Exiting Program");
    }
  }

  public static ArrayList<Player> getPlayerArrayList() {
    ArrayList<Player> alp = new ArrayList<>();
    alp.add(new Player("a", 23231, 23, 132, "IND", 50));
    alp.add(new Player("b", 31, 223, 322, "IND", 0));
    alp.add(new Player("c", 6231, 93, 231, "IND", 30));
    alp.add(new Player("d", 45231, 43, 132, "IND", 40));
    alp.add(new Player("e", 24231, 23, 332, "IND", 20));
    return alp;
  }

  public static ArrayList<Player> removePlayerFromList() {
    System.out.println("Enter player name to delete:");
    System.out.println("type clear to delete all:");
    String name = Console.getStringInput();
    if (name.equals("clear")) {
      playerArrayList.clear();
      System.out.println("Player Array List cleared.");
    } else {
      int index = findIndexOf(name);
      if (index == -1) {
        System.out.println("Wrong Input");
        System.exit(0);
      }
      playerArrayList.remove(index);
      Console.notify("removed", index, name);
    }

    return playerArrayList;
  }

  public static int findIndexOf(String name) {
    int index = 0;
    for (Player p : playerArrayList) {
      if (p.getName().equals(name)) {
        return index;
      }
      index += 1;
    }
    return -1;
  }

  public static ArrayList<Player> updatePlayerArrayList() {
    // check if playerArrayList has elements or not
    if (playerArrayList == null) {
      Console.notify("player ArrayList is empty");
    }

    System.out.println("Enter player name to update:");
    String name = Console.getStringInput();
    int index = findIndexOf(name);
    if (index == -1) {
      System.out.println("Wrong Input");
      System.exit(0);
    }
    Player player = playerArrayList.get(index);
    Console.addEmptyLine(1);
    System.out.println("Select what to update :");
    System.out.println("1.name 2.totalRun 3. wickets");
    System.out.println("4.numberOfMatches 5. countryName");
    System.out.println("7.numberOfCenturies");
    int updateChoice = Console.getIntegerInput();
    switch (updateChoice) {
      case 1:
        System.out.print("Enter New name:");
        player.setName(Console.getStringInput());
        break;
      case 2:
        System.out.print("Enter New TotalRun:");
        player.setTotalRun(Console.getIntegerInput());
        break;
      case 3:
        System.out.print("Enter New number of wickets:");
        player.setNumberOfWickets(Console.getIntegerInput());
        break;
      case 4:
        System.out.print("Enter New number of matches:");
        player.setNumberOfMatches(Console.getIntegerInput());
        break;
      case 5:
        System.out.print("Enter New country:");
        player.setCountryName(Console.getStringInput());
        break;
      case 6:
        System.out.print("Enter New number of Centuries:");
        player.setNumberOfCenturies(Console.getIntegerInput());
        break;
      default:
        System.out.print("Wrong input");
        System.exit(0);
    }
    Console.addEmptyLine(1);
    Console.notify("updated", index, name);

    return playerArrayList;
  }

  public static void displayPlayer() {
    System.out.println("Enter player name to display info");
    String name = Console.getStringInput();
    int index = findIndexOf(name);
    if (index == -1) {
      System.out.println("Wrong Input");
      System.exit(0);
    }

    System.out.println(playerArrayList.get(index));
    Console.addEmptyLine(1);
    Console.notify("displayed", index, name);
  }

  public static void displayHighestScoringPlayer() {
    Comparator<Player> highestScoringComparatorObj = new HighestScoringComparator();
    Player p = Collections.max(playerArrayList, highestScoringComparatorObj);
    System.out.println("Highest Scoring Player is " + p.getName());
    System.out.println("Scored " + p.getTotalRun() + " runs");

    Console.addEmptyLine(1);
  }

  public static void updateCategory() {
    if (playerArrayList == null) {
      Console.notify("player ArrayList is empty");
    }
    for (Player p : playerArrayList) {
      if (p.getNumberOfCenturies() > 10) p.setCategory("A"); else p.setCategory(
        "B"
      );
    }
    System.out.println("updated categories");
    Console.addEmptyLine(1);
  }

  public static void removePlayersLessThanHundredRuns() {
    if (playerArrayList == null) {
      Console.notify("player ArrayList is empty");
    }

    int index = 0;
    int indexToDelete = 0;
    boolean isLowScoringPlayerFound = false;
    String playerName = "";
    for (Player p : playerArrayList) {
      if (p.getTotalRun() < 100) {
        indexToDelete = index;
        isLowScoringPlayerFound = true;
        playerName = p.getName();
      }
      index += 1;
    }
    if (isLowScoringPlayerFound) {
      playerArrayList.remove(indexToDelete);
      Console.notify("Player removed", indexToDelete, playerName);
    } else {
      System.out.println("No Player has scored less than 100 runs");
      Console.addEmptyLine(1);
    }
  }
}
