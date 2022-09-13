package Childs;

import Parents.Items;

public class Material extends Items {
  private String expiredDate, materialsType;
  private Boolean isComsumable;

  public Material() {
  }

  public Material(Double unitOfStock, String productionCode, String productionDate, String expiredDate,
      String materialsType, Boolean isComsumable) {
    super(unitOfStock, productionCode, productionDate);
    this.expiredDate = expiredDate;
    this.materialsType = materialsType;
    this.isComsumable = isComsumable;
  }

  public String getExpiredDate() {
    return expiredDate;
  }

  public void setExpiredDate(String expiredDate) {
    this.expiredDate = expiredDate;
  }

  public String getMaterialsType() {
    return materialsType;
  }

  public void setMaterialsType(String materialsType) {
    this.materialsType = materialsType;
  }

  public Boolean getIsComsumable() {
    return isComsumable;
  }

  public void setIsComsumable(Boolean isComsumable) {
    this.isComsumable = isComsumable;
  }

  @Override
  public void calculatedPrice() {
    // TODO Auto-generated method stub

  }

}