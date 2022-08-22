package mainclass;

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);//objek dari class Scanner

    System.out.println("Masukkan Jumlah Elemen :");

     int jumlahelemen = input.nextInt(); //jumlah elemen yang dimasukkan

     int[]array = new int[jumlahelemen];//array dengan jumlah elemen yang ditentukan

     System.out.println("Masukkan Semua Elemen :");

     for(int i=0;i <jumlahelemen;i++){

         array[i] =input.nextInt();//memasukkan input elemen pengguna ke elemen array

     }

   

     Arrays.sort(array);//mengurutkan elemen di dalam array

     for(int index:array){

         System.out.println("Telah diurutkan :"+index);/*mencetak elemen yang telah diurutkan*/

     }

    }

 

}


