public class Novel extends Book implements Tax{
    private String genre;

    public Novel() {
        // TODO Auto-generated constructor stub
    }

    public Novel(String bookCode, String title, Novelis author, Publisher publisher, String genre) {
        super(bookCode, title, author, publisher);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void calculatePrice() {
        // TODO Auto-generated method stub
        super.calculatePrice();
    }

    @Override
    public double calculatedTax() {
        // TODO Auto-generated method stub

        double tax = (1.4 * getPublisher().getProductionCost()) * RATE_TAX_BOOK;

        return tax;
    }

    @Override
    public void calculatedPrice() {
        // TODO Auto-generated method stub
        setPrice((1.4 * getPublisher().getProductionCost()) + calculatedTax());
    }
}