public class Person {
    String name, address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Person() {
    }

    void greeting(){
        System.out.println("Hello my name is " + name + ".");
        System.out.println("I, Come from " + address + ".");
    }
}
