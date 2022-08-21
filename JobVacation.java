import java.util.Scanner;
public class JobVacation{
	public static void main( String [] args){
		String nama;
		int umur;
		String JenisKelamin;
		String lulusan;
		int pengalaman;
		int penampilan;
		boolean Criteriakoordinator1;
		boolean Criteriakoordinator2;
		boolean CriteriaAdmin1;
		boolean CriteriaAdmin2;
		boolean koordinator;
		boolean admin;
		
		Scanner input = new Scanner(System.in);
	
		System.out.println("Nama:");
		nama = input.next();
	
		System.out.println("Umur :");
		umur = input.nextInt();
		
		System.out.println("Jenis Kelamin :");
		JenisKelamin = input.next();

		System.out.println("Lulusan (SMK/D3/S1) :");
		lulusan = input.next();
		
		System.out.println("Pengalaman :");
		pengalaman = input.nextInt();
		
		System.out.println("Penampilan :");
		penampilan = input.nextInt();
		
		Criteriakoordinator1 = (JenisKelamin.equalsIgnoreCase("pria")) && (umur >= 21 || umur <= 30) && (lulusan.equalsIgnoreCase("smk") || lulusan.equalsIgnoreCase("d3")) && (pengalaman >= 2);
		Criteriakoordinator2 = (JenisKelamin.equalsIgnoreCase("pria")) && (umur > 30) && (pengalaman >= 5);
		CriteriaAdmin1 = (JenisKelamin.equalsIgnoreCase("wanita")) && (umur >= 20 || umur <= 25) && (lulusan.equalsIgnoreCase("d3")) && (penampilan > 7 || pengalaman >= 1);
		CriteriaAdmin2 = (JenisKelamin.equalsIgnoreCase("wanita")) && (umur > 25) && (lulusan.equalsIgnoreCase("s1")) && (penampilan > 7) && (pengalaman >= 5);
		
		koordinator = Criteriakoordinator1 || Criteriakoordinator2;
		admin = CriteriaAdmin1 || CriteriaAdmin2 ;
		
		System.out.println(nama + ", Terima kasih sudah mengikuti Lowongan Kerja di PT. Secret Semut 79. ");
		System.out.println("Berikut adalah hasil dari rekrutment untuk koordinator dan admin : ");
		
		System.out.println("Hasil Kelulusan untuk Koordinator : " + koordinator);
		System.out.println("Hasil kelulusan untuk Admin : " + admin);
	
 
}
}