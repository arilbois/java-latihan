import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class PayrolKaryawan{

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
		double[] umkCity = {3742276, 4453935, 4782935,1961085, 4330249, 3289409};
		String[] branchCompanyData = {"Bandung","Jakarta","Bekasi","Garut","Bogor","Palembang"},roleCompanyData = {"Admin","Coordinator","SPV","Manager","Sprinter","Officer"}, statusMenikahData = {"Ya","Tidak","Ya","Tidak","Ya","Tidak"};

		double tunjanganMenikah = 0.1, tunjanganJabatan = 0.05, tunjanganTransport = 500000, tunjanganPegawai = 0, gajiKotor, potonganBpjs = 0.02, potonganPensiun = 0.02, potonganPph = 0.05, gajiBersih;
		String nama, tempString, roleCompany, branchCompany,statusMenikah, syaratTunjanganTranport = "Jakarta";
		int  masaKerja;

	//Input Nama
		nama = inputTypeAlphabet(templateInputNama);
	//Input Jabatan
		System.out.println(templateInputJabatan);
		tempString = input.next();
		roleCompany= validatePlayerChoiceChar(tempString, roleCompanyData, templateErrorRole);
	//Input Cabang
		System.out.println(templateInputCabang);
		tempString = input.next();
		branchCompany = validatePlayerChoiceChar(tempString, branchCompanyData, templateErrorCabang);
	//Input Masa Kerja
		masaKerja = inputTypeNumberLimit(templateInputMasaKerja, minimalKerja, maximalKerja);
	//Input Cabang
		System.out.println(templateInputMenikah);
		tempString = input.next();
		statusMenikah = validatePlayerChoiceChar(tempString, statusMenikahData, templateErorrMenikah);


		//Proses
		double umkKaryawan = convertCabangToUmk(branchCompany,branchCompanyData,umkCity);
		double gajiPokok =  countgajiPokok(roleCompany, umkKaryawan, masaKerja, roleCompanyData);
		tunjanganTransport = addTujangan(branchCompany,tunjanganTransport,syaratTunjanganTranport, umkKaryawan);
		tunjanganMenikah = addTujangan(statusMenikah,"Ya",tunjanganMenikah, umkKaryawan);
		tunjanganJabatan = addTujangan(masaKerja, tunjanganJabatan, umkKaryawan);
		tunjanganPegawai = addTujangan(roleCompany, branchCompanyData);
		gajiKotor = totalGajiKotor(gajiPokok,tunjanganJabatan, tunjanganPegawai ,tunjanganTransport,tunjanganMenikah);
		potonganPensiun = addPotongan(gajiKotor, potonganPensiun);
		potonganBpjs = addPotongan(gajiKotor, potonganBpjs);
		potonganPph = addPotongan(gajiKotor, potonganPph);
		gajiBersih = totalGajiBersih(gajiKotor, potonganBpjs, potonganPensiun, potonganPph);

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

	//function validasi hanya Jabatan dan cabang yang di input
	public static String validatePlayerChoiceChar(String inputString,String[] data,String templateError){
		boolean isValid = false;
		do{
			if(!(inputString.equalsIgnoreCase(data[0])||
				inputString.equalsIgnoreCase(data[1])||
				inputString.equalsIgnoreCase(data[2])||
				inputString.equalsIgnoreCase(data[3])||
				inputString.equalsIgnoreCase(data[4])||
				inputString.equalsIgnoreCase(data[5]))){
				System.out.println(templateError);
			inputString = input.next();
		}else{
			isValid = true;
		}
	}while(!isValid);
	return inputString;
}
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

public static double addTujangan(String syaratTunjangan, String data,double typeTunjangan, double umkKaryawan){
	double tunjangan;
	
	if(syaratTunjangan.equalsIgnoreCase(data)){
		tunjangan = umkKaryawan * typeTunjangan;
	}else{
		tunjangan = 0;
	}

	return tunjangan;
}
public static double addTujangan(String syaratTunjangan,double typeTunjangan,String data, double umkKaryawan){
	double tunjangan;
	
	if(syaratTunjangan.equalsIgnoreCase(data)){
		tunjangan = 500000;
	}else{
		tunjangan = 0;
	}

	return tunjangan;
}
public static double addTujangan(int masaKerja,double typeTunjangan, double umkKaryawan){
	double tunjangan;
	
	if(masaKerja > 4){
		tunjangan = umkKaryawan * typeTunjangan;
	}else{
		tunjangan = 0;
	}

	return tunjangan;
}

public static double addTujangan(String roleCompany,String[] roleCompanyData){
	double tunjangan;
	if(roleCompany.equalsIgnoreCase(roleCompanyData[0])){
		tunjangan = 200000;
	}else if(roleCompany.equalsIgnoreCase(roleCompanyData[1])){
		tunjangan = 500000;
	}else if(roleCompany.equalsIgnoreCase(roleCompanyData[2])){
		tunjangan = 700000;
	}else if(roleCompany.equalsIgnoreCase(roleCompanyData[3])){
		tunjangan = 1000000;
	}else{
		tunjangan = 200000;
	}

	return tunjangan;
}

public static double totalGajiKotor(double gajiPokok, double tunjanganJabatan,double tunjanganPegawai ,double tunjanganTransport,double tunjanganMenikah){
	double gajiKotor = gajiPokok + tunjanganPegawai + tunjanganJabatan + tunjanganMenikah + tunjanganTransport;
	return gajiKotor;
}

public static double addPotongan(double gajiKotor, double jenisPotongan){
	double potongan = gajiKotor - (gajiKotor* jenisPotongan);
	potongan = gajiKotor - potongan;
	return potongan;

}
public static double totalGajiBersih(double gajiKotor, double potonganBpjs, double potonganPensiun, double potonganPph){
	double gajiBersih = gajiKotor - potonganBpjs - potonganPensiun - potonganPph;

	return gajiBersih;
}
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