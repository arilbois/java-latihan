import java.util.Scanner;

public class QuizArray3{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] numbers = {3,2,5,11,7,10,11,3,15,11,17,10,5};
		int index1, index2, indexTemp;

		System.out.println("Nilai dari numbers adalah: ");
		for(int num : numbers){
			System.out.print(num + " ");
		}

		System.out.print("\nMasukan index Pertama : ");
		index1 = input.nextInt();
		index1 -= 1;

		indexTemp = numbers[index1]; 
		System.out.print("Masukan index Kedua : ");
		index2 = input.nextInt();

		index2 -= 1;
		numbers[index1] = numbers[index2];
		numbers[index2] = indexTemp;

		System.out.print("Nilai dari numbers adalah: ");

	for(int num : numbers){
			System.out.print(num + " ");
		}

	}
}