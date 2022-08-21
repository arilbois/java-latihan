import java.util.Scanner;

public class QuizBintang6{
	public static void main(String[] args){
		int baris;

		Scanner input = new Scanner(System.in);

		System.out.println("6 \nInput Jumlah Baris: ");
		baris = input.nextInt();

		for(int i = 1; i <= baris;i++){
			for(int j = baris; j > i;j--){
				System.out.print(" ");
			}
			for(int k = 1; k <= i;k++){
				System.out.print("* ");
			}
			System.out.println(" ");
		}
	}
}