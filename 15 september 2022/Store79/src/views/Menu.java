package views;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

import parents.Product;
import repositories.StoreRepository;

public class Menu extends StoreRepository {

  public static void getFoodAndBev() {
    int i = 1;
    List listFood = StoreRepository.getAllProduct();
    for (Product product : getAllProduct()) {
      if (product.getProductType().equalsIgnoreCase("Food")) {
        System.out.println("No " + i++ + " " + product);
      }
    }
  }

  public static void getMenu(String menuHeader, String[] data, String exit) {
    String leftAlignFormat = "| %d%s %-20s  |%n";
    System.out.format("+--------------------------+%n");
    System.out.format("|  " + menuHeader + " |%n");
    System.out.format("+--------------------------|%n");
    for (int i = 0; i < data.length; i++) {
      System.out.format(leftAlignFormat, i + 1, ".", data[i]);
    }
    System.out.format("+ 0. " + exit + "     |%n");
    System.out.format("+--------------------------+%n");
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

}