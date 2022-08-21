import java.util.Scanner;

public class BatuGuntingKertas{
	public static void main(String[] args){
		String computerChoice, userChoice,battleResult, statusWinner;
		int  computerHp, userHp, roll, computerAttack, userAttack , computerDefence , userDefence, damageAttack;
		
		Scanner input = new Scanner(System.in);
		
		computerHp = 100;
		userHp = 100;
		computerChoice = "";
		battleResult = "";
		statusWinner = "";


		roll = 1 + (int)(Math.random() * 3);
		if(roll == 1){
			computerChoice = "Kertas";
		}else if(roll == 2){
			computerChoice = "Gunting";
		}else if(roll == 3){
			computerChoice = "Batu";
		}
		System.out.println("Computer memilih tipe Serangan ..."+ computerChoice);
		computerAttack = 2 + (int)(Math.random() * 10);
		if(computerAttack > 10){
			computerAttack = 10;
		}
		computerDefence = 10 - computerAttack;

		System.out.println("Attack = "+computerAttack);
		System.out.println("Deffense = "+computerDefence);

		System.out.println("Pilih tipe Serangan anda (K/G/B)");
		userChoice = input.next();
		if(userChoice.equals("K")){
			userChoice = "Kertas";
		}else if(userChoice.equals("G")){
			userChoice = "Gunting";
		}else if(userChoice.equals("B")){
			userChoice = "Batu";
		}
		System.out.println("Tentukan Attack (2-10)");
		userAttack = input.nextInt();
		userDefence = 10 - userAttack;

		System.out.println("Deffense = " + userDefence);

			//battle start
		System.out.println(computerChoice + " vs " + userChoice);
		if(computerChoice.equals("Kertas") && userChoice.equals("Batu")){
			battleResult = "Computer wins with Kertas";
			System.out.println("Computer give " + computerAttack + " damage");
			if(userAttack > computerAttack){
				damageAttack = (computerAttack - (userDefence / 2));					
			}else{
			damageAttack = (userDefence /2);
			}
			System.out.println("player use Deffense (Damage -" +damageAttack +")");
			if(computerAttack > 6){
				computerAttack += 2;
				System.out.println("Computer Deal Critical Attack, Damage Increase +2");
			}
			System.out.println("Player hp -" + (damageAttack = computerAttack - damageAttack));
			userHp -= damageAttack;
			statusWinner = "Computer";
		}else if(computerChoice.equals("Gunting") && userChoice.equals("Kertas")){
			battleResult = "Computer wins with Gunting";
			System.out.println("Computer give " + computerAttack + " damage");
			if(userAttack > computerAttack){
				damageAttack = (computerAttack - (userDefence / 2));					
			}else{
			damageAttack = (userDefence /2);
			}
			System.out.println("player use Deffense (Damage -" +damageAttack +")");
			if(computerAttack > 6){
				computerAttack += 2;
				System.out.println("Computer Deal Critical Attack, Damage Increase +2");
			}
			System.out.println("Player hp -" + (damageAttack = computerAttack - damageAttack));
			userHp -= damageAttack;
			statusWinner = "Computer";
		}else if(computerChoice.equals("Batu") && userChoice.equals("Gunting")){
			battleResult = "Computer wins with Batu";
			System.out.println("Computer give " + computerAttack + " damage");
			if(userAttack > computerAttack){
				damageAttack = (computerAttack - (userDefence / 2));					
			}else{
			damageAttack = (userDefence /2);
			}
			System.out.println("player use Deffense (Damage -" +damageAttack +")");
			if(computerAttack > 6){
				computerAttack += 2;
				System.out.println("Computer Deal Critical Attack, Damage Increase +2");
			}
			System.out.println("Player hp -" + (damageAttack = computerAttack - damageAttack));
			userHp -= damageAttack;
			statusWinner = "Computer";
		}else if(computerChoice.equals("Kertas") && userChoice.equals("Gunting")){
			battleResult = "Player wins with Gunting";
			System.out.println("Player give " + userAttack + " damage");
			if(computerAttack > userAttack){
				damageAttack = (userAttack - (computerDefence / 2));					
			}else{
			damageAttack = (userDefence /2);
			}
			System.out.println("Computer use Deffense (Damage -" + damageAttack+")");
			if(userAttack > 6){
				userAttack += 2;
				System.out.println("User Deal Critical Attack, Damage Increase +2");
			}
			System.out.println("Computer hp -" + (damageAttack = userAttack - damageAttack));
			computerHp -= damageAttack;
			statusWinner = "User";
		}else if(computerChoice.equals("Gunting") && userChoice.equals("Batu")){
			battleResult = "Player wins with Batu";
			System.out.println("Player give " + userAttack + " damage");
			if(computerAttack > userAttack){
				damageAttack = (userAttack - (computerDefence / 2));					
			}else{
			damageAttack = (userDefence /2);
			}
			System.out.println("Computer use Deffense (Damage -" + damageAttack+")");
			if(userAttack > 6){
				userAttack += 2;
				System.out.println("User Deal Critical Attack, Damage Increase +2");
			}
			System.out.println("Computer hp -" + (damageAttack = userAttack - damageAttack));
			computerHp -= damageAttack;
			statusWinner = "User";
		}else if(computerChoice.equals("Batu") && userChoice.equals("Kertas")){
			battleResult = "Player wins with Kertas";
			System.out.println("Player give " + userAttack + " damage");
			if(computerAttack > userAttack){
				damageAttack = (userAttack - (computerDefence / 2));					
			}else{
			damageAttack = (userDefence /2);
			}
			System.out.println("Computer use Deffense (Damage -" + damageAttack+")");
			if(userAttack > 6){
				userAttack += 2;
				System.out.println("User Deal Critical Attack, Damage Increase +2");
			}
			System.out.println("Computer hp -" + (damageAttack = userAttack - damageAttack));
			computerHp -= damageAttack;
			statusWinner = "User";
		}
		if(statusWinner.equals("Computer") && userDefence > computerAttack){
			userHp += 2;
		}else if(statusWinner.equals("User") && computerDefence > userAttack){
			computerHp += 2;
		}
		System.out.println(battleResult);
		System.out.println("computer Hp " +computerHp);
		System.out.println("user Hp "+userHp);

	}

}
