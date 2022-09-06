package childs;

public class Publisher {
    String publisherName, country;
    double productionCost;

    public double getProductionCost() {
        return productionCost;
    }

    public Publisher() {
    }

    public Publisher(String publisherName, String country, double productionCost) {
        this.publisherName = publisherName;
        this.country = country;
        this.productionCost = productionCost;
    }


}
