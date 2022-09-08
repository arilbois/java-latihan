package Parent;

public class Book {
    String title,releaseDate;
    Person person;
    protected Publisher publisher;
    Double price;

    public Book(String title, String releaseDate, Person person, Publisher publisher, Double price) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.person = person;
        this.publisher = publisher;
        this.price = price;
    }

    void calculatePrice(){

    }
}
