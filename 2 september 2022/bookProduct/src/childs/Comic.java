package childs;

import parent.BookProduct;
import parent.Person;

public class Comic extends BookProduct {
    boolean volumeSeries;
    Mangaka Person;


    public Comic(String bookCode, String title, double price, parent.Person mangaka, Publisher publisher, boolean volumeSeries) {
        super(bookCode, title, price, mangaka, publisher);
        this.volumeSeries = volumeSeries;
    }

}

