import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import time.Time;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class Time_ {

    @Test
    @Parameters(method = "timeStringCases")
    public void timeString(int hours, int minutes, int seconds, String expected) {
        assertThat(new Time(hours, minutes, seconds).timeString()).isEqualTo(expected);
    }

    private Object[][] timeStringCases() {
        return new Object[][] {
                {0, 0, 0, "00:00:00"},
                {23, 30, 20, "23:30:20"},
                {1, 100, 0, "02:40:00"},
                {23, 59, 60, "00:00:00"},
                {25, 125, 125, "03:07:05"},
                {-10, -10, -10, "00:00:00"},
                {-10, 60, 40, "01:00:40"}
        };
    }

    @Test
    @Parameters(method = "scaleCases")
    public void scale(int hours, int minutes, int seconds, int scale, String expected) {
        assertThat(new Time(hours, minutes, seconds).scale(scale).timeString()).isEqualTo(expected);
    }

    private Object[][] scaleCases() {
        return new Object[][] {
                {0, 0, 0, 10, "00:00:10"},
                {1, 30, 20, 0, "01:30:20"},
                {1, 100, 0, 60, "02:41:00"},
                {23, 59, 60, 125, "00:02:05"},
                {25, 125, 125, -8, "03:07:00"}
        };
    }
}
