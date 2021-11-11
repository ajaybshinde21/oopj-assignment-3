public class Book {

  private String name;
  private double price;
  private String author_name;
  private long isbnNumber;
  private String publisher;

  Book(
    String name,
    double price,
    String author_name,
    long isbnNumber,
    String publisher
  ) {
    this.name = name;
    this.price = price;
    this.author_name = author_name;
    this.isbnNumber = isbnNumber;
    this.publisher = publisher;
  }

  public String toString() {
    return (
      this.name +
      " by " +
      this.author_name +
      ", Price: " +
      this.price +
      ", ISBN: " +
      this.isbnNumber +
      ", publisher: " +
      this.publisher
    );
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getPublisher() {
    return this.publisher;
  }

  public double getPrice() {
    return this.price;
  }

  public String getBookName() {
    return this.name;
  }
}
