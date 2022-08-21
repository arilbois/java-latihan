import java.util.Scanner;
import java.text.DecimalFormat;

public class BusQuiz2{
	public static void main( String[] args){

		//deklarasi
		String bus60, bus45, bus32, bus18, bus12, bus6;
		double busP60, busP45, busP32, busP18, busP12, busP6;
		int passenger;

		Scanner input = new Scanner(System.in);	//untuk input
		DecimalFormat f = new DecimalFormat("#,###,###"); // untuk format (jutaan)

		//inisialisasi harga bus *P for price
		busP60 = 2300000;
		busP45 = 2000000;
		busP32 = 1800000;
		busP18 = 1500000;
		busP12 = 1300000;
		busP6 = 2000000;

		//inisialisasi keterangan bus

		bus60 = "Buses Available For You: \n\nBus With Seat 60 Rp. 2,300,000 \nBus With Seat 45 Rp. 2,000,000 \nBus With Seat 32 Rp. 1,800,000 \nBus With Seat 18 Rp. 1,500,000 \nBus With Chair 12 Rp. 1,300,000 \nBus Executive with 6 Chairs Rp. 2,000,000\n";
		bus45 = "Buses Available For You: \n\nBus With Seat 45 Rp. 2,000,000 \nBus With Seat 32 Rp. 1,800,000 \nBus With Seat 18 Rp. 1,500,000 \nBus With Chair 12 Rp. 1,300,000 \nBus Executive with 6 Chairs Rp. 2,000,000\n";
		bus32 = "Buses Available For You: \n\nBus With Seat 32 Rp. 1,800,000 \nBus With Seat 18 Rp. 1,500,000 \nBus With Chair 12 Rp. 1,300,000 \nBus Executive with 6 Chairs Rp. 2,000,000\n";
		bus18 = "Buses Available For You: \n\nBus With Seat 18 Rp. 1,500,000 \nBus With Chair 12 Rp. 1,300,000 \nBus Executive with 6 Chairs Rp. 2,000,000\n";
		bus12 = "Buses Available For You: \n\nBus With Chair 12 Rp. 1,300,000 \nBus Executive with 6 Chairs Rp. 2,000,000\n";
		bus6  = "Buses Available For You: \n\nBus Executive with 6 Chairs Rp. 2,000,000\n";



		System.out.println("Welcome to Secret Travel");
		System.out.println("");

		System.out.println("Enter Number of Passengers:");
		passenger = input.nextInt();
		System.out.println("");

		if(passenger > 120){
			System.out.println("Sorry, Travel can handle maximum 120 passengers.");
		}
		else{
			if(passenger <= 120 && passenger > 105){
				System.out.println(bus60);

				System.out.println("* Recommended bus for you \n- 2 buses with 60 seats at a price of " + f.format(2 * busP60));
			}else if(passenger <= 105 && passenger > 92){
				System.out.println(bus60);

				System.out.println("* Recommended bus for you \n- 1 bus with 60 seats and 1 bus with 45 seats with a price of "+ f.format(busP60+busP45));
			}else if(passenger <= 92 && passenger > 90){
				System.out.println(bus60);

				System.out.println("* Recommended bus for you \n- 1 bus with 60 seats and 1 bus with 32 seats with a price of "+ f.format(busP60+busP32));
			}else if(passenger <= 90 && passenger > 78){
				System.out.println(bus60);

				System.out.println("* Recommended bus for you \n-2 buses with 45 seats at a price of " + f.format(2 * busP45));
			}else if(passenger <= 78  && passenger > 72){
				System.out.println(bus60);

				System.out.println("* Recommended bus for you \n- 1 bus with 60 seats and 1 bus with 18 seats with a price of "+ f.format(busP60+busP18));
			}else if(passenger <= 72  && passenger > 63){
				System.out.println(bus60);

				System.out.println("* Recommended bus for you \n- 1 bus with 60 seats and 1 bus with 12 seats with a price of "+ f.format(busP60+busP12));
			}else if(passenger <= 63  && passenger > 61){
				System.out.println(bus60);

				System.out.println("* Recommended bus for you \n- 1 bus with 45 seats and 1 bus with 18 seats with a price of "+ f.format(busP45+busP18));
			}else if(passenger == 60 ){
				System.out.println(bus60);

				System.out.println("* Recommended bus for you \n- 1 buses with 60 seats at a price of " + f.format(busP60));
			}else if(passenger <= 59  && passenger > 57){
				System.out.println(bus45);

				System.out.println("* Recommended bus for you \n- 1 bus with 45 seats and 1 bus with 18 seats with a price of "+ f.format(busP45+busP18));
			}else if(passenger <= 57  && passenger > 45){
				System.out.println(bus45);

				System.out.println("* Recommended bus for you \n- 1 bus with 45 seats and 1 bus with 12 seats with a price of "+ f.format(busP45+busP12));
			}else if(passenger == 45 ){
				System.out.println(bus45);

				System.out.println("* Recommended bus for you \n- 1 buses with 45 seats at a price of " + f.format(busP45));
			}else if(passenger <= 44  && passenger > 36 ){
				System.out.println(bus32);

				System.out.println("* Recommended bus for you \n- 1 bus with 32 seats and 1 bus with 12 seats with a price of "+ f.format(busP32+busP12));
			}else if(passenger <= 35  && passenger > 32 ){
				System.out.println(bus32);

				System.out.println("* Recommended bus for you \n- 2 buses with 18 seats at a price of " + f.format(2 * busP18));
			}else if(passenger == 32 ){
				System.out.println(bus32);

				System.out.println("* Recommended bus for you \n- 1 buses with 18 seats at a price of " + f.format(1 * busP32));
			}else if(passenger == 31 ){
				System.out.println(bus18);

				System.out.println("* Recommended bus for you \n- 2 buses with 18 seats at a price of " + f.format(2 * busP18));
			}else if(passenger <=30  && passenger > 24 ){
				System.out.println(bus18);

				System.out.println("* Recommended bus for you \n- 1 bus with 18 seats and 1 bus with 12 seats with a price of "+ f.format(busP18+busP12));
			}else if(passenger <=24  && passenger > 18 ){
				System.out.println(bus18);

				System.out.println("* Recommended bus for you \n- 2 buses with 12 seats at a price of " + f.format(2 * busP12));
			}else if(passenger == 18 ){
				System.out.println(bus18);

				System.out.println("* Recommended bus for you \n- 1 buses with 18 seats at a price of " + f.format(busP18));
			}else if(passenger <=17  && passenger > 12 ){
				System.out.println(bus12);

				System.out.println("* Recommended bus for you \n- 2 buses with 12 seats at a price of " + f.format(2 * busP12));
			}else if(passenger == 12 ){
				System.out.println(bus12);

				System.out.println("* Recommended bus for you \n- 1 buses with 12 seats at a price of " + f.format(busP12));
			}else if(passenger <=11  && passenger > 6 ){
				System.out.println(bus6);

				System.out.println("* Recommended bus for you \n- 2 buses with 6 seats at a price of " + f.format(2 * busP6));
			}else if(passenger <=6  && passenger > 0 ){
				System.out.println(bus6);

				System.out.println("* Recommended bus for you \n- 1 buses with 6 seats at a price of " + f.format(1 * busP6));
			}else{
				System.out.println("Tidak ada Bus/Passenger");
			}
		}
	}
}