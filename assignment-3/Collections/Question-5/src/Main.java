import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Collection;
import java.util.Collections;
public class Main {

  static HashMap<Integer, Book> hashMapObj;

  public static void main(String[] args) {
    while (true) {
      displayMenu();
      int userChoice = getIntegerInput();
      performOperation(userChoice);
    }
  }

  public static void displayMenu() {
    System.out.println("1. Create and add five book objects in Map");
    System.out.println("2. Display Map");
    System.out.println("3. Display Book Obj by giving key");
    System.out.println("4. Reduce prices by 10% of publication ");
    System.out.println("5. Delete entry set by book name");
    System.out.println("6. Delete entry set by map key");
  }

  public static int getIntegerInput() {
    Scanner input = new Scanner(System.in);
    return input.nextInt();
  }

  public static String getStringInput() {
    Scanner input = new Scanner(System.in);
    return input.next();
  }

  public static void addEmptyLine() {
    System.out.println();
  }

  public static void performOperation(int userChoice) {
    switch (userChoice) {
      case 1:
        {
          // Create 5 Objects of book class and add all in the map
          Book b1 = new Book("C", 400, "John Doe", 12341234L, "Pearson");
          Book b2 = new Book("OS", 500, "Jane Doe", 11112222L, "Pearson");
          Book b3 = new Book("Java", 445, "John Smith", 470028610L, "Wiley");
          Book b4 = new Book("Algo", 600, "Joe Schmo", 1848000707L, "Springer");
          Book b5 = new Book("Ruby", 550, "Richard S", 26214087L, "MIT Press");
          hashMapObj = new HashMap<>();

          hashMapObj.put(1, b1);
          hashMapObj.put(2, b2);
          hashMapObj.put(3, b3);
          hashMapObj.put(4, b4);
          hashMapObj.put(5, b5);
          break;
        }
      case 2:
        {
          // Display Map
          for (Map.Entry<Integer, Book> e : hashMapObj.entrySet()) {
            System.out.println(e);
          }
          addEmptyLine();
          break;
        }
      case 3:
        {
          // Display single Book
          System.out.println("Enter Key to Search");
          int userKey = getIntegerInput();
          Book bookObj = hashMapObj.get(userKey);
          System.out.println(bookObj);
          addEmptyLine();
          break;
        }
      case 4:
        {
          // reduce price by 10%
          if (hashMapObj == null) {
            System.out.println("No entry sets in Map, add data");
            addEmptyLine();
            break;
          }
          System.out.println("Enter Publication Name");
          String publicationName = getStringInput();
          Book bookObj;
          boolean isBookDeleted = false;

          for (Map.Entry<Integer, Book> e : hashMapObj.entrySet()) {
            bookObj = e.getValue();
            if (bookObj.getPublisher().equalsIgnoreCase(publicationName)) {
              double newPrice =
                bookObj.getPrice() - bookObj.getPrice() * (10.0 / 100);
              bookObj.setPrice(newPrice);
              isBookDeleted = true;
            }
          }

          if (isBookDeleted) {
            System.out.println("Updated Prices");
            addEmptyLine();
            System.out.println("list of Books affected");
            for (Map.Entry<Integer, Book> e : hashMapObj.entrySet()) {
              bookObj = e.getValue();
              if (bookObj.getPublisher().equalsIgnoreCase(publicationName)) {
                System.out.println(bookObj);
              }
            }
            addEmptyLine();
          } else {
            System.out.println("Publication does not exist in map ");
          }
          break;
        }
      case 5:
        {
          // delete entry set by book mame
          System.out.println("Enter book name to delete");
          String bookName = getStringInput();
          Book bookObj;
          Integer keyOfEntrySetToDelete = 0;
          for (Map.Entry<Integer, Book> e : hashMapObj.entrySet()) {
            bookObj = e.getValue();
            if (bookObj.getBookName().equalsIgnoreCase(bookName)) {
              keyOfEntrySetToDelete = e.getKey();
            }
          }
          hashMapObj.remove(keyOfEntrySetToDelete);
          System.out.println(
            "Entry Set containing book " + bookName + " deleted."
          );
          addEmptyLine();
          break;
        }
      case 6:
        {
          // delete entry set by key
          System.out.println("Enter key to delete");
          Integer keyOfEntrySetToDelete = getIntegerInput();
          if (hashMapObj.containsKey(keyOfEntrySetToDelete)) {
            Book bookObj = hashMapObj.get(keyOfEntrySetToDelete);
            hashMapObj.remove(keyOfEntrySetToDelete);
            System.out.println("Deleted contents :");
            System.out.println("Key = " + keyOfEntrySetToDelete);
            System.out.println("Value = " + bookObj);
            addEmptyLine();
          } else {
            System.out.println("Cannot delete : given key does not exist");
            addEmptyLine();
          }
          break;
        }
     
      default:
        {
          System.exit(0);
        }
    }
  }
}
