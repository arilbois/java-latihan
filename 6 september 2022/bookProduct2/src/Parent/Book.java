package Parent;

import Childs.Author;

public class Book {
    private String title,releaseDate;
    private Author author;
    private Publisher publisher;
    private Double price;

    public Book() {
    }

    public Book(String title, String releaseDate, Author author, Publisher publisher, Double price) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
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
    public Paper getPaper(){
        return this.getPaper();
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    void calculatePrice(){
        this.setPrice(getPaper().getPaperPrice() * 1.5);
    }
}
