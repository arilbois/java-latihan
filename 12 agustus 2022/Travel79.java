import java.util.Scanner;

public class Travel79{
	public static void main(String [] args){
		String name, result, fail;
		int people, day, budget , totalLombok, totalBangkok, totalSingapura, totalTokyo , differenceLombok, differenceBangkok, differenceSingapura, differenceTokyo;

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

		Scanner input = new Scanner(System.in);

		result = "";
		//Input Data
		System.out.println("========WELCOME TO TRAVEL 79.com==========");
		System.out.println("");
		System.out.println("Easily determine your best destination!");
		System.out.println("");
		
		System.out.println("Hey, What is your name?");
		name = input.next();
		
		System.out.println("How many people will take the Travel? ");
		people = input.nextInt();
		
		System.out.println("How many days will you take this Travel?");
		day = input.nextInt();
		
		System.out.println("What is your budget" + name);
		budget = input.nextInt();

		
		totalLombok = (((hotelLombok + culinaryLombok) * day) + transportLombok + snorklingLombok) * people; //1000000
		totalBangkok =(((hotelBangkok + culinaryBangkok) * day) + transportBangkok + shopingBangkok) * people;
		totalSingapura =(((hotelSingapura + culinarySingapura) * day) + transportSingapura + universalStudioSingapura) * people;
		totalTokyo =(((hotelTokyo + culinaryTokyo) * day) + transportTokyo + skiTokyo) * people;


		
		differenceLombok =  budget - totalLombok;
		
		differenceBangkok = budget - totalBangkok;

		differenceSingapura = budget - totalSingapura;

		differenceTokyo = budget - totalTokyo;

		System.out.println("selising lombok "+differenceLombok);
		System.out.println(" selisigh babgkok "+differenceBangkok);
		System.out.println(" selisigh tokyo "+differenceTokyo);
		System.out.println(" selisigh singapura "+differenceSingapura);

		fail = "Sorry we could not find a recommendation destination  for you " + name + ", with budget " + budget;

		
			if(differenceLombok < 0){
				differenceLombok = budget + totalLombok * 1000;
				System.out.println("selising baru lombok "+differenceLombok);
			}else if(differenceBangkok < 0){
				differenceBangkok = budget + totalBangkok * 1000;
				System.out.println(" selisigh baru babgkok "+differenceBangkok);
			}else if(differenceSingapura < 0){
				differenceSingapura = budget + totalSingapura * 1000;
					System.out.println(" selisigh baru singapura "+differenceSingapura);
			}else if(differenceTokyo < 0){
				differenceTokyo = budget + totalTokyo * 1000;
				System.out.println(" selisigh tokyo tokyo "+differenceTokyo);
				

			}

						if (differenceLombok < differenceBangkok) {
			    if (differenceLombok < differenceSingapura && differenceLombok < differenceTokyo) {
			        result = "lombok";
			    } else {
			        if (differenceSingapura < differenceTokyo) {
			            result = "singapura";
			        } else {
			            result = "tokyo";
			        }
			    }
			} else {
			    if (differenceBangkok < differenceSingapura && differenceBangkok < differenceTokyo) {
			        result = "bangkok";
			    } else {
			        if (differenceSingapura > differenceTokyo) {
			            result = "singapura";
			        } else {
			            result = "tokuo";
			        }
			    }
			}


		System.out.println(result);
	}
}