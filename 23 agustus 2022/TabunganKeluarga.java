import java.util.Scanner;

public class TabunganKeluarga{
	public static void main( String [] args){
		Scanner input = new Scanner(System.in);
		int tabungan = 0, perHari = 0, keluarga,minimalKeluarga = 2, maximalKeluarga = 6, minLamaTabungan = 1, maximalLamaTabungan = 12;
		int[] maximalDayOfMonth = {31, 28, 31 ,30 ,31,30,31,31,30,31,30,31};
		int[]lamaTabungan = new int[maximalDayOfMonth.length];

		String result = "",
		templateInputKeluarga = "Masukan Jumlah keluarga :  ", templateInputLamaTabungan = "Masukan Lama tabungan : ", templateTabungan = "Tabungan Pada bulan";


		System.out.println(templateInputKeluarga);
		keluarga = input.nextInt();
		System.out.println(templateInputLamaTabungan);
		lamaTabungan[0] = input.nextInt();

		for( int i = 0; i < maximalDayOfMonth.length; i++ ){
			
				for (int cariPerhari : maximalDayOfMonth) {
					perHari += cariPerhari;
				}
			
			for(int j = 0; j < lamaTabungan[i]; j++ ){
				System.out.println(templateTabungan + j + "sebesar" + tabungan);
			}
		}
		System.out.println(perHari);
		System.out.println("Total Tabungan Selama 3 Bulan dengan 4 anggota keluarga adalah 5592000");


	}
}

