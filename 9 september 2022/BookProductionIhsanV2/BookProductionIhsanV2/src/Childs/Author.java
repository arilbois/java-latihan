package Childs;

import Parents.Person;

public class Author extends Person {
    private String gender;
    private Integer age;
    private String genre;

    public Author(){
        super();
    }
    public Author(String firstName, String lastName, String country, String gender, String genre, Integer age){
        super(firstName, lastName, country);
        this.gender = gender;
        this.age = age;
        this.genre = genre;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return genre;
    }

    public String toString(){
        return  super.toString()+
                "\ngender    : "+gender+
                "\nage       : "+age+
                "\ngenre     : "+genre;
    }
}
