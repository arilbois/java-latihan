package childs;

import parent.Person;

public class Mangaka extends Person {
    String rating;

    public String getRating() {
        return rating;
    }

    public Mangaka(String firstName, String lastName, String country, int age, String rating) {
        super(firstName, lastName, country, age);
        this.rating = rating;
    }
}
