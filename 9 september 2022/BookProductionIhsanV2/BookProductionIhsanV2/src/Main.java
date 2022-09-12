import Childs.*;
import Parents.*;

public class Main {
    public  static  void main(String[] args) {
        Paper paper1 = new Paper("Best", 10000.0);
        Paper paper2 = new Paper("Good", 7000.0);
        Paper paper3 = new Paper("Low", 5000.0);
        Paper paper4 = new Paper("Good", 120000.0);
        Paper paper5 = new Paper("Best", 150000.0);

        Publisher publisher1 = new Publisher("Dwi Airlangga","Indonesia",paper2);
        Publisher publisher2 = new Publisher("Kodansha","Japan",paper5);
        Publisher publisher3 = new Publisher("Hakusensha","Japan",paper4);
        Publisher publisher4 = new Publisher("Gramedia","Indonesia",paper1);
        Publisher publisher5 = new Publisher("Pustaka Cipta","Indonesia",paper3);

        Author author1 = new Author("Ihsan","Nugraha","Indonesia","Male","Romance",25);
        Author author2 = new Author("J.R.R.","Tolkien","Inggris","Male","Fiction Fantasy",24);
        Author author3 = new Author("Kartini","Armijn Pane","Indonesia","Male","Action",25);
        Author author4 = new Author("Raditya","Dika","Indonesia","Male","Comedy",25);
        Author author5 = new Author("Merle","Calvin","Indonesia","Male","Clasic",23);

        Mangaka mangaka1 = new Mangaka("Oda","Sensei","Japan","Male","Action",30,"Best Seller");
        Mangaka mangaka2 = new Mangaka("Masashi","Kisimoto","Japan","Male","Action",35,"Best Seller");
        Mangaka mangaka3 = new Mangaka("Yasuke","Murata","Japan","Male","Action",40,"Best Seller");
        Mangaka mangaka4 = new Mangaka("Ichigo","Kurosaki","Japan","Male","Action",25,"Good");
        Mangaka mangaka5 = new Mangaka("Hinata","Shoyo","Japan","Male","Sports",27,"New Commer");

        Book book1 = new Book("Diantara Kita","05 September 2017",author1,publisher1);
        Book book2 = new Book("The Hobbits","21 September 1937",author2,publisher3);
        Book book3 = new Book("Habis Gelap Terbitlah Terang","29 Januari 2005",author3,publisher3);
        Book book4 = new Book("Manusia Setengah Salmon"," Desember 2011",author4,publisher5);
        Book book5 = new Book("Sejarah Indonesia Modern","2008",author5,publisher4);

        Comic comic1 = new Comic("onp01","One Pice",mangaka1,publisher2,true);
        Comic comic2 = new Comic("nrt01","Naruto",mangaka2,publisher3,true);
        Comic comic3 = new Comic("opm01","One Punch Man",mangaka3,publisher2,true);
        Comic comic4 = new Comic("blc01","Bleach",mangaka4,publisher3,false);
        Comic comic5 = new Comic("hk01","Haikyu",mangaka5,publisher2,false);

        Reviewer reviewer1 = new Reviewer("Randi","Rivani","Indonesia",true);
        Reviewer reviewer2 = new Reviewer("Rival","Firmansyah","Indonesia",false);
        Reviewer reviewer3 = new Reviewer("Chaswandi","Firmansyah","Indonesia",true);
        Reviewer reviewer4 = new Reviewer("Nana","Hidayat","Indonesia",false);
        Reviewer reviewer5 = new Reviewer("Muhammad","Reza","Indonesia",true);

        Person person1 = new Person("Chika","Ajeng Maesa","Indonesia");
        Person person2 = new Person("Ai","Fatimah","Indonesia");
        Person person3 = new Person("Bill","Gates","America");
        Person person4 = new Person("Thomas","Alva Edison ","America");
        Person person5 = new Person("Torakusu","Yamaha","Japan");

        RatingBook rating1 = new RatingBook(comic1,reviewer1,10.0);
        RatingBook rating2 = new RatingBook(comic2,reviewer2,9.5);
        RatingBook rating3 = new RatingBook(comic3,reviewer3,9.0);
        RatingBook rating4 = new RatingBook(comic4,reviewer4,8.5);
        RatingBook rating5 = new RatingBook(comic5,reviewer5,8.0);

        Customers cust1 = new Customers("Adam","Fariz","Indonesia","Male","Cibatu, Garut, West Java","089587652938","44197","adamfariz@gmail.com");
        Customers cust2 = new Customers("Novia","Alawiyah","Indonesia","Female","Wanaraja, Garut, West Java","081388657620","44183","noviaa@gmail.com");
        Customers cust3 = new Customers("Tina","Maryana","Indonesia","Female","Garut Kota, Garut, West Java","089529830087","44180","maryanatina@gmail.com");
        Customers cust4 = new Customers("Mark","Zuckerberg","America","Male","Palo Alto","(+1)650-543-4800","94020","zuckerberg@fb.com");
        Customers cust5 = new Customers("Jack","Ma","China","Male","Hangzhou","(+86) 571-8502-2088","242332","jackma@hotmail.com");

        System.out.println(book2);
    }
}
