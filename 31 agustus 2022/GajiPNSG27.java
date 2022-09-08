import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class GajiPNSG27{
	public static final Scanner INPUT = new Scanner(System.in);

	public static final String
	TEMPLATEINPUTNAMA = "Tolong Masukan Nama Anda :",TEMPLATEINPUTGOLONGAN = "Tolong Masukan Golongan Anda :",TEMPLATEINPUTRUANGKERJA = "Tolong Masukan Golongan Ruang Kerja Anda :", TEMPLATEINPUTMASAKERJA = "Tolong Masukan Jumlah Masa Kerja Golongan Anda :",TEMPLATEINPUTSTATUSMENIKAH = "Tolong Masukan Status Menikah Anda : (Kawin/Belum Kawin/Cerai) )",TEMPLATEINPUTJUMLAHANAK = "Tolong Masukan Jumlah Anak Anda :",
	REGEX = "[0-9]+",TEMPLATEWELCOME = "Slip Gaji Karyawan", TEMPLATEINPUTGOLONGAN12 = "Hanya ada Golongan Ruang Kerja A",
	TEMPLATELINE = "=================================================";

	public static final int 
	MINIMALPANGKAT = 1, MAXIMALPANGKAT = 4,MINIMALANAK = 0,MINIMALMASAKERJA = 0,  MAXIMALDATA = 33, MAXIMALGOLONGAN1 = 2, MAXIMALMASAKERJAGOLONGAN = 100 ;

	public static void main(String[] args){
		//Deklarasi dan inisialisasi variabel
		String[] ruangKerja1Sampai3 = {"A","B","C","D"}, ruangKerja4 = {"A","B","C","D","E"}, statusPernikahanData = {"Kawin","Belum Kawin", "Cerai"};
		String nama, golonganRuangKerja, statusPernikahan = "";
		int golonganPangkat, masakerja, jumlahAnak,  convertedRuangKerja;
		double gajiPokok = 0,gajiMinimalBruto = 4500000,iuranPensiunPercen = 0.0475,biayaJabatan,totalPotongan,iuranPensiun,potonganPph = 0, tunjanganKeluarga = 0, tunjanganAnak = 0, tunjanganBeras = 0, gajiBruto = 0, tunjaganJabatan = 0, iuaranWajibPajak = 0, potonganTaperum = 0, gajiNeto;
		boolean checkGolongan = true;
		//Input Nama
		nama = inputTypeAlphabet(TEMPLATEINPUTNAMA);
		do{
		//Input Pangkat
			golonganPangkat = inputTypeNumberLimit(TEMPLATEINPUTGOLONGAN, MINIMALPANGKAT, MAXIMALPANGKAT);

		//kondisi untuk Golongan ruang kerja yang berbeda
			if(golonganPangkat < MAXIMALPANGKAT){
				golonganRuangKerja =  inputTypeAlphabetLimit(TEMPLATEINPUTRUANGKERJA,ruangKerja1Sampai3);
			}else{
				golonganRuangKerja =  inputTypeAlphabetLimit(TEMPLATEINPUTRUANGKERJA,ruangKerja4);		
			}
		//Input Masa kerja
			masakerja = inputTypeNumberLimit(TEMPLATEINPUTMASAKERJA, MINIMALMASAKERJA, MAXIMALMASAKERJAGOLONGAN);

		// Check golongan kerja Sesuai Data
			checkGolongan = checkGolonganPangkat(golonganPangkat,masakerja,golonganRuangKerja);
		}while(checkGolongan);
		
		//Input Status Pernikahan
		statusPernikahan = inputTypeAlphabetLimit(TEMPLATEINPUTSTATUSMENIKAH, statusPernikahanData);

		//Kondisi Jika Belum menikah tidak bisa input jumlah anak 
		if(statusPernikahan.equalsIgnoreCase(statusPernikahanData[1])){
			jumlahAnak = MINIMALANAK;	
		}else{
			jumlahAnak = inputTypeNumberLimit(TEMPLATEINPUTJUMLAHANAK, MINIMALANAK, MAXIMALDATA);
		}
		//Untuk mengubah Bentuk huruf menjadi angka 
		convertedRuangKerja = convertGolonganRuangKerja(golonganRuangKerja);

		//Pengkondisian Untuk Menghitung Gaji Pokok
		gajiPokok = menghitungGajiPokok(golonganPangkat,masakerja,convertedRuangKerja);	

		//Proses Perhitungan tunjangan
		tunjanganKeluarga 	= menghitungTunjangan(gajiPokok, statusPernikahan);
		tunjanganAnak 		= menghitungTunjangan(gajiPokok,jumlahAnak);
		tunjanganBeras 		= menghitungTunjangan(jumlahAnak,statusPernikahan);
		tunjaganJabatan 	= menghitungData(golonganPangkat, "jabatan");

		//Proses Menjumlhakna Gaji Bruto
		gajiBruto = menghitunggajiBruto(gajiPokok,tunjanganKeluarga,tunjanganAnak,tunjanganBeras,tunjaganJabatan);

		//Proses Perhitungan Potongan
		biayaJabatan = menghitungPotongan(gajiBruto);
		iuranPensiun = (gajiPokok + tunjanganKeluarga + tunjanganAnak) * iuranPensiunPercen;
		double netto = (gajiBruto-biayaJabatan-iuranPensiun);
		if (gajiBruto >= gajiMinimalBruto) {
			potonganPph = menghitungPotongan(netto, statusPernikahan, jumlahAnak);
		}
		iuaranWajibPajak = menghitungPotongan(gajiPokok,tunjanganAnak,tunjanganKeluarga);
		potonganTaperum  = menghitungData(golonganPangkat, "taperum");
		totalPotongan    = iuaranWajibPajak + potonganTaperum + potonganPph;
		gajiNeto         = gajiBruto - totalPotongan; 

		//Untuk Menampilkan Slip gaji
		getFinalOutput(nama, gajiPokok, tunjanganKeluarga, tunjanganAnak, tunjaganJabatan, tunjanganBeras, gajiBruto, potonganPph, iuaranWajibPajak, potonganTaperum, totalPotongan, gajiNeto);
	}//batas main

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
			result = INPUT.nextLine();
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
			angka = INPUT.nextLine();
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
		if (!angka.matches(REGEX)) {
			return hasil=false;
		} else{
			return hasil = true;
		}
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
	//Function untuk mengubah huruf menjadi angka
	public static int convertGolonganRuangKerja(String golonganRuangKerja){
		String[] ruangKerja = {"A","B","C","D","E"};
		int result = -1;
		for (int i = 0; i < ruangKerja.length; i++) {
			if (golonganRuangKerja.equalsIgnoreCase(ruangKerja[i])) {
				result = i;
			}
		}
		return result;
	}
	//Function untuk Menghitung gaji Pokok
	public static double menghitungGajiPokok(int golonganPangkat ,int masakerja,int convertedRuangKerja){
		if (masakerja>=GAJIPOKOKGOLONAN[golonganPangkat-1].length) {
				masakerja = (GAJIPOKOKGOLONAN[golonganPangkat-1].length)-1;
			}
		double gajiPokok = GAJIPOKOKGOLONAN[golonganPangkat-1][masakerja][convertedRuangKerja];
		return gajiPokok;
	}
	//Function untuk Menghitung Tunjangan Pernikahan
	public static double menghitungTunjangan(double gajiPokok,String statusPernikahan){
		double tunjanganKeluarga = 0, gajiPokokPercent = 0.1;
		if(statusPernikahan.equalsIgnoreCase("kawin")){
			tunjanganKeluarga = gajiPokok * gajiPokokPercent;
		}
		return tunjanganKeluarga;
	}
	//Function untuk Menghitung Tunjangan Anak
	public static int maximalAnak(int jumlahAnak){
		if(jumlahAnak > 2){
			jumlahAnak = 2;
		}else{
			jumlahAnak = jumlahAnak;
		}
		return jumlahAnak;
	}
	//Function untuk Menghitung Jumlah Anak Maximal Tunjangan
	public static double menghitungTunjangan(double gajiPokok, int jumlahAnak){
		jumlahAnak = maximalAnak(jumlahAnak);
		double tunjanganAnak = (gajiPokok * 0.02) * jumlahAnak;
		return tunjanganAnak;
	}
	//Function untuk Menghitung Tunjangan Beras
	public static double menghitungTunjangan(int jumlahAnak,String statusPernikahan){
		jumlahAnak = maximalAnak(jumlahAnak);
		double hargaBeras = 15000, banyakBeras = 10;
		int jmlAnggotaKeluarga = 1;
		if (statusPernikahan.equalsIgnoreCase("kawin")){
			jmlAnggotaKeluarga += 1;	
		}
		return (jmlAnggotaKeluarga+jumlahAnak)*hargaBeras*banyakBeras;
	}
	//Function untuk Menghitung Tunjangan Jabatan
	public static double menghitungData(int golonganPangkat, String tipe){
		double dataTaperumJabatan[][] ={{3000,175000},{5000,18000},{7000,185000},{10000,190000}};
        double valueData=0; 
        if (tipe.equalsIgnoreCase("jabatan")) {
			valueData = dataTaperumJabatan[golonganPangkat-1][1];
		} else {
			valueData = dataTaperumJabatan[golonganPangkat-1][0];
		}
        return valueData;
    }
	//Function untuk Menghitung Gaji Bruto
	public static double menghitunggajiBruto(double gajiPokok,double tunjanganKeluarga,double tunjanganAnak, double tunjanganBeras, double tunjaganJabatan){
		double gajiBruto = gajiPokok + tunjanganKeluarga + tunjanganAnak + tunjanganBeras + tunjaganJabatan;
		return gajiBruto;
	}
	//Function untuk Menghitung Potongan PPH21
	public static double menghitungPotongan(double netto, String statusPernikahan, double jumlahAnak){
		double wpSendiri= 36000000, wpAnak= jumlahAnak*3000000, wpistri = 0, pphSetahunPercen = 0.05, setahun = 12, maxAnak=3;
		if (statusPernikahan.equalsIgnoreCase("kawin")){
			wpistri =  3000000;
		}
		if (jumlahAnak > maxAnak){
			wpAnak = maxAnak * 3000000;
		}
		double jumlahPTKP 	= (wpSendiri + wpAnak + wpistri);
		double pkp 		  	= (netto * setahun) - jumlahPTKP;
		double pphSetahun 	= pphSetahunPercen * pkp;
		double pphPerbulan 	= pphSetahun / setahun;
		return pphPerbulan;
	}
	//Function untuk Menghitung Potongan IWT
	public static double menghitungPotongan(double gajiPokok, double tunjanganAnak, double tunjanganKeluarga){
		double iuaranWajibPajak = (gajiPokok + tunjanganAnak + tunjanganKeluarga) * 0.1;
		return iuaranWajibPajak;
	}
	public static double menghitungPotongan(double gajiBruto){
		double biayaJabatan = gajiBruto * 0.05;
		return biayaJabatan;
	}
	//Function untuk Mengecek golongan Pangkat
	public static boolean checkGolonganPangkat(int golonganPangkat,int masakerja, String golonganRuangKerja){
		boolean checkGolongan = false;
		if (golonganPangkat <= MAXIMALGOLONGAN1){
			if(!golonganRuangKerja.equalsIgnoreCase("A") && masakerja <= MAXIMALGOLONGAN1){
				System.out.println(TEMPLATEINPUTGOLONGAN12 + " Untuk Golongan " + golonganPangkat + " dan masa Kerja " + masakerja);
				checkGolongan = true;
			}
		}
		return checkGolongan;
	}
	public static void getFinalOutput(String nama, double gajiPokok, double tunjanganKeluarga, double tunjanganAnak, double tunjaganJabatan, double tunjanganBeras, double gajiBruto, double potonganPph, double iuaranWajibPajak, double potonganTaperum, double totalPotongan, double gajiNeto){
        String result = "";
        result += TEMPLATELINE;
        result += "\n              "+TEMPLATEWELCOME+"        ";
        result += "\n                     "+nama+"        ";
        result += "\n"+TEMPLATELINE;
        result += "\nGaji Pokok                    :"+indonesiaCurrency(gajiPokok);
        result += "\nTunjangan Istri               :"+indonesiaCurrency(tunjanganKeluarga);
        result += "\nTunjangan Anak                :"+indonesiaCurrency(tunjanganAnak);
        result += "\nTunjangan Jabatan             :"+indonesiaCurrency(tunjaganJabatan);
        result += "\nTunjangan beras               :"+indonesiaCurrency(tunjanganBeras);
        result += "\n"+TEMPLATELINE;
        result += "\njumlah Pengahasilan Bruto     :"+indonesiaCurrency(gajiBruto);
        result += "\n"+TEMPLATELINE;
        result += "\njumlah Potongan PPH 21        :"+indonesiaCurrency(potonganPph);
        result += "\njumlah Potongan IWP           :"+indonesiaCurrency(iuaranWajibPajak);
        result += "\njumlah Potongan Taperum       :"+indonesiaCurrency(potonganTaperum);
        result += "\n"+TEMPLATELINE;
        result += "\nTotal Potongan                :"+indonesiaCurrency(totalPotongan);    
        result += "\n"+TEMPLATELINE;
        result += "\njumlah Gaji Neto / THP        :"+indonesiaCurrency(gajiNeto);
        result += "\n"+TEMPLATELINE;
        System.out.println(result);
    }

	public static final int[][][] 
	GAJIPOKOKGOLONAN = {
		{
			{1560800},{1560800},{1610000}, 		{1610000,1704500,1776600,1851800},
			{1660700,1704500,1776600,1851800},	{1660700,1758200,1832600,1910100},
			{1713000,1758200,1832600,1910100},	{1713000,1813600,1890300,1970200},
			{1766900,1813600,1890300,1970200},	{1766900,1870700,1949800,2032300},
			{1822600,1870700,1949800,2032300},	{1822600,1929600,2011200,2096300},
			{1880000,1929600,2011200,2096300},	{1880000,1990400,2074600,2162300},
			{1939200,1990400,2074600,2162300},	{1939200,2053100,2139900,2230400},
			{2000300,2053100,2139900,2230400},	{2000300,2053100,2139900,2230400},
			{2063300,2053100,2139900,2230400},	{2063300,2184400,2276800,2373100},
			{2128300,2184400,2276800,2373100},	{2128300,2184400,2276800,2373100},
			{2195300,2184400,2276800,2373100},	{2195300,2324200,2422500,2525000},
			{2254400,2324200,2422500,2525000},	{2254400,2397400,2498800,2604500},
			{2335800,2397400,2498800,2604500},	{2335800,2472900,2557500,2686500},
		},
		{
			{2022200},{2054100},{2054100},		{2118800,2208400,2301800,2399200},
		{2118800,2208400,2301800,2399200},	{2185500,2277900,2374300,2474700},//5
		{2185500,2277900,2374300,2474700},	{2254300,2349700,2449100,2552700},
		{2254300,2349700,2449100,2552700},	{2325300,2423700,2526200,2633100},
		{2325300,2423700,2526200,2633100},	{2398600,2500000,2605800,2716000},
		{2398600,2500000,2605800,2716000},	{2474100,2578800,2687800,2801500},
		{2474100,2578800,2687800,2801500},	{2552000,2660000,2772500,2889800},
		{2552000,2660000,2772500,2889800},	{2632400,2743800,2859800,2980800},
		{2632400,2743800,2859800,2980800},	{2715300,2830200,2949900,3074700},
		{2715300,2830200,2949900,3074700},	{2800800,2919300,3042800,3171500},
		{2800800,2919300,3042800,3171500},	{2889100,3011200,3138600,3271400},
		{2889100,3011200,3138600,3271400},	{2980000,3106100,3237500,3374400},
		{2980000,3106100,3237500,3374400},	{3073900,3293899,3339400,3480700},
		{3073900,3293899,3339400,3480700},	{3170700,3304800,3444600,3590300},
		{3170700,3304800,3444600,3590300},	{3270600,3408900,3553100,3703400},
		{3270600,3408900,3553100,3703400},	{3373600,3516300,3665000,3820000},
	},
	{
		{2579400,2688500,2802300,2920800},	{2579400,2688500,2802300,2920800},
		{2660700,2773200,2890500,3012800},	{2660700,2773200,2890500,3012800},
		{2744500,3860500,3981500,3107700},	{2744500,3860500,3981500,3107700},
		{2830900,2950600,3075500,3205500},	{2830900,2950600,3075500,3205500},
		{2920100,3043600,3172300,3306500},	{2920100,3043600,3172300,3306500},
		{3012000,3139400,3272200,3410600},	{3012000,3139400,3272200,3410600},
		{3106900,3238300,3375300,3518100},	{3106900,3238300,3375300,3518100},
		{3204700,3340300,3481600,3628900},	{3204700,3340300,3481600,3628900},
		{3305700,3445500,3591200,3743199},	{3305700,3445500,3591200,3743199},
		{3409800,3554000,3704300,3861000},	{3409800,3554000,3704300,3861000},
		{3517200,3665900,3821000,3982600},	{3517200,3665900,3821000,3982600},
		{3627900,3781400,3941400,4108100},	{3627900,3781400,3941400,4108100},
		{3742200,3900500,4065500,4237500},	{3742200,3900500,4065500,4237500},
		{3860100,4023300,4193500,4370900},	{3860100,4023300,4193500,4370900},
		{3981600,4150100,4325600,4508600},	{3981600,4150100,4325600,4508600},
		{4017000,4280800,4461800,4650600},	{4017000,4280800,4461800,4650600},
		{4236400,4415600,4602400,2797000},
	},
	{
		{3044300,3173100,3307300,3447200,3593100},	{3044300,3173100,3307300,3447200,3593100},
		{3140200,3272100,3411500,3555800,3706200},	{3140200,3272100,3411500,3555800,3706200},
		{3239100,3376100,3518900,3667800,3822900},	{3239100,3376100,3518900,3667800,3822900},
		{3341100,3482500,3629800,3783300,3943300},	{3341100,3482500,3629800,3783300,3943300},
		{3446400,3592100,3744199,3902500,4067500},	{3446400,3592100,3744199,3902500,4067500},
		{3554900,3705300,3862000,4025400,4195700},	{3554900,3705300,3862000,4025400,4195700},
		{3666900,3822000,3983600,4152200,4327800},	{3666900,3822000,3983600,4152200,4327800},
		{3782400,3942400,4109100,4282900,4462100},	{3782400,3942400,4109100,4282900,4462100},
		{3901500,4066500,4237500,4417800,4604700},	{3901500,4066500,4237500,4417800,4604700},
		{4024400,4192600,4372000,4557000,4749700},	{4024400,4192600,4372000,4557000,4749700},
		{4151100,4326700,4509700,4700500,4899300},	{4151100,4326700,4509700,4700500,4899300},
		{4281800,4463000,4651800,4848500,5053600},	{4281800,4463000,4651800,4848500,5053600},
		{4416700,4603500,4798300,5001200,5212800},	{4416700,4603500,4798300,5001200,5212800},
		{4555800,4748500,4949400,5158700,5377000},	{4555800,4748500,4949400,5158700,5377000},
		{4699300,4898100,5105300,5321200,5546300},	{4699300,4898100,5105300,5321200,5546300},
		{4847300,5052300,5266100,5488800,5721000},	{4847300,5052300,5266100,5488800,5721000},
		{5000000,5211500,5431900,5661700,5901200},
	}
};
}//class
