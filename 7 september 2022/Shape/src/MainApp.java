import childs.Circle;
import childs.Triangle;
import parents.Shape;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Shape lingkaran = new Circle("Biru",20);
        Shape segitiga = new Triangle(10,15,"Merah");


        System.out.println("Luas Lingkaran berwarna " + lingkaran.getColor() + " adalah " + lingkaran.getArea());
        System.out.println("Luas segitiga berwarna " + segitiga.getColor() + " adalah " + segitiga.getArea());

        List<String> list = Arrays.asList("Ryan", "Julie", "Bob");
        for(String lists : list){
                System.out.println(lists);
        }
    }
}
