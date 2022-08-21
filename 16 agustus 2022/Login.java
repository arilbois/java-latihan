import java.util.Scanner;

public class Login{
	public static void main(String[] args){
		String inputUsername,username = "aril";
		int inputPin,pin = 1234;

		Scanner input = new Scanner(System.in);
		System.out.println("Silahkan masukan usename dan pin");

		inputUsername = input.next();
		inputPin = input.nextInt();

		while(inputUsername != username && inputPin != pin){
		
		System.out.println("Username / pin salah!!");
		System.out.println("Silahkan masukan usename dan pin");

		inputUsername = input.next();
		inputPin = input.nextInt();
		}
		System.out.println("correct");
	}
}