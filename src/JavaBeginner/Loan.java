package JavaBeginner;

//Principal -- amount of loan you want to get
//Annual Interest rate -- Monthly interest rate = (AIR/(12))/100)
// Period in years
//Mortgage - total
public class Loan {
    private final double principal;
    private final float interest;
    private final byte years;

    public Loan(double principal, float interest, byte years) {
        this.principal = principal;
        this.interest = interest;
        this.years = years;
    }

    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENT = 100;

    public double calculateMortgage() {
        var numerator = getMonthlyInterest() * Math.pow((1 + getMonthlyInterest()), getNumberOfPayments());
        var denominator = Math.pow((1 + getMonthlyInterest()), getNumberOfPayments()) - 1;
        return (principal * numerator) / denominator;
    }

    public float getMonthlyInterest() {
        return (interest / PERCENT) / MONTHS_IN_YEAR;
    }

    public int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
}
