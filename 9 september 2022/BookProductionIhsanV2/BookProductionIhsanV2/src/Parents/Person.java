package Parents;

public class Person {
    private String firstName;
    private String lastName;
    private String country;

    public Person(){
        super();
    }

    public Person(String firstName, String lastName, String country){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(){
        return  "\n==============================="+
                "\nname          : "+firstName+" "+lastName+
                "\ncountry       : "+country;
    }
}

