import java.util.Scanner;

public class PerhitunganYudisium{
	public static void main( String [] args){
		String nama = "" ,predikat = "",
		//template untuk output
		templateWelcome = "Selamat Datang di Simulasi Perhitungan Yudisium.",templateBatas = "================================",
		templateInputName = "Silahkan Masukan Nama Anda:", templateInputeJumlahMataKuliah = "Silahkan masukan Berapa Jumlah Mata Mata Kuliah:",
		templateInputNamaMataKuliah = "Silahkan masukan Nama Mata Kuliah ", templateInputJumlahSks = "Silahkan masukan Jumlah SKS untuk Mata Kuliah : ",
		templateInputNilaiMataKuliah = "Silahkan masukan Nilai Untuk Mata Kuliah ", templateABC = " (A/B/C/D/E) :",
		templateHasilPredikat = "\nHasil Perhitungan Yudisium a.n ", templateTotalMatakuliah = "Total Mata Kuliah adalah ",
		templateTotalSks = "Total SKS adalah", templateIpk = "IPK yang didapat adalah";
		//deklarasi 
		float ipk = 0, jumlahBobot = 0, hasilIpk = 0;
		int jumlahMataKuliah, jumlahSks = 0, minimalSks = 2, maximalSks = 6, minimalJumlahMatakuliah = 2, maximalJumlahMatakuliah = 12;
		boolean isFindMataKuliah = true, isCheckInputMatakuliah = true, isCheckInputSks = true ,isCheckInputnilaiMatakuliah = true, repeat = true;
		Scanner input = new Scanner(System.in);
		String tempString;

		System.out.println(templateWelcome);
		System.out.println(templateInputName);
		//input nama
		tempString = input.next();
		System.out.println(templateBatas+"\n");
		
		//mencari jumlah mata kuliah
		System.out.println(templateInputeJumlahMataKuliah);
		tempString = input.next();
		jumlahMataKuliah = validateInteger(tempString, isCheckInputMatakuliah, minimalJumlahMatakuliah, maximalJumlahMatakuliah, input);
		
		//inisialisasi panjang array
		String[] mataKuliah = new String[jumlahMataKuliah], nilaiMatakuliah = new String[jumlahMataKuliah]; 
		int[] sksMatakuliah = new int[jumlahMataKuliah];
		float[] bobotMatakuliah = new float[jumlahMataKuliah];

		//mulai looping sesusai jumlah mata kuliah
		
		do{
			for( int i = 0; i < jumlahMataKuliah; i++ ){
				System.out.println(templateInputNamaMataKuliah + (i+1) +":");
				mataKuliah[i] = input.next();												// Mata kuliah

				System.out.println(templateInputJumlahSks + mataKuliah[i]);
				tempString = input.next();
				sksMatakuliah[i] = validateInteger(tempString, isCheckInputSks, minimalSks, maximalSks, input);
				
				//mencari bobot nilai dan validasi

				System.out.println(templateInputNilaiMataKuliah + mataKuliah[i]+ templateABC);
				tempString = input.next();
				nilaiMatakuliah[i] = validateStringNilai(tempString,isCheckInputnilaiMatakuliah, input);

				// proseses menganti value nilai menjadi bobot
				bobotMatakuliah[i] = convertNilai(nilaiMatakuliah[i], bobotMatakuliah[i]);
				

				//proses mengakhiri looping
				if(i <= 0){
					isFindMataKuliah = false;
				}
			}
		}while(isFindMataKuliah);
		//batas looping
		for(int i = 0; i < jumlahMataKuliah; i++){
			jumlahBobot += (bobotMatakuliah[i] * sksMatakuliah[i]);
			jumlahSks += sksMatakuliah[i];
			hasilIpk = jumlahBobot / jumlahSks;
			

			predikat = findPredikat(nilaiMatakuliah[i],hasilIpk,predikat);
		}

		System.out.println(templateHasilPredikat + nama +" Adalah "+ predikat +" dengan Rincian Sebagai Berikut:\n");
		System.out.println(templateTotalMatakuliah + jumlahMataKuliah +", Yaitu: ");

		for(int i = 0; i < jumlahMataKuliah; i++){
			System.out.println((i+1)+". "+ mataKuliah[i] + " ("+nilaiMatakuliah[i] +")");
		}



		System.out.println("\n"+templateTotalSks + " " + jumlahSks);
		System.out.println(templateIpk + " " + hasilIpk);

	}

	public static int validateInteger(String inputString, boolean repeat, int minimal, int maximal, Scanner input){

		String regex = "[0-9]+", templateErorrminimalSks = "\nMaaf, Jumlah SKS tidak boleh kurang dari 2.\nSilahkan input kembali.\n", 
		templateErorrMaximalSks = "\nMaaf, Jumlah SKS tidak boleh lebih dari 6\nSilahkan input kembali.\n",
		templateErorrMinimalJumlahMatakuliah = "\nMaaf, Jumlah Mata Kuliah tidak boleh kurang dari 2\nSilahkan input kembali.\n", 
		templateErorrMaximalJumlahMatakuliah = "\nMaaf, Jumlah Mata Kuliah tidak boleh lebih dari 12\nSilahkan input kembali.\n";

		while(repeat){
			if(!inputString.matches(regex)){
				System.out.println(templateErorrminimalSks);
				inputString = input.next();
			}else{
				if(Integer.parseInt(inputString) < minimal){
					System.out.println(templateErorrminimalSks);
					inputString = input.next();
				}else if(Integer.parseInt(inputString) > maximal){
					System.out.println(templateErorrMaximalSks);
					inputString = input.next();
				}else{
					repeat = false;
				}
			}
		}
		return Integer.parseInt(inputString);
	}

	public static String validateStringNilai(String inputString, boolean repeat,Scanner input){
		String templateErorrNilaiMataKuliah = "\nUser input Nilai Mata Kuliah tidak boleh Selain A/B/C/D/E.\nSilahkan input kembali.\n";
		while(repeat){
			if( !(	inputString.equals("A") || inputString.equals("B") || inputString.equals("C") ||inputString.equals("D") ||inputString.equals("E"))){
				System.out.println(templateErorrNilaiMataKuliah);
				inputString = input.next();
			}else{
				repeat = false;
			}
		}
		return inputString;

	}


	public static float convertNilai(String nilaiMatakuliah, float bobotMatakuliah){
		
		switch (nilaiMatakuliah.toUpperCase()){
		case "A":
			bobotMatakuliah = 4;
			break;
		case "B":
			bobotMatakuliah = 3;
			break;
		case "C":
			bobotMatakuliah = 2;
			break;
		case "D":
			bobotMatakuliah = 1;
			break;
		default:
			bobotMatakuliah = 0;
			break;
		}
		return bobotMatakuliah;

	}

	public static String findPredikat(String nilaiMatakuliah, float hasilIpk, String predikat ){

			//proses pemilihan predikat
		if(nilaiMatakuliah.equalsIgnoreCase("E") && hasilIpk < 2){
			predikat = "Pending";
		}else{
			if(hasilIpk >= 3.5){
				predikat = "Cum Laude";
			}else if(hasilIpk >= 2.75 && hasilIpk < 3.5){
				predikat = "Sangat Memuaskan";
			}else if(hasilIpk >= 2 && hasilIpk < 2.75){
				predikat = "Memuaskan";
			}
		}
		return predikat;
	}

}
