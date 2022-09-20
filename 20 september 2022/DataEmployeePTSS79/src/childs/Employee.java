package childs;

import parent.Person;

public class Employee extends Person {
  private String employeeID, jobDesc, placement;
  private Double salary;

  public Employee() {
  }

  public Employee(String name, String address, Integer age, String employeeID, String jobDesc, String placement) {
    super(name, address, age);
    this.employeeID = employeeID;
    this.jobDesc = jobDesc;
    this.placement = placement;
    FindUmk();
    calculateSalary();
    calculateAllowance();
  }

  public String getEmployeeID() {
    return employeeID;
  }

  public void setEmployeeID(String employeeID) {
    this.employeeID = employeeID;
  }

  public String getJobDesc() {
    return jobDesc;
  }

  public void setJobDesc(String jobDesc) {
    this.jobDesc = jobDesc;
  }

  public String getPlacement() {
    return placement;
  }

  public void setPlacement(String placement) {
    this.placement = placement;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  @Override
  public Double FindUmk() {
    Double umkSalary = 0.0;
    if (getPlacement().equalsIgnoreCase("Garut")) {
      umkSalary = 1961085.0;
    } else if (getPlacement().equalsIgnoreCase("Bandung")) {
      umkSalary = 3742276.0;
    } else if (getPlacement().equalsIgnoreCase("Jakarta")) {
      umkSalary = 4453935.0;
    } else if (getPlacement().equalsIgnoreCase("Bekasi")) {
      umkSalary = 4782935.0;
    } else {
      umkSalary = 4330249.0;
    }
    return umkSalary;

  }

  @Override
  public void calculateAllowance() {

  }

  @Override
  public void calculateSalary() {
    this.setSalary(FindUmk() * 1);
  }

}