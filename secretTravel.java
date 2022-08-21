import java.util.Scanner;
public class secretTravel{
	public static void main(String[] args){
		int numOfPassenger;
		String travel1, travel2, travel3, travel4, travel5, travel6, recomend; 

		Scanner input = new Scanner(System.in);
		travel1 = "Bus Executive with 6 Seat Rp. 2,000,000";
		travel2 = "Bus With Chair 12 Rp. 1,300,000";
		travel3 = "Bus With Seat 18 Rp. 1,500,000";
		travel4 = "Bus With Seat 32 Rp. 1,800,000";
		travel5 = "Bus With Seat 45 Rp. 2,000,000";
		travel6 = "Bus With Seat 60 Rp. 2,300,000";
		recomend = "";

		System.out.println("\n============= Screened Results =========== ");
		System.out.println("Welcome to Secret Travel\n");
		System.out.println("Enter Number of Passengers: ");
		numOfPassenger = input.nextInt();

		if(numOfPassenger <= 120 ){
			System.out.println("\nBuses Available For You: ");
			if(numOfPassenger <= 11){
				System.out.println(travel1);
				if(numOfPassenger <= 11 && numOfPassenger >= 7){
					recomend = "2 Bus Executive With 6 Seat at a price Rp. 4,000,000";
				}else{
					recomend = "1 Bus Executive With 6 Seat at a price Rp. 2,000,000";
				}
			}else if(numOfPassenger <= 17 && numOfPassenger >= 12){
				System.out.println(travel2+"\n"+travel1);
				if(numOfPassenger == 12){
					recomend = "1 Bus With Chair 12 at a price Rp. 1,300,000";
				}else{
					recomend = "2 Bus With Chair 12 at a price Rp. 2,600,000";
				}
			}else if(numOfPassenger <= 31 && numOfPassenger >= 18){
				System.out.println(travel3+"\n"+travel2+"\n"+travel1);
				if(numOfPassenger == 31){
					recomend = "2 Bus With Seat 18 at a price Rp. 3,000,000";
				}else if(numOfPassenger >= 25 && numOfPassenger <= 30){
					recomend = "1 Bus With Seat 18 and 1 Bus With Chair 12 with a price of Rp. 2,800,000";
				}else if(numOfPassenger >= 19 && numOfPassenger <= 24){
					recomend = "2 Bus With Chair 12 at a price Rp. 2,600,000";
				}else{
					recomend = "1 Bus With Seat 18 at a price Rp. 1,500,000";
				}
			}else if(numOfPassenger <= 44 && numOfPassenger >= 32){
				System.out.println(travel4+"\n"+travel3+"\n"+travel2+"\n"+travel1);
				if(numOfPassenger == 32){
					recomend = "1 Bus With Seat 32 at a price Rp. 1,800,000";
				}else if(numOfPassenger <= 36 && numOfPassenger >= 33){
					recomend = "2 Bus With Seat 18 at a price Rp. 3,000,000";
				}
				else{
					recomend = "1 Bus With Seat 32 and Bus With Chair 12 with a price of Rp. 3,100,000";
				}
			}else if(numOfPassenger <= 59 && numOfPassenger >= 45){
				System.out.println(travel5+"\n"+travel4+"\n"+travel3+"\n"+travel2+"\n"+travel1);
				if(numOfPassenger == 45){
					recomend = "1 Bus With Seat 45 at a price Rp. 2,000,000";
				}else if(numOfPassenger >= 46 && numOfPassenger <= 50){
					recomend = "1 Bus With Seat 45 and 1 Bus With Chair 12 with a price of Rp. 3,300,000\n1 Bus With Seat 32 and 1 Bus With Seat 18 with a price of Rp. 3,300,000";
				}else if(numOfPassenger >= 51 && numOfPassenger <= 57){
					recomend = "1 Bus With Seat 45 and 1 Bus With Chair 12 with a price of Rp. 3,300,000"; 
				}
				else{
					recomend = "1 Bus With Seat 45 and 1 Bus With Chair 18 with a price of Rp. 3,500,000";
				}
			}else{
				System.out.println(travel6+"\n"+travel5+"\n"+travel4+"\n"+travel3+"\n"+travel2+"\n"+travel1);
				if(numOfPassenger == 60){
					recomend = "1 Bus With Seat 60 at price Rp. 2,300,000";
				}else if(numOfPassenger <= 63 && numOfPassenger >= 61){
					recomend = "1 Bus With Seat 45 and 1 Bus With Chair 18 with a price of Rp. 3,500,000";
				}else if(numOfPassenger == 64){
					recomend = "2 Bus With Seat 32 at a price Rp. 3,600,000\n1 Bus With Seat 60 and 1 Bus With Chair 12 with a price of Rp. 3,600,000";
				}else if(numOfPassenger >= 65 && numOfPassenger <= 72){
					recomend = "1 Bus With Seat 60 and 1 Bus With Chair 12 with a price of Rp. 3,600,000";
				}else if(numOfPassenger >= 73 && numOfPassenger <= 77){
					recomend = "1 Bus With Seat 45 and 1 Bus With Seat 32 with a price of Rp. 3,800,000\n1 Bus With Seat 60 and 1 Bus With Seat 18 with a price of Rp. 3,800,000";
				}else if(numOfPassenger == 78){
					recomend = "1 Bus With Seat 60 and 1 Bus With Seat 18 with a price of Rp. 3,800,000";
				}else if(numOfPassenger >= 79 && numOfPassenger <= 90){
					recomend = "2 Bus With Seat 45 with a price of Rp. 4,000,000";
				}else if(numOfPassenger >= 91 && numOfPassenger <= 92){
					recomend = "1 Bus With Seat 60 and 1 Bus With Seat 32 with a price of Rp. 4,100,000";
				}else if(numOfPassenger >= 93 && numOfPassenger <= 105){
					recomend = "1 Bus With Seat 60 and 1 Bus With Seat 45 with a price of Rp. 4,300,000";
				}else{
					recomend = "2 Bus With Seat 60 at a price Rp. 4,600,000";
				}
			}
			System.out.println("\n* Recommended bus for you");
			System.out.println(recomend);
		}else{
			System.out.println("\nTravel only can handle a maximum 120 passengers");
		}
	}
}