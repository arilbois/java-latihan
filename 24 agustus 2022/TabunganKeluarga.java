import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class TabunganKeluarga{
	public static void main( String [] args){
		Scanner input = new Scanner(System.in);
		int totalTabungan = 0,totalTabunganPerBulan = 0, indexHari = 0,uangPerhari = 0, jumalhKeluarga = 0,minimalKeluarga = 2, maximalKeluarga = 6, minimalLamaTabungan = 1, maximalLamaTabungan = 12;
		String[] namaBulan = {"pertama","kedua","ketiga","keempat","kelima","keenam","ketujuh","kedelapan","kesembilan","kesepuluh","kesebelas","keduabelas"};
		int[] hariPerbulan = {31, 28, 31 ,30 ,31,30,31,31,30,31,30,31};
		int[]lamaTabungan = new int[hariPerbulan.length], totalTabunganBulanan = new int[hariPerbulan.length];
		boolean isCheckInputKeluarga = true, isCheckInputTabungan = true; 
		String tempInput = "",
		templateWelcome = "Tabungan Keluarga.", templateInputKeluarga = "Masukan Jumlah keluarga :  ", 
		templateInputLamaTabungan = "Masukan Lama tabungan : ", templateTabungan = "Tabungan Pada bulan",templateTotalTabungan = "Total Tabungan Selama",
		templateErorrMinimalKeluarga = "Maaf, Jumlah keluarga Tidak boleh kurang dari 2.\nSilahkan input kembali.",
		templateErorrMaximalKeluarga = "Maaf, Jumlah keluarga Tidak boleh Lebih dari 6.\nSilahkan input kembali.",
		templateErorrMinimalTabungan = "Maaf, Jumlah Tabungan Tidak boleh kurang dari 1.\nSilahkan input kembali.",
		templateErorrMaximalTabungan = "Maaf, Jumlah Tabungan Tidak boleh Lebih dari 12.\nSilahkan input kembali.",
		templateErrorInteger = "Hanya Boleh memasukan Angka!!!\nSilahkan input kembali.\n";
		
		//deklari Format Rupiah
		DecimalFormat indonesiaCurrency = (DecimalFormat) DecimalFormat.getCurrencyInstance();
		DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
		formatRp.setCurrencySymbol("Rp. ");
		formatRp.setMonetaryDecimalSeparator(',');
		formatRp.setGroupingSeparator('.');
		indonesiaCurrency.setDecimalFormatSymbols(formatRp);
		System.out.println(templateWelcome);

		//Input Jumlah anggota keluarga
		do{
			System.out.println(templateInputKeluarga);
			tempInput = input.next();
			if (!tempInput.matches("[0-9]+")) {
				System.out.printf(templateErrorInteger);
			}else {
				jumalhKeluarga = Integer.parseInt(tempInput);
				if(jumalhKeluarga < minimalKeluarga){
					System.out.println(templateErorrMinimalKeluarga);
				}else if(jumalhKeluarga> maximalKeluarga){
					System.out.println(templateErorrMaximalKeluarga);
				}else{
					isCheckInputKeluarga = false;
				}
			}

		}while(isCheckInputKeluarga);

		//Input Durasi Menabung
		do{
			System.out.println(templateInputLamaTabungan);
			tempInput = input.next();
			if (!tempInput.matches("[0-9]+")) {
				System.out.printf(templateErrorInteger);
			}else {
				lamaTabungan[0] = Integer.parseInt(tempInput);
				if(lamaTabungan[0] < minimalLamaTabungan){
					System.out.println(templateErorrMinimalTabungan);
				}else if(lamaTabungan[0] > maximalLamaTabungan){
					System.out.println(templateErorrMaximalTabungan);
				}else{
					isCheckInputTabungan = false;
				}
				System.out.println("");
			}
		}while(isCheckInputTabungan);

		//Proses mencari total tabungan per bulan
		for (int i=0; i<lamaTabungan[0]; i++) {
			totalTabunganPerBulan = 0;
			for (int j=hariPerbulan[i]; j>=1; j--) {
				totalTabunganPerBulan += (j*1000);
			}
            totalTabunganBulanan[i] = totalTabunganPerBulan*jumalhKeluarga; // Tabungan total per bulan * total Keluarga
            totalTabungan += totalTabunganBulanan[i]; // total Tabungan per bulan add to variable total tabungan 

            System.out.println(templateTabungan+" " + namaBulan[i] + " sebesar " + indonesiaCurrency.format(totalTabunganBulanan[i]));
        }

        System.out.println("\n"+templateTotalTabungan +" "+lamaTabungan[0]+" Bulan dengan "+ jumalhKeluarga +" anggota keluarga adalah "+ indonesiaCurrency.format(totalTabungan));


    }
}

