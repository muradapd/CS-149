import java.util.Scanner; 

/**
* Pay stub calculator.
*
* @author Patrick Muradaz
* @version 1-16-2018
* Acknowledgements: I recieved no unauthorized help on this project. 
* All code is my own.
*/

public class PayStub {
  
    /**
    * Main method.
    *
    * @param args commandline arguments.
    */
  
    public static void main(String[] args) {
     
        // declare variables
        String fullName;
        String jobTitle; 
        int annivMonth;
        int annivYear;
        int hourWork;
        int monthsWork; 
        double payRate;
        double grossPay;
        double retire;
        double tax;
        double netPay;
        double vacation;
        final double VAC_RATE = .025;
        final double SAVINGS = .03;
        final double TAX = .2063;
        final int MONTH_PER_YR = 12;
        final int CURRENT_MONTH = 2;
        
        // prompt and gather input
        Scanner in = new Scanner(System.in); 
        System.out.print("Enter your full name: "); 
        fullName = in.nextLine(); 
        System.out.print("Enter your job title: ");
        jobTitle = in.nextLine();
        System.out.print("Enter your anniversary month(1-12): ");
        annivMonth = in.nextInt();
        System.out.print("Enter your annivarsary year(2000-2017): ");
        annivYear = in.nextInt();
        System.out.print("Enter your hours worked this pay period(0-80): ");
        hourWork = in.nextInt();
        System.out.print("Enter your pay rate: ");
        payRate = in.nextDouble();
        
        // perform calculations
        monthsWork = ((2018 - annivYear) * MONTH_PER_YR) - annivMonth + CURRENT_MONTH; 
        vacation = monthsWork * VAC_RATE; 
        grossPay = hourWork * payRate; 
        retire = grossPay * SAVINGS; 
        tax = (grossPay - retire) * TAX; 
        netPay = grossPay - retire - tax; 
        
        // print output to screen        
        System.out.print("======================="
                             + "============================\n"); 
        System.out.println("Meep Inc.\n\\(\"^\")/"); 
        System.out.println("------------\nName: " + fullName); 
        System.out.println("Title: " + jobTitle); 
        System.out.println("Anniversary: " + annivMonth + "/" + annivYear); 
        System.out.println("Months Worked: " + monthsWork); 
        System.out.printf("Vacation Hours Earned: %.1f\n", vacation); 
        System.out.printf("------------\nGross Pay:     $ %.2f\n", grossPay); 
        System.out.printf("Retirement:    $ %.2f\n", retire); 
        System.out.printf("Tax:           $ %.2f\n", tax); 
        System.out.printf("------------\nNet Pay:       $ %.2f\n", netPay); 
        System.out.print("====================" 
                             + "===============================");
    }
}
