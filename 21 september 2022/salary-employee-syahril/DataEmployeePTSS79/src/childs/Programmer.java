package childs;

import interfaces.Allowance;

public class Programmer extends Employee implements Allowance {
  private String programmingLanguage;
  private Integer experiences;
  private Double allowance;

  public Programmer() {

  }

  public Programmer(String name, String address, Integer age, String employeeID, String jobDesc, String placement,
      String programmingLanguage, Integer experiences) {
    super(name, address, age, employeeID, jobDesc, placement);
    this.programmingLanguage = programmingLanguage;
    this.experiences = experiences;
    calculateAllowance();

  }

  public String getProgrammingLanguage() {
    return programmingLanguage;
  }

  public void setProgrammingLanguage(String programmingLanguage) {
    this.programmingLanguage = programmingLanguage;
  }

  public Integer getExperiences() {
    return experiences;
  }

  public void setExperiences(Integer experiences) {
    this.experiences = experiences;
  }

  public Double getAllowance() {
    return allowance;
  }

  public void setAllowance(Double allowance) {
    this.allowance = allowance;
  }

  @Override
  public void calculateAllowance() {
    if (experiences > 4) {
      setAllowance(0.2 * getSalary());
    } else {
      setAllowance(0.1 * getSalary());
    }

  }

}
