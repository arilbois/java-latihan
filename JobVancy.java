import java.util.Scanner;

public class JobVancy{
	public static void main( String [] args){
		
		//Deklarasi
		Scanner input = new Scanner(System.in);
		String nama, JenisKelamin, posisi, lulusan;
		int umur, pengalaman, penampilan;
		
		
		//Input Data
		System.out.println("Nama :");
		nama = input.next();
		
		System.out.println("umur :");
		umur = input.nextInt();
		
		System.out.println("Jenis Kelamin");
		JenisKelamin = input.next();
		
		System.out.println("Lulusan (SMK/D3/S1");
		lulusan = input.next();
		
		System.out.println("Pengalaman (Tahun)");
		pengalaman = input.nextInt();
		
		System.out.println("Penampilan (1 s.d 10)");
		penampilan = input.nextInt();
		
		System.out.println("Posisi yang dilamar (SPV, Admin, atau Koordinator)");
		posisi = input.next();
		
		System.out.println(nama +", Terima kasih sudah mengikuti lowongan kerja di PT. Secret Semut.");
		System.out.println("");
		
		
	}
}