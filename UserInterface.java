import java.util.Scanner;

public class UserInterface {

  public static void main(String[] args) {

    System.out.println("Welcome to the Whisk(e)y Journal!");

    JournalSystem whiskyJournal = new JournalSystem();

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

			else if (action.equalsIgnoreCase("Q") || action.equalsIgnoreCase("QUIT")) {
				return;
      }

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

        // get age
        System.out.print("Age: ");
        if (scanner.hasNextLine()) {
          age = scanner.nextInt();
        }
        
        // get name
        System.out.print("Alcohol %: ");
        if (scanner.hasNextLine()) {
          abv = scanner.nextDouble();
        }

        // get category
        System.out.print("Category: ");
        if (scanner.hasNextLine()) {
          category = scanner.nextLine();
        }

        // TODO: Fix this
        // I have no idea why this needs to run twice 
        // If removed, it will skip asking for Category
        if (scanner.hasNextLine()) {
          category = scanner.nextLine();
        }
      
        System.out.println(); 
        whiskyJournal.createEntry(name, age, abv, category);
      }  

      else if (action.equalsIgnoreCase("ENTRIES")) {
        whiskyJournal.printEntries();
      }
      System.out.print("\n>");
    }

  }
  
}
