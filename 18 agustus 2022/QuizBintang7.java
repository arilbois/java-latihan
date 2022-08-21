import java.util.Scanner;

public class QuizBintang7{
	public static void main(String[] args){
		int baris;

		Scanner input = new Scanner(System.in);

		System.out.println("7 \nInput Jumlah Baris: ");
		baris = input.nextInt();

		for(int i = 1; i <= baris;i++){
			for(int j = 1; j < i;j++){
				System.out.print(" ");
			}
			for(int k = baris; k >= i;k--){
				System.out.print("* ");
			}
			System.out.println(" ");
		}
	}
}