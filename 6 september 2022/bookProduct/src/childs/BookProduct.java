package childs;
import parent.Book;
public class BookProduct extends Book  {
    //Constructor
    public BookProduct(String bookCode, String title, Author author, Publisher publisher) {
        super(bookCode, title, author, publisher);
        calculatePrice();
    }
    private void calculatePrice() {
        double percent = 1.2;
        this.setPrice(getPublisher().getProductionCost() * percent);
    }


}
