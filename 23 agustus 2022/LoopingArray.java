import java.util.Scanner;

public class LoopingArray {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		String
		nama, predikat,
		predikatArray[] = {"Cumlaude", "Sangat Memuaskan", "Memuaskan", "pending"},
		namaMataKuliah[], nilaiMataKuliah[], temp, resultOutput = "";
		int
		jumlahMataKuliah = 0,
		minimalMataKuliah = 2, maksimalMataKuliah = 12,
		minimalSKS = 2, maksimalSKS = 6,
		totalSKS = 0, sksMataKuliah[];
		float
		bobotNilaiMataKuliah[], bobotArray[] = {4, 3, 2, 1, 0},
		ipkArray[] = {3.5f, 2.75f, 2f},
		jumlahBobot = 0, indeksPrestasiKumulatif;
		boolean
		isJumlahMataKuliah = true, isSKSMataKuliah = true, isNilaiMataKuliah = true, isPending = false;

		// TEMPLATE (THIS IS THE MOST EXHAUSTING STEP IN MY EXPERIENCE)
		String
		templateJumlahMataKuliah = "Jumlah Mata Kuliah",
		templateJumlahSKS = "Jumlah SKS",
		welcomeMessage = "Selamat Datang di Simulasi Perhitungan Yudisium.",
		inputNamaMessage = "Silahkan Masukkan Nama Anda :",
		inputMataKuliahMessage = "Silahkan masukan Berapa Jumlah Mata Mata Kuliah :",
		inputNamaMataKuliahMessage = "Silahkan masukan Nama Mata Kuliah ke-%s :\n",
		inputSKSMessage = "Silahkan masukan Jumlah SKS untuk Mata Kuliah %s :\n",
		inputNilaiMessage = "Silahkan masukan Nilai Untuk Mata Kuliah %s (A/B/C/D/E) :\n",
		errorAngkaOnlyMessage = "Maaf, %s hanya bisa dimasukkan angka saja.\n",
		errorKurangMessage = "Maaf, %s tidak boleh kurang dari %s.\n",
		errorLebihMessage = "Maaf, %s tidak boleh lebih dari %s.\n",
		errorNilaiMessage = "Maaf, Nilai Mata Kuliah tidak boleh selain A, B, C, D, dan E.",
		outputHasil = "Hasil Perhitungan Yudisium a.n %s Adalah \"%s\" dengan Rincian Sebagai Berikut :\n",
		outputTotal = "- Total Mata Kuliah adalah %s, Yaitu:\n",
		outputList = "%s. %s (%s)\n",
		outputTotalSKS = "- Total SKS adalah %s.\n",
		outputIPK = "- IPK yang didapat adalah %s";

		System.out.println(welcomeMessage);

		// NAMA ANDA
			System.out.println(inputNamaMessage);
			nama = input.nextLine();

		// JUMLAH MATA KULIAH
			do {
				System.out.println(inputMataKuliahMessage);
				temp = input.next();
				if (!temp.matches("[0-9]+")) {
					System.out.printf(errorAngkaOnlyMessage, templateJumlahMataKuliah);
				} else {
					jumlahMataKuliah = Integer.parseInt(temp);
					if (jumlahMataKuliah < minimalMataKuliah) {
						System.out.printf(errorKurangMessage, templateJumlahMataKuliah, minimalMataKuliah);
					} else if (jumlahMataKuliah > maksimalMataKuliah) {
						System.out.printf(errorLebihMessage, templateJumlahMataKuliah, minimalMataKuliah);
					} else {
						isJumlahMataKuliah = false;
					}
				}
			} while (isJumlahMataKuliah);

		// INISIALISASI PANJANG ARRAY
			namaMataKuliah = new String[jumlahMataKuliah];
			nilaiMataKuliah = new String[jumlahMataKuliah];
			sksMataKuliah = new int[jumlahMataKuliah];
			bobotNilaiMataKuliah = new float[jumlahMataKuliah];

		// perulangan mata kuliah ke n
			for (int i = 0; i < jumlahMataKuliah; i++) {
				// NAMA MATA KULIAH
				System.out.printf(inputNamaMataKuliahMessage, (i+1));
				input.nextLine();
				namaMataKuliah[i] = input.nextLine();

				// JUMLAH SKS
				do {
					System.out.printf(inputSKSMessage, namaMataKuliah[i]);
					temp = input.next();
					if (!temp.matches("[0-9]+")) {
						System.out.printf(errorAngkaOnlyMessage, templateJumlahSKS);
					} else {
						sksMataKuliah[i] = Integer.parseInt(temp);
						if (sksMataKuliah[i] < minimalSKS) {
							System.out.printf(errorKurangMessage, templateJumlahSKS, minimalSKS);
						} else if (sksMataKuliah[i] > maksimalSKS) {
							System.out.printf(errorLebihMessage, templateJumlahSKS, maksimalSKS);
						} else {
							isSKSMataKuliah = false;
						}
					}
				} while (isSKSMataKuliah);

				// NILAI MATA KULIAH
				do {
					System.out.printf(inputNilaiMessage, namaMataKuliah[i]);
					nilaiMataKuliah[i] = input.next();
					if (	!(
								nilaiMataKuliah[i].equalsIgnoreCase("A") ||
								nilaiMataKuliah[i].equalsIgnoreCase("B") ||
								nilaiMataKuliah[i].equalsIgnoreCase("C") ||
								nilaiMataKuliah[i].equalsIgnoreCase("D") ||
								nilaiMataKuliah[i].equalsIgnoreCase("E")
								)
						) {
						System.out.println(errorNilaiMessage);
					} else {
						isNilaiMataKuliah = false;
					}
				} while (isNilaiMataKuliah);

				// OTOMATIS MEMASUKKAN BOBOT NILAI
				switch (nilaiMataKuliah[i].toUpperCase()) {
					case "A":
						bobotNilaiMataKuliah[i] = bobotArray[0];
						break;
					case "B":
						bobotNilaiMataKuliah[i] = bobotArray[1];
						break;
					case "C":
						bobotNilaiMataKuliah[i] = bobotArray[2];
						break;
					case "D":
						bobotNilaiMataKuliah[i] = bobotArray[3];
						break;
					default:
						bobotNilaiMataKuliah[i] = bobotArray[4];
						break;
				}
			}

		// KALKULASI TOTAL SKS, JUMLAH BOBOT, IPK, PREDIKAT
			// TOTAL SKS
				for (int sksSatuMataKuliah : sksMataKuliah) {
					totalSKS += sksSatuMataKuliah;
				}
			// JUMLAH BOBOT
				for (int j = 0; j < jumlahMataKuliah; j++) {
					jumlahBobot += (bobotNilaiMataKuliah[j] * sksMataKuliah[j]);
				}
			// IPK
				indeksPrestasiKumulatif = jumlahBobot / totalSKS;
			// PREDIKAT
				// Cek nilai mata kuliah E
				for (String nilaiKata : nilaiMataKuliah) {
					if (nilaiKata.equalsIgnoreCase("E")) {
						isPending = true;
					}
				}
				if (isPending || indeksPrestasiKumulatif < ipkArray[2]) {
					predikat = predikatArray[3];
				} else if (indeksPrestasiKumulatif >= ipkArray[2] && indeksPrestasiKumulatif < ipkArray[1]) {
					predikat = predikatArray[2];
				} else if (indeksPrestasiKumulatif >= ipkArray[1] && indeksPrestasiKumulatif < ipkArray[0]) {
					predikat = predikatArray[1];
				} else {
					predikat = predikatArray[0];
				}

		System.out.printf(outputHasil, nama, predikat);
		System.out.printf(outputTotal, jumlahMataKuliah);
		for (int l = 0; l < jumlahMataKuliah; l++) {
			resultOutput += String.format(outputList, l, namaMataKuliah[l], nilaiMataKuliah[l]);
		}
		System.out.println(resultOutput);
		System.out.printf(outputTotalSKS, totalSKS);
		System.out.printf(outputIPK, indeksPrestasiKumulatif);
	}
}