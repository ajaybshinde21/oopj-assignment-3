import java.util.Comparator;

public class NamePlayerComparator implements Comparator<Player> {

  @Override
  public int compare(Player player1, Player player2) {
    if (player1.getName().compareTo(player2.getName()) < 0) return -1; else if (
      player1.getName().compareTo(player2.getName()) > 0
    ) return 1;
    return 0;
  }
}
