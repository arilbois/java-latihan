import java.util.Scanner;

public class QuizArray5{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] numbers = {3,2,5,11,7,10,11,3,15,11,17,10,5};
		int maxNumber= numbers[0], minNumber = numbers [0];


		System.out.println("Nilai dari numbers adalah: ");
		for(int num : numbers){
			System.out.print(num + " ");
		}
		System.out.println("");

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i]>maxNumber){
				maxNumber = numbers[i];
			}else if(numbers[i]<minNumber){
				minNumber = numbers[i];
			}
		}
		System.out.println("\nNilai Terbesar adalah "+maxNumber);
		System.out.println("Nilai Terkecil adalah = "+minNumber);
	}
}


