import java.util.Scanner;

public class QuizArray9{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int batas, k = 0;
		String kalimat;
		String[] kalimatArray;

		System.out.print("\nBatas segitiga : ");

		batas = input.nextInt();
		
		System.out.print("\nkalimat : ");
		
		input.nextLine();
		kalimat = input.nextLine(); 
		
		kalimatArray = kalimat.split("");
		int length = kalimat.length();


		for(int i = 1; i <= batas;i++){
			for(int j = i; j < batas;j++){
				System.out.print(" ");
			}
			for(int j = i; j >= 1;j--){
				if (j <= batas){
					if (k < length){
						System.out.print(kalimatArray[k]+" ");
					}
					k++;
				}else{
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}