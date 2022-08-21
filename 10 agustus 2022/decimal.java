import java.text.DecimalFormat;
public class decimal {
  public static void main(String[] args) {

    double pay, od;
    
    DecimalFormat f = new DecimalFormat("#,###,###");

    pay = 1000823;
    od = 893;

    System.out.println("wlwlw " + f.format(pay+od));
      }
}