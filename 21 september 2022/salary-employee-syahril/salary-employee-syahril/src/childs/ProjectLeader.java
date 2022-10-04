package childs;

import interfaces.Allowance;

public class ProjectLeader extends Employee implements Allowance {
  private Integer totalProject;
  private Double allowance;

  public ProjectLeader() {

  }

  public ProjectLeader(String name, String address, Integer age, String employeeID, String jobDesc, String placement,
      Integer totalProject) {
    super(name, address, age, employeeID, jobDesc, placement);
    this.totalProject = totalProject;
    calculateAllowance();

  }

  public Integer getTotalProject() {
    return totalProject;
  }

  public void setTotalProject(Integer totalProject) {
    this.totalProject = totalProject;
  }

  public Double getAllowance() {
    return allowance;
  }

  public void setAllowance(Double allowance) {
    this.allowance = allowance;
  }

  @Override
  public void calculateAllowance() {
    if (totalProject >= 2) {
      setAllowance(0.15 * getSalary());
    } else {
      setAllowance(0.05 * getSalary());
    }
  }
}
