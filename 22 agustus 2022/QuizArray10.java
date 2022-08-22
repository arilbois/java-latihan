import java.util.Scanner;

public class QuizArray10{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] numbers = {25,14,56,15,36,56,77,18,29,49};
        int pindahKiri;     

        System.out.println("Deret Angka Awal: ");
        for(int num : numbers){
            System.out.print(num + " ");
        }
        System.out.println("");
        System.out.println("Shift ke kiri Sebanyak : ");
        pindahKiri = input.nextInt();

        for(int i = 0;i<pindahKiri;i++){
            int awalArray = numbers[0];
            for(int j = 0;j<numbers.length-1;j++){
                numbers[j] = numbers[j+1];
            }
            numbers[numbers.length-1]=awalArray;
        }

        System.out.println("Hasil yang diinginkan!!!");
        for(int num : numbers){
            System.out.print(num + " ");
        }
        


    }
}