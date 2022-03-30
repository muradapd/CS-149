import java.util.Scanner;

/**
 * Simple command-line version of the Dice Roulette game.
 *
 * @author Alvin Chao
 * @author Chris Mayfield
 * @author Nathan Sprague
 * @version 02/09/2018
 */
public class Game {
    
    /**
     * The main keeps collecting bets from the user as long as he or she wants
     * to play. Total winnings are tracked and reported after each bet.
     *
     * @param args Command-line arguments. Not used.
     */
    public static void main(String[] args) {
        Scanner scan;
        String keepPlaying;
        double totalWinnings;
        
        keepPlaying = "y";
        totalWinnings = 0;
        scan = new Scanner(System.in);
        
        System.out.println("Welcome to Dice Roulette!");
        
        while (keepPlaying.equals("y")) {
            totalWinnings += oneBet(scan);
            System.out.printf("Your total winnings are $%,.2f\n",
                              totalWinnings);
            System.out.printf("Play again? (y/n) ");
            keepPlaying = scan.nextLine();
        }
        
        System.out.println("Thanks for playing!");
    }
    
    /**
     * Prompt the user for an integer value and return the result.
     *
     * @param prompt the prompt to display
     * @param scan initialized scanner object
     * @return value entered by the user
     */
    public static int readInt(String prompt, Scanner scan) {
        int input;
        System.out.print(prompt);
        input = scan.nextInt();
        scan.nextLine();
        return input;
    }
    
    /**
     * Handle one betting interaction with the user. This method will ask the
     * user what bet they want to place, and how much they want to wager.
     *
     * @param scan initialized scanner object
     * @return amount that the player won or lost on the bet
     */
    public static double oneBet(Scanner scan) {
        int betType;
        String betPrompt;
        double betAmount;
        double payout;
        
        Dice dice = new Dice();
        int number = -1; // This will be ignored unless the bet is SINGLE
        
        betPrompt = "\nWhat is your bet?(0-14)\n"
            + "0 = Under 7\n"
            + "1 = Over 7\n"
            + "Any number 2-12\n"
            + "13 = Odd\n"
            + "14 = Even\n"
            + "Bet: ";
        
        betType = readInt(betPrompt, scan);
        System.out.print("How much do you want to bet? ");
        betAmount = scan.nextDouble();
        scan.nextLine();
        
        System.out.println("You rolled: " + dice.getFirst() + " "
                               + dice.getSecond() + " ");
        
        payout = Roulette.payout(dice, betType, betAmount);
        
        if (payout <= 0) {
            System.out.println("Better luck next time!");
        } else {
            System.out.printf("Congratulations! You won $%,.2f!\n", payout);
        }
        
        return payout;
    }
}
