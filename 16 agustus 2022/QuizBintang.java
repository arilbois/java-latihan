import java.util.Scanner;

public class QuizBintang{
	public static void main(String[] args){
		int baris;

		Scanner input = new Scanner(System.in);

		System.out.println("1 \nInput Jumlah Baris: ");
		baris = input.nextInt();

		for(int i = 0;i < baris;i++){
			for(int j = baris;j > i;j--){
				System.out.print("* ");
			}
			System.out.println("");
		}
	}
}