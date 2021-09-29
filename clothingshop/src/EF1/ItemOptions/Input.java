package DIT043PROJECT.clothingshop.src.EF1.ItemOptions;

import java.util.Scanner;

public class Input {
// All methods to process input in our program go here
    public static Scanner input = new Scanner(System.in);
    public static int response;

    public static void askOption() {
        response = input.nextInt();
        input.nextLine();
    }

    /*
    Here we need to add Plan B steps for if the user enters a String, or any other unwanted type
    instead of int i.e. Error handling
    */

}
