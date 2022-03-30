/**
 * PA3: Dice Roulette (Decisions and Logic).
 * 
 * @author Patrick Muradaz
 * @version 2-23-2018
 */
public class Roulette {
    
    public static final int UNDER7 = 0;
    public static final int OVER7 = 1;
    public static final int ODD = 13;
    public static final int EVEN = 14;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int ELEVEN = 11;
    public static final int TWELVE = 12;
    public static final int DEFAULT = 15;
    
    public static final int PAY_UNDER7 = 2;
    public static final int PAY_OVER7 = 2;
    public static final int PAY_ODD = 2;
    public static final int PAY_EVEN = 2;
    public static final int PAY_TWO = 30;
    public static final int PAY_THREE = 15;
    public static final int PAY_FOUR = 10;
    public static final int PAY_FIVE = 7;
    public static final int PAY_SIX = 6;
    public static final int PAY_SEVEN = 5;
    public static final int PAY_EIGHT = 6;
    public static final int PAY_NINE = 7;
    public static final int PAY_TEN = 10;
    public static final int PAY_ELEVEN = 15;
    public static final int PAY_TWELVE = 30;

    
    /**
     * Passes variables to other methods 
     * in order to calculate winnings.
     *
     * @param dice current values of the dice
     * @param category selected by the player
     * @param amount how much money was bet
     * @return how much money should be paid
     */
    public static double payout(Dice dice, int category, double amount) {
        double payment;
        
        switch (category) {
            case 0:
                payment = underSeven(dice, amount);
                break;
            case 1:
                payment = overSeven(dice, amount);
                break;
            case 2: case 3: case 4: case 5: case 6: case 7: 
            case 8: case 9: case 10: case 11: case 12:
                payment = twoToTwelve(dice, category, amount);
                break;
            case 13:
                payment = odd(dice, amount);
                break;
            case 14:
                payment = even(dice, amount);
                break;
            default:
                payment = 0.0;
                break;
        }
        return payment;
    }
    
    /**
     * Calculates winnings if the Bet Type was Even.
     *
     * @param dice current values of the dice
     * @param amount how much money was bet
     * @return how much money should be paid
     */
    public static double even(Dice dice, double amount) {
        double payment;
        double total;
        
        total = dice.getFirst() + dice.getSecond();
        if ((total % 2) == 0) {
            payment = PAY_EVEN * amount;
        } else {
            payment = 0;
        }       
        return payment;
    }
    
    /**
     * Calculates winnings if the Bet Type was Odd.
     *
     * @param dice current values of the dice
     * @param amount how much money was bet
     * @return how much money should be paid
     */
    public static double odd(Dice dice, double amount) {
        double payment;
        double total;
        
        total = dice.getFirst() + dice.getSecond();
        if ((total % 2) != 0) {
            payment = PAY_EVEN * amount;
        } else {
            payment = 0;
        }       
        return payment;
    }
    
    /**
     * Calculates winnings if the Bet Type was Under7.
     *
     * @param dice current values of the dice
     * @param amount how much money was bet
     * @return how much money should be paid
     */
    public static double underSeven(Dice dice, double amount) {
        double payment;
        double total;
        
        total = dice.getFirst() + dice.getSecond();
        if (total < 7) {
            payment = PAY_UNDER7 * amount;
        } else {
            payment = 0;
        }
        return payment;
    }
    
    /**
     * Calculates winnings if the Bet Type was Over7.
     *
     * @param dice current values of the dice
     * @param amount how much money was bet
     * @return how much money should be paid
     */
    public static double overSeven(Dice dice, double amount) {
        double payment;
        double total;
        
        total = dice.getFirst() + dice.getSecond();
        if (total > 7) {
            payment = PAY_OVER7 * amount;
        } else {
            payment = 0;
        }
        return payment;
    }
    
    /**
     * Calculates winnings if the Bet Type was
     * two through twelve.
     *
     * @param dice current values of the dice
     * @param category selected by the player
     * @param amount how much money was bet
     * @return how much money should be paid
     */
    public static double twoToTwelve(Dice dice, int category, double amount) {
        double payment;
        double total;
    
        total = dice.getFirst() + dice.getSecond();
        if (total == category && category == TWO) {
            payment = PAY_TWO * amount;
        } else if (total == category && category == THREE) {
            payment = PAY_THREE * amount;
        } else if (total == category && category == FOUR) {
            payment = PAY_FOUR * amount;
        } else if (total == category && category == FIVE) {
            payment = PAY_FIVE * amount;
        } else if (total == category && category == SIX) {
            payment = PAY_SIX * amount;
        } else if (total == category && category == SEVEN) {
            payment = PAY_SEVEN * amount;
        } else if (total == category && category == EIGHT) {
            payment = PAY_EIGHT * amount;
        } else if (total == category && category == NINE) {
            payment = PAY_NINE * amount;
        } else if (total == category && category == TEN) {
            payment = PAY_TEN * amount;
        } else if (total == category && category == ELEVEN) {
            payment = PAY_ELEVEN * amount;
        } else if (total == category && category == TWELVE) {
            payment = PAY_TWELVE * amount;
        } else {
            payment = 0.0;
        }    
        return payment;
    }
}
