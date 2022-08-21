import java.util.Scanner;

public class QuizBintang2{
	public static void main(String[] args){
		int baris, bintang;

		Scanner input = new Scanner(System.in);

		System.out.println("2 \nInput Jumlah Bintang: ");
		bintang = input.nextInt();
		System.out.println("Input Jumlah Baris: ");
		baris = input.nextInt();

		for(int i = 1;i <= baris;i++){
			for(int j = 1;j <= bintang;j++){
				System.out.print("* ");
			}
			System.out.println(" ");
		}
	}
}