import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void main (String [] args) {

        final int PERCENT = 100;
        final int MONTH_IN_A_YEAR = 12;

        //get principal amount
        Scanner input = new Scanner(System.in);
        int principal = 0;
        do {
            System.out.println("Enter a number between 1,000 and 1,000,000.");
            System.out.print("Input principal amount: ");
            principal = input.nextInt();
        }
        while (principal < 1000 || principal > 1_000_000);

        //get the annual rate
        float annualInterest = 0;
        do {
            System.out.println("Enter a number between 1 and 30.");
            System.out.print("Input annual rate: ");
            annualInterest = input.nextFloat();
        }
        while (annualInterest <= 0 || annualInterest > 30);
        float monthlyInterest = annualInterest / (float)PERCENT / MONTH_IN_A_YEAR;

        //get the period in years
        int period = 0;
        do {
            System.out.println("Enter a number between 1 and 30.");
            System.out.print("Input number of years: ");
            period = input.nextInt();
        }
        while (period <= 0 || period > 30); // to make sure input value is valid.
        int numberOfPayments = period * MONTH_IN_A_YEAR;

        double m = principal * ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        String mortgage = NumberFormat.getCurrencyInstance().format(m);
        System.out.println("Mortgage:" + mortgage);
    }
}
