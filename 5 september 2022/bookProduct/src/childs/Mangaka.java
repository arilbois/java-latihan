package childs;

import parent.Person;

public class Mangaka extends Author {
    String rating;
    //Construktor
    public Mangaka(String firstName, String lastName, String country, int age, String rating) {
        super(firstName, lastName, country, age);
        this.rating = rating;
    }
    //Getter
    public String getRating() {
        return rating;
    }

}
