package childs;
public class Novel extends BookProduct {
    String genre;
    //Constructor

    public Novel(String bookCode, String title, Novelis novelis, Publisher publisher, String genre) {
        super(bookCode, title, novelis, publisher);
        this.genre = genre;
        calculatePrice();
    }
    //Calculate Price
    private void calculatePrice() {
        double percent;
        if (((Novelis) getAuthor()).getRating().equalsIgnoreCase("New Comer")) {
            percent = 1.25;
            this.setPrice(getPublisher().getProductionCost() * percent);
        } else {
            if (((Novelis) getAuthor()).getRating().equalsIgnoreCase("Good")) {
                percent = 1.35;
            } else {
                percent = 1.5;
            }
            this.setPrice(getPublisher().getProductionCost() * percent);
        }
    }

    //Getter
    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return          "Novelis          : " + getAuthor().getFullName() +
                        super.toString() +
                        "\nGenre            : " + getGenre() +
                        "\nlocation         : " + getAuthor().getCountry()+
                        "\n===================================";
    }
}
