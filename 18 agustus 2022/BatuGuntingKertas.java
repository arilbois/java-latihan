import java.util.Scanner;

public class BatuGuntingKertas{
	public static void main(String[] args){
		String computerChoice = "", playerChoice,battleResult = "" , statusWinner= "", useDefenceResult = "" ,templateWinner ,templateComputerChoiceHand, templateUseDefence, hpResult= "", criticalAttackResult= "",templatePlayerChoiceHand,templatePlayerChoiceAttack, templateComputerChoice, templateDamageHp, temlateCriticalAttack, attackDamageResult= "", templateOpening, templateLine, templateKgb, templateRound, templateBattleStart, templateBattleEnd;
		int  roll, computerAttack, playerAttack , computerDefence , playerDefence, roundStatus= 1,loseGame = 0, criticalAttack= 2, bonusHp = 2, minGetCriticalAttack = 6;
		boolean winner=false;
		float computerHp = 30, playerHp = 30, damageAttack;					//hp player
		Scanner input = new Scanner(System.in);
		templateUseDefence = " use Deffense (Damage -";
		templateDamageHp = " hp ";
		temlateCriticalAttack = " Deal Critical Attack, Damage Increase +2";
		templateLine = "==============================";
		templateKgb = "           KGB Battle";
		templateRound = "             Round ";
		templateBattleStart = "           Battle Start !";
		templateBattleEnd = "           Battle End !";
		templateComputerChoiceHand = "Computer memilih tipe Serangan ...";
		templatePlayerChoiceHand = "Pilih tipe Serangan anda (K/G/B)";
		templatePlayerChoiceAttack = "Tentukan Attack (2-10)";
		templateWinner = "Battle Berakhir";

		while(!winner)				//jika belum ada winner proses bakal diulang terus
		{
			//template Opening
			System.out.println(templateLine);
			System.out.println(templateKgb);
			System.out.println(templateLine);
			System.out.println(templateRound + roundStatus);
			roundStatus++;
			System.out.println(templateLine);

			//proses computer memilih Kertas, Gunting , Batu
			roll = 1 + (int)(Math.random() * 3);		// random dari 1 sampai 3
			if(roll == 1){								//inisial 1 sebagai kertas
				computerChoice = "Kertas";
			}else if(roll == 2){						//inisial 2 sebagai Gunting
				computerChoice = "Gunting";
			}else if(roll == 3){						//inisial 3 sebagai Batu
				computerChoice = "Batu";
			}

			System.out.println(templateComputerChoiceHand + computerChoice);
			computerAttack = 2 + (int)(Math.random() * 10);			//Computer memilih Serangan dari 2 sampai 10
			if(computerAttack > 10){
				computerAttack = 10;
			}
			computerDefence = 10 - computerAttack;					//Defence adalah sisa dari serangan

			System.out.println("Attack = "+computerAttack);
			System.out.println("Deffense = "+computerDefence);
			System.out.println();
			System.out.println(templatePlayerChoiceHand);
			//Proses Player memilih Kertas, Gunting , Batu

			playerChoice = input.next();
			if(playerChoice.equalsIgnoreCase("K")){
				playerChoice = "Kertas";				//inisial K sebagai kertas
			}else if(playerChoice.equalsIgnoreCase("G")){
				playerChoice = "Gunting";				//inisial G sebagai Gunting
			}else if(playerChoice.equalsIgnoreCase("B")){
				playerChoice = "Batu";					//inisial B sebagai Batu
			}
			System.out.println(templatePlayerChoiceAttack);
			playerAttack = input.nextInt();				//Plater memilih Serangan
			playerDefence = 10 - playerAttack;			//Defence adalah sisa dari serangan

			System.out.println("Deffense = " + playerDefence);
			System.out.println();
			System.out.println(templateLine);
			System.out.println(templateBattleStart);
			System.out.println(templateLine);
			System.out.println(computerChoice + " vs " + playerChoice);

			//logika menentukan pemenang permainan
			if(computerChoice.equalsIgnoreCase(playerChoice)){
				statusWinner = "Draw";
			}else{
				if(computerChoice.equalsIgnoreCase("Kertas") && playerChoice.equalsIgnoreCase("Batu") || computerChoice.equalsIgnoreCase("Gunting") && playerChoice.equalsIgnoreCase("Kertas") || computerChoice.equalsIgnoreCase("Batu") && playerChoice.equalsIgnoreCase("Gunting")) {
					battleResult = "Computer wins with " +computerChoice;
					statusWinner = "Computer";
				}else{
					battleResult = "Player wins with " +playerChoice;
					statusWinner = "player";
				}
			}	

			if(statusWinner.equalsIgnoreCase("Computer")){
				attackDamageResult = "Computer give " + computerAttack + " damage";
				if(playerDefence > computerAttack){												//jika Defence Player lebih besar dari serangan Computer 
					useDefenceResult = "Player " + templateUseDefence + playerDefence +")";		//HP player +2
					hpResult = "Player "  + templateDamageHp + " + " +bonusHp;
					playerHp += bonusHp;
				}else{
					damageAttack = ((float)computerAttack - ((float)playerDefence / 2));						//Proses Menentukan damage attack 				
					if(computerAttack > minGetCriticalAttack){														//jika damage attack > 6. damage attack +2
						damageAttack += criticalAttack;
						criticalAttackResult = "Computer" + temlateCriticalAttack;
					}
					useDefenceResult = "Player " + templateUseDefence + damageAttack +")";
					hpResult = "Player "  + templateDamageHp + "-"+ damageAttack;
					playerHp -= damageAttack;
				}

			}else if(statusWinner.equalsIgnoreCase("player")){
				attackDamageResult = "player give " + playerAttack + " damage";
				if(computerDefence > playerAttack){												//jika Defence Computer lebih besar dari serangan Player 
					useDefenceResult = "Computer " + templateUseDefence + computerDefence +")";	//HP Computer +2
					hpResult = "Computer "  + templateDamageHp + " + "+ bonusHp;
					computerHp += bonusHp;
				}else{
					damageAttack = ((float)playerAttack - ((float)computerDefence / 2));						//Proses Menentukan damage attack 
					if(playerAttack > minGetCriticalAttack){														//jika damage attack > 6. damage attack +2
						damageAttack += criticalAttack;
						criticalAttackResult = "Player" + temlateCriticalAttack;
					}
					useDefenceResult = "Computer " + templateUseDefence + damageAttack +")";
					hpResult = "Computer "  + templateDamageHp + "-" +damageAttack;
					computerHp -= damageAttack;
				}
			}else if(statusWinner.equalsIgnoreCase("Draw")){									//Jika terjadi draw proses tidak mengurangi hp siapapun
				System.out.println("Draw");
			}
			//Menampilkan data
			System.out.println(battleResult);
			System.out.println(attackDamageResult);
			System.out.println(useDefenceResult);
			System.out.println(criticalAttackResult);
			System.out.println(hpResult);
			System.out.println(templateLine);
			System.out.println(templateBattleEnd);
			System.out.println(templateLine);
			System.out.println("computer Hp " +computerHp);
			System.out.println("player Hp "+playerHp);
			System.out.println(templateLine);

			//logika untuk mengakhiri Permainan
			if(computerHp <= loseGame || playerHp <= loseGame){
				winner = true;
			}
		}		
		if(computerHp <= loseGame){
			System.out.println(templateWinner +" Player Win!");
		}else{
			System.out.println(templateWinner +" Computer Win!");
		}
	}
}