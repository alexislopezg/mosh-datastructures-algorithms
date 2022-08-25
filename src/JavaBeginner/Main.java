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

        var formattedMortgage = NumberFormat.getCurrencyInstance().format(loan.calculateMortgage());
        printSection("MORTGAGE");
        System.out.println("Monthly Payments: " + formattedMortgage);
        printSection("PAYMENT SCHEDULE");

        for (short paymentsMade = 0; paymentsMade <= loan.getNumberOfPayments(); paymentsMade++){
            double balance = loan.getRemainingBalance(paymentsMade);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private static double readNumber(String prompt, double min, double max) {
        var scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }

    private static void printSection(String section) {
        System.out.println(section.toUpperCase());

        for (int letter = 0; letter < section.length(); letter++) {
            if (section.length() - 1 == letter)
                System.out.println("-");
            else
                System.out.print("-");
        }
    }
}
