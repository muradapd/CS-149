import java.util.Scanner; 

/**
* Pay stub calculator.
*
* @author Patrick Muradaz
* @version 1-16-2018
* Acknowledgements: I recieved no unauthorized help on this project. 
* All code is my own.
*/

public class Calander {
  
    /**
    * Main method.
    *
    * @param args commandline arguments.
    */
  
    public static void main(String[] args) {
     
        // declare variables
        int annivMonth;
        int monthsWork;
        int annivYear;
        final int MONTH_PER_YR = 12;
        final int CURRENT_MONTH = 2;
        
        // prompt and gather input
        Scanner in = new Scanner(System.in); 
        System.out.print("Enter your anniversary month(1-12): ");
        annivMonth = in.nextInt();
        System.out.print("Enter your annivarsary year(2000-2018): ");
        annivYear = in.nextInt();
                
        // perform calculations
        monthsWork = ((2018 - annivYear) * MONTH_PER_YR) - annivMonth + CURRENT_MONTH; 
                
        // print output to screen        
        System.out.println("Anniversary: " + annivMonth + "/" + annivYear); 
        System.out.println("Months Worked: " + monthsWork); 
        }
}
