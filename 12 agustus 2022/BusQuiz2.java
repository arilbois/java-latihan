import java.util.Scanner;
import java.text.DecimalFormat;

public class BusQuiz2{
	public static void main( String[] args){

		//deklarasi
		String bus60, bus45, bus32, bus18, bus12, bus6, recommend;
		double busP60, busP45, busP32, busP18, busP12, busP6, busPrice;
		int numOfPassenger, busSeat6, busSeat12 , busSeat18 , busSeat32 , busSeat45 , busSeat60 , passengerMaximal , passengerMinimal, totalBus;

		Scanner input = new Scanner(System.in);	//untuk input
		DecimalFormat f = new DecimalFormat("#,###,###"); // untuk format (jutaan)

		//inisialisasi harga bus *P for price
		busP60 = 2300000;
		busP45 = 2000000;
		busP32 = 1800000;
		busP18 = 1500000;
		busP12 = 1300000;
		busP6 = 2000000;
		busPrice = 0;

		busSeat60 = 60;
		busSeat45 = 45;
		busSeat32 =32 ;
		busSeat18 =18 ;
		busSeat12 =12 ;
		busSeat6 =6 ;
		passengerMaximal = 120;
		passengerMinimal = 0;

		recommend = "";
		totalBus = 1;

		//inisialisasi keterangan bus

		bus60 = "Bus With Seat 60 Rp. 2,300,000";
		bus45 = "Bus With Seat 45 Rp. 2,000,000";
		bus32 = "Bus With Seat 32 Rp. 1,800,000";
		bus18 = "Bus With Seat 18 Rp. 1,500,000";
		bus12 = "Bus With Chair 12 Rp. 1,300,000";
		bus6  = "Bus Executive with 6 Chairs Rp. 2,000,000";

		System.out.println("\n============= Screened Results =========== ");
		System.out.println("Welcome to Secret Travel\n");
		System.out.println("Enter Number of Passengers: ");
		numOfPassenger = input.nextInt();

		System.out.println("Buses Available For You:\n");

		if(numOfPassenger > passengerMaximal){
			System.out.println("Travel can handle maximum 120 passengers");
		}else{
			if(numOfPassenger >= busSeat60 && numOfPassenger  <= passengerMaximal){
				System.out.println(bus60);
			}if(numOfPassenger >= busSeat45){
				System.out.println(bus45);
			}if(numOfPassenger >= busSeat32){
				System.out.println(bus32);
			}if(numOfPassenger >= busSeat18){
				System.out.println(bus18);
			}if(numOfPassenger >= busSeat12){
				System.out.println(bus12);
			}if(numOfPassenger > passengerMinimal){
				System.out.println(bus6);
			}else{
				System.out.println("no passengers");
			}
		
System.out.println("* Recommended bus for you\n");

		if(numOfPassenger > passengerMinimal && numOfPassenger <= busSeat6){
		
				busPrice += totalBus * busP6;
				recommend = totalBus + " buses executive with 6 Chairs with a price of " + f.format(busPrice);
			}
		if(numOfPassenger >= busSeat12){
			totalBus = numOfPassenger / busSeat12;
			busPrice = totalBus * busP12;

			//System.out.print(totalBus);

			System.out.print(totalBus + " buses with 12 Chairs ");
				if (totalBus == 1) {
					System.out.print("with a price of ");
				}
				else if (totalBus > 1) {
					System.out.print("and ");
				}
		}
		if(numOfPassenger >= busSeat18){
			totalBus = numOfPassenger / busSeat18;
			busPrice = totalBus * busP18;

			//System.out.print(totalBus);

			System.out.print(totalBus + " buses with 18 Chairs ");
				if (totalBus == 1) {
					System.out.print("with a price of ");
				}
				else if (totalBus > 1) {
					System.out.print("and ");
				}
		}if(numOfPassenger >= busSeat32){
			totalBus = numOfPassenger / busSeat32;
			busPrice = totalBus * busP32;

			//System.out.print(totalBus);

			System.out.print(totalBus + " buses with 32 Chairs ");
				if (totalBus == 1) {
					System.out.print("with a price of ");
				}
				else if (totalBus > 1) {
					System.out.print("and ");
				}
		}if(numOfPassenger >= busSeat45){
			totalBus = numOfPassenger / busSeat45;
			busPrice = totalBus * busP45;

			//System.out.print(totalBus);

			System.out.print(totalBus + " buses with 45 Chairs ");
				if (totalBus == 1) {
					System.out.print("with a price of ");
				}
				else if (totalBus > 1) {
					System.out.print("and ");
				}
		}if(numOfPassenger >= busSeat60){
			totalBus = numOfPassenger / busSeat60;
			busPrice = totalBus * busP60;

			//System.out.print(totalBus);

			System.out.print(totalBus + " buses with 60 Chairs ");
				if (totalBus == 1) {
					System.out.print("with a price of ");
				}
				else if (totalBus > 1) {
					System.out.print("and ");
				}
		}

		System.out.print(f.format(busPrice));

}





//System.out.print(recommend);

		
		
		
		

	}
}











