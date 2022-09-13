package Childs;

import Parents.Items;

public class Garment extends Items {
  private String garmentsType, fabrics, color, size, ageGrup;

  public Garment() {
    super();
  }

  public Garment(String garmentsType, String fabrics, String color, String size, String ageGrup) {
    this.garmentsType = garmentsType;
    this.fabrics = fabrics;
    this.color = color;
    this.size = size;
    this.ageGrup = ageGrup;
  }

  public String getGarmentsType() {
    return garmentsType;
  }

  public void setGarmentsType(String garmentsType) {
    this.garmentsType = garmentsType;
  }

  public String getFabrics() {
    return fabrics;
  }

  public void setFabrics(String fabrics) {
    this.fabrics = fabrics;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getAgeGrup() {
    return ageGrup;
  }

  public void setAgeGrup(String ageGrup) {
    this.ageGrup = ageGrup;
  }

  @Override
  public void calculatedPrice() {
    // TODO Auto-generated method stub

  }

}