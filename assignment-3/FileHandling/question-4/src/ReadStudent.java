import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ReadStudent {

  public static void main(String[] args) {
    //Read the objects from the file,
    try {
      ArrayList<Student> studentList = getStudentData();
      printStudentData(studentList);
      // Find out result and display the student details along with result.
      ArrayList<Result> resultList = getStudentResult(studentList);
      printResultData(resultList);
      //Find out how many no of students passed and failed in a particular Subject.
      filterResultBySubject(resultList);

      // *Sort the students object based on marks.
      Comparator<Student> marksComparatorObj = new MarksComparator();
      Collections.sort(studentList, marksComparatorObj);
      System.out.println("\nStudents data after sort");
      printStudentData(studentList);
    } catch (ClassNotFoundException e) {
      System.out.println(e.getCause());
    } catch (FileNotFoundException e) {
      System.out.println("The file does not exist or is a directory");
    } catch (IOException e) {
      System.out.println("I/O error occured");
    }
  }

  public static ArrayList<Student> getStudentData()
    throws FileNotFoundException, IOException, ClassNotFoundException {
    ArrayList<Student> studentList = new ArrayList<>();
    File file = new File("students.txt");
    if (!file.exists()) {
      System.out.println("File Does not exist");
      System.exit(0);
    }
    try (
      ObjectInputStream objectInputStream = new ObjectInputStream(
        new FileInputStream(file)
      );
    ) {
      try {
        while (true) {
          studentList.add((Student) objectInputStream.readObject());
        }
      } catch (EOFException e) {}
    }

    return studentList;
  }

  public static void printStudentData(ArrayList<Student> list) {
    for (Student s : list) {
      System.out.println(s);
    }
  }

  public static void printResultData(ArrayList<Result> list) {
    System.out.println(list.size());
    for (Result s : list) {
      System.out.println(s);
    }
  }

  public static ArrayList<Result> getStudentResult(ArrayList<Student> list) {
    // Find out result and display the student details along with result.
    ArrayList<Result> resultList = new ArrayList<>();
    double passingMarks = 40.0;
    boolean isPass = false;
    for (Student s : list) {
      if (s.getMarks() < passingMarks) resultList.add(
        new Result(isPass, s)
      ); else resultList.add(new Result(!isPass, s));
    }
    return resultList;
  }

  public static void filterResultBySubject(ArrayList<Result> list) {
    // Find out how many no of students passed and failed in a particular
    // Subject.
    int passedStudents = 0;
    for (Result e : list) {
      if (e.getIsPass()) passedStudents++;
    }
    System.out.println(passedStudents + " Students Passed in Subject");
    System.out.println(
      list.size() - passedStudents + " Students Failed in Subject"
    );
  }
}
