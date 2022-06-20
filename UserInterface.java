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

    try (Scanner scanner = new Scanner(System.in)) {
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

        else if (action.equalsIgnoreCase("SEARCHINV")) {
          String name = "";

          System.out.print("Name: ");
          if (scanner.hasNextLine()) {
            name = scanner.nextLine();
          }

          inventory.searchInventory(name);
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

          try {
            journal.addInfo(id);
          }
          catch (EntryNotFoundException e) {
            System.out.println(e.getMessage());
          }
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
        }

        else if (action.equalsIgnoreCase("PRINTENTRY")) {
          String id = "";

          System.out.print("ID: ");
          if (scanner.hasNextLine()) {
            id = scanner.nextLine();
          }

          journal.printEntry(id);

        }

        else if (action.equalsIgnoreCase("SEARCHENTRYNAME")) {
          String name = "";

          System.out.print("Name: ");
          if (scanner.hasNextLine()) {
            name = scanner.nextLine();
          }

          journal.searchEntryName(name);

        }

        else if (action.equalsIgnoreCase("HELP")) {
          System.out.println("\nCOMMANDS:\n");
          System.out.println("addinfo           -  add info to an existing entry");
          System.out.println("addinv            -  add item to invenory");
          System.out.println("addnotes          -  add notes to existing entry");
          System.out.println("clearinv          -  clear current inventory");
          System.out.println("delinv            -  delete item from inventory");
          System.out.println("entries           -  print entries");
          System.out.println("entry             -  create new entry");
          System.out.println("help              -  access this menu");
          System.out.println("q/quit            -  exit the program");
          System.out.println("printentry        -  print entry by id number");
          System.out.println("printinv          -  print inventory");
          System.out.println("printinvcount     -  print inventory by descending count");
          System.out.println("reminv            -  remove or decrement inventory total for an item");
          System.out.println("searchinv         -  search inventory for item(s) by name");
          System.out.println("searchentryname   -  search journal for entries with matching name");

        }

        System.out.print("\n>");
      }

      scanner.close();

    } 
    catch (NumberFormatException e) {
      e.printStackTrace();
    } 
  }
  
}
