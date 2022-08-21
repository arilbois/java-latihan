import java.util.Scanner;

public class NameLoop{
	public static void main(String []args){
		String name;
		int n,x;
		Scanner input = new Scanner(System.in);
		System.out.println("Masukan nama");
		name = input.next();
		System.out.println("Masukan Berapa x dicetak");
		x = input.nextInt();

		for(n = 1;n <= x;n++){
			System.out.println(n +" "+ name);
		}

		for(n = 2; n < 10;n+=5){
			System.out.println(n + " genap " +name);
		}

	}
}