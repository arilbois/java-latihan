import Childs.Comic;
import Childs.Mangaka;

public class MainApp {
    public static void main(String[] args) {
        Paper paper1 = new Paper("Best Paper",400);
        Publisher publisher1 = new Publisher("Pastel Books","Indonesia",paper1);
        Mangaka mangaka1 = new Mangaka("Masashi","Kishimoto","Japan","Male","Fiksi",56,"Best saller");
        Comic comic1 = new Comic("Naruto The Last","12 Desember 1999",mangaka1,publisher1,"")
        
    }
}
