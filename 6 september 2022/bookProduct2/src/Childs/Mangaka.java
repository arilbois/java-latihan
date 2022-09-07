package Childs;

public class Mangaka extends Author {
   private String rating;

    public Mangaka(String firstName, String lastName, String country, String gender, String genre, Integer age, String rating) {
        super(firstName, lastName, country, gender, genre, age);
        this.rating = rating;
    }

    public Mangaka(){
        super();
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
