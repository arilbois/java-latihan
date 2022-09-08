package childs;

import parent.BookProduct;
import parent.Person;
public class Comic extends Book {
   private boolean volumeSeries;
    private Mangaka mangaka;
    //Construktor
    public Comic(String bookCode, String title, Mangaka mangaka, Publisher publisher, boolean volumeSeries) {
        super(bookCode, title, mangaka, publisher);
        this.volumeSeries = volumeSeries;
        this.mangaka = mangaka;
        calculatePrice();
    }
    private void calculatePrice() {
        double percen;
        if (mangaka.getRating().equalsIgnoreCase("New Commer") && volumeSeries) {
            percen = 1.35;
        }else if (mangaka.getRating().equalsIgnoreCase("New Commer") && !volumeSeries) {
            percen = 1.25;
        }else if(mangaka.getRating().equalsIgnoreCase("Good") && volumeSeries){
            percen = 1.45;
        }else if(mangaka.getRating().equalsIgnoreCase("Good") && !volumeSeries){
            percen = 1.3;
        }else if(mangaka.getRating().equalsIgnoreCase("Best Seller") && volumeSeries){
            percen = 1.5;
        }else{
            percen = 1.4;
        }
        this.setPrice(getPublisher().getProductionCost() * percen);
    }
 String convertSeries() {
        String series;
        if (volumeSeries) {
            series = "Available";
        } else {
            series = "Not Available";
        }
        return series;
    }



    @Override
    public String toString() {
        return "Novelis          : " + mangaka.getFullName() +
                "\nBook Code        : " + getBookCode() +
                "\nTitle            : " + getTitle()+
                "\nRating           : " + mangaka.getRating() +
                "\nPubliser         : " + getPublisher().getPublisherName() +
                "\nPrice            : " + indonesiaCurrency() +
                "\nlocation         : " + getPerson().getCountry() +
                "\nSeries           : " + convertSeries() +
                "\n===================================";

    }
}

