package time;

import static time.FormattingUtils.paddedNumber;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {

        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        normalize();
    }

    public void normalize() {

        hours = hours < 0 ? 0 : hours;
        minutes = minutes < 0 ? 0 : minutes;
        seconds = seconds < 0 ? 0 : seconds;

        minutes += seconds / 60;
        hours += minutes / 60;

        seconds = seconds % 60;
        minutes = minutes % 60;
        hours = hours % 24;
    }

    public Time scale(int seconds) {
        this.seconds += seconds;
        normalize();
        return this;
    }

    public String timeString() {
        return paddedNumber(hours) + ":" + paddedNumber(minutes) + ":" + paddedNumber(seconds);
    }
}
