import java.util.Scanner;

public class QuizBintang4{
	public static void main(String[] args){
		int baris;

		Scanner input = new Scanner(System.in);

		System.out.println("masukan baris");
		baris = input.nextInt();

		for (int i = 0; i < baris; i++) {
			for (int j = baris; j > i; j--) {
				System.out.print("* ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 1; i <= baris; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			for (int k = baris; k >= i; k--) {
				System.out.print(" ");
			}
			System.out.println();

		}
	}
}