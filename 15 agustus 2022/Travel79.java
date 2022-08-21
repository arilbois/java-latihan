import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Travel79{
	public static void main(String [] args){
		//deklarasi variable
		String name, result, templatetotalBudget, templateSuccess, templateFail, templateOpening, templateAskName, templateAskDay, templateAskPeople, templateAskBudget;
		int people, day, budget , totalBudgetLombok, totalBudgetBangkok, totalBudgetSingapura, totalBudgetTokyo , closestBudgetLombok, closestBudgetBangkok, closestBudgetSingapura, closestBudgetTokyo , zero;

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

		//Template pesan yang akan ditampikan
		templateOpening = "========WELCOME TO TRAVEL 79.com==========\n Easily determine your best destination!\n";
		templatetotalBudget = "\n\nThe totalBudget you have to pay to go to ";
		templateAskName = "Hey, What is your name?";
		templateAskPeople = "\nHow many people will take the Travel? ";
		templateAskDay = "\nHow many days will you take this Travel? ";
		templateAskBudget = "What is your budget ,%s";
		

		Scanner input = new Scanner(System.in); //deklari untuk input

		//deklari Format Rupiah
		DecimalFormat indonesiaCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

		formatRp.setCurrencySymbol("Rp. ");
		formatRp.setMonetaryDecimalSeparator(',');
		formatRp.setGroupingSeparator('.');

		indonesiaCurrency.setDecimalFormatSymbols(formatRp);

		result = "";

		//Input Data
		System.out.println(templateOpening);
		
		System.out.println(templateAskName);
		name = input.next();
		
		System.out.println(templateAskPeople);
		people = input.nextInt();
		
		System.out.println(templateAskDay);
		day = input.nextInt();
		
		System.out.printf("\n"+templateAskBudget+"\n", name);
		budget = input.nextInt();

		templateFail = "\nSorry we could not find a recommendation destination for you " + name + ", with budget " + indonesiaCurrency.format(budget);
		templateSuccess = "\nOur recommended destination for you " + name + " is ";

		//Penghitungan total Budget biaya Setiap Kota
		totalBudgetLombok = (((hotelLombok + culinaryLombok) * day) + transportLombok + snorklingLombok) * people;
		totalBudgetBangkok =(((hotelBangkok + culinaryBangkok) * day) + transportBangkok + shopingBangkok) * people;
		totalBudgetSingapura =(((hotelSingapura + culinarySingapura) * day) + transportSingapura + universalStudioSingapura) * people;
		totalBudgetTokyo =(((hotelTokyo + culinaryTokyo) * day) + transportTokyo + skiTokyo) * people;

		//Mencari selisih dari budget untuk dilakukan perbandingan yang paling mendekati
		closestBudgetLombok =  budget - totalBudgetLombok;
		closestBudgetBangkok = budget - totalBudgetBangkok;
		closestBudgetSingapura = budget - totalBudgetSingapura;
		closestBudgetTokyo = budget - totalBudgetTokyo;

		//Proses menghilangkan nilai minus menjadi 0
		if(closestBudgetLombok < zero){
			closestBudgetLombok = zero;
		}if(closestBudgetBangkok < zero){
			closestBudgetBangkok = zero;
		}if(closestBudgetSingapura < zero){
			closestBudgetSingapura = zero;
		}if(closestBudgetTokyo < zero){
			closestBudgetTokyo = zero;
		}

		//Proses Perbandingan budget dan totalBudget harga agar mendapat nilai yang mendekati budget
		if(closestBudgetLombok > zero || closestBudgetBangkok > zero || closestBudgetSingapura > zero || closestBudgetTokyo > zero){
			if ((closestBudgetBangkok >= closestBudgetLombok || closestBudgetBangkok == zero) && (closestBudgetSingapura >= closestBudgetLombok || closestBudgetSingapura == zero) && (closestBudgetTokyo >= closestBudgetLombok || closestBudgetTokyo == zero) && (closestBudgetLombok > zero)){
				result = templateSuccess + "\"Lombok\"" + templatetotalBudget + "Lombok is " + indonesiaCurrency.format(totalBudgetLombok);

			}else if((closestBudgetSingapura >= closestBudgetBangkok || closestBudgetSingapura == zero) && (closestBudgetTokyo >= closestBudgetBangkok || closestBudgetTokyo == zero) && (closestBudgetBangkok > zero)){
				result = templateSuccess + "\"Bangkok\"" + templatetotalBudget + "Bangkok is " + indonesiaCurrency.format(totalBudgetBangkok);

			}else if((closestBudgetTokyo >= closestBudgetBangkok || closestBudgetTokyo == zero) && (closestBudgetSingapura > zero)){
				result = templateSuccess + "\"Singapura\"" + templatetotalBudget + "Singapura is " + indonesiaCurrency.format(totalBudgetSingapura);

			}else{
				result = templateSuccess + "\"Tokyo\"" + templatetotalBudget + "Tokyo is " + indonesiaCurrency.format(totalBudgetTokyo);
			}
		}else{
			result = templateFail;
		}
		System.out.println(result);
	}
}