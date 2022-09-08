public class Book implements Price{
    private String bookCode;
    private String title;
    private Author author;
    private Publisher publisher;
    private Double price;

    public Book() {
        // TODO Auto-generated constructor stub
    }

    public Book(String bookCode, String title, Author author, Publisher publisher) {
        super();
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        calculatedPrice();
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void calculatePrice() {
        setPrice(publisher.getProductionCost() * 1.2);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Title : " + title
                +"\n"+ author
                +"\n" + publisher
                +"\nPrice : " + price;
    }

    @Override
    public void calculatedPrice() {
        setPrice(publisher.getProductionCost() * RATE_PRICE_BOOK);
    }
}