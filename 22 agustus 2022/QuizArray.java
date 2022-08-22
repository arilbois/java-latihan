import java.util.Scanner;

public class QuizArray{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int[] numbers = {3,2,5,11,7,10,11,3,15,11,17,10,5};
		int findNumber = 0, count = 0;
		boolean isThere = false;

		System.out.print("Masukan angka yang anda cari : ");
		findNumber = input.nextInt();
		
		for(int i = 0; i < numbers.length; i++){
			if(findNumber == numbers[i]){
				isThere = true;
				count++;
			}
		}

		if(isThere == true){
			System.out.println("Angka " + findNumber + " yang anda cari ditemukan di array numbers.");
			System.out.println("ada " + count + " angka " + findNumber + " didalam array numbers.");
			System.out.println("yaitu pada index ke : ");
			for(int i = 0;i< numbers.length; i++){
				if(findNumber == numbers[i]){
					System.out.print(i+ " ");
				}
			}
		}else{
			System.out.println("Angka " + findNumber + " yang anda cari tidak ditemukan di array ");;
		}
	}
}
