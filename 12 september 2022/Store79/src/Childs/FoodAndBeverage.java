package Childs;

import Parents.Items;

public class FoodAndBeverage extends Items {
  private String expireDate, ingredients, certification;

  public FoodAndBeverage(String expireDate, String ingredients, String certification) {
    this.expireDate = expireDate;
    this.ingredients = ingredients;
    this.certification = certification;
  }

  public String getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(String expireDate) {
    this.expireDate = expireDate;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public String getCertification() {
    return certification;
  }

  public void setCertification(String certification) {
    this.certification = certification;
  }

  @Override
  public void calculatedPrice() {
    // TODO Auto-generated method stub

  }

}
