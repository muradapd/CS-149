import java.util.Scanner;

/**
* Updated Pay stub calculator.
*
* @author Patrick Muradaz
* @version 2-1-2018
* Acknowledgements: I recieved no unauthorized help on this project. 
* All code is my own.
*/

public class BetterPayStub {
    /**
    * Main method.
    *
    * @param args commandline arguments.
    */
  
    public static void main(String[] args) {
   
        // declare variables
        Scanner input;
        String fullName;
        String jobTitle;
        double annivMonth;
        double annivYear;
        double hourWork;
        double monthsWork; 
        double payRate;
        double vacation;
        double grossPay;
        double retire;
        double fedTax;
        double stateTax;
        double netPay;

        // initialize variables
        input = new Scanner(System.in);
        final double SAVINGS = .03;
        final double FED_TAX = .1525;
        final double STATE_TAX = .0538;
        final double CURRENT_MONTH = 2;
        final double VAC_RATE = .025;
        final double MONTH_PER_YR = 12;
        
        // gather input
        fullName = BetterPayStub.inputLine(input, "Enter your full name: ");
        annivMonth = BetterPayStub.inputNumber(input, "Enter your Anniversary "
                                                + "Month(1-12): ");
        annivYear = BetterPayStub.inputNumber(input, "Enter your Anniversary "
                                                + "Year(2000-2017): ");
        hourWork = BetterPayStub.inputNumber(input, "Enter your hours worked "
                                                + "this pay period(0-80): ");
        jobTitle = BetterPayStub.inputLine(input, "Enter your Job Title: ");
        payRate = BetterPayStub.inputNumber(input, "Enter your pay rate: ");
        
        // calculations
        monthsWork = (2018 - annivYear) * MONTH_PER_YR - annivMonth 
                                                + CURRENT_MONTH; 
        vacation = BetterPayStub.calcPercentage(monthsWork, VAC_RATE);
        grossPay = hourWork * payRate; 
        retire = BetterPayStub.calcPercentage(grossPay, SAVINGS); 
        fedTax = BetterPayStub.calcPercentage(grossPay - retire, FED_TAX); 
        stateTax = BetterPayStub.calcPercentage(grossPay - retire, STATE_TAX);
        netPay = grossPay - retire - stateTax - fedTax; 

        // print output
        System.out.println("====================================="
                                                + "==============");
        System.out.println("Meep Inc.");
        System.out.println("\\(\"^\")/");
        System.out.println("------------");
        BetterPayStub.outputLine("\tName: ", fullName);
        BetterPayStub.outputLine("\tTitle: ", jobTitle);
        BetterPayStub.outputLine("\tAnniversary: ", (int) annivMonth 
                                                + "/" + (int) annivYear);
        BetterPayStub.outputNumber("\t\tMonths Worked: ", monthsWork);
        BetterPayStub.outputNumber("\t\tVacation hours earned: ", vacation);
        System.out.println("------------");
        BetterPayStub.outputNumber("\t\tGross Pay:\t\t$", grossPay);
        BetterPayStub.outputNumber("\t\tRetirement:\t\t$", retire);
        BetterPayStub.outputNumber("\t\tFed tax:\t\t$", fedTax);
        BetterPayStub.outputNumber("\t\tState tax:\t\t$", stateTax);
        System.out.println("------------");
        BetterPayStub.outputNumber("\t\tNet Pay:\t\t$", netPay);
        System.out.println("====================================="
                                                + "==============");
    }
    /**
    * Prompts the user to give a number and gathers input.
    *
    * @param input collects user input.
    * @param prompt asks the user for input.
    * @return a double given by the user.
    */
   
    public static double inputNumber(Scanner input, String prompt) {
        
        // declare variables
        double result;
        
        // prompt user and gather input
        System.out.print(prompt);
        result = input.nextDouble();
        input.nextLine();
        return result; 
    }
    /**
    * Prompts the user to give a string and gathers input.
    *
    * @param input collects user input.
    * @param prompt asks the user for input.
    * @return a string given by the user.
    */
   
    public static String inputLine(Scanner input, String prompt) {
        
        // declare variables
        String result;
        
        // prompt user and gather input
        System.out.print(prompt);
        result = input.nextLine();
        return result;
    }
    /**
    * Performs percentage-based calculations.
    *
    * @param number is the multiplicand.
    * @param percent is the rate which number is multiplied by.
    * @return the result of the calculation.
    */
   
    public static double calcPercentage(double number, double percent) {
        
        // declare variables
        double result;
        
        // calculate percent
        result = number * percent;
        return result;
    }
    /**
    * Prints a header and a string.
    *
    * @param heading describes item.
    * @param item displays user input.
    */
     
    public static void outputLine(String heading, String item) {
        
        // print output
        System.out.print("\t" + heading);
        System.out.println(item);
    }
    /**
    * Prints a header and a number. 
    *
    * @param heading describes num.
    * @param num is the outcome of calculations.
    */
    
    public static void outputNumber(String heading, double num) {
        
        // print output
        System.out.print("\t\t" + heading);
        System.out.printf("%.02f\n", num);
    }
}  
