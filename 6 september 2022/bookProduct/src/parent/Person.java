package parent;

public class Person {
    String firstName, lastName, country;
    int age;

    //Constructor
    public Person(String firstName, String lastName, String country, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }
    //Getter
    public String getCountry() {
        return country;
    }
    public String getFullName(){
        return  firstName + " " + lastName;
    }

}
