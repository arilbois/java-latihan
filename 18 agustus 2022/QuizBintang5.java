import java.util.Scanner;

public class QuizBintang5{
	public static void main(String[] args){
		int baris;

		Scanner input = new Scanner(System.in);

		System.out.println("5 \nInput Jumlah Baris: ");
		baris = input.nextInt();

		for (int i = 1; i<= baris;i++) {
			for (int j = 0;j < i; j++) {
				System.out.print(" ");
			}
			for (int k = baris; k > i; k--) {
				System.out.print("*");
			}
			System.out.println();
}
		for (int i = 1; i<= baris;i++) {
			for (int j = baris;j > i; j--) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}