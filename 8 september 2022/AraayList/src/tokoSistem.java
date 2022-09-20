import java.util.HashMap;
public class tokoSistem {
   
    private static HashMap<String, String> namaBarang = new HashMap<>();//kode nama barang
    private static HashMap<String, Integer> kodeHarga = new HashMap<>();//kode Harga
    private static HashMap<String, Integer> kodeJumlah = new HashMap<>();//kode Jumlah
    private static HashMap<String, Integer> barangKeluar = new HashMap<>();//namaBarang barang keluar
    private long uang;//uang kantor
    private int transaksi;//daftar transaksi
    private int persediaan;//persediaan
    private static final String user = "aril";
    private static final String password = "bois";
    private long pembelian;
    
    tokoSistem() {//construst
        uang = 0;
    }
    
    void resetPembelian() {//resetter
        pembelian = 0;
    }
    
    tokoSistem(long uang) {//construct
        this.uang = uang;
    }
    
    void tambahBarang(String nama, String kode, int harga, int jumlah) {
        namaBarang.put(kode, nama);
        kodeHarga.put(kode, harga);
        kodeJumlah.put(kode, jumlah);
        persediaan += jumlah;
    }//untuk menambah barang
    
    void beli(String kode, int jumlah) {
        if (namaBarang.containsKey(kode)) {//jika namaBarang ada kode yang dicari
            int sedia = kodeJumlah.get(kode);//sedia nilai dari namaBarang 3
            if (sedia >= jumlah) {//jika sedia lebih dari pesan
                kodeJumlah.put(kode, sedia - jumlah);//store nilai
                this.uang += (kodeHarga.get(kode) * jumlah);
                persediaan -= jumlah;//persediaan barang dikurangi
                transaksi++;//transaksi bertambah
                pembelian += kodeHarga.get(kode) * jumlah;
                if (barangKeluar.containsKey(kode)) {//jika namaBarang 4 ada kode 
                    barangKeluar.put(kode, barangKeluar.get(kode) + jumlah);//tambah nilai ke barangKeluar(history of product)
                } else {//jika namaBarang 4 belum ada
                    barangKeluar.put(kode, jumlah);//tambah namaBarang
                }
            } else {//barang ada tapi permintaan terlalu banyak
                System.out.println("Pembelian tidak dapat dilanjutkan\nbarang tidak mencukupi");
            }
          } else {//barang tidak ada di namaBarang
            System.out.println("BARANG TIDAK ADA (Transaksi dibatalkan)");
        }
        
        
    }//membeli barang
    
    long total() {//total pembelian
        long pembelian = this.pembelian;
        return pembelian;
    }
    
    void displayBarang() {//cetak namaBarang
        if (namaBarang.isEmpty()) {//jika namaBarang kosong
            System.out.println("-\t-\t\t-\t-");//cetak tulisan ini
            System.out.println("Barang masih kosong");
        } else {//jika tidak maka tampilkan namaBarang
            for (String kode : namaBarang.keySet()) {
                if (namaBarang.get(kode).length() <= 7) {
                    System.out.println(kode + "\t" + namaBarang.get(kode) + "\t\t" + kodeJumlah.get(kode) + "\t" + kodeHarga.get(kode));
                } else {
                    System.out.println(kode + "\t" + namaBarang.get(kode) + "\t" + kodeJumlah.get(kode) + "\t" + kodeHarga.get(kode));
                }
                
            }
        }
    }
    
    void cekUang() {//cek saldo kasir
        System.out.println("Saldo Kasir sejumlah : " + this.uang);
    }
    
    void cariBarang(String kode) {
        if (namaBarang.containsKey(kode) && kodeJumlah.get(kode) > 0) {
            System.out.println("Barang dengan kode " + kode + " Tersedia");
        } else {
            System.out.println("Barang sedang tidak ada/habis");
        }
    }
    
    void trx() {
        System.out.println("Jumlah transaksi hari ini sejumlah " + transaksi);
        
    }
    
    boolean Verif(String usern, String passw) {
        return (usern.equals(this.user) && passw.equals(password));
    }
    
    void hapusBarang(String kode) {
        if (namaBarang.containsKey(kode)) {
            System.out.println("Remove " + namaBarang.get(kode) + " berhasil");
            namaBarang.remove(kode);
            kodeHarga.remove(kode);
            kodeJumlah.remove(kode);
        } else {
            System.out.println("Barang tidak bisa dihapus karena barang tidak ada");
        }
    }
    
    void start() {
        tambahBarang("Mixagrip", "mxg", 2000, 50);
        tambahBarang("Ponstan", "pon", 2500, 60);
        tambahBarang("Panadol", "pan", 3000, 40);
        tambahBarang("Entrostop", "etr", 1500, 54);
        tambahBarang("Decolgen", "dcg", 3000, 70);
        tambahBarang("Parasetamol", "prm", 3000, 100);
        tambahBarang("Acyclovir", "acv", 17000, 200);
        tambahBarang("Ibuproven", "ibp", 19000, 150);
        tambahBarang("Oksitosin", "oks", 15000, 240);
        tambahBarang("Trihexyphenidyl", "trh", 40000, 100);
    }
    
    void barangKeluar() {
        System.out.println("----------------");
        if (barangKeluar.isEmpty()) {
            System.out.println("Belum ada barang keluar hari ini");
        } else {
            System.out.println("Kode\tNama\t\tJumlah");
            for (String kode : barangKeluar.keySet()) {
                if (namaBarang.get(kode).length() <= 7) {
                    System.out.println(kode + "\t" + namaBarang.get(kode) + "\t\t" + barangKeluar.get(kode));
                } else {
                    System.out.println(kode + "\t" + namaBarang.get(kode) + "\t" + barangKeluar.get(kode));
                }
            }
        }
    }
}
