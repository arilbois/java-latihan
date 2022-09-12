package Childs;

import Parent.Person;

public class Author extends Person {
    private String gender, genre;
    private Integer age;

    public Author(String firstName, String lastName, String country, String gender, String genre, Integer age) {
        super(firstName, lastName, country);
        this.gender = gender;
        this.genre = genre;
        this.age = age;
    }

    public Author() {
        super();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nGender                : " + gender +
                "\nGenre                 : " + genre +
                "\nAge                   : " + age + "\n";

    }
}
