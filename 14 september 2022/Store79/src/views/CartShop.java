package views;

import java.util.HashMap;

public class CartShop {

  private static HashMap<String, String> putProductID = new HashMap<>();// kode nama barang
  private static HashMap<String, Integer> putQuantity = new HashMap<>();// kode Harga
  private static int stock;

  public static void addProduct(String produdId, Integer quantity) {
    putQuantity.put(produdId, quantity);
    stock -= quantity;
  }

  public static void getCartShopTable() {
    String line = "+----+----------------+------------------------------------------+------------+--------------------+--------------------+%n";
    String head = "| No | Product ID     | Product Description                      | Quantity   |      Price         |  Total Price       |%n";
    String footer = "| 00 |   Back To Main Menu                                                                                              |%n";
    String leftAlignFormat = "| %-2d | %-14s | %-44s | %-11s| %-18s |%n";
    System.out.format(line);
    System.out.format(head);
    System.out.format(line);

    for (String kode : putProductID.keySet()) {
      if (putProductID.get(kode).length() <= 7) {
        System.out.println(kode + "\t" + putProductID.get(kode) + "\t\t" + putQuantity.get(kode));
      }

      System.out.format(line);
      System.out.format(footer);
      System.out.format(line);
    }
  }
}