package childs;

import parent.Person;

public class Novelis extends Person {
    String  rating;
    boolean serial;

    public String getRating() {
        return rating;
    }

    public boolean isSerial() {
        return serial;
    }

    public Novelis(String firstName, String lastName, String country, int age, String rating, boolean serial) {
        super(firstName, lastName, country, age);
        this.rating = rating;
        this.serial = serial;
    }
}
