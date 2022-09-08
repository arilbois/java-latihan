package Childs;

import Publisher;

public class Comic extends  BookProduct{
    boolean volumeSeries;

    public Comic(String title, String releaseDate, Mangaka mangaka, Publisher publisher, Double price, boolean volumeSeries) {
        super(title, releaseDate, mangaka, publisher, price);
        this.volumeSeries = volumeSeries;
    }
    private void calculatePrice() {
        double percent;
        if (((Mangaka)getAuthor()).getRating().equalsIgnoreCase("New Comer") && volumeSeries) {
            percent = 1.35;
        }else if (((Mangaka)getAuthor()).getRating().equalsIgnoreCase("New Comer") && !volumeSeries) {
            percent = 1.25;
        }else if(((Mangaka)getAuthor()).getRating().equalsIgnoreCase("Good") && volumeSeries){
            percent = 1.45;
        }else if(((Mangaka)getAuthor()).getRating().equalsIgnoreCase("Good") && !volumeSeries){
            percent = 1.3;
        }else if(((Mangaka)getAuthor()).getRating().equalsIgnoreCase("Best Seller") && volumeSeries){
            percent = 1.5;
        }else{
            percent = 1.4;
        }
        this.setPrice(getPublisher().getProductionCost() * percent);
    }
}
