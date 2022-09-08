package childs;
public class Publisher {
    String publisherName, country;
    double productionCost;
    //Construktor
    public Publisher(String publisherName, String country, double productionCost) {
        this.publisherName = publisherName;
        this.country = country;
        this.productionCost = productionCost;
    }
    //Getter
    public double getProductionCost() {
        return productionCost;
    }
    public String getPublisherName() {
        return publisherName;
    }
}
