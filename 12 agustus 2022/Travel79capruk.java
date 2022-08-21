import java.util.Scanner;

public class Travel79capruk{
	public static void main(String [] args){
		String name, result, templateTotal, templateSuccess, templateFail;
		int people, day, budget , totalLombok, totalBangkok, totalSingapura, totalTokyo , differenceLombok, differenceBangkok, differenceSingapura, differenceTokyo , zero;

		int transportLombok = 2170000, 
		hotelLombok 	= 125000, 
		culinaryLombok  = 75000, 
		snorklingLombok = 250000;

		int transportBangkok = 3780000, 
		hotelBangkok 	 = 155000, 
		culinaryBangkok  = 55000, 
		shopingBangkok   = 300000;

		int transportSingapura = 1200000,
		hotelSingapura = 170000,
		culinarySingapura = 85000,
		universalStudioSingapura = 360000;

		int transportTokyo = 4760000,
		hotelTokyo = 170000,
		culinaryTokyo = 105000,
		skiTokyo = 325000;

		zero = 0;

		Scanner input = new Scanner(System.in);

		result = "";
		//Input Data
		System.out.println("========WELCOME TO TRAVEL 79.com==========");
		System.out.println("");
		System.out.println("Easily determine your best destination!");
		System.out.println("");
		
		System.out.println("Hey, What is your name?");
		name = input.next();
		
		System.out.println("\nHow many people will take the Travel? ");
		people = input.nextInt();
		
		System.out.println("\nHow many days will you take this Travel?");
		day = input.nextInt();
		
		System.out.println("\nWhat is your budget" + name);
		budget = input.nextInt();

		
		totalLombok = (((hotelLombok + culinaryLombok) * day) + transportLombok + snorklingLombok) * people; //1000000
		totalBangkok =(((hotelBangkok + culinaryBangkok) * day) + transportBangkok + shopingBangkok) * people;
		totalSingapura =(((hotelSingapura + culinarySingapura) * day) + transportSingapura + universalStudioSingapura) * people;
		totalTokyo =(((hotelTokyo + culinaryTokyo) * day) + transportTokyo + skiTokyo) * people;


		
		differenceLombok =  budget - totalLombok;
		
		differenceBangkok = budget - totalBangkok;

		differenceSingapura = budget - totalSingapura;

		differenceTokyo = budget - totalTokyo;

		templateFail = "\n\nSorry we could not find a recommendation destination  for you " + name + ", with budget " + budget;
		templateSuccess = "\nOur recommended destination for you " + name + " is ";
		templateTotal = "\n\nThe total you have to pay to go to ";

		if(differenceLombok < zero){
			differenceLombok = zero;
		}if(differenceBangkok < zero){
			differenceBangkok = zero;
		}if(differenceSingapura < zero){
			differenceSingapura = zero;
		}if(differenceTokyo < zero){
			differenceTokyo = zero;
		}

		if(differenceLombok > zero || differenceBangkok > zero || differenceSingapura > zero || differenceTokyo > zero){
			if ((differenceBangkok >= differenceLombok || differenceBangkok == zero) && (differenceSingapura >= differenceLombok || differenceSingapura == zero) && (differenceTokyo >= differenceLombok || differenceTokyo == zero) && (differenceLombok > zero)){
				result = templateSuccess + "\"Lombok\"" + templateTotal + "Lombok is " + totalLombok;
			}else if((differenceSingapura >= differenceBangkok || differenceSingapura == zero) && (differenceTokyo >= differenceBangkok || differenceTokyo == zero) && (differenceBangkok > zero)){
				result = templateSuccess + "\"Bangkok\"" + templateTotal + "Bangkok is " + totalBangkok;
			}else if((differenceTokyo >= differenceBangkok || differenceTokyo == zero) && (differenceSingapura != zero)){
				result = templateSuccess + "\"Singapura\"" + templateTotal + "Singapura is " + totalSingapura;
			}else{
				result = templateSuccess + "\"Tokyo\"" + templateTotal + "Tokyo is " + totalTokyo;
			}
		}else{
			result = templateFail;
		}






		System.out.println(result);
	}
}