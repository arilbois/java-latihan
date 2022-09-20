package views;

import childs.Employee;
import models.data;
import parent.Person;
import validations.Validator;

public class Menu {
  public static void getMenu(String menuHeader, String[] data, String exit) {
    String leftAlignFormat = "| %d%s %-20s  |%n";
    String lineMenu = "+--------------------------+";
    System.out.println(lineMenu);
    System.out.format("|  " + menuHeader + " |%n");
    System.out.println(lineMenu);
    for (int i = 0; i < data.length; i++) {
      System.out.format(leftAlignFormat, i + 1, ".", data[i]);
    }
    System.out.println(lineMenu);

    System.out.format("| 0. " + exit + "     |%n");
    System.out.println(lineMenu);
  }

  public static void MenuAddEmployee() {
    getMenu(TEMPLATE_HEADER_ADD_EMPLOYEE, EMPLOYEE_TYPE, EXIT_MENU);
    int choiseMenu = Validator.inputTypeNumberLimit(Menu.TEMPLATE_CHOICE_MENU, 0, 4);
    switch (choiseMenu) {
      case 1:
        data.addEmployee("Employment");
        App.MainMenu();
        break;
      case 2:
        data.addEmployee("Programmer");
        App.MainMenu();
        break;
      case 3:
        data.addEmployee("ProjectLeader");
        App.MainMenu();
        break;
      case 4:
        data.addEmployee("Analist");
        App.MainMenu();
        break;
      default:
        App.MainMenu();
    }
  }

  public static final String[] WELCOME_MENU = { "Add Employee", "Edit Employee", "Data Employee",
      "Delete Employee", "Seach Employee" },
      EMPLOYEE_TYPE = { "Employee", "Programmer", "Project Leader", "Analyst" };
  public static final String TEMPLATE_HEADER_WELCOME = "  Welcome to PT SS79  ",
      TEMPLATE_HEADER_ADD_EMPLOYEE = "  Add Employee PT SS79  ",
      TEMPLATE_CHOICE_MENU = "Please Choice one of The menu", EXIT_MENU = "Exit             ";
}
