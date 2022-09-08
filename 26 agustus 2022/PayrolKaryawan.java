import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
public class PayrolKaryawan{

	//variabel final
	public static final Scanner
	input = new Scanner(System.in);

	public static final String
	templateInputNama = "Nama:", templateInputJabatan = "Posisi Jabatan:", templateInputCabang = "Cabang Kantor:",templateInputMenikah = "Status Pernikahan (Ya/Tidak):",
	templateInputMasaKerja = "Masa Kerja:",
	templateErrorRole = "Maaf Jabatan Tersebut Tidak Tersedia",
	templateErrorCabang = "Maaf Cabang Tersebut Tidak Tersedia",
	templateErorrMenikah = "Hanya Bisa Memilih YA/TIDAK",
	templateLine = "====================================",
	templateWelcome = "Slip Gaji Karyawan",
	regex = "[0-9]+";

	public static final int
	minimalKerja = 0, maximalKerja = 9999999;

	public static void main(String[] args){
		double[] umkCity = {3742276, 4453935, 4782935,1961085, 4330249, 3289409} , tunjanganPegawaiData = {200000,500000,700000,1000000,200000,200000}; ;
		String[] branchCompanyData = {"Bandung","Jakarta","Bekasi","Garut","Bogor","Palembang"},roleCompanyData = {"admin","koordinator","spv","Manager","sprinter","officer"}, statusMenikahData = {"Ya","Tidak"};

		double tunjanganMenikah = 0.1, tunjanganJabatan = 0.05, tunjanganTransport = 500000, gajiKotor, potonganBpjs = 0.02, potonganPensiun = 0.02, potonganPph = 0.05, gajiBersih, tunjanganPegawai;
		String nama, tempString, roleCompany = "", branchCompany,statusMenikah, syaratTunjanganTranport = "Jakarta", syaratTunjanganMenikah = "Ya";
		int  masaKerja;

	//Input Nama
		nama = inputTypeAlphabet(templateInputNama);
	//Input Jabatan
		roleCompany= inputTypeAlphabetLimit(templateInputJabatan, roleCompanyData);
	//Input Cabang
		branchCompany = inputTypeAlphabetLimit(templateInputCabang, branchCompanyData);
	//Input Masa Kerja
		masaKerja = inputTypeNumberLimit(templateInputMasaKerja, minimalKerja, maximalKerja);
	//Input Cabang
		statusMenikah = inputTypeAlphabetLimit(templateInputMenikah, statusMenikahData);


		//Proses Perhitungan gaji
		double umkKaryawan = convertCabangToUmk(branchCompany,branchCompanyData,umkCity);
		double gajiPokok =  countgajiPokok(roleCompany, umkKaryawan, masaKerja, roleCompanyData);
		tunjanganTransport = menghitungTunjangan(branchCompany,tunjanganTransport,syaratTunjanganTranport, umkKaryawan);
		tunjanganMenikah = menghitungTunjangan(statusMenikah,syaratTunjanganMenikah,tunjanganMenikah, umkKaryawan);
		tunjanganJabatan = menghitungTunjangan(masaKerja, tunjanganJabatan, umkKaryawan);
		tunjanganPegawai = menghitungTunjangan(tunjanganPegawaiData, roleCompany, roleCompanyData);
		gajiKotor = totalGajiKotor(gajiPokok,tunjanganJabatan, tunjanganPegawai ,tunjanganTransport,tunjanganMenikah);
		potonganPensiun = menghitungPotongan(gajiKotor, potonganPensiun);
		potonganBpjs = menghitungPotongan(gajiKotor, potonganBpjs);
		potonganPph = menghitungPotongan(gajiKotor, potonganPph);
		gajiBersih = totalGajiBersih(gajiKotor, potonganBpjs, potonganPensiun, potonganPph);


		//proses Menampilkan Gaji
		System.out.println(templateLine);
		System.out.println("         "+templateWelcome);
		System.out.println("               "+nama+"        ");
		System.out.println(templateLine);
		System.out.println("Gaji Pokok         :"+indonesiaCurrency(gajiPokok));
		System.out.println("Tunj. Transportasi :"+indonesiaCurrency(tunjanganTransport));
		System.out.println("Tunj. Keluarga	   :"+indonesiaCurrency(tunjanganMenikah));
		System.out.println("Tunj. Jabatan	   :"+indonesiaCurrency(tunjanganJabatan));
		System.out.println("Tunj. Pegawai	   :"+indonesiaCurrency(tunjanganPegawai));
		System.out.println(templateLine);
		System.out.println("gaji kotor         :"+indonesiaCurrency(gajiKotor));
		System.out.println(templateLine);
		System.out.println("Potongan Pensiun   :"+indonesiaCurrency(potonganPensiun));
		System.out.println("Potongan BPJS	   :"+indonesiaCurrency(potonganBpjs));
		System.out.println("PPH                :"+indonesiaCurrency(potonganPph));
		System.out.println(templateLine);
		System.out.println("Take Home Pay      :"+indonesiaCurrency(gajiBersih));
		System.out.println(templateLine);


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
			if (!(angka > min && angka <= max)) {
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
			angka = input.nextLine();
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

//Function untuk Menentukan Gaji Pokok menurut UMK
	public static double convertCabangToUmk(String branchCompany,String[] branchCompanyData, double[] umkCity){
		double	umkKaryawan;

		if(branchCompany.equalsIgnoreCase(branchCompanyData[0])){
			return umkKaryawan = umkCity[0];
		}else if(branchCompany.equalsIgnoreCase(branchCompanyData[1])){
			return umkKaryawan = umkCity[1];
		}else if(branchCompany.equalsIgnoreCase(branchCompanyData[2])){
			return umkKaryawan = umkCity[2];
		}else if(branchCompany.equalsIgnoreCase(branchCompanyData[3])){
			return umkKaryawan = umkCity[3];
		}else if(branchCompany.equalsIgnoreCase(branchCompanyData[4])){
			return umkKaryawan = umkCity[4];
		}else{
			return umkKaryawan = umkCity[5];

		}

	}
//Function untuk Total gaji pokok menurut Umk dan Jabatan 
	public static double countgajiPokok(String roleCompany, double umkKaryawan, int masaKerja,String[] roleCompanyData){
		double gajiPokok;

		if(roleCompany.equalsIgnoreCase(roleCompanyData[0])){
			if(masaKerja < 2){
				gajiPokok = umkKaryawan;
			}else{
				gajiPokok = umkKaryawan * 1.2;
			}
		}else if(roleCompany.equalsIgnoreCase(roleCompanyData[1])){
			if(masaKerja < 3){
				gajiPokok = umkKaryawan * 1.1;
			}else{
				gajiPokok = umkKaryawan * 1.3;
			}
		}else if(roleCompany.equalsIgnoreCase(roleCompanyData[2])){
			if(masaKerja < 2){
				gajiPokok = umkKaryawan * 1.25;
			}else if(masaKerja >=2 && masaKerja < 4 ){
				gajiPokok = umkKaryawan * 1.4;
			}else{
				gajiPokok = umkKaryawan * 1.5;
			}
		}else if(roleCompany.equalsIgnoreCase(roleCompanyData[4])){
			gajiPokok = umkKaryawan * 0.9;
		}else if(roleCompany.equalsIgnoreCase(roleCompanyData[5])){
			gajiPokok = umkKaryawan;
		}else{
			if(masaKerja < 3){
				gajiPokok = umkKaryawan * 1.5;
			}else{
				gajiPokok = umkKaryawan * 2;
			}
		}

		return gajiPokok;
	}

//Function untung Menentukan tunjangan Menikah
	public static double menghitungTunjangan(String syaratTunjangan, String data,double typeTunjangan, double umkKaryawan){
		double tunjangan;

		if(syaratTunjangan.equalsIgnoreCase(data)){
			tunjangan = umkKaryawan * typeTunjangan;
		}else{
			tunjangan = 0;
		}

		return tunjangan;
	}
//Function untung Menentukan tunjangan Transport
	public static double menghitungTunjangan(String syaratTunjangan,double typeTunjangan,String data, double umkKaryawan){
		double tunjangan;

		if(syaratTunjangan.equalsIgnoreCase(data)){
			tunjangan = 500000;
		}else{
			tunjangan = 0;
		}

		return tunjangan;
	}
//Function untung Menentukan tunjangan Pegawai
	public static double menghitungTunjangan(int masaKerja,double typeTunjangan, double umkKaryawan){
		double tunjangan;

		if(masaKerja > 4){
			tunjangan = umkKaryawan * typeTunjangan;
		}else{
			tunjangan = 0;
		}

		return tunjangan;
	}
//Function untung Menentukan tunjangan Jabatan
	public static double menghitungTunjangan(double[] tunjanganPegawaiData,String roleCompany,String[] roleCompanyData){
		double tunjangan = 0;
		for (int i=0; i<tunjanganPegawaiData.length; i++) {
			if (roleCompany.equalsIgnoreCase(roleCompanyData[i])) {
				tunjangan = tunjanganPegawaiData[i];
			}
		}

		return tunjangan;
	}
//Function untung Menentukan gaji kotor
	public static double totalGajiKotor(double gajiPokok, double tunjanganJabatan,double tunjanganPegawai ,double tunjanganTransport,double tunjanganMenikah){
		double gajiKotor = gajiPokok + tunjanganPegawai + tunjanganJabatan + tunjanganMenikah + tunjanganTransport;
		return gajiKotor;
	}
//Function untung Menentukan Potongan Gaji
	public static double menghitungPotongan(double gajiKotor, double jenisPotongan){
		double potongan = gajiKotor - (gajiKotor* jenisPotongan);
		potongan = gajiKotor - potongan;
		return potongan;

	}
//Function untung Menentukan Gaji Bersih
	public static double totalGajiBersih(double gajiKotor, double potonganBpjs, double potonganPensiun, double potonganPph){
		double gajiBersih = gajiKotor - potonganBpjs - potonganPensiun - potonganPph;

		return gajiBersih;
	}

//Function untung Format Rupiah
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