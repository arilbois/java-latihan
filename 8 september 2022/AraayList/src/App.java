import java.util.Scanner;
 
public class App {
 
    public static void main(String[] args) {
        Scanner baca = new Scanner(System.in);
        System.out.println("Selamat datang di APOTEK Sehat");
        System.out.println("SISTEM MANAJEMEN TERPADU APOTEK");
        System.out.print("Masukkan Jumlah Modal Uang di Toko(KASIR): ");
        long uang;
        try {//Test Exception Handling
            uang = baca.nextInt();
        } catch (Exception e) {//Jika kode diatas error maka akan ditampilkan
            baca.nextLine();
            System.out.println("----------------");
            System.out.println("System says : Masukkan Salah tidak Integer");
            System.out.print("Masukkan Uang sekali lagi :");
            baca.nextLine();
            uang = baca.nextInt();
        }
        int pilih = 0;
        boolean verifikasi = false;
        tokoSistem toko = new tokoSistem(uang);//create objek toko
        baca.nextLine();
        toko.start();//memulai isi data
        do {
            if (verifikasi != true) {//login
                System.out.println("----------------");
                System.out.println("Login User");
                System.out.print("Masukkan Usename  : ");
                String user = baca.nextLine();
                System.out.print("Masukkan Password : ");
                String pass = baca.nextLine();
                verifikasi = toko.Verif(user, pass);
                if (verifikasi != true) {//jika login gagal
                    System.out.println("System says : Password Salah");
                }//akhir dari login
            } else {//jika login berhasil
                System.out.println("----------------");
                System.out.println("-Daftar Layanan-");
                System.out.println("1.Tambah Barang");
                System.out.println("2.Daftar Barang");
                System.out.println("3.Cari Barang");
                System.out.println("4.Pembelian");
                System.out.println("5.Hapus Barang");
                System.out.println("6.Cek KAS Saldo");
                System.out.println("7.Cek Jumlah Transaksi");
                System.out.println("8.History Barang keluar");
                System.out.println("8.Exit");
                System.out.print("Masukkan Pilihan : ");
                try{pilih = baca.nextInt();//pilihan user
                baca.nextLine();
                }catch(Exception e){//exception handling salah
                    System.out.println("System says : Input salah");
                    System.out.println("Ulangi pilihan");
                    System.out.print("Masukkan Pilihan : ");
                    pilih=baca.nextInt();
                    baca.nextLine();
                }
                char lanjut;
                System.out.println("----------------");
                switch (pilih) {//switch @ nilai dari pilih
                    case 1:
                        System.out.println("Tambah Barang");
                        do {
                            System.out.print("Masukkan Kode Barang   : ");
                            String kode = baca.nextLine();
                            System.out.print("Masukkan Nama Barang   : ");
                            String nama = baca.nextLine();
                            System.out.print("Masukkan Harga Barang  : ");
                            int harga;
                            try {//exception handling
                                harga = baca.nextInt();
                                baca.nextLine();
                            } catch (Exception e) {
                                System.out.println("System says : Inputan tidak valid(ulangi)");
                                System.out.print("Masukkan Harga Barang : ");
                                harga = baca.nextInt();
                                baca.nextLine();
                            }//akhir exception
                            System.out.print("Masukkan Jumlah Barang : ");
                            int jumlah;
                            try {//another exception
                                jumlah = baca.nextInt();
                                baca.nextLine();
                            } catch (Exception e) {
                                System.out.println("System says : Inputan tidak valid(ulangi)");
                                System.out.print("Masukkan Jumlah Barang : ");
                                jumlah = baca.nextInt();
                                baca.nextLine();
                            }//end of exception
                            toko.tambahBarang(nama, kode, harga, jumlah);
                            System.out.print("Lanjut? (y/n) ");
                            try{//another exception(again)
                            lanjut = baca.nextLine().toLowerCase().charAt(0);    
                            }catch(Exception e){
                                System.out.println("System says : Inputan tidak valid");
                                System.out.print("Lanjut (y/n) ");
                                lanjut = baca.nextLine().toLowerCase().charAt(0);
                            }//end of exception(again)
                        } while (lanjut == 'y');
                        break;
                    case 2://menu daftar barang
                        System.out.println("Daftar Barang");
                        System.out.println("Kode\tNama\t\tStok\tHarga");
                        toko.displayBarang();
                        break;
                    case 3://menu cari
                        System.out.println("Pencarian Barang");
                        System.out.print("Masukkan Kode : ");
                        String kode = baca.nextLine().toLowerCase();
                        toko.cariBarang(kode);
                        break;
                    case 4://menu pembelian
                        System.out.println("Pembelian Barang");
                        do {
                            System.out.print("Masukkan Kode Barang   : ");
                            kode = baca.nextLine();
                            System.out.print("Masukkan Jumlah Barang : ");
                            int jumlah = baca.nextInt();
                            baca.nextLine();
                            toko.beli(kode, jumlah);
                            System.out.print("Lanjut? (y/n) ");
                            lanjut = baca.nextLine().toLowerCase().charAt(0);
                        } while (lanjut == 'y');
                        System.out.println("Total Pembelian anda adalah :Rp." + toko.total());
                        toko.resetPembelian();
                        break;
                    case 5://hapus barang dari database
                        System.out.println("Hapus Barang");
                        System.out.print("Masukkan Kode : ");
                        kode = baca.nextLine();
                        toko.hapusBarang(kode);
                        break;
                    case 6://cek saldo kasir
                        System.out.println("Kas Saldo Kasir");
                        toko.cekUang();
                        break;
                    case 7://history transaksi
                        System.out.println("History Transaksi");
                        toko.trx();
                        break;
                    case 8://info barang keluar
                        System.out.println("Data Barang Keluar");
                        toko.barangKeluar();
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Menu tidak tersedia");
                }
            }
        } while (pilih != 9);
        System.out.println("System says : Bye Bye");
        System.out.println("Coded By Faathin with a cup of Coffee");
    }
}
 