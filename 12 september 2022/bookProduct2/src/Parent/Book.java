package Parent;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import Childs.Author;

public class Book {
    private String title, releaseDate;
    private Author author;
    private Publisher publisher;
    private Double price;

    public Book() {
    }

    public Book(String title, String releaseDate, Author author, Publisher publisher) {
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

    void calculatePrice() {
        this.setPrice(getPublisher().getPaper().getPaperPrice() * 1.5);
    }

    @Override
    public String toString() {
        return "Title                 : " + title +
                "\nRelease Date          : " + releaseDate +
                "\nauthor                : " + author.getFirstName() + " " + author.getLastName() +
                "\nprice                 : " + indonesiaCurrency() +
                "\ncountry               : " + author.getCountry() +
                "\npublisher             : " + publisher.getCompanyName() + "\n";

    }

    public String indonesiaCurrency() {
        DecimalFormat indonesiaCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        indonesiaCurrency.setDecimalFormatSymbols(formatRp);
        return indonesiaCurrency.format(price);
    }
}
