import java.util.Scanner;
public class CobaValidasi{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int jumlahSks = input.nextInt();

		 jumlahSks = validateInteger(input, jumlahSks);


	}

	public static int validateInteger(Scanner input, int jumlahSks){
		String templateErrorInteger = "Hanya Boleh memasukan Angka!!!\nSilahkan input kembali.\n", 
		templateErorrminimalSks = "\nMaaf, Jumlah SKS tidak boleh kurang dari 2.\nSilahkan input kembali.\n", 
		templateErorrMaximalSks = "\nMaaf, Jumlah SKS tidak boleh lebih dari 6\nSilahkan input kembali.\n";
		int minimalSks = 2, maximalSks = 6, minimalJumlahMatakuliah = 2, maximalJumlahMatakuliah = 12;


		if(jumlahSks < minimalSks){
			System.out.println(templateErorrminimalSks);
		}else if(jumlahSks > maximalSks){
			System.out.println(templateErorrMaximalSks);
		}

		return jumlahSks;
	}
}