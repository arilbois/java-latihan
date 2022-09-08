package childs;

import parent.BookProduct;
import parent.Person;


public class Book extends BookProduct {
    private Mangaka novelis;

    public Book(String bookCode, String title, Person person, Publisher publisher) {
        super(bookCode, title, person, publisher);
    }

}
