import java.util.Scanner;

public class Segitiga{
	public static void main(String[] args){
		int baris;
		Scanner input = new Scanner(System.in);

		System.out.println("1 \nMasukan jumlah baris :");
		baris = input.nextInt();

		for(int i = 1; i <= baris;i++){
			for(int j = 1; j <= i;j++){
				System.out.print("* ");
			}
			System.out.println(" ");
		}
		System.out.println(" 2");
		
		for(int i = 1; i <= baris;i++){
			for(int j = baris; j >= i;j--){
				System.out.print("* ");
			}
			System.out.println(" ");
		}

		System.out.println(" 3");
		
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