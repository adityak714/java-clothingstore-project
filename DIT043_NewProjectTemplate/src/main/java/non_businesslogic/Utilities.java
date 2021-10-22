package non_businesslogic;
import java.util.Scanner;


public class Utilities {
    
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputInt(String message){
        //takes user input as an int.
        System.out.print(message);
        int valueInt = scanner.nextInt();
        scanner.nextLine(); 
        return valueInt;
    }

    public static String inputString(String message){
        //takes user input as a string.
        System.out.print(message);
        return scanner.nextLine();
    }

    public static double inputDouble(String message){
        //takes user input as a double.
        System.out.print(message);
        double valueDouble = scanner.nextDouble();
        scanner.nextLine();
        return valueDouble;
    }

    public static char inputChar(String message){
        //takes user input as a char.
        System.out.println(message);
        char valueChar = scanner.next().charAt(0);
        scanner.nextLine();
        return valueChar;

    }

   

}
