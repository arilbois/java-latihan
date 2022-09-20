package validations;

import java.util.Scanner;

public class Validations {

  public static String inputTypeAlphabetLimit(String question, String[] listWord) {
    boolean isRepeat = true, isFound;
    String result = "";
    do {
      isFound = false;
      result = inputTypeAlphabet(question);
      for (String word : listWord) {
        if (result.equalsIgnoreCase(word)) {
          isFound = true;
          isRepeat = false;
        }
      }
      if (!isFound) {
        System.out.println("Input tidak sesuai.");
      }
    } while (isRepeat);
    return result;
  }

  // Fungtion Hanya Text yang bisa di input
  public static String inputTypeAlphabet(String question) {
    boolean isValid = false;
    String result;
    do {
      System.out.println(question);
      result = INPUT.nextLine();
      isValid = result.matches("[a-zA-Z\\s']+");
      if (!isValid) {
        System.out.println("Maaf, inputan berua alphabet saja.");
      }
    } while (!isValid);
    return result;
  }

  public static int inputTypeNumber(String question) {
    boolean isValid = false;
    String angka;
    do {
      System.out.println(question);
      angka = INPUT.nextLine();
      isValid = validasiAngka(angka);
      if (!isValid) {
        System.out.println("Maaf input hanya berupa angka saja.\nSilahkan input kembali.");
      }
    } while (!isValid);
    return Integer.parseInt(angka);
  }

  // function boolean validasi angka
  public static boolean validasiAngka(String angka) {
    boolean hasil;
    if (!angka.matches(REGEX)) {
      return hasil = false;
    } else {
      return hasil = true;
    }
  }

  public static int inputTypeNumberLimit(String question, int min, int max) {
    boolean isValid = false;
    int angka = 0;
    do {
      angka = inputTypeNumber(question);
      if (!(angka >= min && angka <= max)) {
        System.out.println(
            "Maaf, input angka mulai dari " + min + " sampai " + max + "\nSilahkan input kembali.");
      } else {
        isValid = true;
      }
    } while (!isValid);
    return angka;
  }

  public static final Scanner INPUT = new Scanner(System.in);
  public static final String REGEX = "[0-9]+";

}
