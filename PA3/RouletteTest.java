import org.junit.Assert;

import org.junit.Test;

/**
 * JUnit tests for Dice Roulette.
 * 
 * @author Patrick Muradaz
 * @version 02-23-2018
 */
public class RouletteTest {
    
    /** Delta value to use for assertEquals. */
    public static final double DELTA = 0.01;

    /**
     * Tests the class Roulette.
     */
    @Test
    public void testWhole() {
        new Roulette();
        double expect;
        double actual;
    }
    
    /**
     * Tests default switch statement.
     */
    @Test
    public void testSwitch() {
        double expect;
        double actual;
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.DEFAULT, 1.0);
        Assert.assertEquals("$1.00 DEFAULT (1, 1)", expect, actual, DELTA);
    }
    
    /**
     * Tests the UNDER7 category.
     */
    @Test
    public void testUnderSeven() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 2.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.UNDER7, 1.0);
        Assert.assertEquals("$1.00 UNDER7 (1, 1)", expect, actual, DELTA);
        
        expect = 2.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.UNDER7, 1.0);
        Assert.assertEquals("$1.00 UNDER7 (2, 2)", expect, actual, DELTA);
        
        expect = 2.0;
        actual = Roulette.payout(new Dice(3, 3), Roulette.UNDER7, 1.0);
        Assert.assertEquals("$1.00 UNDER7 (3, 3)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(3, 4), Roulette.UNDER7, 1.0);
        Assert.assertEquals("$1.00 UNDER7 (3, 4)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(5, 4), Roulette.UNDER7, 1.0);
        Assert.assertEquals("$1.00 UNDER7 (5, 4)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(6, 6), Roulette.UNDER7, 1.0);
        Assert.assertEquals("$1.00 UNDER7 (6, 6)", expect, actual, DELTA);
    }
    
    /**
     * Tests the OVER7 category.
     */
    @Test
    public void testOverSeven() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 2.0;
        actual = Roulette.payout(new Dice(4, 4), Roulette.OVER7, 1.0);
        Assert.assertEquals("$1.00 OVER7 (4, 4)", expect, actual, DELTA);
        
        expect = 2.0;
        actual = Roulette.payout(new Dice(4, 5), Roulette.OVER7, 1.0);
        Assert.assertEquals("$1.00 OVER7 (4, 5)", expect, actual, DELTA);
        
        expect = 2.0;
        actual = Roulette.payout(new Dice(6, 6), Roulette.OVER7, 1.0);
        Assert.assertEquals("$1.00 OVER7 (6, 6)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.OVER7, 1.0);
        Assert.assertEquals("$1.00 OVER7 (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.OVER7, 1.0);
        Assert.assertEquals("$1.00 OVER7 (2, 2)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(3, 4), Roulette.OVER7, 1.0);
        Assert.assertEquals("$1.00 OVER7 (3, 4)", expect, actual, DELTA);
    }
    
    /**
     * Tests the TWO category.
     */
    @Test
    public void testTwo() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 30.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.TWO, 1.0);
        Assert.assertEquals("$1.00 TWO (1, 1)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 1), Roulette.TWO, 1.0);
        Assert.assertEquals("$1.00 TWO (2, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.TWO, 1.0);
        Assert.assertEquals("$1.00 TWO (2, 2)", expect, actual, DELTA);
    }

    /**
     * Tests the THREE category.
     */
    @Test
    public void testThree() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 15.0;
        actual = Roulette.payout(new Dice(1, 2), Roulette.THREE, 1.0);
        Assert.assertEquals("$1.00 THREE (1, 2)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.THREE, 1.0);
        Assert.assertEquals("$1.00 THREE (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.THREE, 1.0);
        Assert.assertEquals("$1.00 THREE (2, 2)", expect, actual, DELTA);
    }
    
    /**
     * Tests the FOUR category.
     */
    @Test
    public void testFour() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 10.0;
        actual = Roulette.payout(new Dice(1, 3), Roulette.FOUR, 1.0);
        Assert.assertEquals("$1.00 FOUR (1, 3)", expect, actual, DELTA);
        
        expect = 10.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.FOUR, 1.0);
        Assert.assertEquals("$1.00 FOUR (2, 2)", expect, actual, DELTA);

        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.FOUR, 1.0);
        Assert.assertEquals("$1.00 FOUR (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(3, 2), Roulette.FOUR, 1.0);
        Assert.assertEquals("$1.00 FOUR (3, 2)", expect, actual, DELTA);
    }

    /**
     * Tests the FIVE category.
     */
    @Test
    public void testFive() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 7.0;
        actual = Roulette.payout(new Dice(1, 4), Roulette.FIVE, 1.0);
        Assert.assertEquals("$1.00 FIVE (1, 4)", expect, actual, DELTA);
        
        expect = 7.0;
        actual = Roulette.payout(new Dice(2, 3), Roulette.FIVE, 1.0);
        Assert.assertEquals("$1.00 FIVE (2, 3)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.FIVE, 1.0);
        Assert.assertEquals("$1.00 FIVE (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.FIVE, 1.0);
        Assert.assertEquals("$1.00 FIVE (2, 2)", expect, actual, DELTA);
    }

    /**
     * Tests the SIX category.
     */
    @Test
    public void testSix() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 6.0;
        actual = Roulette.payout(new Dice(1, 5), Roulette.SIX, 1.0);
        Assert.assertEquals("$1.00 SIX (1, 5)", expect, actual, DELTA);
        
        expect = 6.0;
        actual = Roulette.payout(new Dice(2, 4), Roulette.SIX, 1.0);
        Assert.assertEquals("$1.00 SIX (2, 4)", expect, actual, DELTA);
        
        expect = 6.0;
        actual = Roulette.payout(new Dice(3, 3), Roulette.SIX, 1.0);
        Assert.assertEquals("$1.00 SIX (3, 3)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.SIX, 1.0);
        Assert.assertEquals("$1.00 SIX (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.SIX, 1.0);
        Assert.assertEquals("$1.00 SIX (2, 2)", expect, actual, DELTA);
    }

    /**
     * Tests the SEVEN category.
     */
    @Test
    public void testSeven() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 5.0;
        actual = Roulette.payout(new Dice(1, 6), Roulette.SEVEN, 1.0);
        Assert.assertEquals("$1.00 SEVEN (1, 6)", expect, actual, DELTA);
        
        expect = 5.0;
        actual = Roulette.payout(new Dice(2, 5), Roulette.SEVEN, 1.0);
        Assert.assertEquals("$1.00 SEVEN (2, 5)", expect, actual, DELTA);

        expect = 5.0;
        actual = Roulette.payout(new Dice(3, 4), Roulette.SEVEN, 1.0);
        Assert.assertEquals("$1.00 SEVEN (3, 4)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.SEVEN, 1.0);
        Assert.assertEquals("$1.00 SEVEN (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.SEVEN, 1.0);
        Assert.assertEquals("$1.00 SEVEN (2, 2)", expect, actual, DELTA);
    }

    /**
     * Tests the EIGHT category.
     */
    @Test
    public void testEight() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 6.0;
        actual = Roulette.payout(new Dice(2, 6), Roulette.EIGHT, 1.0);
        Assert.assertEquals("$1.00 EIGHT (2, 6)", expect, actual, DELTA);
        
        expect = 6.0;
        actual = Roulette.payout(new Dice(4, 4), Roulette.EIGHT, 1.0);
        Assert.assertEquals("$1.00 EIGHT (4, 4)", expect, actual, DELTA);

        expect = 6.0;
        actual = Roulette.payout(new Dice(3, 5), Roulette.EIGHT, 1.0);
        Assert.assertEquals("$1.00 EIGHT (3, 5)", expect, actual, DELTA);

        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.EIGHT, 1.0);
        Assert.assertEquals("$1.00 EIGHT (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.EIGHT, 1.0);
        Assert.assertEquals("$1.00 EIGHT (2, 2)", expect, actual, DELTA);
    }

    /**
     * Tests the NINE category.
     */
    @Test
    public void testNine() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 7.0;
        actual = Roulette.payout(new Dice(3, 6), Roulette.NINE, 1.0);
        Assert.assertEquals("$1.00 NINE (1, 8)", expect, actual, DELTA);
        
        expect = 7.0;
        actual = Roulette.payout(new Dice(5, 4), Roulette.NINE, 1.0);
        Assert.assertEquals("$1.00 NINE (7, 2)", expect, actual, DELTA);

        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.NINE, 1.0);
        Assert.assertEquals("$1.00 NINE (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.NINE, 1.0);
        Assert.assertEquals("$1.00 NINE (2, 2)", expect, actual, DELTA);
    }

    /**
     * Tests the TEN category.
     */
    @Test
    public void testTen() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 10.0;
        actual = Roulette.payout(new Dice(5, 5), Roulette.TEN, 1.0);
        Assert.assertEquals("$1.00 TEN (5, 5)", expect, actual, DELTA);
        
        expect = 10.0;
        actual = Roulette.payout(new Dice(6, 4), Roulette.TEN, 1.0);
        Assert.assertEquals("$1.00 TEN (6, 4)", expect, actual, DELTA);

        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.TEN, 1.0);
        Assert.assertEquals("$1.00 TEN (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.TEN, 1.0);
        Assert.assertEquals("$1.00 TEN (2, 2)", expect, actual, DELTA);
    }
    
    /**
     * Tests the ELEVEN category.
     */
    @Test
    public void testEleven() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 15.0;
        actual = Roulette.payout(new Dice(5, 6), Roulette.ELEVEN, 1.0);
        Assert.assertEquals("$1.00 ELEVEN (5, 6)", expect, actual, DELTA);
        
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.ELEVEN, 1.0);
        Assert.assertEquals("$1.00 ELEVEN (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.ELEVEN, 1.0);
        Assert.assertEquals("$1.00 ELEVEN (2, 2)", expect, actual, DELTA);
    }
    
    /**
     * Tests the TWELVE category.
     */
    @Test
    public void testTwelve() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 30.0;
        actual = Roulette.payout(new Dice(6, 6), Roulette.TWELVE, 1.0);
        Assert.assertEquals("$1.00 ELEVEN (6, 6)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.TWELVE, 1.0);
        Assert.assertEquals("$1.00 ELEVEN (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.TWELVE, 1.0);
        Assert.assertEquals("$1.00 ELEVEN (2, 2)", expect, actual, DELTA);
    }
    
    /**
     * Tests the ELSE category.
     */
    @Test
    public void testElse() {
        double expect;
        double actual;
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.DEFAULT, 1.0);
        Assert.assertEquals("$1.00 DEFAULT (1, 1)", expect, actual, DELTA);
    }
    
    /**
     * Tests the ODD category.
     */
    @Test
    public void testOdd() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 2.0;
        actual = Roulette.payout(new Dice(1, 2), Roulette.ODD, 1.0);
        Assert.assertEquals("$1.00 ODD (1, 2)", expect, actual, DELTA);
        
        expect = 2.0;
        actual = Roulette.payout(new Dice(2, 3), Roulette.ODD, 1.0);
        Assert.assertEquals("$1.00 ODD (2, 3)", expect, actual, DELTA);
        
        expect = 2.0;
        actual = Roulette.payout(new Dice(3, 4), Roulette.ODD, 1.0);
        Assert.assertEquals("$1.00 ODD (3, 4)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.ODD, 1.0);
        Assert.assertEquals("$1.00 ODD (1, 1)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(3, 3), Roulette.ODD, 1.0);
        Assert.assertEquals("$1.00 ODD (3, 3)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(6, 6), Roulette.ODD, 1.0);
        Assert.assertEquals("$1.00 ODD (6, 6)", expect, actual, DELTA);
    }

    /**
     * Tests the EVEN category.
     */
    @Test
    public void testEven() {
        double expect;
        double actual;
        
        // dice that match the category
        expect = 2.0;
        actual = Roulette.payout(new Dice(1, 1), Roulette.EVEN, 1.0);
        Assert.assertEquals("$1.00 EVEN (1, 1)", expect, actual, DELTA);
        
        expect = 2.0;
        actual = Roulette.payout(new Dice(2, 2), Roulette.EVEN, 1.0);
        Assert.assertEquals("$1.00 EVEN (2, 2)", expect, actual, DELTA);
        
        expect = 2.0;
        actual = Roulette.payout(new Dice(4, 2), Roulette.EVEN, 1.0);
        Assert.assertEquals("$1.00 EVEN (4, 2)", expect, actual, DELTA);
        
        // dice that don't match the category
        expect = 0.0;
        actual = Roulette.payout(new Dice(3, 4), Roulette.EVEN, 1.0);
        Assert.assertEquals("$1.00 EVEN (3, 4)", expect, actual, DELTA);
        
        expect = 0.0;
        actual = Roulette.payout(new Dice(1, 4), Roulette.EVEN, 1.0);
        Assert.assertEquals("$1.00 EVEN (1, 4)", expect, actual, DELTA);

        expect = 0.0;
        actual = Roulette.payout(new Dice(3, 6), Roulette.EVEN, 1.0);
        Assert.assertEquals("$1.00 EVEN (3, 6)", expect, actual, DELTA);

    }

    
}
