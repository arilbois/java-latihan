package childs;

public class Novelis extends Author {
    String  rating;
    boolean serial;
    //Construktor
    public Novelis(String firstName, String lastName, String country, int age, String rating, boolean serial) {
        super(firstName, lastName, country, age);
        this.rating = rating;
        this.serial = serial;
    }
    //Getter
    public String getRating() {
        return rating;
    }

    public boolean isSerial() {
        return serial;
    }
}
