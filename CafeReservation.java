import java.util.Scanner;

public class CafeReservation{
	public static void main( String [] args){
		
		//Deklarasi
		Scanner input = new Scanner(System.in);


		String name, gender, day, templateSuccess, templateFail, result;
		int age, attractive, money;
		
		templateSuccess = "Reservation Successfully, You can Order on";
		templateFail = "Sorry, Yoy can't Order";
		result = "";
		//Input Data
		System.out.println("Welcome To Reservation Cafe");
		System.out.println("");
		
		System.out.println("Please insert your name?");
		name = input.next();
		
		System.out.println("How old are you?");
		age = input.nextInt();
		
		System.out.println("What is your gender?");
		gender = input.next();
		
		System.out.println("How attractive are you? (1 to 10)");
		attractive = input.nextInt();
		
		System.out.println("How much money do you have?");
		money = input.nextInt();
		
		System.out.println("What day do you want to make a reservation?");
		day = input.next();
		
		System.out.println("");
		System.out.println("Hi " + name + ", Thank you for using our Application.");
		System.out.println("Following Results for you Reservation");


		//Percabangan 
		if(day.equals("Monday")){
			if(age >= 20 && age <= 30 && money >= 500){
				result = templateSuccess + " Monday. Young Night.";
			}else{
				System.out.println("Sorry, Yoy can't Order on Monday!!. Because it is for Young Night.");
			}
		}else if(day.equals("Tuesday")){
			if(age >= 31 && age <= 50 && money >= 250){
				result = templateSuccess + " Thuesday. Oldest Night.";
			}else{
				System.out.println("Sorry, Yoy can't Order on Mondat!!. Because it is for Oldest Night.");
			}
		}else if(day.equals("Wednesday")){
			if(age >= 20 && age <= 35 && attractive > 7 && money >= 300){
				result = templateSuccess + " Wednesday. Ladist Night.";
			}else{
				System.out.println("Sorry, Yoy can't Order on Mondat!!. Because it is for Ladist Night.");
			}
		}else if(day.equals("Thuesday") && age >= 21 && age <= 30){
			if(gender.equals("Female")){
				if(attractive > 7 && money >= 300){
					result = templateSuccess + " Thuesday. Parti Night For Single.";
				}else{
					System.out.println("Sorry, Yoy can't Order on Thuesday!!. Because it is Parti Night For Single.");
				}
			}else if(gender.equals("Male")){
				if(money >= 1000){
					result = templateSuccess + " Thuesday. Parti Night For Single.";
				}else{
					System.out.println("Sorry, Yoy can't Order on Thuesday!!. Because it is Parti Night For Single.");
				}
			}				
		}else if(day.equals("Friday")){
			if(gender.equals("Female")){
				if(age >= 31 && age <= 45 && money > 1000){
					result = templateSuccess + " Friday. Women Night.";
				}else{
					result = templateSuccess + " Friday!!. Because it is for Women Night.";
				}
			}else if(gender.equals("Male")){
				if(age >= 21 && age <= 25 && attractive > 7){
					result = templateSuccess + " Friday. Women Night.";
				}else{
					System.out.println("Sorry, Yoy can't Order on Friday!!. Because it is for Women Night.");
				}
			}
		}else if(day.equals("Saturday") || day.equals("Sunday")){
			if(age >= 18 && age <= 60 && money >= 100){
					result = templateSuccess + " Saturday and Sunday (Weekend). Weekend Freedoom.";
			}else{
					System.out.println("Sorry, Yoy can't Order on Saturday!!. Because it is for Weekend Freedoom.");
			}
		}

		System.out.println(result)
	}
}