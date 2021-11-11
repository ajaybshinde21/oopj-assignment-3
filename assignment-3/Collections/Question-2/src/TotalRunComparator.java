import java.util.Comparator;

public class TotalRunComparator implements Comparator<Player> {

  @Override
  public int compare(Player player1, Player player2) {
    if (player1.getTotalRun() > player2.getTotalRun()) return 1; else if (
      player1.getTotalRun() < player2.getTotalRun()
    ) return -1; else return 0;
  }
}
