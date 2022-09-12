import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        //char
        String string = "Syahril Lukman Nur Hakim";

        List<Character> chars = new ArrayList<>();

        for (char ch : string.toCharArray()) {

            chars.add(ch);
        }

        System.out.println(chars);


        //arraylist
        ArrayList<String> languages = new ArrayList<>();

        // add elements in the array list
        languages.add("Java");
        languages.add("Kotlin");
        languages.add("C++");
        languages.add(2, "Type Script");//menambahkan data sesuai index
        languages.lastIndexOf("C++");
        System.out.println("ArrayList: " + languages);

        // change the element of the array list
        languages.set(2, "JavaScript");
        System.out.println("Modified ArrayList: " + languages);

        System.out.println("Accessing individual elements:  ");

        for (String language : languages) {
            System.out.print(language);
            System.out.print(", ");
        }

        ArrayList cars = new ArrayList<>();
        cars.add("blue");
        cars.add(3);
        cars.add(true);
        cars.add(90.000000);
        cars.listIterator(2);


        System.out.println("\nmobil berwarna " + cars.get(0) + " dengan panjang body " + cars.get(1) + " M " + "Sudah dijual dipasaran " + cars.get(2) + " dengan harga " + cars.get(3));


        ArrayList sec_list = new ArrayList();
        sec_list = (ArrayList)cars.clone();

        // Displaying the other linked list
        System.out.println("Second ArrayList is: "
                + sec_list);

        Scanner input = new Scanner(System.in);
        String car1 = "" , car2= "", car3= "", car4= "";

        ArrayList<ArrayList> carsx = new ArrayList<>();
        carsx.add(new ArrayList());
        carsx.add(new ArrayList());
        len(carsx);
            for(int i = 0;i < len;i++){
        }

        System.out.println(carsx);

    }
}
