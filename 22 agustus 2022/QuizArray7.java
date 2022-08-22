import java.util.Scanner;
import java.util.Arrays;

public class QuizArray7{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] numbers = {3,2,5,11,7,10,11,3,15,11,17,10,5};
		String duplicates = "";

		System.out.println("Nilai dari numbers adalah: ");
		for(int num : numbers){
			System.out.print(num + " ");
		}
		System.out.println("");
		System.out.println("");

		System.out.println("angka duplikasi yang ada di arrays numbers adalah ");

		for(int i = 0; i < numbers.length; i++) {  
			for(int j = i + 1; j < numbers.length; j++) {  
				if (numbers[i] == numbers[j] &&!duplicates.contains(String.valueOf(numbers[j]))) {
					duplicates += String.valueOf(numbers[j]) + ", ";
				System.out.print(numbers[j] + " ");  
			}
		}
	}

}
}