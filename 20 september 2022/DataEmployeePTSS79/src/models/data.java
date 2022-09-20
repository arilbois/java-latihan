package models;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import childs.Analyst;
import childs.Employee;
import childs.Programmer;
import childs.ProjectLeader;
import parent.Person;
import repositories.EmployeDataRepositories;
import validations.Validator;
import views.App;
import views.DataEmployee;
import views.Menu;

public class data {
  public static List<Person> allData = EmployeDataRepositories.getAllEmployee();

  public static List<Person> allEmployee() {
    List<Person> allEmploye = new ArrayList<>();
    for (Person person : allData) {
      allEmploye.add(person);
    }
    return allEmploye;
  }

  public static List<Person> addEmployee(String employmenType) {
    List<Person> allEmploye = new ArrayList<>();
    String name = Validator.inputTypeAlphabet("Input Your Name :");
    String address = Validator.inputTypeAlphabet("Input Your Address");
    Integer age = Validator.inputTypeNumberLimit("Input Your age", 0, 999);
    String employeeID = Validator.checkInputTypeId("input ID Employee");
    String jobDesc = Validator.inputTypeAlphabet("Input Your job Desk");
    String placement = Validator.inputTypeAlphabetLimit("Input Your Placement", EMPLOYEE_PLACE);
    if (employmenType.equalsIgnoreCase("Employment")) {
      allData.add(new Employee(name, address, age, "EMP" + employeeID, jobDesc, placement));

    } else if (employmenType.equalsIgnoreCase("Programmer")) {
      String programmingLanguage = Validator.inputTypeAlphabet("programming Language");
      Integer experiences = Validator.inputTypeNumberLimit("experiences", 0, 999);
      allData.add(
          new Programmer(name, address, age, employeeID, jobDesc, placement, programmingLanguage, experiences));
    } else if (employmenType.equalsIgnoreCase("ProjectLeader")) {
      Integer totalProject = Validator.inputTypeNumberLimit("experiences", 0, 999);
      allData.add(
          new ProjectLeader(name, address, age, employeeID, jobDesc, placement, totalProject));
    } else {
      allData.add(new Analyst(name, address, age, employeeID, jobDesc, placement));
    }

    return allEmploye;

  }

  public static List<Person> deleteEmployee() {
    DataEmployee.getAllDataPerson(data.allEmployee());
    List<Person> allEmploye = new ArrayList<>();
    String idemploye = Validator.validateEmployeeID("Input Your Id Employee \n");
    Iterator<Person> data = allData.iterator();
    data = allData.iterator();
    while (data.hasNext()) {
      Person person = data.next();
      if (person instanceof Employee) {
        if (((Employee) person).getEmployeeID().equalsIgnoreCase(idemploye)) {
          data.remove();
        }
      }
    }
    return allEmploye;
  }

  public static Integer getIndexEmployeByID(String idProduct) {
    List<Person> data = new ArrayList<>();
    data = allData;
    int index = 0, i = 0;
    for (Person person : data) {
      if (((Employee) person).getEmployeeID().equalsIgnoreCase(idProduct)) {
        index = i;
      }
      i++;
    }
    return index;
  }

  public static List<Person> updateEmployee() {
    DataEmployee.getAllDataPerson(data.allEmployee());
    String idemploye = Validator.validateEmployeeID("Input Your Id Employee ");
    Integer indexEmployee = getIndexEmployeByID(idemploye);
    String placement = Validator.inputTypeAlphabetLimit("Placement", EMPLOYEE_PLACE);
    for (Person person : allData) {
      if (person instanceof Employee || person instanceof Programmer || person instanceof Analyst
          || person instanceof ProjectLeader) {
        ((Employee) allData.get(indexEmployee)).setPlacement(placement);
      }
      person.FindUmk();
      person.calculateSalary();
      person.calculateAllowance();
    }

    return allData;
  }

  public static List<Person> searchbyPlace(String searchByDescription) {
    List<Person> returnData = new ArrayList<>();
    for (int i = 0; i < allData.size(); i++) {
      if (((Employee) allData.get(i)).getPlacement().toLowerCase().contains(searchByDescription.toLowerCase())) {
        returnData.add(allData.get(i));
      }
    }
    return returnData;
  }

  public static String convertToIDR(double money) {
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    formatRp.setCurrencySymbol("Rp. ");
    formatRp.setMonetaryDecimalSeparator(',');
    formatRp.setGroupingSeparator('.');
    kursIndonesia.setDecimalFormatSymbols(formatRp);
    return kursIndonesia.format(money);
  }

  public static void getTemplateHeaderEmploye() {
    System.out.format(LINE);
    System.out.format(TEMPLATE_HEADER);
    System.out.format(LINE);
  }

  public static void getTemplateFooterEmploye() {
    System.out.format(LINE);
    System.out.format(FOOTER);
    System.out.format(LINE);

  }

  public static String findEmployeeID() {
    String choices;
    choices = Validator.validateEmployeeID("Please choice menu : ");
    System.out.println("");
    return choices;
  }

  public static String choiceEmployeeID() {
    String choices;
    choices = Validator.validateEmployeeID("Please choice menu : ");
    System.out.println("");
    return choices;
  }

  public static void choisingListProduct(String choices) {
    if (choices.equalsIgnoreCase("00")) {
      App.MainMenu();
    }
  }

  public static List<Person> getDataByDescription(String searchByDescription) {
    List<Person> returnData = new ArrayList<>(allData);
    // returnData.removeIf(((Employee) person ->
    // !product.getPlacement.toLowerCase().contains(searchByDescription.toLowerCase())));
    return returnData;
  }

  protected static final String TEMPLATE_HEADER = "| No | Employee ID |    Nama          | Placement |               Job Desc              |        Salary         |     Alloance      |%n",
      LINE = "+----+-------------+------------------+-----------+-------------------------------------+-----------------------+-------------------+%n",
      FOOTER = "|  Back To MEnu 00 %n";
  public static final String LEFT_ALIGN = "| %-2d | %-11s | %-16s | %-10s| %-35s | %-21s | %-17s |%n";
  public static final String[] EMPLOYEE_PLACE = { "Garut", "Bandung", "Jakarta", "Bekasi", "Bogor" };
}
