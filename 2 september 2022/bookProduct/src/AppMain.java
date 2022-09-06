import childs.Comic;
import childs.Mangaka;
import childs.Novel;
import childs.Novelis;
import childs.Publisher;
import parent.BookProduct;
import parent.Person;

public class AppMain {
    public static void main(String[] args) {
        Person novelis1 = new Novelis("fiersa","Besari","Indonesia",28,"Best Seller",true);
        Person mangaka1 = new Mangaka("Arif","Didu","Indonesia", 40,"Good");
        Publisher publisher1 = new Publisher("Raffi","Thailand",20000000);
        Publisher publisher2 = new Publisher("Andri","Indoneisa",10000000);


        BookProduct novel1 = new Novel("NVL01","Sendal yg Tertukar",40000,novelis1,publisher1,"Comedy");
        BookProduct comic1 = new Comic("CMK01","Ojan the explore", 30000,mangaka1,publisher2,true);


        novel1.calculatePrice(publisher1.getProductionCost(), ((Novelis) novelis1).getRating());
        comic1.calculatePrice(publisher2.getProductionCost(), ((Mangaka) mangaka1).getRating());

    }



}
