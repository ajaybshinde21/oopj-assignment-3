public class Result {

  private boolean isPass;
  Student student;

  Result(boolean isPass, Student student) {
    this.student = student;
    this.isPass = isPass;
  }

  public boolean getIsPass() {
    return this.isPass;
  }

  public String toString() {
    if (isPass) return "Passed ->" + this.student;
    return "Failed ->" + this.student;
  }
}
