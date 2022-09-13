package Parents;

public class Services extends Product {
  private Double userUsage;
  private String constCalculationType;

  public Services() {
  }

  public Services(String productID, String productType, String productDescription, Double costRate, Double userUsage,
      String constCalculationType) {
    super(productID, productType, productDescription, costRate);
    this.userUsage = userUsage;
    this.constCalculationType = constCalculationType;
  }

  public Double getUserUsage() {
    return userUsage;
  }

  public void setUserUsage(Double userUsage) {
    this.userUsage = userUsage;
  }

  public String getConstCalculationType() {
    return constCalculationType;
  }

  public void setConstCalculationType(String constCalculationType) {
    this.constCalculationType = constCalculationType;
  }

}
