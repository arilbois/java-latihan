package childs;

import parent.Book;

public class Comic extends Book {
    private Boolean volumeSeries;

    public Comic() {
        // TODO Auto-generated constructor stub
    }

    public Comic(String bookCode, String title, Mangaka author, Publisher publisher,
                 Boolean volumeSeries) {
        super(bookCode, title, author, publisher);
        this.volumeSeries = volumeSeries;
    }

    public Boolean getVolumeSeries() {
        return volumeSeries;
    }

    public void setVolumeSeries(Boolean volumeSeries) {
        this.volumeSeries = volumeSeries;
    }
    @Override
    public void calculatePrice() {
        // TODO Auto-generated method stub
        super.calculatePrice();
    }

    @Override
    public void calculatedPrice() {
        // TODO Auto-generated method stub
        double price = 0;
        if (((Mangaka)getAuthor()).getRating().equalsIgnoreCase("Best Seller")) {
            price = 1.5 * getPublisher().getProductionCost();
        }else {
            price = 1.25 * getPublisher().getProductionCost();
        }
        setPrice(price);
    }
}