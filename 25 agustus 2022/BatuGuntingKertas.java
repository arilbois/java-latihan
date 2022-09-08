import java.util.Scanner;

public class BatuGuntingKertas{

	public static final String
	templateUseDefence = " use Deffense (Damage -",
	templateDamageHp = " hp ",
	temlateCriticalAttack = " Deal Critical Attack, Damage Increase +2",
	templateLine = "==============================",
	templateKgb = "           KGB Battle",
	templateRound = "             Round ",
	templateBattleStart = "           Battle Start !",
	templateBattleEnd = "           Battle End !",
	templateComputerChoiceHand = "Computer memilih tipe Serangan ...",
	templatePlayerChoiceHand = "Pilih tipe Serangan anda (K/G/B)",
	templatePlayerChoiceAttack = "Tentukan Attack (2-10)",
	templateWinner = "Battle Berakhir",
	templateErrorInteger = "masukkan int (2-10)",
	templateErrorKGB = "Hanya bisa K/G/B", textPlayer = "Player", textComputer = "Computer",
	regex = "[0-9]+";

	public static final Scanner
	input = new Scanner(System.in);

	public static final int
	roll = 1 + (int)(Math.random() * 3),		// random dari 1 sampai 3
	RollComputerAttack = 2 + (int)(Math.random() * 10),
	minimalPlayerAttack = 2,maximalPlayerAttack = 10, minGetCriticalAttack = 6, criticalAttack= 2, bonusHp = 2;			//Computer memilih Serangan dari 2 sampai 10

	public static final float
	damageAttack = 0;

	public static void main(String[] args){
		String tempString = "",computerChoice = "", playerChoiceChar,playerChoice,battleResult = "" , statusWinner= "", criticalAttackResult= "", theWinner = "",
		attackDamageResult = "", useDefenceResult = "",hpResult = "", endGame;
		int   computerAttack = 0, playerAttack = 0, computerDefence , playerDefence, roundStatus= 1,loseGame = 0;
		boolean winner=true , chekInputKGB = true, checkInputAttack = true;
		float computerHp = 30, playerHp = 30;	
		
		//jika belum ada winner proses bakal diulang terus
		do				
		{

			//template Opening
			System.out.println(templateLine);
			System.out.println(templateKgb);
			System.out.println(templateLine);
			System.out.println(templateRound + roundStatus);
			roundStatus++;
			System.out.println(templateLine);

			//Computer memilih otomatis KGB
			computerChoice = computerPicker(roll);
			System.out.println(templateComputerChoiceHand);
			//Computer Memilih otomatis attack
			computerAttack = computerAttacker(RollComputerAttack);
			//Computer Memilih otomatis defence
			computerDefence = defender(computerAttack);
			//Menampilkan Pilihan Computer
			System.out.println("Attack = "+computerAttack);
			System.out.println("Deffense = "+computerDefence);
			System.out.println();

			//Proses Player memilih Kertas, Gunting , Batu
			System.out.println(templatePlayerChoiceHand);
			tempString = input.next();
			playerChoiceChar = validatePlayerChoiceChar(tempString);
			//Proses convert K/G/B
			playerChoice = convertCharToLeater(playerChoiceChar);
			//Input Attack
			playerAttack = inputTypeNumberLimit(templatePlayerChoiceAttack, minimalPlayerAttack, maximalPlayerAttack);
			//Defence adalah sisa dari serangan
			playerDefence = defender(playerAttack);			
			System.out.println("Deffense = " + playerDefence);

			System.out.println();
			System.out.println(templateLine);
			System.out.println(templateBattleStart);
			System.out.println(templateLine);
			System.out.println(computerChoice + " vs " + playerChoice);

			//Menampilkan pemenang permainan
			statusWinner = getWinner(computerChoice,playerChoice);
			//Proses Pertarungan antar Permain
			if(statusWinner.equalsIgnoreCase("computer")){
				playerHp =	prosesStatusWinner(statusWinner,playerDefence, computerAttack,playerHp,bonusHp,damageAttack,minGetCriticalAttack, textComputer );
			}else{
				computerHp =	prosesStatusWinner(statusWinner,computerDefence, playerAttack,computerHp,bonusHp,damageAttack,minGetCriticalAttack, textPlayer );
			}

			//Menampilkan data
			System.out.println(templateLine);
			System.out.println(templateBattleEnd);
			System.out.println(templateLine);
			System.out.println("computer Hp " +computerHp);
			System.out.println("player Hp "+playerHp);
			System.out.println(templateLine);
			
			//logika untuk mengakhiri Permainan
			endGame(computerHp,playerHp,loseGame);
		}while(winner);

		theWinner = showTheWinner(computerHp,loseGame);

	}

	// Function untuk Text
	public static String inputTypeAlphabetLimit(String question, String[] listWord){
		boolean isRepeat = true, isFound;
		String result = "";
		do {
			isFound = false;
			result = inputTypeAlphabet(question);
			for (String word : listWord) {
				if (result.equalsIgnoreCase(word)) {
					isFound = true;
					isRepeat = false;
				}
			}
			if (!isFound) {
				System.out.println("Input tidak sesuai.");
			}
		} while(isRepeat);
		return result;
	}

	//Fungtion Hanya Text yang bisa di input
	public static String inputTypeAlphabet(String question){
		boolean isValid = false;
		String result;
		do {
			System.out.println(question);
			result = input.nextLine();
			isValid = result.matches("[a-zA-Z\\s']+");
			if (!isValid) {
				System.out.println("Maaf, inputan berua alphabet saja.");
			} 
		} while(!isValid);
		return result;
	}

	//fungtion untuk Menentukan batas angka
	public static int inputTypeNumberLimit(String question, int min, int max){
		boolean isValid = false;
		int angka = 0;
		do{
			angka = inputTypeNumber(question);
			if (!(angka >= min && angka <= max)) {
				System.out.println("Maaf, input angka mulai dari "+min+" sampai "+max +"\nSilahkan input kembali.");
			}else{
				isValid = true;
			}
		} while(!isValid);
		return angka;
	}
	//function untuk validasi hanya angka
	public static int inputTypeNumber(String question){
		boolean isValid = false;
		String angka;
		do{
			System.out.println(question);
			angka = input.next();
			isValid = validasiAngka(angka);

			if (!isValid) {
				System.out.println("Maaf input hanya berupa angka saja.\nSilahkan input kembali.");
			}
		} while(!isValid);
		return Integer.parseInt(angka);
	}
	//function boolean validasi angka
	public static boolean validasiAngka(String angka){
		boolean hasil;
		if (!angka.matches(regex)) {
			return hasil=false;
		} else{
			return hasil = true;
		}
	}

	//proses computer memilih Kertas, Gunting , Batu
	public static String computerPicker(int roll){
		String computerChoice = "";
			if(roll == 1){								//inisial 1 sebagai kertas
				computerChoice = "Kertas";
			}else if(roll == 2){						//inisial 2 sebagai Gunting
				computerChoice = "Gunting";
			}else if(roll == 3){						//inisial 3 sebagai Batu
				computerChoice = "Batu";
			}
			return computerChoice;

		}
	//function menentukan attack computer
	public static int computerAttacker(int RollComputerAttack){
		int computerAttack = 0;
			if(computerAttack > 10){
				computerAttack = 10;
			}else{
				computerAttack = RollComputerAttack;
			}

			return computerAttack;
		}
	//function menentukan defend computer
	public static int defender(int attack){
			int defence = 10 - attack;					//Defence adalah sisa dari serangan
			return defence;
		}
	//function validasi hanya KGB yang di input
	public static String validatePlayerChoiceChar(String inputString){
			boolean isValid = false;
			do{
				if(!(inputString.equalsIgnoreCase("K") || 
					inputString.equalsIgnoreCase("G") || 
					inputString.equalsIgnoreCase("B"))){
					System.out.println(templateErrorKGB);
				inputString = input.next();
			}else{
				isValid = true;
			}
		}while(!isValid);
		return inputString;
	}
	//function untuk mengubah Huruf KGB
	public static String convertCharToLeater(String playerChoiceChar){
		String	playerChoice;
		
		if(playerChoiceChar.equalsIgnoreCase("K")){
			return playerChoice = "Kertas";
		}else if(playerChoiceChar.equalsIgnoreCase("G")){
			return playerChoice = "Gunting";
		}else{
			return playerChoice = "Batu";
		}

	}
	//function untuk mencari pemenang KGB
	public static String getWinner(String computerChoice, String playerChoice){
		String statusWinner;
		if(computerChoice.equalsIgnoreCase(playerChoice)){
			statusWinner = "Draw";
		}else{
			if(computerChoice.equalsIgnoreCase("Kertas") && playerChoice.equalsIgnoreCase("Batu") || computerChoice.equalsIgnoreCase("Gunting") && playerChoice.equalsIgnoreCase("Kertas") || computerChoice.equalsIgnoreCase("Batu") && playerChoice.equalsIgnoreCase("Gunting")) {
				System.out.println("Computer wins with " +computerChoice);
				statusWinner = "Computer";
			}else{
				System.out.println("Player wins with " +playerChoice);
				statusWinner = "player";
			}
		}

		return statusWinner;
	}
	//function proses Pertarungan antar pemain
	public static float prosesStatusWinner(String statusWinner,int defence, int attack,float healt,int bonusHp,float damageAttack, int minGetCriticalAttack, String textwho){
		
		if(statusWinner.equalsIgnoreCase(statusWinner)){
			System.out.println(textwho + " give " + attack + " damage");
			if(defence > attack){												
				System.out.println(textwho + templateUseDefence + defence +")");		//HP player +2
				System.out.println(textwho  + templateDamageHp + " + " + bonusHp);
				healt += bonusHp;
			}else{
					damageAttack = ((float)attack - ((float)defence / 2));						//Proses Menentukan damage attack 				
					
					if(attack > minGetCriticalAttack){														//jika damage attack > 6. damage attack +2
						damageAttack += criticalAttack;
						System.out.println(textwho + temlateCriticalAttack);
					}
					System.out.println(textwho + templateUseDefence + damageAttack +")");
					System.out.println(textwho  + templateDamageHp + "-"+ damageAttack);
					healt -= damageAttack;
				}
			}
			return healt;
		}
		//function untuk menampilkan Pemenang
		public static String showTheWinner(float computerHp,int loseGame ){
			String theWinner = "";
			if(computerHp <= loseGame){
				System.out.println(templateWinner +" Player Win!");
			}else{
				System.out.println(templateWinner +" Computer Win!");
			}
			return theWinner;

		}
		//function untuk mengakhiri Permainan
		public static boolean endGame(float computerHp, float playerHp, int loseGame){
			boolean winner = true;
			if(computerHp <= loseGame || playerHp <= loseGame){
				winner = false;
			}
			return winner;
		}
	}