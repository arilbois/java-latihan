package childs;

public class Comic extends BookProduct {
    private boolean volumeSeries;

    //Constructor
    public Comic(String bookCode, String title, Mangaka mangaka, Publisher publisher, boolean volumeSeries) {
        super(bookCode, title, mangaka, publisher);
        this.volumeSeries = volumeSeries;
        calculatePrice();
    }
    //Calculate Price
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
    //Function for Convert Series OutPut
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
        return "Mangaka          : " + getAuthor().getFullName() +
                super.toString() +
                "\nRating           : " + ((Mangaka)getAuthor()).getRating() +
                "\nSeries           : " + convertSeries() +
                "\n===================================";

    }
}

