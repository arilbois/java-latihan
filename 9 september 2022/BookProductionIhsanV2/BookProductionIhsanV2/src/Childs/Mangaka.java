package Childs;

public class Mangaka extends Author{
    private String rating;

    public Mangaka(){
        super();
    }
    public Mangaka(String firstName, String lastName, String country, String gender, String genre, Integer age, String rating){
        super(firstName, lastName, country, gender, genre, age);
        this.rating = rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public String toString(){
        return  super.toString()+
                "\nrating        : "+rating;
    }
}
