import java.util.Scanner;
import java.text.DecimalFormat;

public class OldBusQuiz2{
	public static void main( String[] args){

		//deklarasi
		String busDescription60, busDescription45, busDescription32, busDescription18, busDescription12, busDescription6, recommed , templatePrice ;
		double busPrice60, busPrice45, busPrice32, busPrice18, busPrice12, busPrice6;
		int passenger, busSeat6, busSeat12 , busSeat18 , busSeat32 , busSeat45 , busSeat60 , passengerMaximal , passengerMinimal, totalBus;;

		Scanner input = new Scanner(System.in);	//untuk input
		DecimalFormat f = new DecimalFormat("#,###,###"); // untuk format (jutaan)

		recommed = "";

		//inisialisasi harga bus
		busPrice60 = 2300000;
		busPrice45 = 2000000;
		busPrice32 = 1800000;
		busPrice18 = 1500000;
		busPrice12 = 1300000;
		busPrice6 = 2000000;

		//inisialisasi jumlah seat
		busSeat60 = 60;
		busSeat45 = 45;
		busSeat32 =32 ;
		busSeat18 =18 ;
		busSeat12 =12 ;
		busSeat6 =6 ;
		passengerMaximal = 120;
		passengerMinimal = 0;

		//inisialisasi keterangan bus

String	busDescriptionSeat60 = "Bus With Seat 60",
		busDescriptionSeat45 = "Bus With Seat 45",
		busDescriptionSeat32 = "Bus With Seat 32",
		busDescriptionSeat18 = "Bus With Seat 18",
		busDescriptionSeat12 = "Bus With Chair 12",
		busDescriptionSeat6  = "Bus Executive with 6 Chairs";


String	busDescriptionPrice60 = "Rp. 2,300,000",
		busDescriptionPrice45 = "Rp. 2,000,000",
		busDescriptionPrice32 = "Rp. 1,800,000",
		busDescriptionPrice18 = "Rp. 1,500,000",
		busDescriptionPrice12 = "Rp. 1,300,000",
		busDescriptionPrice6  = "Rp. 2,000,000";

		busDescription60 = busDescriptionSeat60 + busDescriptionPrice60;
		busDescription45 = busDescriptionSeat45 + busDescriptionPrice45;
		busDescription32 = busDescriptionSeat32 + busDescriptionPrice32;
		busDescription18 = busDescriptionSeat18 + busDescriptionPrice18;
		busDescription12 = busDescriptionSeat12 + busDescriptionPrice12;
		busDescription6  = busDescriptionSeat6 + busDescriptionPrice6;

		templatePrice = " with a price of Rp. ";


		System.out.println("Welcome to Secret Travel");
		System.out.println("");

		System.out.println("Enter Number of Passengers:");
		passenger = input.nextInt();
		System.out.println("");
		

		if(passenger > passengerMaximal){
			System.out.println("Travel can handle maximum 120 passengers");
		}else{

			System.out.println("Buses Available For You:");
			System.out.println("");

			if(passenger >= busSeat60 && passenger  <= passengerMaximal){
				System.out.println(busDescription60);
			}if(passenger >= busSeat45){
				System.out.println(busDescription45);
			}if(passenger >= busSeat32){
				System.out.println(busDescription32);
			}if(passenger >= busSeat18){
				System.out.println(busDescription18);
			}if(passenger >= busSeat12){
				System.out.println(busDescription12);
			}if(passenger > passengerMinimal){
				System.out.println(busDescription6);
			}else{
				System.out.println("Tidak ada Bus/Passenger");
			}

			if(passenger > passengerMaximal){
				System.out.println("Sorry, Travel can handle maximum 120 passengers.");
			}
			else{
				if(passenger <= passengerMaximal && passenger > (busSeat45 + busSeat60)){ // p < 120 && p > 105

					recommed = "- 2 " +busDescriptionSeat60 + templatePrice + f.format(2 * busPrice60);
				}else if(passenger <= (busSeat45 + busSeat60) && passenger > (busSeat32 + busSeat60)){ // p <= 105 && p > 92											

					recommed = "- 1 " + busDescriptionSeat60 + " and 1 " + busDescriptionSeat45 + templatePrice + f.format(busPrice60+busPrice45);
				}else if(passenger <= (busSeat32 + busSeat60) && passenger > (busSeat45 + busSeat45)){ // p <= 92 && p > 90

					recommed = "- 1 " + busDescriptionSeat60 + " and 1 " + busDescriptionSeat32 + templatePrice + f.format(busPrice60+busPrice32);
				}else if(passenger <= (busSeat45 + busSeat45) && passenger > (busSeat18 + busSeat60)){ // p < 90 && p > 78

					recommed = "- 2 " +busDescriptionSeat45 + templatePrice + f.format(2 * busPrice45);
				}else if(passenger <= (busSeat18 + busSeat60)  && passenger > (busSeat12 + busSeat60)){ // p <= 78 && p > 72

					recommed = "- 1 " + busDescriptionSeat60 + " and 1 " + busDescriptionSeat18 + templatePrice + f.format(busPrice60+busPrice18);
				}else if(passenger <= (busSeat12 + busSeat60) && passenger > (busSeat45 + busSeat18)){ // p <= 72 && p > 63

					recommed = "- 1 " + busDescriptionSeat60 + " and 1 " + busDescriptionSeat12 + templatePrice + f.format(busPrice60+busPrice12);
				}else if(passenger <= (busSeat45 + busSeat18)  && passenger >= (busSeat32 + busSeat18 + busSeat12)){ // p <= 68 && p >= 62

					recommed = "- 1 " + busDescriptionSeat45 + " and 1 " + busDescriptionSeat18 + templatePrice + f.format(busPrice45+busPrice18);
				}else if(passenger == busSeat60 ){ // p = 60

					recommed = "- 1 " +busDescriptionSeat60 + templatePrice + f.format(busPrice60);
				}else if(passenger < busSeat60  && passenger > (busSeat45 + busSeat12)){ // p < 59 && p > 57

					recommed = "- 1 " + busDescriptionSeat45 + " and 1 " + busDescriptionSeat18 + templatePrice + f.format(busPrice45+busPrice18);
				}else if(passenger <= (busSeat45 + busSeat12)  && passenger > busSeat45){// p <= 57 && p > 45

					recommed = "- 1 " + busDescriptionSeat45 + " and 1 " + busDescriptionSeat12 + templatePrice + f.format(busPrice45+busPrice12);
				}else if(passenger == busSeat45 ){// p = 45

					recommed = "- 1 " +busDescriptionSeat45 + templatePrice + f.format(busPrice45);
				}else if(passenger < busSeat45  && passenger > (busSeat60 - busSeat18 - busSeat6) ){// p < 45 && p > 36

					recommed = "- 1 " + busDescriptionSeat32 + " and 1 " + busDescriptionSeat12 + templatePrice + f.format(busPrice32+busPrice12);
				}else if(passenger < (busSeat60 - busSeat18 - busSeat6)  && passenger > busSeat32 ){// p < 36 && p > 32

					recommed = "- 2 " +busDescriptionSeat18 + templatePrice + f.format(2 * busPrice18);
				}else if(passenger == busSeat32 ){// p = 32

					recommed = "- 1 " +busDescriptionSeat32 + templatePrice + f.format(1 * busPrice32);
				}else if(passenger == (busSeat32 + busSeat18 + busSeat12)/2 ){ //p = 31

					recommed = "- 2 " +busDescriptionSeat18 + templatePrice + f.format(2 * busPrice18);
				}else if(passenger <= (busSeat12 + busSeat18)  && passenger > (2 * busSeat12) ){// p < 30 && p > 24

					recommed = "- 1 " + busDescriptionSeat18 + " and 1 " + busDescriptionSeat12 + templatePrice + f.format(busPrice18+busPrice12);
				}else if(passenger <= (2 * busSeat12)  && passenger > busSeat18 ){// p <= 24  && p > 18

					recommed = "- 2 " +busDescriptionSeat12 + templatePrice + f.format(2 * busPrice12);
				}else if(passenger == busSeat18 ){// p = 18

					recommed = "- 1 " +busDescriptionSeat18 + templatePrice + f.format(busPrice18);
				}else if(passenger < busSeat18  && passenger > busSeat12 ){// p < 18 && p > 12

					recommed = "- 2 " +busDescriptionSeat12 + templatePrice + f.format(2 * busPrice12);
				}else if(passenger == busSeat12 ){ // p = 12

					recommed = "- 1 " +busDescriptionSeat12 + templatePrice + f.format(busPrice12);
				}else if(passenger < busSeat12  && passenger > busSeat6 ){ // p < 12 = p > 6

					recommed = "- 2 " +busDescriptionSeat12 + templatePrice + f.format(2 * busPrice6);
				}else if(passenger <= busSeat6  && passenger > passengerMinimal ){ // p <= 6 && p > 0

					recommed = "- 1 " +busDescriptionSeat6 + templatePrice + f.format(1 * busPrice6);
				}else{
					recommed ="Tidak ada Bus/Passenger";
				}
			}
			System.out.println("\n* Recommended bus for you\n" +recommed);
		}
	}
}