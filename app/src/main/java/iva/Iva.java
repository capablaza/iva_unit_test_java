package iva;

public class Iva {
    public static final int AMOUNT_MAXIMUM = 250000;
    public static final String AMOUNT_MAXIMUM_MESSAGE = "the amount maximum is " + AMOUNT_MAXIMUM;

    public int compute(int amount, int rate) {

        if (amount > AMOUNT_MAXIMUM) throw new IllegalArgumentException(AMOUNT_MAXIMUM_MESSAGE);

        if (amount < 0 || rate < 0) return 0;
        return (amount * rate) / 100;
    }
}
