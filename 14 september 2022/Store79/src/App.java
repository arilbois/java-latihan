import java.util.*;

import childs.Transportations;
import parents.Product;
import repositories.*;
import views.CartShop;
import views.ItemsAndServicesProduct;
import views.Menu;
import views.Recomendation;
import views.Search;
import validations.*;

public class App {
    public static void main(String[] args) {
        // Menu.getFoodAndBev();
        String[] welcomeMenu = { "Product Item", "Product Service", "Cart Shop", "Searching Product" },
                productItems = { "Food And Beverage", "Material", "Garment" },
                productServices = { "Transportation", "Telecomunication" },
                TEMPLATESEARCHINGPRODUCT = { "By Type", "By Description", "Recommendation" };
        String templateHeaderWelcome = "  Welcome to 79 Store  ",
                templateHeaderProductItems = "   Product Item Menu   ",
                templateHeaderProductServices = " Product Services Menu ",
                exitMenu = "Exit             ", exitProduct = "Back To Main Menu",
                TEMPLATEHEADERSEARCHINGPRODUCT = "Searching Product",
                TEMPLATESEARCHINGBYTYPE = "Masukan Type Product yang dicari ", ask = "";
        do {
            Menu.getMenu(templateHeaderWelcome, welcomeMenu, exitMenu);
            int choiseMenu = Validations.inputTypeNumberLimit(TEMPLATECHOICEMENU, 0, 4);
            switch (choiseMenu) {
                case 1:
                    Menu.getMenu(templateHeaderProductItems, productItems, exitProduct);
                    choiseMenu = Validations.inputTypeNumberLimit(TEMPLATECHOICEMENU, 0, 31);
                    switch (choiseMenu) {
                        case 1:
                            ItemsAndServicesProduct.getItemsAndServicesProduct("FoodandBeverages");
                            String productId = Validations.inputTypeAlphabet(TEMPLATESEARCHINGBYTYPE);
                            int qty = Validations.inputTypeNumberLimit("", 0, 2);
                            CartShop.addProduct(productId, qty);
                            CartShop.getCartShopTable();
                            break;
                        case 2:
                            ItemsAndServicesProduct.getItemsAndServicesProduct("Material");
                            break;
                        case 3:
                            ItemsAndServicesProduct.getItemsAndServicesProduct("Garment");
                            break;
                        case 0:
                            Menu.getMenu(templateHeaderWelcome, welcomeMenu, exitMenu);
                            break;
                    }
                    break;
                case 2:
                    Menu.getMenu(templateHeaderProductServices, productServices, exitProduct);
                    choiseMenu = Validations.inputTypeNumberLimit(TEMPLATECHOICEMENU, 0, 2);
                    switch (choiseMenu) {
                        case 1:
                            ItemsAndServicesProduct.getItemsAndServicesProduct("Transportation");

                            break;
                        case 2:
                            ItemsAndServicesProduct.getItemsAndServicesProduct("Telecomunication");
                            break;
                        case 0:
                            Menu.getMenu(templateHeaderWelcome, welcomeMenu, exitMenu);
                            break;
                    }
                    break;
                case 3:
                    CartShop.getCartShopTable();
                    break;
                case 4:
                    Menu.getMenu(TEMPLATEHEADERSEARCHINGPRODUCT, TEMPLATESEARCHINGPRODUCT, exitMenu);
                    choiseMenu = Validations.inputTypeNumberLimit(TEMPLATECHOICEMENU, 0, 3);
                    switch (choiseMenu) {
                        case 1:
                            String searchBytipe = Validations.inputTypeAlphabet(TEMPLATESEARCHINGBYTYPE);
                            ItemsAndServicesProduct.getItemsAndServicesProduct(searchBytipe);
                            break;
                        case 2:
                            String x = Validations.inputTypeAlphabet(TEMPLATESEARCHINGBYTYPE);
                            Search.searchByDescription(x);
                            break;
                        case 3:
                            Recomendation.getRecomendation();
                            break;
                        case 0:
                            Menu.getMenu(templateHeaderWelcome, welcomeMenu, exitMenu);
                            break;
                    }
                    break;
                case 0:
                    Menu.getMenu(templateHeaderProductItems, productItems, exitProduct);
                    break;
            }
        } while (ask.equalsIgnoreCase("ya"));
        // System.out.println("Type YES to continue");
        // } while (Validations.INPUT.next().equalsIgnoreCase("YES"));
        // Validations.INPUT.close();
    }

    public static final String TEMPLATECHOICEMENU = "Please Choice one of The menu";

}
