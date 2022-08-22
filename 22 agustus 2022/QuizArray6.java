import java.util.Scanner;

public class QuizArray6{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] numbers = {3,2,5,11,7,10,11,3,15,11,17,10,5};
		int  minNumber;


		System.out.println("Nilai dari numbers adalah: ");
		for(int num : numbers){
			System.out.print(num + " ");
		}
		System.out.println("");

		for (int i = 0; i < numbers.length; i++) {
			for(int j = numbers.length - 1;j> i; j--){
				if(numbers[j] < numbers[i]){
					minNumber = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = minNumber;
				}
			}
		}

		for(int num : numbers){
			System.out.print(num + " ");
		}
	}
}


