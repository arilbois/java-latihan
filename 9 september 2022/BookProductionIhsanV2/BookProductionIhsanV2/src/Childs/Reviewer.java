package Childs;
import Parents.Person;

public class Reviewer extends Person {
    private Boolean isVerified;

    public  Reviewer(){
        super();
    }
    public Reviewer(String firstName, String lastName, String country, Boolean isVerified){
        super(firstName, lastName, country);
        this.isVerified = isVerified;
    }

    public Boolean isVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public String toString(){
        return  super.toString()+
                "\nverified      : "+ isVerified;
    }
}
