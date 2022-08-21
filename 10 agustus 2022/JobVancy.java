import java.util.Scanner;

public class JobVancy{
	public static void main( String [] args){
		
		//Deklarasi
		Scanner input = new Scanner(System.in);
		String nama, JenisKelamin, posisi, lulusan, hasil;
		int umur, pengalaman, penampilan;
		
		//inisialisasi
		hasil = "";
		
		
		//Input Data
		System.out.println("Nama :");
		nama = input.next();
		
		System.out.println("umur :");
		umur = input.nextInt();
		
		System.out.println("Jenis Kelamin (Pria/Wanita) :");
		JenisKelamin = input.next();
		
		System.out.println("Lulusan (SMK/D3/S1) :");
		lulusan = input.next();
		
		System.out.println("Pengalaman (Tahun) :");
		pengalaman = input.nextInt();
		
		System.out.println("Penampilan (1 s.d 10) :");
		penampilan = input.nextInt();
		
		System.out.println("Posisi yang dilamar (SPV, Admin, atau Koordinator) :");
		posisi = input.next();
		
		System.out.println(nama +", Terima kasih sudah mengikuti lowongan kerja di PT. Secret Semut.");
		System.out.println("");
		
		
		if(posisi.equals("Koordinator")){
			if(JenisKelamin.equals("Wanita")){
				hasil = "Maaf, " + nama + ".\nAnda Tidak memenuhi syarat sebagai " + posisi + ". Dan tidak akan masuk ke Tahap Selanjutnya.";
			}else{
				if(umur > 20 || umur < 31 && lulusan.equals("SMK") || lulusan.equals("D3") && pengalaman > 1){
					hasil = "Selamat, " + nama + ".\nAnda memenuhi syarat sebagai " + posisi + ". Dan akan masuk ke Tahap Selanjutnya.";
				}else if(umur > 29 && lulusan.equals("S1") && pengalaman > 4){
					hasil = "Selamat, " + nama + ".\nAnda memenuhi syarat sebagai " + posisi + ". Dan akan masuk ke Tahap Selanjutnya.";
				}else{
					hasil = "Maaf, " + nama + ".\nAnda Tidak memenuhi syarat sebagai " + posisi + ". Dan tidak akan masuk ke Tahap Selanjutnya.";
				}
			}
		}else if(posisi.equals("Admin")){
			if(JenisKelamin.equals("Wanita") && umur >= 20 || umur <= 25 && lulusan.equals("D3") && penampilan > 7 || pengalaman > 1){
				hasil = "Selamat, " + nama + ".\nAnda memenuhi syarat sebagai " + posisi + ". Dan akan masuk ke Tahap Selanjutnya.";
			}else if(JenisKelamin.equals("Wanita") && umur > 25 && lulusan.equals("S1") && penampilan > 7 && pengalaman >= 3){
				hasil = "Selamat, " + nama + ".\nAnda memenuhi syarat sebagai " + posisi + ". Dan akan masuk ke Tahap Selanjutnya.";
			}else if(JenisKelamin.equals("Pria") && umur >= 20 || umur <= 30 && lulusan.equals("D3") || lulusan.equals("S1") && penampilan > 7 && pengalaman >= 2){
				hasil = "Selamat, " + nama + ".\nAnda memenuhi syarat sebagai " + posisi + ". Dan akan masuk ke Tahap Selanjutnya.";
			}else{
				hasil = "Maaf, " + nama + ".\nAnda Tidak memenuhi syarat sebagai " + posisi + ". Dan tidak akan masuk ke Tahap Selanjutnya.";
			}
		}else if(posisi.equals("SPV")){
			if(umur >= 23 || umur <= 30 && lulusan.equals("S1") && pengalaman > 1){
				hasil = "Selamat, " + nama + ".\nAnda memenuhi syarat sebagai " + posisi + ". Dan akan masuk ke Tahap Selanjutnya.";
			}else if(umur >= 25 || umur <= 35 && lulusan.equals("D3") && pengalaman > 4){
				hasil = "Selamat, " + nama + ".\nAnda memenuhi syarat sebagai " + posisi + ". Dan akan masuk ke Tahap Selanjutnya.";
			}else{
				hasil = "Maaf, " + nama + ".\nAnda Tidak memenuhi syarat sebagai " + posisi + ". Dan tidak akan masuk ke Tahap Selanjutnya.";
			}
		}
		
		System.out.println(nama +", Terima kasih sudah mengikuti lowongan kerja di PT. Secret Semut.");
		System.out.println("");
		System.out.println(hasil);
	}
}