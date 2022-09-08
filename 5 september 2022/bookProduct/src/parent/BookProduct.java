package parent;
import childs.Novelis;
import childs.Publisher;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class BookProduct {
    String bookCode, title;
    double price;
    Person person;
    Publisher publisher;
    //Construktor
    public BookProduct(String bookCode, String title, Person person, Publisher publisher) {
        this.bookCode = bookCode;
        this.title = title;
        this.person = person;
        this.publisher = publisher;
    }
    //Getter
    public double getPrice() {
        return price;
    }
    public Person getPerson(){
        return this.person;
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

    public String indonesiaCurrency(){
        DecimalFormat	indonesiaCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        indonesiaCurrency.setDecimalFormatSymbols(formatRp);
        return indonesiaCurrency.format(price);
    }

    @Override
    public String toString() {
        return "Book Code         : " + getBookCode() +
                "\nTitle         : " + getTitle() +
                "\nPrice         : " + getPrice() +
                "\nPerson         : " + getPerson() +
                "\nPubliser         : " + getPublisher() ;
    }
}

