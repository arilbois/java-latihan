package views;

import models.Model;
import parents.Items;
import parents.Product;
import parents.Services;
import repositories.StoreRepository;

public class ItemsAndServicesProduct extends StoreRepository {

  public static void getItemsAndServicesProduct(String productType) {
    Model.getTemplateMenuProductHeader();
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
    Model.getTemplateMenuProductFooter();
  }
}
