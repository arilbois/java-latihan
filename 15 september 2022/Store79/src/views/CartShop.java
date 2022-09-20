package views;

import java.util.ArrayList;
import java.util.List;

import parents.*;
import repositories.StoreRepository;

public class CartShop {

  private static String productID;
  private static String productDescription;
  private static int quantity;
  private static double totalPrice;

  public CartShop(String productID, String productDescription, int quantity, double totalPrice) {
    this.productID = productID;
    this.productDescription = productDescription;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
    addProduct(productID, quantity);
    Data(productID, productDescription, quantity, totalPrice);
  }

  public CartShop() {
  }

  public static String getProductID() {
    return productID;
  }

  public static void setProductID(String productID) {
    CartShop.productID = productID;
  }

  public static String getProductDescription() {
    return productDescription;
  }

  public static void setProductDescription(String productDescription) {
    CartShop.productDescription = productDescription;
  }

  public static int getQuantity() {
    return quantity;
  }

  public static void setQuantity(int quantity) {
    CartShop.quantity = quantity;
  }

  public static double getTotalPrice() {
    return totalPrice;
  }

  public static void setTotalPrice(double totalPrice) {
    CartShop.totalPrice = totalPrice;
  }

  public static void addProduct(String productId, Integer quantity) {
    for (Product product : StoreRepository.getAllProduct()) {
      if (product.getProductID().equalsIgnoreCase(productId)) {
        List<CartShop> Cartlist = new ArrayList<>();
        CartShop cart = new CartShop(product.getProductID(), product.getProductDescription(), quantity,
            product.getPrice() * quantity);
        Cartlist.add(cart);

      }
    }
  }

  public void Data(String n, String a, Integer c, double d) {

    setProductID(n);
    setProductDescription(a);
    setQuantity(c);
    setTotalPrice(d);
  }

  public static void getCartShopTable() {
    String line = "+----+----------------+------------------------------------------+------------+--------------------+--------------------+%n";
    String head = "| No | Product ID     | Product Description                      | Quantity   |      Price         |  Total Price       |%n";
    String footer = "| 00 |   Back To Main Menu                                                                                              |%n";
    String leftAlignFormat = "| %-2d | %-14s | %-44s | %-11s| %-18s |%n";
    System.out.format(line);
    System.out.format(head);
    System.out.format(line);
    System.out.println(getProductID() + getProductDescription() + getQuantity() + getTotalPrice());
    System.out.format(line);
    System.out.format(footer);
    System.out.format(line);
  }
}