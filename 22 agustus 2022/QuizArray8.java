import java.util.Scanner;

public class QuizArray8{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String kalimatOriginal, palindrome = ""; 
		Scanner in = new Scanner(System.in);   

		System.out.println("Masukan kata");  

		kalimatOriginal = in.nextLine();   
		int length = kalimatOriginal.length();   
		for ( int i = length - 1; i >= 0; i-- )  
			palindrome = palindrome + kalimatOriginal.charAt(i);  
		if (kalimatOriginal.equals(palindrome))  
			System.out.println("palindrome.");  
		else  
			System.out.println("bukan palindrome.");   
	}
}