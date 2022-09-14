package views;

import parents.Items;
import parents.Product;
import parents.Services;
import repositories.StoreRepository;

public class ItemsAndServicesProduct extends StoreRepository {
  public static void getTemplateMenuProductHeader() {
    System.out.format("+----+----------------------------------------------+------------+--------------------+%n");
    System.out.format("| No |  Product Description                         | Stock/User |       Price        |%n");
    System.out.format("+----+----------------------------------------------+------------+--------------------+%n");
  }

  public static void getTemplateMenuProductFooter() {
    System.out.format("+----+----------------------------------------------+------------+--------------------+%n");
    System.out.format("+ 00 |   Back To Main Menu                                                            |%n");
    System.out.format("+----+----------------------------------------------+------------+--------------------+%n");

  }

  public static void getItemsAndServicesProduct(String productType) {
    getTemplateMenuProductHeader();
    String leftAlignFormat = "| %-2d | %-44s | %-11s| %-18s |%n";
    int i = 1;
    for (Product product : getAllProduct()) {
      if (product.getProductType().equalsIgnoreCase(productType)) {
        if (product.getProductType().equalsIgnoreCase("FoodandBeverages")
            || product.getProductType().equalsIgnoreCase("Garment") || product.getProductType()
                .equalsIgnoreCase("Material")) {
          System.out.format(leftAlignFormat, i++, product.getProductDescription(), ((Items) product).getUnitOfStock(),
              product.price());
        } else {
          System.out.format(leftAlignFormat, i++, product.getProductDescription(), ((Services) product).getUserUsage(),
              ((Services) product).price());

        }
      }
    }
    getTemplateMenuProductFooter();
  }
}
