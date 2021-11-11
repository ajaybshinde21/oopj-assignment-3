public class Player {

  private String name;
  private int totalRun;
  private int numberOfWickets;
  private int numberOfMatches;
  private String countryName;
  private int numberOfCenturies;
  private String category;

  Player(
    String name,
    int totalRun,
    int numberOfWickets,
    int numberOfMatches,
    String countryName,
    int numberOfCenturies
  ) {
    this.name = name;
    this.totalRun = totalRun;
    this.numberOfWickets = numberOfWickets;
    this.numberOfMatches = numberOfMatches;
    this.countryName = countryName;
    this.numberOfCenturies = numberOfCenturies;
    this.category = null;
  }

  @Override
  public String toString() {
    return (
      "name=" +
      name +
      ", totalRun=" +
      totalRun +
      ", numberOfWickets=" +
      numberOfWickets +
      ", numberOfMatches=" +
      numberOfMatches +
      ", countryName=" +
      countryName +
      ", numberOfCenturies=" +
      numberOfCenturies +
      ", category=" +
      category +
      ""
    );
  }

  public String getName() {
    return this.name;
  }

  public int getTotalRun() {
    return this.totalRun;
  }

  public int getNumberOfCenturies() {
    return this.numberOfCenturies;
  }

  // setters

  public void setName(String name) {
    this.name = name;
  }

  public void setTotalRun(int totalRun) {
    this.totalRun = totalRun;
  }

  public void setNumberOfWickets(int numberOfTotalWickets) {
    this.numberOfWickets = numberOfTotalWickets;
  }

  public void setNumberOfMatches(int numberOfMatches) {
    this.numberOfMatches = numberOfMatches;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public void setNumberOfCenturies(int numberOfCenturies) {
    this.numberOfCenturies = numberOfCenturies;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}
