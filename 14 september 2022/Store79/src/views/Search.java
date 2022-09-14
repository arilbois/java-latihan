package views;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.List;

import parents.Items;
import parents.Product;
import repositories.StoreRepository;

public class Search {

  public static void searchByDescription(String searchByDescription) {
    ItemsAndServicesProduct.getTemplateMenuProductHeader();
    String leftAlignFormat = "| %-2d | %-44s | %-11s| %-18s |%n";
    int i = 1;
    for (Product product : StoreRepository.getAllProduct()) {
      if (product.getProductDescription().toLowerCase()
          .contains(searchByDescription.toLowerCase())) {
        System.out.format(leftAlignFormat, i++, product.getProductDescription(),
            ((Items) product).getUnitOfStock(),
            product.price());
      }

    }
    ItemsAndServicesProduct.getTemplateMenuProductFooter();
  }
}
