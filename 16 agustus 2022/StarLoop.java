import java.util.Scanner;

public class StarLoop{
	public static void main(String[] args){
		int baris;
		Scanner input = new Scanner(System.in);

		System.out.println("masukan baris");
		baris = input.nextInt();

		for (int i = 0; i < baris; i++) {
			for (int j = baris; j > i; j--) {
				System.out.print("* ");
			}
			for (int k = 0; k <= i; k++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 0; i < baris; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("* ");
			}
			for (int k = baris; k > i; k--) {
				System.out.print(" ");
			}
			System.out.println();


		}
	}
}
