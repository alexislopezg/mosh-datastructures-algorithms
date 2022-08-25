package JavaBeginner;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    //Principal -- amount of loan you want to get
    //Annual Interest rate -- Monthly interest rate = (AIR/(12))/100)
    // Period in years
    //Mortgage - total

    public static void main(String[] args) {
        var principal = (int) readNumber("Principal", 1000, 1_000_000);
        var annualInterest = (float) readNumber("Annual Interest Rate", 1, 30);
        var years = (byte) readNumber("Period (Years)", 1, 30);

        var loan = new Loan(principal, annualInterest, years);
        System.out.println("You'll be paying: " + NumberFormat.getCurrencyInstance().format(loan.calculateMortgage()));
        System.out.println("Annual Interest rate: " + NumberFormat.getPercentInstance().format(annualInterest));
        System.out.println("Monthly Interest rate: " + NumberFormat.getPercentInstance().format(loan.getMonthlyInterest()));
        System.out.println("Number of payments: " + loan.getNumberOfPayments());
    }

    private static double readNumber(String prompt, double min, double max) {
        var scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.println(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
}
