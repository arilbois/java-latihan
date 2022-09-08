import java.util.Scanner;
public class Array2Dimensi {

	public static void main(String[] args){
		String roles[][] = {
			{ "admin", "customer", "cashier", "manager" },
			{ "Jasmine", "lyka", "marbie", "soleen" },
			{ "mama", "papa", "jenilyn", "efren" }
		};

		String temp[][] = new String[roles];

		int masa = 1, lama = 3;

		String admin = roles[masa][lama];

		System.out.println(admin);


	}

}