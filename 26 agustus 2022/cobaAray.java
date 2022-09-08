import java.util.Scanner;
import java.util.*;
public class cobaAray
{
  public static void main (String[]args) throws Exception
  {
    Scanner in = new Scanner (System.in);
    /*Prints out the welcome message at the top of the screen */
    System.out.printf ("%55s", "**WELCOME TO IDIOCY CENTRAL**\n");
    System.out.printf ("%55s", "=================================\n");

    String[] codes =
    {
      "G22", "K13", "I30", "S20"};

      System.out.printf ("%5s%5s%5s%5s\n", codes[0], codes[1], codes[2],
       codes[3]);
      System.out.printf ("Enter one of the above!\n");

      String usercode = in.nextLine ();
      for (int i = 0; i < codes.length; i++)
      {
        if (codes[i].equals (usercode))
        {
          System.out.printf ("What's the matter with you?\n");
        }
        else
        {
          System.out.printf ("Youda man!");
        }
      }

    }
  }