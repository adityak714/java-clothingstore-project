package EF1;

import java.util.Scanner;

public class Input {
// All methods to process input in our program go here

    public static int response;

    public static void askOption() {
        Scanner input = new Scanner(System.in);
        response = input.nextInt();
        input.nextLine();
        input.close();
    }

    /*
    Here we need to add Plan B steps for if the user enters a String, or any other unwanted type
    instead of int i.e Error handling
    */

}
