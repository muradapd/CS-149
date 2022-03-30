import org.junit.Assert;

import org.junit.Test;

/**
 * Tests DukesTranslate.
 * 
 * @author Patrick Muradaz
 * @version 3-30-2018
 * 
 * Acknowledgments: I have received no unauthorized help on this assignment. 
 */
public class DukesTranslateTest {
    
    /** Delta value to use for assertEquals. */
    public static final double DELTA = 0.01;

    /** Tests full class. */
    @Test public void testDukesTranslate() {
        DukesTranslate myDukesTranslate = new DukesTranslate(); 
    }

    /** Tests analyze. **/
    @Test public void testAnalyze() {
        int[] expect;
        int[] actual;
        expect = new int[] {0, 0, 0};
        actual = DukesTranslate.analyze(" ");
        Assert.assertArrayEquals("testAnalyze \" \".", expect, actual);
    }
   
    /** Tests jmuIt. **/
    @Test public void testJmuIt() {
        String expect;
        String actual;
        expect = "null";
        actual = DukesTranslate.jmuIt(" ");
        Assert.assertEquals("testJmuIt \" \".", expect, actual);
    }
   
    /** Tests separate. **/
    @Test public void testSeparate() {
        String[] expect;
        String[] actual;
        expect = new String[] {"0", "0", "0"};
        actual = DukesTranslate.separate(" ");
        Assert.assertArrayEquals("testSeparate \" \".", expect, actual);
    }
   
    /** Tests Translate. **/
    @Test public void testTranslate() {
        String expect;
        String actual;
        expect = "null";
        actual = DukesTranslate.translate(new String[] {"CS"}, 
            new String[] {"Computer Science"}, "I like CS");
        Assert.assertEquals("testTranslate \" \".", expect, actual);
    }

}
