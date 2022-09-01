import java.util.Scanner;
import java.util.Arrays;  

public class QuizArray4{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int[] numbers = {3,2,5,11,7,10,11,3,15,11,17,10,5};
		int arrayValue = 0, indexPosisi = 0, j = 0;


		System.out.println("Masukan Nilai yang akan disisipkan: ");
		arrayValue = input.nextInt();
		System.out.println("Disisipkan pada index ke : ");
		indexPosisi = input.nextInt();

		int lengthNumber = numbers.length;
		int newArray[] = new int[lengthNumber+1];
		for(int i = 0; i < newArray.length; i++ ){
			if(i == indexPosisi){
				newArray[i] = arrayValue;
			}else{
				newArray[i] = numbers[j];
				j++;
			}
		}
		
		numbers = newArray;
		System.out.print("Nilai dari numbers adalah: "+Arrays.toString(numbers));

	}
}