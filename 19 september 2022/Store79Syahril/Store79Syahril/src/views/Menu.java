package views;

import models.Model;
import repositories.StoreRepository;
import validations.Validations;

public class Menu extends StoreRepository {

  public static String[] welcomeMenu = { "Product Item", "Product Service", "Cart Shop", "Searching Product" },
      productItems = { "Food And Beverage", "Material", "Garment" },
      productServices = { "Transportation", "Telecomunication" },
      templateSeacrhProduct = { "By Type", "By Description", "Recommendation" };
  public static String templateHeaderWelcome = "  Welcome to 79 Store  ",
      templateHeaderProductItems = "   Product Item Menu   ",
      templateHeaderProductServices = " Product Services Menu ",
      exitMenu = "Exit             ",
      exitProduct = "Back To Main Menu",
      templateHeaderSeacrcProduct = "Searching Product";

  public static void getMenu(String menuHeader, String[] data, String exit) {
    String leftAlignFormat = "| %d%s %-20s  |%n";
    String lineMenu = "+--------------------------+";
    System.out.println(lineMenu);
    System.out.format("|  " + menuHeader + " |%n");
    System.out.println(lineMenu);
    for (int i = 0; i < data.length; i++) {
      System.out.format(leftAlignFormat, i + 1, ".", data[i]);
    }
    System.out.println(lineMenu);
    System.out.format("| 0. " + exit + "     |%n");
    System.out.println(lineMenu);
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
      default:
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
      default:
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
      App.MainMenu();
    } else {
      Model.addToCart(choices);
    }
  }
}