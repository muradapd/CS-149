import java.util.Random;

/**
 * Represents the values of two dice.
 *
 * @author Alvin Chao
 * @author Chris Mayfield
 * @author Nathan Sprague
 * @version 02/09/2018
 */
public class Dice {
    
    /** The first die. */
    private final int first;
    
    /** The second die. */
    private final int second;
    
    /**
     * Constructs a new Dice object with random face values.
     */
    public Dice() {
        Random random = new Random();
        this.first = random.nextInt(6) + 1;
        this.second = random.nextInt(6) + 1;
    }
    
    /**
     * Constructs a new Dice object with the given face values.
     *
     * @param first value of first die
     * @param second value of second die
     */
    public Dice(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * Adds the values of all dice together.
     *
     * @return sum total of all dice values
     */
    public int addValues() {
        return this.first + this.second;
    }
    
    /**
     * Counts how many dice have the given face value.
     *
     * @param face value to look for (1 to 6)
     * @return number of dice that match (0 to 5)
     */
    public int countValues(int face) {
        int count = 0;
        if (this.first == face) {
            count++;
        }
        if (this.second == face) {
            count++;
        }
        return count;
    }
    
    /**
     * Gets the first die.
     * 
     * @return number showing on the first die
     */
    public int getFirst() {
        return this.first;
    }
    
    /**
     * Gets the second die.
     * 
     * @return number showing on the second die
     */
    public int getSecond() {
        return this.second;
    }
    
}
