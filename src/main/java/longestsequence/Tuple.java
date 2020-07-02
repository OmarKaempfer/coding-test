package longestsequence;

public class Tuple<F, S> {

    private F firstValue;
    private S secondValue;

    public Tuple(F firstValue, S secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public String toString() {
        return "(" + firstValue + ", " + secondValue + ')';
    }
}
