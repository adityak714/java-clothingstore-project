package ItemOptions;

public class Menu {

    public static void printMenu(){

        int input;

       
        
        do {  
            
        
            System.out.println("\nItem options menu: "
            + "\n0. Return to Main Menu. "
            + "\n1. Create an Item. "
            + "\n2. Remove an Item. "
            + "\n3. Print all registered Items. "
            + "\n4. Buy an Item. "
            + "\n5. Update an item's name. "
            + "\n6. Update an item's price. ");

            
            input = UserInput.inputInt("\nType an option number: ");
    
          
            
            switch(input) {
                case 0:
                   StartMenu.putInOption();
                    break;
                case 1:
                    CreateItem.Create();
                    break;
                case 2:
                    System.out.print("RemoveItem();");
                    break;
                case 3:
                    System.out.print("PrintItem();");
                    break;
                case 4:
                    System.out.print("BuyItem();");
                    break;
                case 5:
                    System.out.print("UpdateItemName();");
                    break;
                case 6:
                    System.out.print("UpdateItemPrice();");
                    break;
                default:
                    System.out.print("\n“Invalid menu option. Please type another option”");
                    printMenu();
                
             }
          } while(input < 0 || input > 6);


       
    }
    
}
