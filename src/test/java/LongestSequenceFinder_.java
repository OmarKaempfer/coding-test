import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import longestsequence.LongestSequenceFinder;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class LongestSequenceFinder_ {

    @Test
    @Parameters(method = "getCases")
    public void longestSequence(String text, String expectedTuple) {
        assertThat(new LongestSequenceFinder().longestSequence(text).toString()).isEqualTo(expectedTuple);
    }

    private String[][] getCases() {
        return new String[][] {
                {"aabbbcccc", "(c, 4)"},
                {"dghhhmhmx", "(h, 3)"},
                {"dhkkhhKKKt", "(k, 3)"},
                {"aBbBadddadd", "(b, 3)"},
                {"aBbBadddaddaaa", "(a, 3)"},
                {"", "(\0, 0)"}

        };
    }
}
