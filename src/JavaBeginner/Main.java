package JavaBeginner;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    //Principal -- amount of loan you want to get
    //Annual Interest rate -- Monthly interest rate = (AIR/(12))/100)
    // Period in years
    //Mortgage - total

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.print("Insert Principal: ");
        var principal = scanner.nextInt();

        System.out.print("Insert Anual Interest Rate: ");
        var annualInterest = scanner.nextFloat();

        System.out.print("Insert how many years you'll be paying the loan: ");
        var years = scanner.nextByte();

        var loan = new Loan(principal, annualInterest, years);
        System.out.println("You'll be paying: " + NumberFormat.getCurrencyInstance().format(loan.calculateMortgage()));
        System.out.println("Annual Interest rate: " + NumberFormat.getPercentInstance().format(annualInterest));
        System.out.println("Monthly Interest rate: " + NumberFormat.getPercentInstance().format(loan.getMonthlyInterest()));
        System.out.println("Number of payments: " + loan.getNumberOfPayments());
    }
}
