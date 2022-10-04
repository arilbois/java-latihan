package views;

import java.util.List;

import childs.*;
import parent.Person;
import repositories.EmployeDataRepositories;
import models.data;

public class DataEmployee extends EmployeDataRepositories {
  public static void getAllDataPerson(List<Person> listPerson) {

    data.getTemplateHeaderEmploye();
    if (listPerson.isEmpty()) {
      System.out.println("Empty");
    } else {
      for (int i = 0; i < listPerson.size(); i++) {
        if (listPerson.get(i) instanceof Programmer) {
          Programmer employee = ((Programmer) listPerson.get(i));
          System.out.printf(data.LEFT_ALIGN, (i + 1), employee.getEmployeeID(), employee.getName(),
              employee.getPlacement(),
              employee.getJobDesc(), data.convertToIDR(employee.getSalary()),
              data.convertToIDR(employee.getAllowance()));
        } else if (listPerson.get(i) instanceof ProjectLeader) {
          ProjectLeader employee = ((ProjectLeader) listPerson.get(i));
          System.out.printf(data.LEFT_ALIGN, (i + 1), employee.getEmployeeID(), employee.getName(),
              employee.getPlacement(),
              employee.getJobDesc(), data.convertToIDR(employee.getSalary()),
              data.convertToIDR(employee.getAllowance()));
        } else if (listPerson.get(i) instanceof Analyst) {
          Analyst employee = ((Analyst) listPerson.get(i));
          System.out.printf(data.LEFT_ALIGN, (i + 1), employee.getEmployeeID(), employee.getName(),
              employee.getPlacement(),
              employee.getJobDesc(), data.convertToIDR(employee.getSalary()),
              data.convertToIDR(employee.getAllowance()));
        } else {
          Employee employee = ((Employee) listPerson.get(i));
          System.out.printf(data.LEFT_ALIGN, (i + 1), employee.getEmployeeID(), employee.getName(),
              employee.getPlacement(),
              employee.getJobDesc(), data.convertToIDR(employee.getSalary()), "Rp. 0");
        }
      }
    }
    data.getTemplateFooterEmploye();
  }
}
