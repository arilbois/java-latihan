package parents;

import java.util.ArrayList;
import java.util.List;

import repositories.StoreRepository;

public class CartShop {
  private Product product;
  private Integer quantity;
  private Double totalPrice;

  public CartShop() {
    super();
  }

  public CartShop(Product product, Integer quantity) {
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

  public static final List<CartShop> CARTSHOP = new ArrayList<>();
  public static List<Product> allData = StoreRepository.getAllProduct();

  public static void addToCartShop(CartShop item) {
    CARTSHOP.add(item);
  }

  public static List<CartShop> getDataCartShop() {
    return CARTSHOP;
  }

}