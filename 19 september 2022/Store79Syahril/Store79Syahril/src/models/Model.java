package models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import parents.*;
import validations.Validations;
import views.App;

public class Model {

  public static Boolean checkDataByIDProduct(String productId) {
    Boolean isFound = false;
    for (Product data : CartShop.allData) {
      if (data.getProductID().equalsIgnoreCase(productId)) {
        isFound = true;
      }
    }
    return isFound;
  }

  public static Integer getTotalCartShopByID(String idProduct) {
    List<CartShop> data = new ArrayList<>();
    data = CartShop.getDataCartShop();
    int totalProduct = 0;
    for (CartShop produk : data) {
      if (produk.getProduct().getProductID().equalsIgnoreCase(idProduct)) {
        totalProduct = produk.getQuantity();
      }
    }
    return totalProduct;
  }

  public static List<Product> getProductByID(String idProduct) {
    List<Product> barang = new ArrayList<>();
    for (Product data : CartShop.allData) {
      if (data.getProductID().equalsIgnoreCase(idProduct)) {
        barang.add(data);
      }
    }
    return barang;
  }

  public static Integer getStockByIDProduct(String productId) {
    Integer jumlah = 0;
    for (Product data : CartShop.allData) {
      if (data instanceof Items && data.getProductID().equalsIgnoreCase(productId)) {
        jumlah = ((Items) data).getUnitOfStock();
      }
    }
    return jumlah;
  }

  public static Integer getIndexCartShopById(String idProduct) {
    List<CartShop> data = new ArrayList<>();
    data = CartShop.getDataCartShop();
    int index = 0, i = 0;
    for (CartShop produk : data) {
      if (produk.getProduct().getProductID().equalsIgnoreCase(idProduct)) {
        index = i;
      }
      i++;
    }
    return index;
  }

  public static String choiceBuyAgain() {
    String[] choice = { "Yes", "No" };
    String choices;
    choices = Validations.inputTypeAlphabetLimit("Do you want to buy another Product (Yes/No) : ", choice);
    System.out.println("");
    return choices;
  }

  public static Double getGrandTotalCart() {
    List<CartShop> data = new ArrayList<>();
    data = CartShop.getDataCartShop();
    Double total = 0.0;

    for (CartShop product : data) {
      total += product.getTotalPrice();
    }
    return total;
  }

  public static CartShop addToCart(String idProduct) {
    CartShop item = new CartShop();
    List<Product> product = new ArrayList<>();
    Boolean isLooping = true;
    do {
      Integer stockBarang = Model.getStockByIDProduct(idProduct);
      product = Model.getProductByID(idProduct);
      Integer cartTotalProduct = Model.getTotalCartShopByID(idProduct);
      Integer quantity;
      for (Product data : product) {
        if (data.getProductType().equalsIgnoreCase("FoodandBeverages")
            || data.getProductType().equalsIgnoreCase("Garment") || data.getProductType()
                .equalsIgnoreCase("Material")) {
          quantity = Validations.inputTypeNumberLimit("Input Total Product : ", 1, (stockBarang
              - cartTotalProduct));
        } else {
          quantity = Validations.inputTypeNumber("Input Total Product : ");
        }
        if (quantity > 0) {
          if (data instanceof Items) {
            if ((quantity + cartTotalProduct) <= stockBarang) {
              item = new CartShop(data, quantity);
              isLooping = false;
            } else {
              System.out.println("Sorry, the quantity you purchased exceeds the stock item.\n");
            }
          } else {
            item = new CartShop(data, quantity);
            isLooping = false;
          }
          if (!isLooping) {
            Integer indexProductCart = Model.getIndexCartShopById(idProduct);
            if (cartTotalProduct != 0) {
              int totalBefore = CartShop.getDataCartShop().get(indexProductCart).getQuantity();
              Double priceProduct = CartShop.getDataCartShop().get(indexProductCart).getProduct().getPrice();
              CartShop.getDataCartShop().get(indexProductCart).setQuantity(totalBefore + quantity);
              CartShop.getDataCartShop().get(indexProductCart).setTotalPrice(priceProduct * (totalBefore + quantity));
            } else {
              CartShop.addToCartShop(item);
            }
          }
        } else {
          System.out.println("Sorry, the number of items cannot be 0.\n");
        }
      }
    } while (isLooping);

    String buyAgain = Model.choiceBuyAgain();
    if (buyAgain.equalsIgnoreCase("Yes")) {
      App.MainMenu();
    } else {
      viewCartShop();
    }

    return item;
  }

  public static void choisingListProduct(String choices) {
    if (choices.equalsIgnoreCase("00")) {
      App.MainMenu();
    } else {
      addToCart(choices);
    }
  }

  public static void viewCartShop() {
    int i = 1;
    Double grandTotal = Model.getGrandTotalCart();
    Model.getTemplateMenuProductHeaderCart();
    if (CartShop.CARTSHOP.size() != 0) {
      for (CartShop data : CartShop.CARTSHOP) {
        if (data.getProduct() instanceof Product) {
          System.out.format(Model.leftAlignFormatCart, i++,
              data.getProduct().getProductID(), data.getProduct().getProductDescription(), data.getQuantity(),
              Model.indonesiaCurrency(data.getProduct().getPrice()), Model.indonesiaCurrency(data.getTotalPrice()));
        } else {
          System.out.printf(Model.leftAlignFormatCart, i++, data.getProduct().getProductID(),
              data.getProduct().getProductDescription(), data.getQuantity(),
              Model.indonesiaCurrency(data.getProduct().getPrice()), Model.indonesiaCurrency(data.getTotalPrice()));
        }
        i++;
      }
    } else {
      System.out.printf("|%-59s %-87s|%n", " ", "Not found product at Cart!");
    }
    System.out.format(Model.lineCart);
    System.out.format("| 00 |" + "Grand Total         " + Model.indonesiaCurrency(grandTotal)
        + "                                                                              |%n");
    System.out.format(Model.lineCart);
    String choices = choicesMenu();
    if (choices.equalsIgnoreCase("Yes")) {
      updateDataProduct(CartShop.CARTSHOP);
      App.MainMenu();
    } else {
      App.MainMenu();
    }
  }

  public static void updateDataProduct(List<CartShop> cartShop) {
    Integer jenisBarang = CartShop.CARTSHOP.size();

    for (int i = 0; i < jenisBarang; i++) {
      for (Product product : CartShop.allData) {
        String idProduct = CartShop.CARTSHOP.get(i).getProduct().getProductID();
        if (product.getProductID().equalsIgnoreCase(idProduct)) {
          if (product instanceof Items) {
            Integer stockTerbaru = ((Items) product).getUnitOfStock() - CartShop.CARTSHOP.get(i).getQuantity();
            ((Items) product).setUnitOfStock(stockTerbaru);
            product.calculatedPrice();
          }
          if (product instanceof Services) {
            Integer userUsage = ((Services) product).getUserUsage() + CartShop.CARTSHOP.get(i).getQuantity();
            ((Services) product).setUserUsage(userUsage);
            product.calculatedPrice();
          }
        }
      }
    }
  }

  public static String choicesMenu() {
    String[] pilihan = { "Yes", "No" };
    String choices = "";
    if (CartShop.CARTSHOP.size() != 0) {
      choices = Validations.inputTypeAlphabetLimit("Check out? (Yes/No) : ", pilihan);
    } else {
      choices = Validations.inputTypeAlphabetLimit("Stay here? (Yes/No) : ", pilihan);
    }
    System.out.println("");
    return choices;
  }

  public static String indonesiaCurrency(double formatter) {
    DecimalFormat indonesiaCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    formatRp.setCurrencySymbol("Rp. ");
    formatRp.setMonetaryDecimalSeparator(',');
    formatRp.setGroupingSeparator('.');
    indonesiaCurrency.setDecimalFormatSymbols(formatRp);
    return indonesiaCurrency.format(formatter);
  }

  public static String lineCart = "+----+----------------+------------------------------------------+------------+--------------------+--------------------+%n";
  static String headCart = "| No | Product ID     | Product Description                      | Quantity   |      Price         |  Total Price       |%n";

  public static String leftAlignFormatCart = "| %-2d | %-14s | %-40s | %-11s| %-18s | %-18s |%n";
  public static String templateHeaderProductItems;

  public static void getTemplateMenuProductHeaderCart() {
    System.out.format(lineCart);
    System.out.format(headCart);
    System.out.format(lineCart);
  }
}
