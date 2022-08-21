import java.util.Scanner;
public class quiz1{
public static void main( String [] args){

	String name;
	int moneyspent;
	double average;
	int total;
	
	Scanner input = new Scanner(System.in);
	
	System.out.println("Calculate Your Money");
	
	System.out.println("Hey, What is your name?");
	name = input.next();
	
	System.out.println("How much money did you spend at the club on Monday?");
	moneyspent = input.nextInt();
	total = moneyspent;
	
	System.out.println("How much money did you spend at the club on Tuesday?");
	moneyspent = input.nextInt();
	total = moneyspent + total;
	
	System.out.println("How much money did you spend at the club on Wednesday?");
	moneyspent = input.nextInt();
	total = moneyspent + total;
	
	System.out.println("How much money did you spend at the club on Thursday?");
	moneyspent = input.nextInt();
	total = moneyspent + total;
	
	System.out.println("How much money did you spend at the club on Friday?");
	moneyspent = input.nextInt();
	total = moneyspent + total;
	
	System.out.println("How much money did you spend at the club on Saturday?");
	moneyspent = input.nextInt();
	total = moneyspent + total;
	
	System.out.println("How much money did you spend at the club on Sunday?");
	moneyspent = input.nextInt();
	total = moneyspent + total;
	
	System.out.println("Hi " + name + ",");
	System.out.println("Your total expenditure at the club this week is $" + total);
	average = (double)total/7;
	System.out.println("with an average daily expenditure of $" + average);
}
}