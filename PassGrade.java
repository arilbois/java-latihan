import java.util.Scanner;

public class PassGrade{
	public static void main( String [] args){
	int matematika;
	int indonesia;
	int inggris;
	int ipa;
	double averange;
	double sastra;
	boolean HasilAverange;
	boolean	HasilSastra;
	boolean HasilMatematika;
	
	Scanner input = new Scanner(System.in);
	
		System.out.println("Masukan Nilai Ujian Matematika :");
		matematika = input.nextInt();
		
		System.out.println("Masukan Nilai Ujian indonesia :");
		indonesia = input.nextInt();
		
		System.out.println("Masukan Nilai Ujian inggris :");
		inggris = input.nextInt();
		
		System.out.println("Masukan Nilai Ujian IPA :");
		ipa = input.nextInt();
		
		averange = (double)(matematika + indonesia + inggris + ipa) / 4;
		HasilAverange = averange > 73;
		sastra = (double)(indonesia + inggris) / 2;
		HasilSastra = sastra > 75;
		HasilMatematika = matematika > 80;
		
		
		System.out.println("Hasil dari simulasi untuk Persyaratan Penerimaan calon siswa di smk padepokan 79 adalah sebagai berikut :");
		System.out.println("================================================================");
		
		System.out.println("Apakah anda memenuhi syarat untuk masuk ke smk padepokan 79 : " + HasilAverange);
		System.out.println("Apakah anda memenuhi syarat untuk masuk ke Jurusan sastra : " + HasilSastra);
		System.out.println("Apakah anda memenuhi syarat untuk masuk ke jurusan teknik komputer jaringan : " + HasilMatematika);
	}
}