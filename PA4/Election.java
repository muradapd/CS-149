import java.util.Random;
import java.util.Arrays;

/**
 * Election results manipulator and calculator.
 *
 * @author Patrick Muradaz
 * @version 03-16-2018
 * Ackgnowledgements: I have recieved no unauthorized help on this assignment.
 * All code is my own.
 */
public class Election {

    /**
     * Counts votes and returns the winner.
     *
     * @param votes is an array of the number of votes cast per candidate.
     * @return the winner of the election.
     */
    public static int countPopular(int[] votes) {
        int num = 0;
        int result = 0;
        int count = 0;
        
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > num) {
                num = votes[i];
            }
            if (votes[i] == num) {
                result = i;
            }
        }
        
        for (int vote : votes) {
            if (vote < 0) {
                result = -1;
            }
        }
        
        for (int vote : votes) { 
            if (vote == num) {
                count++;
            }
        }
        if (count >= 2) {
            result = -1;
        }
        
        return result;
    }
    
    /**
     * Manipulates votes, passes new array to countPopular, 
     * and returns the winner.
     *
     * @param votes is an array of the number of votes cast per candidate.
     * @return the winner of the election.
     */
    public static int countOdd(int[] votes) {
        int[] newVotes = new int[votes.length];
        
        newVotes = Arrays.copyOf(votes, votes.length);
        
        for (int i = 0; i < newVotes.length; i++) {
            if (newVotes[i] % 10 != 5 && newVotes[i] % 2 != 0) {
                newVotes[i] *= 2;
            }
        }
        return countPopular(newVotes);
    }
    
    /**
     * Manipulates votes, passes new array to countPopular, 
     * and returns the winner.
     *
     * @param votes is an array of the number of votes cast per candidate.
     * @return the winner of the election.
     */
    public static int countEvenOdder(int[] votes) {
        int result;
        int[] newVotes = new int[votes.length];
        
        newVotes = Arrays.copyOf(votes, votes.length);
        
        for (int i = 0; i < newVotes.length; i++) {
            if (newVotes[i] % 10 != 4 && newVotes[i] % 2 == 0) {
                newVotes[i] *= 2;
            } else if (newVotes[i] % 10 == 4) {
                newVotes[i] -= 10;
            }
        }
        return countPopular(newVotes);
    }
    
    /**
     * Generates a pseudorandom array of votes per candidate.
     *
     * @param candidates is the number of candidates in the array.
     * @param voters is the number of voters participating.
     * @param seed is the seed for the random number generator.
     * @return a new pseudorandomly generated array of votes per candidate.
    */
    public static int[] randomCounts(int candidates, int voters, long seed) {
        int[] votes = new int[0];
        Random random = new Random(seed);
        int voters1 = voters;
        double candidVotes = 0;
        
        if (candidates < 0 || voters < 0) {
            votes = null;
        } else {
            votes = new int[candidates];
        }
        
        for (int i = 0; i < candidates; i++) {
            if (i < candidates - 1) {
                double percentage = random.nextDouble();
                candidVotes = percentage * voters1;
                candidVotes = Math.round(candidVotes);
                votes[i] = (int) candidVotes;
                voters1 -= candidVotes;
            } else {
                votes[i] = voters1;
            }
        }        
        return votes;
    }
}
