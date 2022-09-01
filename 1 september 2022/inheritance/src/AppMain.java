public class AppMain {
    public static void main(String[] args) {
        Person person1 = new Person("Hendra", "Garut");

        Person person2 = new Programmer("Aril","Bandung Barat","Java");
        person2.greeting();
        System.out.println(((Programmer)person2).technology);
        System.out.println();

        Person person3 = new Teacher("Andre","Cimahi","IPA");
        Person person4 = new Doctor("Andri","Kediri", "FIsik");

        Teacher teacher1 = new Teacher();
        teacher1.name = "Budi";
        teacher1.address = "Jakarta";
        teacher1.subject = "Matematika";

        Doctor doctor1 = new Doctor();
        doctor1.name = "Elis";
        doctor1.address = "Jakarta";
        doctor1.specialist = "Dentis";

        Doctor doctor2 = new Doctor("Joko", "tegal", "Cardiologist");

        Programmer programmer1 = new Programmer();
        programmer1.name = "syahril";
        programmer1.address = "Bandung";
        programmer1.technology = "Golang";

        person1.greeting();
        System.out.println();

        teacher1.greeting();
        System.out.println();

        doctor1.greeting();
        System.out.println();
        doctor2.greeting();
        System.out.println();

        programmer1.greeting();
        System.out.println();

        sayHello(person2);
        sayHello(person3);
        sayHello(person4);
    }
    static void sayHello(Person person){
        String message;
        if(person instanceof Programmer){
            Programmer programmer = (Programmer) person;
            message = "Hello, " +programmer.name + ". Seorang Programmer " + programmer.technology + ".";
        }else if (person instanceof Teacher){
            Teacher teacher = (Teacher) person;
            message = "Hello, " + teacher.name + ". Seorang Guru " + teacher.subject + ".";
        } else if (person instanceof Doctor) {
            Doctor doctor = (Doctor) person;
            message = "Hello, " + doctor.name + ". Seorang Dokter " + doctor.specialist + ".";
        }else {
            message = "Hello, " + person.name;
        }
        System.out.println(message);
    }
}
