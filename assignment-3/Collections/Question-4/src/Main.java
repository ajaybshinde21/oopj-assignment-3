import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // create linked list(Integer)
    LinkedList<Integer> list = new LinkedList<>();

    // add elements in list to work with
    list.add(1);
    list.add(2);
    list.add(3);

    // a.Insert at the beginning.
    list.addFirst(0);
    Console.notify("element added at first position");
    Console.print(list);

    //	b. Insert at given position.
    Console.notify("Enter index at which to insert new element:");
    int index = Console.getIntegerInput();
    if (index > list.size()) {
      Console.notify("index is greater than list size \nExiting Program");
      System.exit(0);
    }

    Console.notify("Enter element to add :");
    int value = Console.getIntegerInput();
    list.add(index, value);
    Console.print(list);

    //		c. Insert after a given node.
    Console.notify("Enter element from list after which to add new element:");
    value = Console.getIntegerInput();
    index = list.indexOf(value);
    System.out.print("Enter element to add after : " + value + " :");
    value = Console.getIntegerInput();
    list.add(index + 1, value);
    Console.print(list);

    //		d. Delete at the beginning.
    Console.notify("Deleting at beginning");
    list.removeFirst();
    Console.print(list);

    // e. Delete at given position.
    Console.notify("Enter index to delete :");
    index = Console.getIntegerInput();
    list.remove(index);
    Console.print(list);

    //f. Delete after a given node.
    Console.notify("Enter element from list after which to delete");
    value = Console.getIntegerInput();
    index = list.indexOf(value);
    if (index + 1 > list.size()) {
      System.out.println(
        "element after" + value + " does not exist." + " \nExiting Program"
      );
      System.exit(0);
    }
    list.remove(index + 1);
    Console.notify("element deleted");
    Console.print(list);

    //g. Reverse the linked list.
    Console.notify("list before reverse");
    Console.print(list);
    Collections.reverse(list);
    Console.notify("list after reverse");
    Console.print(list);
  }
}
