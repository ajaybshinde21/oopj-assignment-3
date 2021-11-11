import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayList<Student> studentList = createStudentList();
    // Write a student object (minimum five)  into the file
    try {
      writeStudents(studentList);
    } catch (FileNotFoundException e) {
      System.out.println("The file does not exist or is a directory");
    } catch (IOException e) {
      System.out.println("I/O error occured");
    }
  }

  public static ArrayList<Student> createStudentList() {
    Student s1 = new Student(123, "John Doe", 60, "C++");
    Student s2 = new Student(124, "Jane Doe", 90, "C++");
    Student s3 = new Student(125, "John Smith", 30, "C++");
    Student s4 = new Student(126, "Richard Smith", 35, "C++");
    Student s5 = new Student(127, "Joe Shmoe", 90, "C++");
    ArrayList<Student> list = new ArrayList<>();

    list.add(s1);
    list.add(s2);
    list.add(s3);
    list.add(s4);
    list.add(s5);
    return list;
  }

  public static void writeStudents(ArrayList<Student> studentsList)
    throws IOException {
    File file = new File("students.txt");
    if (!file.exists()) {
      System.out.println("File Does not exist");
      System.exit(0);
    }
    try (
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(
        new FileOutputStream(file)
      );
    ) {
      for (Student s : studentsList) {
        objectOutputStream.writeObject(s);
      }
    }
  }
}
