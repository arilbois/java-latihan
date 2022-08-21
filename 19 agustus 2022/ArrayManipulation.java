import java.util.Scanner;

public class ArrayManipulation{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int[] orderNumbers = {3,2,5,11,7,10,11,3,15,11,17,10,5};
		int toFind;

		System.out.print("Masukan angka yang anda cari : ");
		toFind = input.nextInt();
		for(int num : orderNumbers){
			System.out.println("Angka" + toFind + "yang anda cari ditemukan di array numbers.");
		}


		for(int num : orderNumbers){
			if(num == toFind){
			System.out.println("Ada" + num + "angka" + toFind +"didalam array numbers.");
			System.out.println("yaitu pada index ke : " + num);
			}
		}
	} 
}