package childs;

import java.util.HashMap;
import java.util.Map;

import interfaces.FindUmk;
import interfaces.Salary;
import parent.Person;

public class Employee extends Person implements FindUmk, Salary {
  private String employeeID, jobDesc, placement;
  private Double salary;

  public Employee() {
  }

  public Employee(String name, String address, Integer age, String employeeID, String jobDesc, String placement) {
    super(name, address, age);
    this.employeeID = employeeID;
    this.jobDesc = jobDesc;
    this.placement = placement;
    findUmk();
    calculateSalary();
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
  public void calculateSalary() {
    Double salary = 0.0;
    String data = getEmployeeID().replaceAll("[^A-Z]", "");
    if (data.equalsIgnoreCase("Emp")) {
      salary = 1 * findUmk();
    } else if (data.equalsIgnoreCase("PRO")) {
      salary = 1.5 * findUmk();
    } else if (data.equalsIgnoreCase("PRL")) {
      salary = 2 * findUmk();
    } else {
      salary = 1.6 * findUmk();
    }
    setSalary(salary);
  }

  @Override
  public Double findUmk() {
    HashMap<String, Double> mapUmk = new HashMap<>();
    Double umkSalary = 0.0;
    mapUmk.put("Garut", 1961085.0);
    mapUmk.put("Bandung", 3742276.0);
    mapUmk.put("Jakarta", 4453935.0);
    mapUmk.put("Bekasi", 4782935.0);
    mapUmk.put("Bogor", 4330249.0);

    for (Map.Entry<String, Double> umk : mapUmk.entrySet()) {
      if (getPlacement().equalsIgnoreCase(umk.getKey())) {
        umkSalary = umk.getValue();
      }
    }
    return umkSalary;
  }

}