import childs.Doctor;
import childs.Programmer;
import childs.Teacher;
import parents.Person;

public class AppMain {
    public static void main(String[] args) {
        Person person1 = new Person();
        String name = "bius";
        person1.setName(name);
        person1.setAddress("Bandung");

        Person person2 = new Programmer("aril","bandung","go");

        System.out.println(person1.getName());

        sayHello(person2);
    }
    static void sayHello(Person person){
        String message;
        if(person instanceof Programmer){
            Programmer programmer = (Programmer) person;
            message = "Hello, " +programmer.getName() + ". Seorang Programmer " + programmer.getTechnology()+ ".";
        }else if (person instanceof Teacher){
            Teacher teacher = (Teacher) person;
            message = "Hello, " + teacher.getName() + ". Seorang Guru " + teacher.getSubject() + ".";
        } else if (person instanceof Doctor) {
            Doctor doctor = (Doctor) person;
            message = "Hello, " + doctor.getName() + ". Seorang Dokter " + doctor.getSpecialist() + ".";
        }else {
            message = "Hello, " + person.getName();
        }
        System.out.println(message);
    }
}
