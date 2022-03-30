import java.util.Scanner;

/**
* a simple calculator.
*
* @author Patrick Muradaz
* @version 1-15-2018
*/

public class Calculator { 
    
    /**
    * main method.
    * @param args command line.
    */
  
    public static void main(String[] args) { 
        // declare variables
        double firstInt;
        double secondInt; 
        int option;
        Scanner in = new Scanner(System.in); 
        // prrompt user and gather input
        System.out.println("*Calculator*"); 
        System.out.println("Options:");
        System.out.println("1 Add");
        System.out.println("2 Subtract");
        System.out.println("3 Multiply");
        System.out.println("4 Divide");
        System.out.println("5 ...");
        System.out.println("Choose option:");
        option = in.nextInt();
        // interpret input
        if (option == 1) {               
            System.out.println("Add"); 
        } else if (option == 2) {
            System.out.println("Subtract");
        } else if (option == 3) {
            System.out.println("Multiply");
        } else if (option == 4) {
            System.out.println("Divide");
        } else {
            System.out.println("...");
        }
        // prompt user gather input
        System.out.print("Enter first number: "); 
        firstInt = in.nextDouble();
        System.out.print("Enter second number: ");
        secondInt = in.nextDouble();
        System.out.print("Equals: ");
        // interpret input
        if (option == 1) {                        
            System.out.println((int) firstInt + (int) secondInt);
        } else if (option == 2) {
            System.out.println((int) firstInt - (int) secondInt);
        } else if (option == 3) {
            System.out.printf("%.2f", firstInt * secondInt);
        } else if (option == 4) {
            System.out.printf("%.2f", firstInt / secondInt);
        } else {
            System.out.println("NO CALCULATIONS FOR YOU!!");
        }
    }
}
