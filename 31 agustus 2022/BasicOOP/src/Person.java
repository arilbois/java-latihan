public class Person {
    String name, address;
    final String country = "Indonesia";


    Person() {

    }

    Person(String paramName) {
        name = paramName;
    }

    Person(String paramName, String paramAddress) {
        this.name = name;
        this.address = address;
    }

    void sayHello(String paramName) {

        System.out.println("Hello " + paramName + ", Myname is " + name + ".");
    }

    String sayAddress() {

        return "I, come from " + address + ".";
    }
}
