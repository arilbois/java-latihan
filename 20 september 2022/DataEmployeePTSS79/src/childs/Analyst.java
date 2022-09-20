package childs;

public class Analyst extends Employee {
  private Double allowance;

  public Analyst() {

  }

  public Analyst(String name, String address, Integer age, String employeeID, String jobDesc, String placement) {
    super(name, address, age, employeeID, jobDesc, placement);
    calculateSalary();
    calculateAllowance();
  }

  public Double getAllowance() {
    return allowance;
  }

  public void setAllowance(Double allowance) {
    this.allowance = allowance;
  }

  public void calculateAllowance() {
    setAllowance(0.05 * super.getSalary());
  }

  public void calculateSalary() {
    this.setSalary(super.FindUmk() * 1.6);
  }
}
