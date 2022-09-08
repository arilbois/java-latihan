import Childs.Author;
import Childs.Customers;
import Childs.Mangaka;
import Childs.Reviewer;
import Childs.Comic;
import Parent.*;

public class MainApp {
    public static void main(String[] args) {
        Paper paper11 = new Paper("low",400.0);
        Paper paper12 = new Paper("low",500.0);
        Paper paper13 = new Paper("Good",600.0);
        Paper paper14 = new Paper("Best",700.0);
        Paper paper15 = new Paper("Best",900.0);

        Person person11 = new Person("Syahril","Lukman","indonesia");
        Person person11 = new Person("Akbar","galang","indonesia");
        Person person11 = new Person("Muhammad","Rizki","indonesia");
        Person person11 = new Person("Widi","widia","indonesia");
        Person person11 = new Person("Robi","rohendi","indonesia");


        Publisher publisher11 = new Publisher("Marvel Entertainment International Ltd","England", paper11);
        Publisher publisher12 = new Publisher("John Wiley & Sons, Inc","United States", paper12);
        Publisher publisher13 = new Publisher("Nature America","United States", paper13);
        Publisher publisher14 = new Publisher("Scholastic, Inc.","United States", paper14);
        Publisher publisher15 = new Publisher("Macmillan Education","England", paper15);

        Author author11 = new Author("Susie","Rae", "England","Female","Fiction",35);
        Author author12 = new Author("A","Osterwalder", "United States","Male","Business",55);
        Author author13 = new Author("Patrick ","O'Dowd", "United States","Male","Education",45);
        Author author14 = new Author("Sylvan","Rae", "United States","Male","Education",45);
        Author author15 = new Author("Conan","Doyle", "England","Male","Fiction",37);

        Mangaka mangaka11 = new Mangaka("Ricardo","Barreiro","Argentina","Male","Fiction",80,"Good");
        Mangaka mangaka12 = new Mangaka("Rutu","Modan","Israel","Female","Fiction",56,"New Comer");
        Mangaka mangaka13 = new Mangaka("Massimo","Belardinelli","Italy","Male","science fiction",68,"Best");
        Mangaka mangaka14 = new Mangaka("Billy","Tan","Malaysia","Male","Fiction", 52,"Good");
        Mangaka mangaka15 = new Mangaka("Yohanes","Surya","Indonesia","Male","science",63,"Good");

        Book book11 = new Book("What Would Hulk Do?","28 October 2021",author11,publisher11);
        Book book12 = new Book("Business Model Generation","20 Augustus 2010",author12,publisher12);
        Book book13 = new Book("United States","1 December 1984",author13,publisher13);
        Book book14 = new Book("00 Words Kids Need to Read","1 January 2002",author14,publisher14);
        Book book15 = new Book("The Norwood Builder and Other Stories","28 October 2021",author15,publisher15);

        Comic Comic11 = new Comic("Le couvent infernal","19 March 2015",mangaka11,publisher11,true);
        Comic Comic12 = new Comic("The Property HC","13 March 2013",mangaka12,publisher12,true);
        Comic Comic13 = new Comic("The John Probe Mission Files","22 March 2018",mangaka13,publisher13,true);
        Comic Comic14 = new Comic("Uncanny X-Men","1 January 2003",mangaka14,publisher14,true);
        Comic Comic15 = new Comic("Fisika Vs Yohanes Surya"," 22 May 2018",mangaka15,publisher15,true);

        Customers customers11 = new Customers("Andre","Kurniadi","Indonesia","Male","Bandung Barat","0821219172822","40554","andre@gmail.com");
        Customers customers12 = new Customers("Rendi","saputra","Indonesia","Male","Jakarta","08789987621","77832","rendiss43@gmail.com");
        Customers customers13 = new Customers("Ima","Holilatul","Malaysia","Female","Johor Baru","0837266372","34323","imaholola@gmail.com");
        Customers customers14 = new Customers("Hyon","park","korea","Female","Busan","0827136713","342342","Hyonpart4@gmail.com");
        Customers customers15 = new Customers("Rian","Sofia","Indonesia","Male","jakrta","0873728372","35332","riansof43@gmial.com");

        Reviewer reviewer11 = new Reviewer("Arul","Dimas","Indonesia",false);
        Reviewer reviewer12 = new Reviewer("Resta","nur Haniza","Indonesia",true);
        Reviewer reviewer13 = new Reviewer("Murni","Salfa","Indonesia",true);
        Reviewer reviewer14 = new Reviewer("Suci","nurhayani","Indonesia",true);
        Reviewer reviewer15 = new Reviewer("yesiva","Ayu","Indonesia",false);

        RatingBook ratingBook1 = new RatingBook(book11,reviewer11,90.0);
        RatingBook ratingBook2 = new RatingBook(book12,reviewer12,80.0);
        RatingBook ratingBook3 = new RatingBook(book13,reviewer13,80.0);
        RatingBook ratingBook4 = new RatingBook(book14,reviewer14,90.0);
        RatingBook ratingBook5 = new RatingBook(book15,reviewer15,70.0);






    }
}
