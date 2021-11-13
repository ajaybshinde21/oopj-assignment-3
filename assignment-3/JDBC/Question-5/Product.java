public class Product {

  private int id;
  private String name;
  private String category;
  private double price;
  private String manufacture;
  private int quantity;

  public Product(
    int id,
    String name,
    String category,
    double price,
    String manufacture,
    int quantity
  ) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.price = price;
    this.manufacture = manufacture;
    this.quantity = quantity;
  }

  public double getPrice() {
    return this.price;
  }

  @Override
  public String toString() {
    return (
      "id=" +
      id +
      ", name=" +
      name +
      ", category=" +
      category +
      ", price=" +
      price +
      ", manufacture=" +
      manufacture +
      ", quantity=" +
      quantity
    );
  }
}
