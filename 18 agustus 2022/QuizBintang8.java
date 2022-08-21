import java.util.Scanner;

public class QuizBintang8{
	public static void main(String[] args){
		int baris;

		Scanner input = new Scanner(System.in);

		System.out.println("6 \nInput Jumlah Baris: ");
		baris = input.nextInt();

		for (int i=1; i<=baris; i++) {
			for (int j=1; j<i; j++) {
		 		System.out.print("0");
		 	}
		 	System.out.print("*");
		 	for (int j=baris; j>i; j--) {
		 		System.out.print("0");
		 	}
		 	System.out.println("");
		}
	}
}