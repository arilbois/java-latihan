import java.util.Scanner;

public class GuessNumber{
	public static void main(String[] args){
		int guess, secret;
		Scanner input = new Scanner(System.in);
		boolean pass = false;

		secret =1 +(int) (Math.random() * 10); 
		System.out.println("Enter a guess: ");

		for(int i = 0; i < 3 ; i++){
			guess = input.nextInt();
			if(guess == secret){
				System.out.println("Right");
				System.out.println("You Win");
				pass =true ;
				break;
			}else if(Math.abs(guess - secret) == 1){
				System.out.println("hot");
			}else if(Math.abs(guess - secret) == 2){
				System.out.println("Warm");
			}else{
				System.out.println("cold");
			}
		}
		System.out.println("wrong.");
		System.out.println("the correct number was " + secret + ".");
		System.out.println("You lose the game");
	}
}