import java.util.Scanner;

public class PerhitunganYudisium{
	public static void main( String [] args){
		String nama ,predikat = "",
		//template untuk output
		templateWelcome = "Selamat Datang di Simulasi Perhitungan Yudisium.",templateBatas = "================================",
		templateInputName = "Silahkan Masukan Nama Anda:", templateInputeJumlahMataKuliah = "Silahkan masukan Berapa Jumlah Mata Mata Kuliah:",
		templateInputNamaMataKuliah = "Silahkan masukan Nama Mata Kuliah ", templateInputJumlahSks = "Silahkan masukan Jumlah SKS untuk Mata Kuliah : ",
		templateInputNilaiMataKuliah = "Silahkan masukan Nilai Untuk Mata Kuliah ", templateABC = " (A/B/C/D/E) :",
		templateHasilPredikat = "\nHasil Perhitungan Yudisium a.n ", templateTotalMatakuliah = "Total Mata Kuliah adalah ",
		templateTotalSks = "Total SKS adalah", templateIpk = "IPK yang didapat adalah",
		templateErorrMinimalJumlahMatakuliah = "\nMaaf, Jumlah Mata Kuliah tidak boleh kurang dari 2\nSilahkan input kembali.\n", templateErorrMaximalJumlahMatakuliah = "\nMaaf, Jumlah Mata Kuliah tidak boleh lebih dari 12\nSilahkan input kembali.\n",
		templateErorrminimalSks = "\nMaaf, Jumlah SKS tidak boleh kurang dari 2.\nSilahkan input kembali.\n", templateErorrMaximalSks = "\nMaaf, Jumlah SKS tidak boleh lebih dari 6\nSilahkan input kembali.\n",
		templateErorrNilaiMataKuliah = "\nUser input Nilai Mata Kuliah tidak boleh Selain A/B/C/D/E.\nSilahkan input kembali.\n";
		//deklarasi 
		float ipk = 0, jumlahBobot = 0, hasilIpk = 0;
		int jumlahSks = 0,minimalSks = 2, maximalSks = 6, minimalJumlahMatakuliah = 2, maximalJumlahMatakuliah = 12;
		int jumlahMataKuliah;
		boolean isFindMataKuliah = true, isCheckInputMatakuliah = true, isCheckInputSks = true ,isCheckInputnilaiMatakuliah = true;
		Scanner input = new Scanner(System.in);

		System.out.println(templateWelcome);
		System.out.println(templateInputName);
		//input nama
		nama = input.next();
		System.out.println(templateBatas+"\n");
		
		//mencari jumlah mata kuliah
		do{
			System.out.println(templateInputeJumlahMataKuliah);
			jumlahMataKuliah = input.nextInt();
			
			if(jumlahMataKuliah < minimalJumlahMatakuliah){
				System.out.println(templateErorrMinimalJumlahMatakuliah);
			}else if(jumlahMataKuliah > maximalJumlahMatakuliah){
				System.out.println(templateErorrMaximalJumlahMatakuliah);
			}else{
				isCheckInputMatakuliah = false;
			}
		}while(isCheckInputMatakuliah);
		
		//inisialisasi panjang array
		String[] mataKuliah = new String[jumlahMataKuliah], nilaiMatakuliah = new String[jumlahMataKuliah]; 
		int[] sksMatakuliah = new int[jumlahMataKuliah];
		float[] bobotMatakuliah = new float[jumlahMataKuliah];

		//mulai looping sesusai jumlah mata kuliah
		
		do{
			for( int i = 0; i < jumlahMataKuliah; i++ ){
				System.out.println(templateInputNamaMataKuliah + (i+1) +":");
				mataKuliah[i] = input.next();												// Mata kuliah

				do{
					System.out.println(templateInputJumlahSks + mataKuliah[i]);
					sksMatakuliah[i] = input.nextInt();										//mencari sks mata kuliah dan validasi
					
					if(sksMatakuliah[i] < minimalSks){
						System.out.println(templateErorrminimalSks);
					}else if(sksMatakuliah[i] > maximalSks){
						System.out.println(templateErorrMaximalSks);
					}else{
						isCheckInputSks = false;
					}

				}while(isCheckInputSks);
				//mencari bobot nilai dan validasi
				do{
					System.out.println(templateInputNilaiMataKuliah + mataKuliah[i]+ templateABC);
					nilaiMatakuliah[i] = input.next();
					if(nilaiMatakuliah[i].equals("A") ||nilaiMatakuliah[i].equals("B") ||nilaiMatakuliah[i].equals("C") ||nilaiMatakuliah[i].equals("D") ||nilaiMatakuliah[i].equals("E")){
						isCheckInputnilaiMatakuliah = false;	
					}else{
						System.out.println(templateErorrNilaiMataKuliah);
					}

				}while(isCheckInputnilaiMatakuliah);

									// proseses menganti value nilai menjadi bobot
				switch (nilaiMatakuliah[i].toUpperCase()){
				case "A":
					bobotMatakuliah[i] = 4;
					break;
				case "B":
					bobotMatakuliah[i] = 3;
					break;
				case "C":
					bobotMatakuliah[i] = 2;
					break;
				case "D":
					bobotMatakuliah[i] = 1;
					break;
				default:
					bobotMatakuliah[i] = 0;
					break;
				}

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

			//proses pemilihan predikat
			if(nilaiMatakuliah[i].equalsIgnoreCase("E") && hasilIpk < 2){
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
		}

		System.out.println(templateHasilPredikat + nama +" Adalah "+ predikat +" dengan Rincian Sebagai Berikut:\n");
		System.out.println(templateTotalMatakuliah + jumlahMataKuliah +", Yaitu: ");
		
		for(int i = 0; i < jumlahMataKuliah; i++){
			System.out.println((i+1)+". "+ mataKuliah[i] + " ("+nilaiMatakuliah[i] +")");
		}



		System.out.println("\n"+templateTotalSks + " " + jumlahSks);
		System.out.println(templateIpk + " " + hasilIpk);

	}
}