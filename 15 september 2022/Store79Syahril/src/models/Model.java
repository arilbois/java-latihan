package models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import parents.*;
import repositories.StoreRepository;
import validations.Validations;
import views.App;
import views.CartShop;

public class Model {
  public static final List<Product> allData = StoreRepository.getAllProduct();

  public static Boolean checkByIDProduct(String productId) {
    Boolean isFound = false;
    for (Product data : allData) {
      if (data.getProductID().equalsIgnoreCase(productId)) {
        isFound = true;
      }
    }
    return isFound;
  }

  public static Integer getTotalCartShopByID(String idProduct) {
    List<CartItem> data = new ArrayList<>();
    data = CartShop.getDataCartShop();
    int jumlahBarang = 0;

    for (CartItem produk : data) {
      if (produk.getProduct().getProductID().equalsIgnoreCase(idProduct)) {
        jumlahBarang = produk.getQuantity();
      }
    }
    return jumlahBarang;
  }

  public static List<Product> getProductByID(String idProduct) {
    List<Product> barang = new ArrayList<>();
    for (Product data : allData) {
      if (data.getProductID().equalsIgnoreCase(idProduct)) {
        barang.add(data);
      }
    }
    return barang;
  }

  public static Integer getStockByIDProduct(String productId) {
    Integer jumlah = 0;
    for (Product data : allData) {
      if (data instanceof Items && data.getProductID().equalsIgnoreCase(productId)) {
        jumlah = ((Items) data).getUnitOfStock();
      }
    }
    return jumlah;
  }

  public static Integer getindexBarangCartShopById(String idProduct) {
    List<CartItem> data = new ArrayList<>();
    data = CartShop.getDataCartShop();
    int index = 0, i = 0;
    for (CartItem produk : data) {
      if (produk.getProduct().getProductID().equalsIgnoreCase(idProduct)) {
        index = i;
      }
      i++;
    }
    return index;
  }

  public static String choiceBuyAgain() {
    String[] pilihan = { "Yes", "No" };
    String choices;
    choices = Validations.inputTypeAlphabetLimit("Do you want to buying product lain (Yes/No) : ", pilihan);
    System.out.println("");
    return choices;
  }

  public static Double getGrandTotalCart() {
    List<CartItem> data = new ArrayList<>();
    data = CartShop.getDataCartShop();
    Double total = 0.0;

    for (CartItem product : data) {
      total += product.getTotalPrice();
    }
    return total;
  }

  public static void getTemplateMenuProductHeaderCart() {
    System.out.format(lineCart);
    System.out.format(headCart);
    System.out.format(lineCart);
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

  public static String choiceMenu() {
    String choices;
    choices = Validations.validateProduct("Please choice menu : ");
    System.out.println("");
    return choices;
  }

  public static String inputWords() {
    String words = Validations.inputTypeAlphabet("Insert keyword to search  : ");
    return words;
  }

  public static void choisingListProduct(String choices) {
    if (choices.equalsIgnoreCase("00")) { // jika memilih kembali ke menu utama
      App.MainMenu();
    } else { // jika memilih kode produk
      CartShop.addToCart(choices);
    }
  }

  public static void getTemplateMenuProductHeader() {
    System.out.format(lineProduct);
    System.out.format(headProduct);
    System.out.format(lineProduct);
  }

  public static void getTemplateMenuProductFooter() {
    System.out.format(lineProduct);
    System.out.format(footerProduct);
    System.out.format(lineProduct);

  }

  static String lineProduct = "+----+----------------+----------------------------------------------+------------+--------------------+%n";
  static String headProduct = "| No | Product ID     | Product Description                          | Quantity   |      Price         |%n";
  static String footerProduct = "| 00 |   Back To Main Menu                                                                             |%n";

  public static String lineCart = "+----+----------------+------------------------------------------+------------+--------------------+--------------------+%n";
  static String headCart = "| No | Product ID     | Product Description                      | Quantity   |      Price         |  Total Price       |%n";
  public static String leftAlignFormatCart = "| %-2d | %-14s | %-40s | %-11s| %-18s | %-18s |%n";
  public static String templateHeaderProductItems;
}
