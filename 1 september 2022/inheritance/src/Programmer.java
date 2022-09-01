public class Programmer extends Person {
    String technology;

    public Programmer(String name, String address, String technology) {
        super(name, address);
        this.technology = technology;
    }

    public Programmer() {
    }

    void hacking() {
        System.out.println("I can hacking a website");
    }

    void coding() {
        System.out.println("I can create a application using technology : " + technology + ".");
    }

    void greeting() {
        super.greeting();
        System.out.println("My job is a " + technology + " programmer");
    }
}