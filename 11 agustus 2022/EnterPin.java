import java.util.Scanner;

public class EnterPin{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int pin, entry;

		pin = 123;

		System.out.println("WELCOME TO THE BANK OF JAVA");
		System.out.print("ENTER YOUR Pin: ");
		entry = input.nextInt();

		while(entry != pin){
			System.out.println("\nINCORRECT PIN. TRY AGAIN.");
			System.out.println("ENTER YOUR Pin: ");
			entry = input.nextInt();
		}

		System.out.println("\nPIN ACCEPTED. YOUR ACCOUNT BALANCE $102.00");
	}
}