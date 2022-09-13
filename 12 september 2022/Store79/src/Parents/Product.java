package Parents;

abstract public class Product {
  private String productID, productType, productDescription;
  private Double costRate, productionCost, price;

  public Product() {
  }

  public Product(String productID, String productType, String productDescription, Double costRate) {
    this.productID = productID;
    this.productType = productType;
    this.productDescription = productDescription;
    this.costRate = costRate;
  }

  public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public String getProductType() {
    return productType;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Double getCostRate() {
    return costRate;
  }

  public void setCostRate(Double costRate) {
    this.costRate = costRate;
  }

  public Double getProductionCost() {
    return productionCost;
  }

  public void setProductionCost(Double productionCost) {
    this.productionCost = productionCost;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

}