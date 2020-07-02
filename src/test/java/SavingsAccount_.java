import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import savingsaccount.SavingsAccount;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SavingsAccount_ {

    @Test
    @Parameters(method = "getCases")
    public void balance(double openingSum, double interestRate, double taxFreeLimit, double taxRate, int numMonths, double expected) {
        assertThat(SavingsAccount.balance(openingSum, interestRate, taxFreeLimit, taxRate, numMonths)).isEqualTo(expected);
    }

    private Object[][] getCases() {
        return new Object[][] {
                {10000, 1, 20000, 1, 2, 10201},
                {25000, 2, 20000, 1, 2, 25904.5},
                {19800, 2, 20000, 1, 2, 20597.96},
        };
    }
}
