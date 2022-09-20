package views;

import models.Model;
import validations.*;

public class App {
    public static void main(String[] args) {
        MainMenu();
    }

    public static void MainMenu() {
        Menu.getMenu(Menu.templateHeaderWelcome, Menu.welcomeMenu, Menu.exitMenu);
        int choiseMenu = Validations.inputTypeNumberLimit(TEMPLATECHOICEMENU, 0, 4);
        switch (choiseMenu) {
            case 1:
                Menu.getMenu(Menu.templateHeaderProductItems, Menu.productItems, Menu.exitProduct);
                choiseMenu = Validations.inputTypeNumberLimit(TEMPLATECHOICEMENU, 0, 3);
                Menu.showProductItem(choiseMenu);
                break;
            case 2:
                Menu.getMenu(Menu.templateHeaderProductServices, Menu.productServices, Menu.exitProduct);
                choiseMenu = Validations.inputTypeNumberLimit(TEMPLATECHOICEMENU, 0, 2);
                break;
            case 3:
                CartShop.viewCartShop();
                break;
            case 4:
                Menu.getMenu(Menu.TEMPLATEHEADERSEARCHINGPRODUCT, Menu.TEMPLATESEARCHINGPRODUCT, Menu.exitMenu);
                choiseMenu = Validations.inputTypeNumberLimit(TEMPLATECHOICEMENU, 0, 3);
                switch (choiseMenu) {
                    case 1:
                        String searchBytipe = Validations.inputTypeAlphabet(Menu.TEMPLATESEARCHINGBYTYPE);
                        ItemsAndServicesProduct.getItemsAndServicesProduct(searchBytipe);
                        String choices = Model.choiceMenu();
                        Model.choisingListProduct(choices);
                        break;
                    case 2:
                        String x = Validations.inputTypeAlphabet(Menu.TEMPLATESEARCHINGBYTYPE);
                        Search.searchByDescription(x);
                        choices = Model.choiceMenu();
                        Model.choisingListProduct(choices);
                        break;
                    case 3:
                        Recomendation.findRecomend();
                        choices = Model.choiceMenu();
                        Model.choisingListProduct(choices);
                        break;
                    case 00:
                        MainMenu();
                        break;
                }
                break;
            case 00:
                MainMenu();
                break;
        }

    }

    public static final String TEMPLATECHOICEMENU = "Please Choice one of The menu";

}
