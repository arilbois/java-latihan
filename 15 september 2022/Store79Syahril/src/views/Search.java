package views;

import models.Model;
import parents.*;
import repositories.StoreRepository;

public class Search {

  public static void searchByDescription(String searchByDescription) {
    Model.getTemplateMenuProductHeader();
    String leftAlignFormat = "| %-2d | %-14s | %-44s | %-11s| %-18s |%n";
    int i = 1;
    for (Product product : StoreRepository.getAllProduct()) {
      if (product.getProductDescription().toLowerCase()
          .contains(searchByDescription.toLowerCase())) {
        if (product instanceof Items) {
          System.out.format(leftAlignFormat, i++, product.getProductID(), product.getProductDescription(),
              ((Items) product).getUnitOfStock(),
              product.price());
        }
        if (product instanceof Services) {
          System.out.format(leftAlignFormat, i++, product.getProductID(), product.getProductDescription(),
              ((Services) product).getUserUsage(),
              product.price());
        }
      }
    }
    Model.getTemplateMenuProductFooter();
  }
}
