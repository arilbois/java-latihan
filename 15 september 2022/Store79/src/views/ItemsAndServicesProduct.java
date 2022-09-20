package views;

import parents.Items;
import parents.Product;
import parents.Services;
import repositories.StoreRepository;

public class ItemsAndServicesProduct extends StoreRepository {
  static String line = "+----+----------------+----------------------------------------------+------------+--------------------+%n";
  static String head = "| No | Product ID     | Product Description                          | Quantity   |      Price         |%n";
  static String footer = "| 00 |   Back To Main Menu                                                                             |%n";

  public static void getTemplateMenuProductHeader() {
    System.out.format(line);
    System.out.format(head);
    System.out.format(line);
  }

  public static void getTemplateMenuProductFooter() {
    System.out.format(line);
    System.out.format(footer);
    System.out.format(line);

  }

  public static void getItemsAndServicesProduct(String productType) {
    getTemplateMenuProductHeader();
    String leftAlignFormat = "| %-2d | %-14s | %-44s | %-11s| %-18s |%n";
    int i = 1;
    for (Product product : getAllProduct()) {
      if (product.getProductType().equalsIgnoreCase(productType)) {
        if (product.getProductType().equalsIgnoreCase("FoodandBeverages")
            || product.getProductType().equalsIgnoreCase("Garment") || product.getProductType()
                .equalsIgnoreCase("Material")) {
          System.out.format(leftAlignFormat, i++, product.getProductID(), product.getProductDescription(),
              ((Items) product).getUnitOfStock(),
              product.price());
        } else {
          System.out.format(leftAlignFormat, i++, product.getProductID(), product.getProductDescription(),
              ((Services) product).getUserUsage(),
              ((Services) product).price());
        }
      }
    }
    getTemplateMenuProductFooter();
  }
}
