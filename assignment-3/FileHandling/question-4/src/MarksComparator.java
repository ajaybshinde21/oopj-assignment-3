import java.util.Comparator;

public class MarksComparator implements Comparator<Student> {

  @Override
  public int compare(Student student1, Student student2) {
    if (student1.getMarks() > student2.getMarks()) return 1; else if (
      student1.getMarks() < student2.getMarks()
    ) return -1;
    return 0;
  }
}
