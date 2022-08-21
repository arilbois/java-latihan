import java.util.Scanner;

public class Guess{
public static void main(String[] args){
	int number,guess = 1 + (int)(100 * Math.random()) ;

	Scanner input = new Scanner(System.in);
	System.out.println("guess a number");
	number = input.nextInt();

	while(number != guess){
		if(number > guess ){
			System.out.println("To high");
		}else if(number < guess){
			System.out.println("To low");
		}number = input.nextInt();
	} 
	System.out.println("betul");
}
}