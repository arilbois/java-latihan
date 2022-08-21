import java.util.Scanner;

public class HighLow{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);

		int secret, guess;

		secret = 1 + (int)(100 * Math.random());

		System.out.println("I'm thinking of a number between 1 - 100. ");
		System.out.println("Try to Guess it!");
		System.out.println("> ");
		guess = input.nextInt();

		while(secret != guess){
			if(guess < secret){
				System.out.println("Sorry, Your guess is too low.");
				System.out.println("Try again.\n> ");
				guess = input.nextInt();
			}
			if(guess > secret){
				System.out.println("Sorry, Your guess is too High.");
				System.out.println("Try again.\n> ");
				guess = input.nextInt();
			}
		}

		System.out.println("You guessed it!");
	}
}