import java.util.Scanner;
import java.util.Random;

public class KgbBattle{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Random random = new Random();

		String  line = "\n======================================",	// set text output
				round= "               Round ",
				battleStart = "\n            Battle Start !",
				computerSetAttack = " Computer memilih tipe serangan...\n Attack = %d \n Deffense = %d\n",
				userSetTypeAttack = " Pilih tipe serangan anda (K/G/B) = ",
				deffenseDamage = " use deffense (Damage -",
				criticalAttack = " Deal Critical Attack, Damage Increase +2";
		String 	human = " Player", computer = " Computer"; // initialize player
		float 	userHp = 100, computerHp = 100; //initialize HP start from 100
		Character typeAttackUser, typeAttackComputer; // initialize variable to saving type attack players
		int 	userAttack, computerAttack, userDeffense, computerDeffense; // initialize variable to saving value attack and deffense
		String 	changeCharacterComputer = "", changeCharacterUser = "", winner = "";
        int 	roundStart = 1; //initialize round start from 1
        boolean checkInput = true, roundAgain = true; // set checkInput and roundAgain to true


      // =====Title output=====  
		System.out.println(line+"\n              KGB Battle"+line);

	  // =====looping round game=====
		do{	
			boolean userWinner = false, computerWinner = false; // set the winner to falses if game rounded
			String roundWinner = "",  setTag =""; // set round winner to null if game rounded

			System.out.println(round+roundStart+line);

			// =====Set Attack from computer=====
			String 	setOfCharacters = "BGK"; // set character to random type attack
        	int charLength = random.nextInt(setOfCharacters.length()); // find the number of random letters

				typeAttackComputer 	= setOfCharacters.charAt(charLength);
				do { //looping for input value of computer attack
					computerAttack 	= random.nextInt(10) + 1;
					if (computerAttack > 1) {
						checkInput = false;
					}
				}while(checkInput);	
				
				computerDeffense	= 10 - computerAttack;
				System.out.printf(computerSetAttack+"\n", computerAttack, computerDeffense);

			// =====set user attack=====
				checkInput = true; // return value checkInput to true
				do{ // looping if user enter wrong character
					System.out.print(userSetTypeAttack);
					typeAttackUser = input.next().charAt(0); // save input to variable type data "char"
					if (typeAttackUser.equals('K') || typeAttackUser.equals('G') || typeAttackUser.equals('B') || typeAttackUser.equals('k') || typeAttackUser.equals('g') || typeAttackUser.equals('b')) {
						checkInput = false;
					}
				}while(checkInput);

				checkInput = true; // return value checkInput to true
				do{ // looping if user enter wrong value
					System.out.print(" Tentukan attack (2-10) = ");
					userAttack 	 = input.nextInt();
					if (userAttack > 1 && userAttack <= 10) {
						checkInput = false;
					}
				}while(checkInput);

				userDeffense = 10 - userAttack;
				System.out.println(" Deffense = "+ userDeffense + "\n"+ line + battleStart + line + "\n");

			// =====Battle start output=====
				if (typeAttackComputer.equals('K')) { changeCharacterComputer = " Kertas";}
				else if (typeAttackComputer.equals('G')) { changeCharacterComputer = " Gunting";}
				else if (typeAttackComputer.equals('B')) { changeCharacterComputer = " Batu";	}
				
				if (typeAttackUser.equals('K') || typeAttackUser.equals('k')) { changeCharacterUser = "Kertas";	}
				else if (typeAttackUser.equals('G') || typeAttackUser.equals('g')) { changeCharacterUser = "Gunting";	}
				else if (typeAttackUser.equals('B') || typeAttackUser.equals('b')) { changeCharacterUser = "Batu";	}
				
			// =====Searching a round winner=====
				System.out.println(changeCharacterComputer +" VS "+ changeCharacterUser);

				if ((typeAttackComputer.equals('K') && (typeAttackUser.equals('B') || typeAttackUser.equals('b'))) || (typeAttackComputer.equals('G') && (typeAttackUser.equals('K') || typeAttackUser.equals('k'))) || (typeAttackComputer.equals('B') && (typeAttackUser.equals('G') || typeAttackUser.equals('g')))) {
					computerWinner = true;
				}
				else if ((typeAttackComputer.equals('B') && (typeAttackUser.equals('K') || typeAttackUser.equals('k'))) || (typeAttackComputer.equals('K') && (typeAttackUser.equals('G') || typeAttackUser.equals('g'))) || (typeAttackComputer.equals('G') && (typeAttackUser.equals('B') || typeAttackUser.equals('b')))) {
					userWinner = true;
				}

			// =====if computer win=====
				float hp;
				if (computerWinner) {
					System.out.println(computer +" wins with " + changeCharacterComputer + "\n" +computer+ " deal a "+ computerAttack + " Damage\n" +human+ deffenseDamage+ ((float)userDeffense/2)+")");
					if (computerAttack > 6) {
						System.out.println(computer + criticalAttack);
						computerAttack += 2;
					}

					if (computerAttack > ((float)userDeffense/2) ) {
						hp = ((float)userDeffense/2)-(float)computerAttack;
					}
					else{
						hp = 2;
						setTag = "+";
					}
					userHp += hp; 
					System.out.print(human+ " HP "+ setTag + hp);
				}
			// =====if user win=====
				else if (userWinner) {
					System.out.println(" You wins with "+changeCharacterUser + "\n" +human+ " give a "+ userAttack + " Damage\n" +computer+ deffenseDamage + ((float)computerDeffense/2)+")");
					if (userAttack > 6) {
						System.out.println(human + criticalAttack);
						userAttack += 2;
					}
					
					if (userAttack > ((float)computerDeffense/2) ) {
						hp = ((float)computerDeffense/2)-(float)userAttack;
					}
					else{
						hp = 2;
						setTag = "+";
					}
					computerHp += hp; 
					System.out.print(computer+ " HP "+ setTag + hp);
				}
				else {
					System.out.println(" There is no winner in this round");
				}

			//=====Round end=====
				System.out.print(line + "\n              Battle End !"+line +"\n Player HP : "+ userHp + "\n Computer HP : " + computerHp + "\n"+ line + "\n");
				roundStart++;

			// check HP players
				if (userHp < 1 || computerHp < 1) {
					roundAgain = false;
				}
		}while(roundAgain);
		// ==== check winner ====
			if (userHp > 0) {
					winner = " Player";
				}else{
					winner = " Computer";
				}
			System.out.println(" .\n" + " .\n Battle berakhir," + winner + " Win!");
	}
}