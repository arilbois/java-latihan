package views;

import java.util.ArrayList;
import java.util.List;

import models.CartItem;
import models.Model;
import parents.*;
import validations.Validations;

public class CartShop {
  public static final List<CartItem> CARTSHOP = new ArrayList<>();

  public static void updateDatasProduct(List<CartItem> cartShop) {
    Integer jenisBarang = cartShop.size();

    for (int i = 0; i < jenisBarang; i++) {
      for (Product data : Model.allData) {
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

  public static void addToCartShop(CartItem item) {
    CARTSHOP.add(item);
  }

  public static List<CartItem> getDataCartShop() {
    return CARTSHOP;
  }

  public static void viewCartShop() {
    int i = 1;
    Double grandTotal = Model.getGrandTotalCart();
    Model.getTemplateMenuProductHeaderCart();
    if (CARTSHOP.size() != 0) {
      for (CartItem data : CARTSHOP) {
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
        + "                                                                                 |%n");
    System.out.format(Model.lineCart);

    String choices = choicesMenu();
    if (choices.equalsIgnoreCase("Yes")) {
      updateDatasProduct(CARTSHOP);
      App.MainMenu();
    } else {
      App.MainMenu();
    }
  }

  public static String choicesMenu() {
    String[] pilihan = { "Yes", "No" };
    String choices = "";
    if (CARTSHOP.size() != 0) {
      choices = Validations.inputTypeAlphabetLimit("Check out? (Yes/No) : ", pilihan);
    } else {
      choices = Validations.inputTypeAlphabetLimit("Stay here? (Yes/No) : ", pilihan);
    }
    System.out.println("");
    return choices;
  }

  public static CartItem addToCart(String idProduct) {
    CartItem item = new CartItem();
    List<Product> product = new ArrayList<>();
    Boolean isLooping = true;
    do {
      Integer stockBarang = Model.getStockByIDProduct(idProduct);
      Integer jumlahBarang = Validations.inputTypeNumber("Input jumlah barang : ");
      product = Model.getProductByID(idProduct);
      Integer jumlahBarangdiCart = Model.getTotalCartShopByID(idProduct);
      for (Product data : product) {
        if (data instanceof Items) {
          if ((jumlahBarang + jumlahBarangdiCart) <= stockBarang) {
            item = new CartItem(data, jumlahBarang);
            isLooping = false;
          } else {
            System.out.println("Maaf, jumlah yang anda beli melebihi stok barang.\n");
          }
        } else {
          System.out.println("masuk service");
          item = new CartItem(data, jumlahBarang);
          isLooping = false;
        }

        Integer indexBarangdiCart = Model.getindexBarangCartShopById(idProduct);
        if (jumlahBarangdiCart != 0) {
          int jumlahSebelumnya = CartShop.getDataCartShop().get(indexBarangdiCart).getQuantity();
          Double hargaBarang = CartShop.getDataCartShop().get(indexBarangdiCart).getProduct().getPrice();
          // tambah jumlah barang di cart
          CartShop.getDataCartShop().get(indexBarangdiCart).setQuantity(jumlahSebelumnya + jumlahBarang);
          // update total harga
          CartShop.getDataCartShop().get(indexBarangdiCart)
              .setTotalPrice(hargaBarang * (jumlahSebelumnya + jumlahBarang));

        } else {
          CartShop.addToCartShop(item);
        }
      }
    } while (isLooping);

    String buyingAgain = Model.choiceBuyAgain();
    if (buyingAgain.equalsIgnoreCase("Yes")) {
      App.MainMenu();
    } else {
      CartShop.viewCartShop();
    }
    return item;
  }
}