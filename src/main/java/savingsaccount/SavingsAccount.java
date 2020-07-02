package savingsaccount;

public class SavingsAccount {

    public static double balance(double openingSum, double interestRate, double taxFreeLimit, double taxRate, int numberOfMonths) {

        double balance = openingSum;
        for(int i = 0; i < numberOfMonths; i++) {

            double interestEarnings = interestRate / 100 * balance;
            double taxCost = balance - taxFreeLimit > 0 ? taxRate / 100 * (balance - taxFreeLimit) : 0;

            balance = balance + interestEarnings - taxCost;
        }

        return balance;
    }
}
