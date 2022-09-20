package views;

import java.util.List;

import models.Model;
import parents.Product;
import repositories.StoreRepository;
import validations.Validations;

public class Menu extends StoreRepository {

  public static String[] welcomeMenu = { "Product Item", "Product Service", "Cart Shop", "Searching Product" };
  public static String[] productItems = { "Food And Beverage", "Material", "Garment" };
  public static String[] productServices = { "Transportation", "Telecomunication" };
  public static String[] TEMPLATESEARCHINGPRODUCT = { "By Type", "By Description", "Recommendation" };
  public static String templateHeaderWelcome = "  Welcome to 79 Store  ";
  public static String templateHeaderProductItems = "   Product Item Menu   ";
  public static String templateHeaderProductServices = " Product Services Menu ";
  public static String exitMenu = "Exit             ";
  public static String exitProduct = "Back To Main Menu";
  public static String TEMPLATEHEADERSEARCHINGPRODUCT = "Searching Product";
  public static String TEMPLATESEARCHINGBYTYPE = "Masukan Type Product yang dicari ";

  public static void getFoodAndBev() {
    int i = 1;
    List listFood = Model.allData;
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

  public static void showProductItem(int choiseMenu) {
    String choices;
    switch (choiseMenu) {
      case 1:
        ItemsAndServicesProduct.getItemsAndServicesProduct("FoodandBeverages");
        choices = choiceMenu();
        choisingListProduct(choices);
        break;
      case 2:
        ItemsAndServicesProduct.getItemsAndServicesProduct("Material");
        choices = choiceMenu();
        choisingListProduct(choices);
        break;
      case 3:
        ItemsAndServicesProduct.getItemsAndServicesProduct("Garment");
        choices = choiceMenu();
        choisingListProduct(choices);
        break;
      case 00:
        App.MainMenu();
        break;
    }
  }

  public static void showProductServices(int choiseMenu) {
    String choices;
    switch (choiseMenu) {
      case 1:
        ItemsAndServicesProduct.getItemsAndServicesProduct("Transportation");
        choices = choiceMenu();
        choisingListProduct(choices);
        break;
      case 2:
        ItemsAndServicesProduct.getItemsAndServicesProduct("Telecomunication");
        choices = choiceMenu();
        choisingListProduct(choices);
        break;
      case 00:
        App.MainMenu();
        break;
    }
  }

  public static String choiceMenu() {
    String choices;
    choices = Validations.validateProduct("Please choice menu : ");
    System.out.println("");
    return choices;
  }

  public static void choisingListProduct(String choices) {
    if (choices.equalsIgnoreCase("00")) {
      getMenu(templateHeaderWelcome, welcomeMenu, exitMenu);
    } else {
      CartShop.addToCart(choices);
    }
  }
}