package parent;
import childs.Author;
import childs.Publisher;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class Book{
    String bookCode, title;
    double price;
    Author author;
    Publisher publisher;
    //Constructor
    public Book(String bookCode, String title, Author author, Publisher publisher) {
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
    //Getter
    public Author getAuthor(){
        return this.author;
    }
    public Publisher getPublisher(){
        return this.publisher;
    }
    public String getBookCode() {
        return bookCode;
    }
    public String getTitle() {
        return title;
    }
    //Setter
    protected void setPrice(double price) {
        this.price = price;
    }
    //For Indonesian Currency Format
    public String indonesiaCurrency(){
        DecimalFormat	indonesiaCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        indonesiaCurrency.setDecimalFormatSymbols(formatRp);
        return indonesiaCurrency.format(price);
    }
    //For Show Data
    @Override
    public String toString() {
        return
                "\nBook Code        : " + getBookCode() +
                        "\nTitle            : " + getTitle()+
                        "\nPublisher        : " + getPublisher().getPublisherName() +
                        "\nPrice            : " + indonesiaCurrency() +
                        "\nlocation         : " + getAuthor().getCountry();

    }
}

