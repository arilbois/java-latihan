import java.util.Scanner;

public class Segitiga{
	public static void main(String[] args){
		 

         for (int i = 0; i < jumlahBaris; i++) {
            for (int j = jumlahBaris; j > i; j--) {
                System.out.print("*");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(" ");
            }
            System.out.println();
        }
        for (int i = 0; i < jumlahBaris; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int k = jumlahBaris; k > i; k--) {
                System.out.print(" ");
            }
            System.out.println();
    }
}
}