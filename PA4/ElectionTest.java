import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit tests for Election.
 * 
 * @author Patrick Muradaz
 * @version 03-02-2018
 * Acknowledgements: I recieved no unauthorized help on this assignment.
 */
public class ElectionTest {

    /** Delta value to use for assertEquals. */
    public static final double DELTA = 0.01;

    /** Tests full class. */
    @Test
    public void testWhole() {
        Election myElection = new Election();
    }   
    
    /** Tests the countPopular method. */
    @Test 
    public void testCountPopular() {
        double expect;
        double actual;
        
        expect = 0;
        actual = Election.countPopular(new int[]{100, 20, 30, 40, 50});
        Assert.assertEquals("countPopular 100, 20, 30, 40, 50)", expect, 
                                actual, DELTA);
        
        expect = 2;
        actual = Election.countPopular(new int[]{10, 20, 300, 40, 50});
        Assert.assertEquals("countPopular 10, 20, 300, 40, 50)", expect, 
                                actual, DELTA);
   
        expect = 4;
        actual = Election.countPopular(new int[]{100, 20, 30, 40, 500});
        Assert.assertEquals("countPopular 10, 20, 30, 40, 500)", expect, 
                                actual, DELTA);
    }
    
    /** Tests the countOdd method. */
    @Test 
    public void testCountOdd() {
        double expect;
        double actual;
        
        expect = 0;
        actual = Election.countOdd(new int[]{7, 4, 6, 8, 10});
        Assert.assertEquals("countOdd 7, 4, 6, 8, 10)", expect, actual, DELTA);
        
        expect = 2;
        actual = Election.countOdd(new int[]{15, 5, 20, 14, 0});
        Assert.assertEquals("countOdd 15, 5, 20, 14, 0)", expect, actual, 
                                DELTA);
   
        expect = 4;
        actual = Election.countOdd(new int[]{3, 10, 8, 5, 11});
        Assert.assertEquals("countOdd 3, 10, 8, 5, 11)", expect, actual, DELTA);
    }
   
    /** Tests the countEvenOdder method. */
    @Test 
    public void testCountEvenOdder() {
        double expect;
        double actual;
        
        expect = 0;
        actual = Election.countEvenOdder(new int[]{24, 13, 14, 11, 9});
        Assert.assertEquals("countEvenOdder 24, 13, 14, 11, 9)", expect, 
                                actual, DELTA);
        
        expect = 2;
        actual = Election.countEvenOdder(new int[]{3, 14, 10, 9, 0});
        Assert.assertEquals("countEvenOdder 3, 14, 10, 9, 0)", expect, 
                                actual, DELTA);
   
        expect = 4;
        actual = Election.countEvenOdder(new int[]{3, 11, 14, 8, 10});
        Assert.assertEquals("countEvenOdder 3, 11, 14, 8, 10)", expect, 
                                actual, DELTA);
    }
    
    /** Tests the randomCounts method. */
    @Test 
    public void testRandomCounts() {
        int[] actualArray;
        int[] expectArray;
        int[] nums = new int[]{73, 6, 21};
        
        expectArray = nums;
        actualArray = Election.randomCounts(3, 100, 0);
        Assert.assertArrayEquals("randomCounts 3, 100, 0)", 
                                    expectArray, actualArray);
    }
    
    /** Tests the methods for nagatives in arrays. */
    @Test 
    public void testNegative() {
        double expect;
        double actual;
        int[] actualArray;
        int[] expectArray;
        
        expect = -1;
        actual = Election.countPopular(new int[]{-1, -2, -3});
        Assert.assertEquals("countPopular -1, -2, -3)", expect, actual, DELTA);
        
        expect = -1;
        actual = Election.countOdd(new int[]{-1, -2, -3});
        Assert.assertEquals("countOdd -1, -2, -3)", expect, actual, DELTA);
   
        expect = -1;
        actual = Election.countEvenOdder(new int[]{-1, -2, -3});
        Assert.assertEquals("countEvenOdder -1, -2, -3)", 
                            expect, actual, DELTA);
    
        expectArray = null;
        actualArray = Election.randomCounts(-5, 0, 0);
        Assert.assertArrayEquals("randomCounts -5, 0, 0)", 
                                    expectArray, actualArray);
                                    
        expectArray = null;
        actualArray = Election.randomCounts(0, -5, 0);
        Assert.assertArrayEquals("randomCounts 0, -5, 0)", 
                                    expectArray, actualArray);
    }

    /** Tests the methods for ties in voting. */
    @Test 
    public void testTiesInvalid() {
        double expect;
        double actual;
        
        expect = -1;
        actual = Election.countPopular(new int[]{0, 0, 0});
        Assert.assertEquals("countPopular 0, 0, 0)", expect, actual, DELTA);
        
        expect = -1;
        actual = Election.countOdd(new int[]{0, 0, 0});
        Assert.assertEquals("countOdd 0, 0, 0)", expect, actual, DELTA);
   
        expect = -1;
        actual = Election.countEvenOdder(new int[]{0, 0, 0});
        Assert.assertEquals("countEvenOdder 0, 0, 0)", expect, actual, DELTA);
    }
}
