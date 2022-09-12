package Childs;

import Parent.Person;

public class Reviewer extends Person {
    private Boolean isVerified;

    public Reviewer(String firstName, String lastName, String country, Boolean isVerified) {
        super(firstName, lastName, country);
        this.isVerified = isVerified;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVerified              : " + getVerified();
    }
}
