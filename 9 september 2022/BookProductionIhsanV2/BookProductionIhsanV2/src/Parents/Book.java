package Parents;
import Childs.Author;

public class Book {
    private String title;
    private String releaseDate;
    private Author author;
    private Publisher publisher;
    private Double price;

    public Book(){
        super();
    }
    public Book(String title, String releaseDate, Author author, Publisher publisher){
        super();
        this.title = title;
        this.releaseDate = releaseDate;
        this.author = author;
        this.publisher = publisher;
        calculatePrice();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Publisher getPublisher() {
        return publisher;
    }
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void calculatePrice(){
        setPrice(1.5*publisher.getPaper().getPaperPrice());
    }

    // method
    public String toString(){
        return  "==============================="+
                "\ntitle         : "+title+
                "\nrelease date  : "+releaseDate+
                "\nauthor        : "+author.getFirstName()+" "+author.getLastName()+
                "\nprice         : "+price+
                "\ncountry       : "+author.getCountry()+
                "\npublisher     : "+publisher.getCompanyName();
    }
}
