import interfaces.Phone;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Phone redmiNote10 = new Xiaomi();

        PhoneUser syahril = new PhoneUser(redmiNote10);

        syahril.turnOnThePhone();

        Scanner input = new Scanner(System.in);
        String aksi;
        boolean isLooping = true;

        do {
            System.out.println("====Aplikasi interface====");
            System.out.println("[1] Nyalakan HP");
            System.out.println("[2] Matikan HP");
            System.out.println("[3] Perbesar Volume");
            System.out.println("[4] Perkecil Volume");
            System.out.println("[0] Keluar");

            System.out.println("Pilih aksi : ");
            aksi = input.next();

            if (aksi.equalsIgnoreCase("1")) {
                syahril.turnOnThePhone();
            } else if (aksi.equalsIgnoreCase("2")) {
                syahril.turnOffThePhone();
            } else if (aksi.equalsIgnoreCase("3")) {
                syahril.makePhoneLouder();
            } else if (aksi.equalsIgnoreCase("4")) {
                syahril.makePhoneSilent();
            } else if (aksi.equalsIgnoreCase("0")) {
                isLooping = false;
            } else {
                System.out.println("Aksi yang anda pilih tidak tersedia");
                System.out.println("Silahkan pilih aksi kembali");
            }
        }while (isLooping);
    }
}
