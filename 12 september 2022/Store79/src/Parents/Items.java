package Parents;

import Interfaces.*;

abstract public class Items extends Product implements Price {

  private Double unitOfStock;
  private String productionCode, productionDate;

  public Items() {
  }

  public Items(Double unitOfStock, String productionCode, String productionDate) {
    this.unitOfStock = unitOfStock;
    this.productionCode = productionCode;
    this.productionDate = productionDate;
  }

  public Double getUnitOfStock() {
    return unitOfStock;
  }

  public void setUnitOfStock(Double unitOfStock) {
    this.unitOfStock = unitOfStock;
  }

  public String getProductionCode() {
    return productionCode;
  }

  public void setProductionCode(String productionCode) {
    this.productionCode = productionCode;
  }

  public String getProductionDate() {
    return productionDate;
  }

  public void setProductionDate(String productionDate) {
    this.productionDate = productionDate;
  }

  public void calculatedProduction() {
  }

  public void calculatedPrice() {
    double price = 0.0;
    if (unitOfStock <= 100) {
      price = 1.5 * getProductionCost();
    } else if (unitOfStock > 100 && unitOfStock <= 300) {
      price = 1.3 * getProductionCost();
    } else {
      price = 1.2 * getProductionCost();
    }
    setPrice(price);
  }

}
