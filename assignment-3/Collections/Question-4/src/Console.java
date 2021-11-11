import java.util.LinkedList;
import java.util.Scanner;
import java.util.LinkedList;
class Console {
  LinkedList<Integer> list = new LinkedList<>();
  static Scanner input = new Scanner(System.in);

  public static int getIntegerInput() {
    return input.nextInt();
  }

  public static String getStringInput() {
    return input.next();
  }

  public static void notify(String action) {
    System.out.println(action);
  }

  public static void addEmptyLine(int numberOfEmptyLines) {
    while (numberOfEmptyLines != 0) {
      System.out.println();
      numberOfEmptyLines -= 1;
    }
  }
  public static void print(LinkedList<Integer> list){
    int i = 0;
    System.out.println("index\t: value");
    for(Integer ele :list){
      System.out.println(" "+i+"\t  "+ele);
      i+=1;
    }
    addEmptyLine(1);
  }
}
