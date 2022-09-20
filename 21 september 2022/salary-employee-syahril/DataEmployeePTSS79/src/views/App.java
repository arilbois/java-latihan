package views;

import models.data;
import repositories.EmployeDataRepositories;
import validations.Validator;

public class App {
    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        String choices;
        Menu.getMenu(Menu.TEMPLATE_HEADER_WELCOME, Menu.WELCOME_MENU, Menu.EXIT_MENU);
        int choiseMenu = Validator.inputTypeNumberLimit(Menu.TEMPLATE_CHOICE_MENU, 0, 5);
        switch (choiseMenu) {
            case 1:
                Menu.MenuAddEmployee();
                break;
            case 2:
                data.updateEmployee();
                App.MainMenu();
                break;
            case 3:
                DataEmployee.getAllDataPerson(data.allEmployee());
                choices = data.choiceEmployeeID();
                data.choisingListProduct(choices);
                break;
            case 4:
                data.deleteEmployee();
                App.MainMenu();
                break;
            case 5:
                String description = Validator.inputTypeAlphabet("Search By Placement");
                DataEmployee.getAllDataPerson(data.searchbyPlace(description));
                choices = data.choiceEmployeeID();
                data.choisingListProduct(choices);
                break;
            default:
                break;
        }
    }
}
