package views;

import java.util.*;

import parents.*;
import repositories.StoreRepository;

public class Recomendation {

  public static void findRecomend() {
    List<Product> tempRecomd = new ArrayList<Product>(StoreRepository.getAllProduct());
    Collections.sort(tempRecomd, Comparator.comparing(Product::getPrice));
    List<Product> tempItemData = new ArrayList<>();
    List<Product> tempServiceData = new ArrayList<>();
    for (Product product : tempRecomd) {
      if (product instanceof Items) {
        tempItemData.add(product);
      } else if (product instanceof Services) {
        tempServiceData.add(product);
      }
    }
    List<Product> recomendData = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      recomendData.add(tempItemData.get(i));
    }
    for (int i = 0; i < 10; i++) {
      recomendData.add(tempServiceData.get(i));
    }
    int i = 1;
    ItemsAndServicesProduct.getTemplateMenuProductHeader();
    String leftAlignFormat = "| %-2d | %-14s | %-44s | %-11s| %-18s |%n";

    for (Product product : recomendData) {

      if (product instanceof Items) {
        System.out.format(leftAlignFormat, i++, product.getProductID(),
            product.getProductDescription(),
            ((Items) product).getUnitOfStock(),
            product.price());
      }
      if (product instanceof Services) {
        System.out.format(leftAlignFormat, i++, product.getProductID(),
            product.getProductDescription(),
            ((Services) product).getUserUsage(),
            ((Services) product).price());
      }
    }
    ItemsAndServicesProduct.getTemplateMenuProductFooter();
  }

}