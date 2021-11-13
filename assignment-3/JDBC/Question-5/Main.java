import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

  public static void main(String[] args)
    throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection connection = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/assignment_5",
      "root",
      "test"
    );
    String query = "SELECT * FROM product";
    PreparedStatement ps = connection.prepareStatement(query);
    ResultSet resultSet = ps.executeQuery();

    ArrayList<Product> productList = new ArrayList<>();
    while (resultSet.next()) {
      Product product = new Product(
        resultSet.getInt(1),
        resultSet.getString(2),
        resultSet.getString(3),
        resultSet.getDouble(4),
        resultSet.getString(5),
        resultSet.getInt(6)
      );
      productList.add(product);
    }
    productList = sortProductByPrice(productList);
    System.out.println("Max Price product details");
    System.out.println(productList.get(0));
    connection.close();
  }

  public static ArrayList<Product> sortProductByPrice(
    ArrayList<Product> productList
  ) {
    Comparator<Product> priceComparatorObj = new PriceComparator();
    Collections.sort(productList, priceComparatorObj);
    return productList;
  }
}
