import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

  public static void main(String[] args) {

    System.out.println("Welcome to the Whisk(e)y Journal!");
    System.out.println("Enter \"q\" or \"quit\" to exit.");
    System.out.println("Enter \"help\" to see available commands.");
    System.out.println();

    JournalSystem journal = new JournalSystem();
    Inventory inventory = new Inventory();

    boolean inventoryModified = false;

    Scanner scanner = new Scanner(System.in);
    System.out.print(">");

    // process keyboard actions
    while(scanner.hasNextLine()) {

			String action = scanner.nextLine();
			
			if (action == null || action.equals("")) {
				System.out.print("\n>");
				continue;
			}

      // misc functionality actions

			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT")) {
        String save = "";

        if (inventoryModified) {
          System.out.print("Would you like to save the current inventory? (y/n): ");
          if (scanner.hasNextLine()) {
            save = scanner.nextLine();
          }

          if (save.equalsIgnoreCase("y") || save.equalsIgnoreCase("yes")) {
            try {
              inventory.writeInventory();
              System.out.println("Saving inventory and exiting.");
            }
            catch (IOException e) {
              e.printStackTrace();
            }
          }
          else {
            System.out.println("Exiting without saving inventory.");
          }
          return;
        }
				else {
          System.out.println("Exiting.");
          return;
        }
      }

      // inventory actions

      else if (action.equalsIgnoreCase("ADDINV")) {
        
        String name = "";
        int number = 0;

        // get name
        System.out.print("Name: ");
        if (scanner.hasNextLine()) {
          name = scanner.nextLine();
        }

        // get number
        System.out.print("Number: ");
        if (scanner.hasNextLine()) {
          number = Integer.parseInt(scanner.nextLine());
        }

        inventoryModified = true;
        inventory.addItem(name, number);
      }

      else if (action.equalsIgnoreCase("DELINV")) {
        String name = "";

        // get name
        System.out.print("Name: ");
        if (scanner.hasNextLine()) {
          name = scanner.nextLine();
        }

        inventoryModified = true;
        inventory.deleteItem(name);
        
      }

      else if (action.equalsIgnoreCase("REMINV")) {
        String name = "";
        int num = 0;

        // get name
        System.out.print("Name: ");
        if (scanner.hasNextLine()) {
          name = scanner.nextLine();
        }

        // get number
        System.out.print("Number: ");
        if (scanner.hasNextLine()) {
          num = Integer.parseInt(scanner.nextLine());
        }

        inventoryModified = true;
        inventory.removeItem(name, num);

      }

      else if (action.equalsIgnoreCase("CLEARINV")) {
        String clear = "";

        System.out.print("Are you sure you want to clear the inventory? (y/n): ");
        if (scanner.hasNextLine()) {
          clear = scanner.nextLine();
        }

        if (clear.equalsIgnoreCase("y") || clear.equalsIgnoreCase("yes")) {
          inventoryModified = true;
          inventory.clearInventory();
        }
      }

      else if (action.equalsIgnoreCase("PRINTINV")) {
        inventory.print(0);
      }

      else if (action.equalsIgnoreCase("PRINTINVCOUNT")) {
        inventory.print(1);
      }

      else if (action.equalsIgnoreCase("WRITEINV")) {
        try {
          inventory.writeInventory();
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }

      // entry actions

      else if (action.equalsIgnoreCase("ADDINFO")) {
        String id = "";

        System.out.print("ID: ");
        if (scanner.hasNextLine()) {
          id = scanner.nextLine();
        }

        journal.addInfo(id);
      }

      else if (action.equalsIgnoreCase("ENTRY")) {

        String name = "";
        String abv = "";
        String category = "";

        // get name
        System.out.print("Name: ");
        if (scanner.hasNextLine()) {
          name = scanner.nextLine();
        }

        // get abv
        System.out.print("Alcohol %: ");
        if (scanner.hasNextLine()) {
          abv = scanner.nextLine();
        }

        // get category
        System.out.print("Category: ");
        if (scanner.hasNextLine()) {
          category = scanner.nextLine();
        }

        try {
          journal.createEntry(name, category, abv);
        }
        catch (InvalidInfoException ex) {
          System.out.println(ex.getMessage());
        }
      }  

      else if (action.equalsIgnoreCase("ENTRIES")) {
        journal.printEntries();

     // TODO: Work on process for adding notes
     // else if (action.equalsIgnoreCase("ADDNOTES")) {
     //   
     //   String id = "";

     //   // search by id or name
     //   System.out.print("Enter ID#: ");
     //   if (scanner.hasNextLine()) {
     //     id = scanner.nextLine();
     //   }
     //   try{
     //     // need to convert to add info
     //     // will pass in strings to be added to each section
     //     // need to get nose, palate, finish in loops
     //     // then add them to string arrays
     //     system.addInfo(Integer.parseInt(id));
     //   }
     //   catch (EntryNotFoundException ex) {
     //     System.err.print(ex);
     //   }
     // }

      // help menu
      }

      else if (action.equalsIgnoreCase("PRINTENTRY")) {
        String id = "";

        System.out.print("ID: ");
        if (scanner.hasNextLine()) {
          id = scanner.nextLine();
        }

        journal.printEntry(id);

      }

      else if (action.equalsIgnoreCase("HELP")) {
        journal.printHelpMenu();
      }

      System.out.print("\n>");
    }

    scanner.close();
  }
  
}
