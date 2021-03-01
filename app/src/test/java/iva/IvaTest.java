package iva;

import org.junit.Assert;
import org.junit.Test;

public class IvaTest {

    @Test
    public void givenAmount2500WhenIvaIs19ThenReturn475() {
        //prepare - arrange
        Iva iva = new Iva();

        int amount = 2500;
        int rate = 19;
        int expected = 475;

        //act
        int result = iva.compute(amount, rate);

        //asserts
        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenAmount3400WhenIvaIs25ThenReturn850() {
        Iva iva = new Iva();

        int amount = 3400;
        int rate = 25;
        int expected = 850;

        int result = iva.compute(amount, rate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenAmountZeroWhenIvaIs25ThenReturnZero() {
        Iva iva = new Iva();

        int amount = 0;
        int rate = 25;
        int expected = 0;

        int result = iva.compute(amount, rate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenAmount3400WhenIvaIsZeroThenReturnZero() {
        Iva iva = new Iva();

        int amount = 3400;
        int rate = 0;
        int expected = 0;

        int result = iva.compute(amount, rate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenAmountNegativeWhenIvaIs25ThenReturnZero() {
        Iva iva = new Iva();

        int amount = -2400;
        int rate = 25;
        int expected = 0;

        int result = iva.compute(amount, rate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenAmount3400WhenIvaIsNegativeThenReturnZero() {
        Iva iva = new Iva();

        int amount = 3400;
        int rate = -25;
        int expected = 0;

        int result = iva.compute(amount, rate);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void givenAmountMaximumWhenIvaIs25ThenReturnZero() {
        boolean expectionDetected = false;
        try {
            Iva iva = new Iva();
            //for business rule the amount maximum is $250.000
            int amount = Iva.AMOUNT_MAXIMUM + 1;
            int rate = 25;
            iva.compute(amount, rate);
        } catch (IllegalArgumentException ex) {
            expectionDetected = true;
            Assert.assertEquals(Iva.AMOUNT_MAXIMUM_MESSAGE, ex.getMessage());
        }

        Assert.assertTrue(expectionDetected);
    }
}
