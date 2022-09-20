package views;

import java.util.ArrayList;
import java.util.List;

import parents.Items;
import parents.Product;
import parents.Services;
import repositories.StoreRepository;
import validations.Validations;

public class CartList {

  private Product product;
  private Integer quantity;
  private Double totalPrice;

  public CartList() {
    super();
  }

  public CartList(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
    calculateTotalPrice();
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public void calculateTotalPrice() {
    setTotalPrice(getQuantity() * getProduct().getPrice());
  }

  static String line = "+----+----------------+------------------------------------------+------------+--------------------+--------------------+%n";
  static String head = "| No | Product ID     | Product Description                      | Quantity   |      Price         |  Total Price       |%n";
  static String footer = "| 00 |   Grand Total                                                                                                   |%n";
  static String leftAlignFormat = "| %-2d | %-14s | %-40s | %-11s| %-18s | %-18f |%n";

  public static final List<CartList> CART_SHOP = new ArrayList<>();

  public static void addToCartShop(CartList item) {
    CART_SHOP.add(item);
  }

  public static List<CartList> getDataCartShop() {
    return CART_SHOP;
  }

  public static void viewCartShop() {
    int i = 1;
    Double grandTotal = getGrandTotalCart();
    getTemplateMenuProductHeader();
    if (CART_SHOP.size() != 0) {
      for (CartList data : CART_SHOP) {
        if (data.getProduct() instanceof Product) {
          System.out.printf(leftAlignFormat, i++ + ".",
              data.getProduct().getProductID(), data.getProduct().getProductDescription(), data.getQuantity(),
              Menu.indonesiaCurrency(data.getProduct().getPrice()), Menu.indonesiaCurrency(data.getTotalPrice()));
        } else {
          System.out.printf(leftAlignFormat, i++ + ".",
              data.getProduct().getProductID(), data.getProduct().getProductDescription(), data.getQuantity(),
              Menu.indonesiaCurrency(data.getProduct().getPrice()), Menu.indonesiaCurrency(data.getTotalPrice()));
        }
        i++;
      }
    } else {
      System.out.printf("|%-59s %-87s|%n", " ", "Not found product at Cart!");
    }
    getTemplateMenuProductFooter();

    String choices = choicesMenu();
    if (choices.equalsIgnoreCase("Yes")) {
      updateDatasProduct(CART_SHOP);
      Menu.getMenu(templateHeaderWelcome, welcomeMenu, exitMenu);
    } else {
      Menu.getMenu(templateHeaderWelcome, welcomeMenu, exitMenu);
    }
  }

  public static String choicesMenu() {
    String[] pilihan = { "Yes", "No" };
    String choices = "";
    if (CART_SHOP.size() != 0) {
      choices = Validations.inputTypeAlphabetLimit("Check out? (Yes/No) : ", pilihan);
    } else {
      choices = Validations.inputTypeAlphabetLimit("Stay here? (Yes/No) : ", pilihan);
    }
    System.out.println("");
    return choices;
  }

  public static void getTemplateMenuProductHeader() {
    System.out.format(line);
    System.out.format(head);
    System.out.format(line);
  }

  public static void getTemplateMenuProductFooter() {
    System.out.format(line);
    System.out.format(footer);
    System.out.format(line);
  }

  public static void prosesCartList(String productID) {
    getTemplateMenuProductHeader();
    int i = 1;
    for (Product product : StoreRepository.getAllProduct()) {
      if (product.getProductID().equalsIgnoreCase(productID)) {
        if (product instanceof Items) {
          System.out.format(leftAlignFormat, i++, product.getProductID(), product.getProductDescription(),
              ((Items) product).getUnitOfStock(),
              product.price(), ((Items) product).getPrice() * 5);
        }
        if (product instanceof Services) {
          System.out.format(leftAlignFormat, i++, product.getProductID(), product.getProductDescription(),
              ((Services) product).getUserUsage(),
              product.price(), ((Items) product).getPrice() * 5);
        }
      }
    }
    getTemplateMenuProductFooter();
  }

  public static void updateDatasProduct(List<CartList> cartShop) {
    Integer jenisBarang = cartShop.size();

    for (int i = 0; i < jenisBarang; i++) {
      for (Product data : StoreRepository.getAllProduct()) {
        String idProduct = cartShop.get(i).getProduct().getProductID();
        if (data.getProductID().equalsIgnoreCase(idProduct)) {
          if (data instanceof Items) {
            Integer stockTerbaru = ((Items) data).getUnitOfStock() - cartShop.get(i).getQuantity();
            ((Items) data).setUnitOfStock(stockTerbaru);
            data.calculatedPrice();
          } else {
            Integer userUsage = ((Services) data).getUserUsage() + cartShop.get(i).getQuantity();
            ((Services) data).setUserUsage(userUsage);
            data.calculatedPrice();
          }
        }
      }
    }
    cartShop.clear();
  }

  public static Double getGrandTotalCart() {
    List<CartList> data = new ArrayList<>();
    data = getDataCartShop();
    Double total = 0.0;

    for (CartList product : data) {
      total += product.getTotalPrice();
    }
    return total;
  }

  static String[] welcomeMenu = { "Product Item", "Product Service", "Cart Shop", "Searching Product" };
  String[] productItems = { "Food And Beverage", "Material", "Garment" };
  String[] productServices = { "Transportation", "Telecomunication" };
  String[] TEMPLATESEARCHINGPRODUCT = { "By Type", "By Description", "Recommendation" };
  static String templateHeaderWelcome = "  Welcome to 79 Store  ";
  String templateHeaderProductItems = "   Product Item Menu   ";
  String templateHeaderProductServices = " Product Services Menu ";
  static String exitMenu = "Exit             ";
  String exitProduct = "Back To Main Menu";
  String TEMPLATEHEADERSEARCHINGPRODUCT = "Searching Product";
  String TEMPLATESEARCHINGBYTYPE = "Masukan Type Product yang dicari ";
  String ask = "";
}
