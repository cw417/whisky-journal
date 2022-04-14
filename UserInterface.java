import java.util.Scanner;

public class UserInterface {

  public static void main(String[] args) {

    System.out.println("Welcome to the Whisk(e)y Journal!");
    System.out.println("Enter \"q\" or \"quit\" to exit.");
    System.out.println("Enter \"help\" to see available commands.");
    System.out.println();

    JournalSystem whiskyJournal = new JournalSystem();
    Inventory inventory = new Inventory();

    Scanner scanner = new Scanner(System.in);
    System.out.print(">");

    // process keyboard actions
    while(scanner.hasNextLine()) {

			String action = scanner.nextLine();
			
			if (action == null || action.equals("")) 
			{
				System.out.print("\n>");
				continue;
			}

      // misc functionality actions

			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT")) {
				return;
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

        inventory.addItem(name, number);
      }

      else if (action.equalsIgnoreCase("PRINTINV")) {
        inventory.print();
      }

      // entry actions

      else if (action.equalsIgnoreCase("ENTRY")) {

        String name = "";
        int age = 0;
        double abv = 0.0;
        String category = "";

        // get name
        System.out.print("Name: ");
        if (scanner.hasNextLine()) {
          name = scanner.nextLine();
        }

        // get name
        System.out.print("Alcohol %: ");
        if (scanner.hasNextLine()) {
          abv = Double.parseDouble(scanner.nextLine());
        }

        // get category
        System.out.print("Category: ");
        if (scanner.hasNextLine()) {
          category = scanner.nextLine();
        }

        whiskyJournal.createEntry(name, category, abv);
      }  

      else if (action.equalsIgnoreCase("ENTRIES")) {
        whiskyJournal.printEntries();
      }

      else if (action.equalsIgnoreCase("ADDNOTES")) {
        
        String id = "";

        // search by id or name
        System.out.print("Enter ID#: ");
        if (scanner.hasNextLine()) {
          id = scanner.nextLine();
        }
        try{
          // need to convert to add info
          // will pass in strings to be added to each section
          // need to get nose, palate, finish in loops
          // then add them to string arrays
          whiskyJournal.addInfo(Integer.parseInt(id));
        }
        catch (EntryNotFoundException ex) {
          System.err.print(ex);
        }
      }

      // help menu

      else if (action.equalsIgnoreCase("HELP")) {
        System.out.println("\nCOMMANDS:\n");
        System.out.println("addinv    -  add item to invenory");
        System.out.println("addnotes  -  add notes to existing entry");
        System.out.println("entries   -  print entries");
        System.out.println("entry     -  create new entry");
        System.out.println("help      -  access this menu");
        System.out.println("q/quit    -  exit the program");
        System.out.println("printinv  -  print inventory");
      }

      System.out.print("\n>");
    }

    scanner.close();
  }
  
}
