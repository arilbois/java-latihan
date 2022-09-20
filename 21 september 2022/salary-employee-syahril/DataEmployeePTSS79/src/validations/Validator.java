
package validations;

import java.util.Random;
import java.util.Scanner;

import childs.Employee;
import models.data;
import parent.Person;
import views.App;

public class Validator {

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
        System.out.println("Invalid input.");
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
        System.out.println("Sorry, the input is only alphabetic.");
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
        System.out.println("Sorry, the input is only a number.\nPlease Try Again.");
      }
    } while (!isValid);
    return Integer.parseInt(angka);
  }

  // function boolean validasi angka
  public static boolean validasiAngka(String angka) {
    boolean hasil;
    if (!angka.matches(REGEX)) {
      hasil = false;
    } else {
      hasil = true;
    }
    return hasil;
  }

  public static boolean checkEmployyID(String employeeID) {
    Boolean isFound = false;
    for (Person data : data.allData) {
      if (data instanceof Employee) {
        if (((Employee) data).getEmployeeID().equalsIgnoreCase(employeeID)) {
          isFound = true;
        }
      }
    }
    return isFound;
  }

  public static String makeEmployeeID() {
    Boolean isRepeat = false;
    Random random = new Random(); // instance of random class
    Integer maximal = 99999;
    Integer employeeid = random.nextInt(maximal);
    // do {
    // for (Person data : data.allData) {
    // if (data instanceof Employee) {
    // String idEmployeeInt = ((Employee) data).getEmployeeID().replaceAll(REGEX,
    // "");
    // if (!(employeeid == Integer.parseInt(idEmployeeInt))) {
    // System.out.println("data sama");
    // } else {
    // isRepeat = true;
    // }
    // }
    // }
    // } while (!isRepeat);
    String dataID = String.valueOf(employeeid);
    return dataID;
  }

  public static String validateEmployeeID(String question) {
    boolean isValid = false;
    String idProduct = "";
    do {
      System.out.print(question);
      idProduct = INPUT.nextLine();
      isValid = checkEmployyID(idProduct);
      if (idProduct.equalsIgnoreCase("00")) {
        App.MainMenu();
      } else {
        if (isValid) {
          isValid = true;
        } else {
          System.out.println("Sorry, Employee ID not found!\nPlease input again.\n");
        }
      }
    } while (!isValid);

    return idProduct;

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
