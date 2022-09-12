package Childs;

import Parents.Person;

public class Customers extends Person {
    private String gender;
    private String address;
    private String phoneNumber;
    private String postalCode;
    private String email;

    public Customers(){
        super();
    }
    public Customers(String firstName, String lastName, String country, String gender, String address, String phoneNumber, String postalCode, String email){
        super(firstName, lastName, country);
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String toString(){
        return  super.toString()+
                "\ngender        : "+gender+
                "\naddress       : "+address+
                "\nphone number  : "+phoneNumber+
                "\npostal code   : "+postalCode+
                "\nemail         : "+email;
    }
}
