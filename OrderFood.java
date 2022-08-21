import java.util.Scanner;

public class OrderFood{
	public static void main( String [] args){
	
		Scanner input = new Scanner(System.in);
		String cuaca;
	
		System.out.print("Cuaca sore ini: ");
		cuaca = input.nextLine();
	
		if(cuaca.equals("hujan")){
			System.out.println("Saya membeli makanan menggunakan Aplikasi GoFood");
		}else if(cuaca.equals("mendung")){
			System.out.println("Saya akan pergi ke restoran untuk membeli makanan dengan mengendarai mobil.");
		}else if(cuaca.equals("cerah") || cuaca.equals("panas")){
			System.out.println("saya akan pergi ke restoran untuk membeli makanan dengan mengendarai motor");
		}else{
			System.out.println("saya akan pergi ke restoran untuk membeli makanan menggunakan payung.");
		}
	}
}