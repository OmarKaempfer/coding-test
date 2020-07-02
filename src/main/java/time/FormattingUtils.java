package time;

public class FormattingUtils {

    public static String paddedNumber(int number) {
        return number < 10 ? "0" + number : String.valueOf(number);
    }
}
