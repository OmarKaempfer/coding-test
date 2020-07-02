import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import secondlowestfrecuency.SecondLowestFrequencyFinder;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SecondLowestFrequencyFinder_ {

    @Test
    @Parameters(method = "getCases")
    public void secondLowest(int[] array, int expected) {
        assertThat(SecondLowestFrequencyFinder.secondLowest(array)).isEqualTo(expected);
    }

    private Object[][] getCases() {
        return new Object[][] {
                {new int[] {4, 3, 1, 1, 2}, 1},
                {new int[] {4, 3, 1, 1, 2, 2}, 2},
                {new int[] {4, 3, 1, 2}, 2},
                {new int[] {4, 3, 1, 1, 2, 2, 3, 3}, 2},

        };
    }
}
