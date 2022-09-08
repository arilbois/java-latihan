import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class TabunganKeluarga{

	public static final String
	templateWelcome = "Tabungan Keluarga.", templateInputKeluarga = "Masukan Jumlah keluarga :  ", regex = "[0-9]+",
	templateInputLamaTabungan = "Masukan Lama tabungan : ", templateTabungan = "Tabungan Pada bulan",templateTotalTabungan = "Total Tabungan Selama";

	public static final Scanner input = new Scanner(System.in);

	public static final int
	minimalKeluarga = 2, maximalKeluarga = 6, minimalLamaTabungan = 1, maximalLamaTabungan = 12;

	public static void main( String [] args){
		//INISILISASI VARIABLE
		int jumalhKeluarga = 0;
		String[] namaBulan = {"pertama","kedua","ketiga","keempat","kelima","keenam","ketujuh","kedelapan","kesembilan","kesepuluh","kesebelas","keduabelas"};
		int[] hariPerbulan = {31, 28, 31 ,30 ,31,30,31,31,30,31,30,31};
		int[]lamaTabungan = new int[hariPerbulan.length];
		String question = "", tempInput = "";
		
		//deklari Format Rupiah
		System.out.println(templateWelcome);

		//Input Jumlah anggota keluarga
		jumalhKeluarga = inputTypeNumberLimit(templateInputKeluarga,minimalKeluarga, maximalKeluarga);

		//Input Durasi Menabung
		lamaTabungan[0] = inputTypeNumberLimit(templateInputLamaTabungan,minimalLamaTabungan, maximalLamaTabungan);

		//Proses mencari total tabungan per bulan
		tampilkanHasil(lamaTabungan,hariPerbulan, namaBulan, jumalhKeluarga);
		
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
	//funtion untuk validasi hanya angka
	public static int inputTypeNumber(String question){
		boolean isValid = false;
		String angka;
		do{
			System.out.println(question);
			angka = input.nextLine();
			isValid = validasiAngka(angka);

			if (!isValid) {
				System.out.println("Maaf input hanya berupa angka saja.\nSilahkan input kembali.");
			}
		} while(!isValid);
		return Integer.parseInt(angka);
	}
	//funtion boolean validasi angka
	public static boolean validasiAngka(String angka){
		boolean hasil;
		if (!angka.matches(regex)) {
			return hasil=false;
		} else{
			return hasil = true;
		}
	}

	//funtion proses menampikan jumlah tabungan
	public static void tampilkanHasil(int[] lamaTabungan, int[] hariPerbulan,String[] namaBulan,int jumalhKeluarga){
		int[] totalTabunganBulanan = new int[hariPerbulan.length];
		int totalTabunganPerBulan = 0,totalTabungan = 0;

		for (int i=0; i<lamaTabungan[0]; i++) {
			totalTabunganPerBulan = 0;
			for (int j=hariPerbulan[i]; j>=1; j--) {
				totalTabunganPerBulan += (j*1000);
			}
            totalTabunganBulanan[i] = totalTabunganPerBulan*jumalhKeluarga; // Tabungan total per bulan * total Keluarga
            totalTabungan += totalTabunganBulanan[i]; // total Tabungan per bulan add to variable total tabungan 

            System.out.println(templateTabungan+" " + namaBulan[i] + " sebesar " + indonesiaCurrency(totalTabunganBulanan[i]));
        }

        System.out.println("\n"+templateTotalTabungan +" "+lamaTabungan[0]+" Bulan dengan "+ jumalhKeluarga +" anggota keluarga adalah "+ indonesiaCurrency(totalTabungan));

    }

    // funtion Format Mata uang Indonesia
    public static String indonesiaCurrency(double formatter){
    	DecimalFormat	indonesiaCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    	DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    	formatRp.setCurrencySymbol("Rp. ");
    	formatRp.setMonetaryDecimalSeparator(',');
    	formatRp.setGroupingSeparator('.');
    	indonesiaCurrency.setDecimalFormatSymbols(formatRp);

    	return indonesiaCurrency.format(formatter);
    }
}