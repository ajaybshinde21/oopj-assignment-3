import java.io.Serializable;
import java.util.Comparator;

public class Student implements Serializable {

  private int studentId;
  private String name;
  private double marks;
  private String subject;

  public Student(int studentId, String name, double marks, String subject) {
    this.studentId = studentId;
    this.name = name;
    this.marks = marks;
    this.subject = subject;
  }

  public double getMarks() {
    return this.marks;
  }

  public String toString() {
    return (
      this.studentId +
      " | " +
      this.name +
      " | " +
      this.marks +
      " | " +
      this.subject
    );
  }
}
