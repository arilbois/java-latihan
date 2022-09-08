package childs;
import childs.Novelis;

import parent.BookProduct;
import parent.Person;
public class Novel extends Book {
    String genre;
    Novelis novelis;
    //Construktor

    public Novel(String bookCode, String title, Novelis novelis, Publisher publisher, String genre) {
        super(bookCode, title, novelis, publisher);
        this.genre = genre;
        this.novelis = novelis;
        calculatePrice();
    }

    private void calculatePrice() {
        double percen;
        if (novelis.getRating().equalsIgnoreCase("New Commer")) {
            percen = 1.25;
        } else if (novelis.getRating().equalsIgnoreCase("Good")) {
            percen =  1.35;
        } else {
            percen = 1.5;
        }
        this.setPrice(getPublisher().getProductionCost() * percen);
    }
    //Getter
    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Novelis          : " + novelis.getFullName() +
                "\nBook Code        : " + getBookCode() +
                "\nTitle            : " + getTitle()+
                "\nGenre            : " + getGenre() +
                "\nRating           : " + novelis.getRating() +
                "\nPubliser         : " + getPublisher().getPublisherName() +
                "\nPrice            : " + indonesiaCurrency() +
                "\nlocation         : " + getPerson().getCountry() +
                "\n===================================";

    }
}
