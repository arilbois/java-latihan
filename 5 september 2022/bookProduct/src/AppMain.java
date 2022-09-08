import childs.Comic;
import childs.Mangaka;
import childs.Novel;
import childs.Novelis;
import childs.Publisher;
import parent.BookProduct;
import parent.Person;

public class AppMain {
    public static void main(String[] args) {
        Novelis novelis1 = new Novelis("fiersa","Besari","Indonesia",28,"Best Seller",true);
        Novelis novelis2 = new Novelis("Andrea","hinata","Indonesia",22,"Good",false);
        Novelis novelis3 = new Novelis("Tere","Liye","Indonesia",23,"New Commer",false);
        Mangaka mangaka1 = new Mangaka("raditya","Dika","Indonesia", 40,"New Commer");
        Mangaka mangaka2 = new Mangaka("hazel","Grace","England", 20,"New Commer");
        Mangaka mangaka3 = new Mangaka("Jodi","picoult","italy", 27,"Good");
        Mangaka mangaka4 = new Mangaka("kathrine","Paterson","United State", 29,"Good");
        Mangaka mangaka5 = new Mangaka("Audrey","Niffenegger","Germany", 24,"Best Seller");
        Mangaka mangaka6 = new Mangaka("john","Steinbeck","Ceko", 49,"Best Seller");
        Person person1 = new Person("Syahril","Lukman","Indonesia",22);
        //System.out.println(person1);

        Publisher publisher1 = new Publisher("Gagas Media","Indonesia",45000);
        Publisher publisher2 = new Publisher("Pastel Books","Indoneisa",50000);

        BookProduct novel1 = new Novel("NVL01","Arah Langkah", novelis1,publisher1,"Comedy");
        BookProduct novel2 = new Novel("NVL02","Laskar Pelangi", novelis2,publisher1,"Comedy");
        BookProduct novel3 = new Novel("NVL03","Negeri Para Berdebah", novelis3,publisher1,"Romance");
        BookProduct comic1 = new Comic("CMK01","Cinta Brutosaurus",mangaka1,publisher2,true);
        BookProduct comic2 = new Comic("CMK02","the fault in our Stars",mangaka2,publisher2,false);
        BookProduct comic3 = new Comic("CMK03","My Sister's Keeper",mangaka3,publisher2,true);
        BookProduct comic4 = new Comic("CMK04","Bridge to Terabithia",mangaka4,publisher2,false);
        BookProduct comic5 = new Comic("CMK05","The Time Traveler's Wife",mangaka5,publisher2,true);
        BookProduct comic6 = new Comic("CMK06","Of Mice and Men",mangaka6,publisher2,false);


        System.out.println(novel1);
        System.out.println(novel2);
        System.out.println(novel3);
        System.out.println(comic1);
        System.out.println(comic2);
        System.out.println(comic3);
        System.out.println(comic4);
        System.out.println(comic5);
        System.out.println(comic6);

    }
}
