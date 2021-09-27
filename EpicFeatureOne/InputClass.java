package com.ClothStoreProject.EpicFeatureOne;

import java.util.Scanner;

public class InputClass {
// All methods to process input in our program go here

    public static int response;

    public static void askOption() {
        Scanner input = new Scanner(System.in);
        response = input.nextInt();
        input.nextLine();
    }

    /*
    Here we need to add Plan B steps for if the user enters a String, or any other unwanted type
    instead of int i.e Error handling
    */

}
