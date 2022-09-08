import java.util.Scanner;

public class MenghitungIpk2{
	public static final String 	
	LINE 					 = "\n================================================ ",
	WELCOME 				 = "\nSelamat Datang di Simulasi Perhitungan Yudisium. ",
	INPUT_NAME 				 = "\n\n Silahkan Masukkan Nama Anda : ",
	INPUT_JUMLAH_MATKUL 	 = "Silahkan Masukkan Berapa Jumlah Mata Kuliah (",
	INPUT_NILAI_MATKUL 		 = "Silahkan masukan Nilai Untuk Mata Kuliah Matematika (A/B/C/D/E) : ",
	MESSAGE_ERROR_INPUT 	 = "\nMaaf anda memasukkan data diluar ketentuan. \n",
	MESSAGE_ERROR_MIN_SKS	 = " Maaf, Jumlah Mata Kuliah tidak boleh kurang dari 2. \n Silahkan input kembali. \n\n",
	MESSAGE_ERROR_MAX_SKS	 = " Maaf, Jumlah Mata Kuliah tidak boleh lebih dari 6. \n Silahkan input kembali. \n\n",
	MESSAGE_ERROR_NOT_NUMBER = " Maaf, Anda Tidak Boleh Memasukkan Huruf. \n Silahkan input kembali.\n\n",
	MESSAGE_ERROR_NOT_STRING = " Maaf, Anda Tidak Boleh Memasukkan Angka. \n Silahkan input kembali.",
	OUTPUT_RESULT 			 = "\n Hasil Perhitungan yudisium a.n %s Adalah \"%s\" dengan Rincian Sebagai Berikut :  \n\n Total Mata Kuliah adalah %d, Yaitu :\n",
	OUTPUT_RESULT2 			 = " - Total sks adalah %d \n - IPK yang di dapat adalah %.2f";
	public static final Scanner INPUT = new Scanner(System.in);

// ==== fungsi main / utama ====
	public static void main(String[] args){
		int minMatkul = 2, maxMatkul = 12, minSks = 2, maxSks = 6, jumlahMataKuliah = 0; //inisialisasi variabel untuk aturan
		String nama = "", message = "", getNilaiMatkul = "", predikat = "", cekValidasi = "";
		float ipk, totalSks = 0, totalBobot=0;
		boolean isValidInput = true, isValidMinInput, isValidMaxInput,isCheckInput = true;	
		String[] listHarkat = {"A","B","C","D","E"};	

		// ==== input nama user
		String question = "Silahkan Input jumlah mata kuliah : ";
		
		nama = inputTypeAlphabet("Silahkan input nama anda : ");
		jumlahMataKuliah = inputTypeNumberLimit(question,minMatkul, maxMatkul);

		// ==== inisialisasi variabel untuk menampung data nama, nilai, dan sks tiap mata kuliah
		String[] namaMatKul = new String[jumlahMataKuliah], hurufMutu = new String[jumlahMataKuliah];
		int[] sks = new int[jumlahMataKuliah], nilaiMatkul = new int[jumlahMataKuliah];

		// ==== looping data berdasarkan jumlah matakuliah
		for (int i=0; i<jumlahMataKuliah; i++) {
			System.out.print(LINE);
			System.out.println();
			namaMatKul[i]	= inputTypeAlphabet("Silahkan masukkan nama mata kuliah : ");
			sks[i]		    = inputTypeNumberLimit("Silahkan masukkan jumlah sks", minSks, maxSks);	
			nilaiMatkul[i]	= convertToNumber(inputTypeAlphabetLimit(INPUT_NILAI_MATKUL, listHarkat));
			System.out.println();
		}

		// ==== proses perhitungan		
		ipk = calculateIpk(jumlahMataKuliah, nilaiMatkul, sks);

		// ==== searching predikat
		predikat = mencariPredikat(ipk, nilaiMatkul, jumlahMataKuliah);			
		//==== result output
		tampilkanHasil(nama, predikat, jumlahMataKuliah, namaMatKul, nilaiMatkul, sks, ipk);
	}

	public static float calculateIpk(int jumlahMataKuliah, int[] nilaiMatkul, int[] sks){
		float ipk = 0;
		float totalBobot=0, totalSks = 0;
		for (int i=0; i<jumlahMataKuliah; i++) {
			totalBobot 	+= nilaiMatkul[i]*sks[i];
			totalSks 	+= sks[i];
		}
		ipk = totalBobot/totalSks;
		return ipk;
	}

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
	public static String inputTypeAlphabet(String question){
		boolean isValid = false;
		String result;
		do {
			System.out.println(question);
			result = INPUT.nextLine();
			isValid = result.matches("[a-zA-Z\\s']+");
			if (!isValid) {
				System.out.println("Maaf, inputan berua alphabet saja.");
			} 
		} while(!isValid);
		return result;
	}

	public static int inputTypeNumberLimit(String question, int min, int max){
		boolean isValid = false;
		int angka = 0;
		do{
			angka = inputTypeNumber(question);
			if (!(angka >= min && angka <= max)) {
				System.out.println("Maaf, input angka mulai dari "+min+" sampai "+max);
			}else{
				isValid = true;
			}
		} while(!isValid);
		return angka;
	}
	public static int inputTypeNumber(String question){
		String angka;
		boolean isValid = false;
		do{
			System.out.println(question);
			angka = INPUT.nextLine();
			isValid = validasiAngka(angka);

			if (!isValid) {
				System.out.println("Maaf input hanya berupa angka saja.");
			}
		} while(!isValid);
		return Integer.parseInt(angka);
	}

// ==== fungsi untuk cek apakah yang di input user itu berupa angka
	public static boolean validasiAngka(String angka){
		boolean hasil;
		if (!angka.matches("[0-9]+")) {
			return hasil=false;
		} else{
			return hasil = true;
		}
	}
// ==== fungsi untuk cek apakah nilai yang di input user sesuai batas yang di tetapkan
	public static String validasiValue(int angka, int minimalValue, int maksimalValue, String messageValueKurang, String messageValueLebih){
		String message;
		if (validasiMaksimalValue(angka, maksimalValue)) {
			return message= messageValueLebih;
		} else if (validasiMinimalValue(angka,minimalValue)) {
			return message= messageValueKurang;
		}else{
			return message = "";
		}
	}
// ==== fungsi untuk cek apakah nilai yang di input user lebih kecil dari nilai yang ditetapkan
	public static boolean validasiMinimalValue(int angka, int minimalValue){
		boolean hasil;
		if (angka < minimalValue){ return hasil = true;} 
		else { return hasil = false;}
	}
// ==== fungsi untuk cek apakah nilai yang di input user lebih besar dari nilai yang ditetapkan
	public static boolean validasiMaksimalValue(int angka, int maksimalValue){
		boolean hasil;
		if (angka > maksimalValue){ return hasil= true;} 
		else { return hasil = false;}
	}
// ==== fungsi untuk menentukan predikat
	public static String mencariPredikat(float ipk, int[] nilaiMatkul, int jumlahMataKuliah){
		String predikat = "";
		boolean isFailed = false;
		for (int i=0; i<jumlahMataKuliah; i++) {
			if (nilaiMatkul[i] == 0) {
				isFailed = true;
				i = jumlahMataKuliah;
			}
		} 
		if (ipk < 2 || isFailed) {			
			predikat = "Pending";
		} else if (ipk >= 2 && ipk < 2.75) {			
			predikat = "Memuaskan";
		} else if (ipk >= 2.75 && ipk < 3.5) {			
			predikat = "Sangat Memuaskan";
		} else {			
			predikat = "Cumlaude";
		}		
		return predikat;
	}

// ==== fungsi untuk konversi nilai ====
	public static int convertToNumber(String getNilaiMatkul){
		int nilaiMatkul;
		if (getNilaiMatkul.equalsIgnoreCase("A")) {
			nilaiMatkul = 4;
		} else if (getNilaiMatkul.equalsIgnoreCase("B")) {
			nilaiMatkul = 3;
		} else if (getNilaiMatkul.equalsIgnoreCase("C")) {
			nilaiMatkul = 2;
		} else if (getNilaiMatkul.equalsIgnoreCase("D")) {
			nilaiMatkul = 1;
		} else {
			nilaiMatkul = 0;
		}		
		return nilaiMatkul;
	}
	public static String convertToHurufMutu(int nilaiMatkul){
		String huruf = "";
		if (nilaiMatkul == 4) {
			return huruf = "A";
		} else if (nilaiMatkul == 3) {
			return huruf = "B";			
		} else if (nilaiMatkul == 2) {
			return huruf = "C";			
		} else if (nilaiMatkul == 1) {
			return huruf = "D";			
		} else {
			return huruf = "E";
		}		
	}

// ==== fungsi untuk menampilkan output result
	public static void tampilkanHasil(String nama, String predikat, int jumlahMataKuliah, String[] namaMatKul, int[] nilaiMatkul, int[] sks, float ipk){
		int totalSks = 0;
		System.out.printf(LINE + OUTPUT_RESULT ,nama,predikat,jumlahMataKuliah);
		for (int i=0; i<jumlahMataKuliah; i++) {
			totalSks += sks[i];
			System.out.println(" "+(i+1)+". "+namaMatKul[i]+" ("+convertToHurufMutu(nilaiMatkul[i])+")");
		}
		System.out.printf("\n"+OUTPUT_RESULT2+LINE, totalSks,ipk);
	}
}