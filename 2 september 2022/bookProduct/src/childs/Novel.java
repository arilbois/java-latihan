package childs;

import parent.BookProduct;
import parent.Person;

public class Novel extends BookProduct {
    String genre;
    Novelis novelis;

    public Novel(String bookCode, String title, double price, parent.Person novelis, Publisher publisher, String genre) {
        super(bookCode, title, price, novelis, publisher);
        this.genre = genre;
    }
}
