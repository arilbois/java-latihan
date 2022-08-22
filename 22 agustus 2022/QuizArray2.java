import java.util.Scanner;

public class QuizArray2{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int changeIndex = 0, changeNumber;
		int[] numbers = {3,2,5,11,7,10,11,3,15,11,17,10,5};

		System.out.println("array numbers");
		for(int num : numbers){
			System.out.print(num + " ");
		}

		System.out.println("\nMerubah nilai dari arrays numbers !!!");
		System.out.print("Masukan index yang mau diganti : ");
		changeIndex = input.nextInt();
		System.out.print("Masukan Nilai : ");
		changeNumber = input.nextInt();

		for(int i = 0; i < numbers.length; i++){
			if(changeIndex - 1 == i){
				numbers[i] = changeNumber;
			}
		}

		System.out.println("Nilai dari numbers adalah:");
		System.out.print("{");
		for(int num : numbers){
			System.out.print(num + " ");
		}
		System.out.print("}");
	}
}