package DIT043PROJECT;

import java.util.Scanner;
public class ReviewOption {

    public static void main(String[] args) {
        final String EOL = System.lineSeparator();

        int optionNumber;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Reviews options menu: " + EOL +
                    "0. Return to Main Menu. " + EOL +
                    "1. Create a review for an Item." + EOL +
                    "2. Print a specific review of an Item." + EOL +
                    "3. Print all reviews of an Item." + EOL +
                    "4. Print mean grade of an Item" + EOL +
                    "5. Print all comments of an Item." + EOL +
                    "6. Print all registered reviews." + EOL +
                    "7. Print item(s) with most reviews." + EOL +
                    "8. Print item(s) with least reviews." + EOL +
                    "9. Print item(s) with best mean review grade." + EOL +
                    "10. Print item(s) with worst mean review grade." + EOL + EOL +
                    "Type an option number: ");



            optionNumber = scanner.nextInt();

            System.out.println(EOL + " Executing option: " + optionNumber);

            switch (optionNumber) {
                case 0:
                    System.out.println("mainMenu()");
                    break;
                case 1:
                    System.out.println("CreateReview().");
                    break;
                case 2:
                    System.out.println("PrintSpecificReviews()");
                    break;
                case 3:
                    System.out.println("PrintAllReviews()");
                    break;
                case 4:
                    System.out.println("PrintMeanGrade()");
                    break;
                case 5:
                    System.out.println("Printing all comments");
                    break;
                case 6:
                    System.out.println("Printing all registered reviews");
                    break;
                case 7:
                    System.out.println("Printing item(s) with most reviews");
                    break;
                case 8:
                    System.out.println("Printing item(s) with least reviews");
                    break;
                case 9:
                    System.out.println("Printing item(s) with best mean review grade");
                    break;
                case 10:
                    System.out.println("Printing item(s) with worst mean review grade");
                    break;
                default:
                    System.out.println("“Invalid menu option. Please type another option”");
                    break;

            }
        } while(optionNumber != 0);


scanner.close();

       }

    }


