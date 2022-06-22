import java.util.ArrayList;
import java.util.Scanner;

/*
 * Models a simple CLI journal and inventory system for whisky.
 */
public class JournalSystem {

    // create entry array to append to
    private ArrayList<Entry> entries;

    // create variable to use for generating order numbers
    private int idNumber = 0;

    public JournalSystem() {
      this.entries = new ArrayList<Entry>();
    }

    /**
     * Generates order number by incrementing the orderNumber variable.
     * @return id number
     */
    private int generateIdNumber() {
      return idNumber++;
    }

    /**
     * Create a new entry and add to entries array
     * @param name name of the whisky
     * @param category category of the whisky (Scotch, Irish, Bourbon, etc...)
     * @param double alcohol % of the whisky
     * @return true if entry created successfully, else false
     */
    public void createEntry(String name, String category, String abv) {
      if (!validInfo(name, category, abv)) { return; }
      Whisky whisky = new Whisky(name, category, Double.parseDouble(abv));
      Entry newEntry = new Entry(whisky, generateIdNumber());
      entries.add(newEntry);
      System.out.println("Created entry: ");
      newEntry.print();
      System.out.println();
    }

    /**
     * Finds an entry based on specified id.
     * @param id id of entry to return
     * @return returns entry with matching id
     */
    public Entry findEntry(String id) throws EntryNotFoundException {
      Entry entry = null;
      //find entry
      for (Entry e: entries) {
        if (e.getId() == Integer.parseInt(id)) {
          entry = e;
        }
      }
      // if entry exists
      if (entry != null) {
        return entry;
      }
      // else throw exception 
      else {
        throw new EntryNotFoundException(
          "Entry ID not found: " + id);
      }
    }

    /**
     * Add additonal info to an existing entry.
     * @param id id for entry
     * @return true if info added successfully, else false
     */
    public void addInfo(String id) {
      // add info with entry add methods
      Entry entry = findEntry(id);
      System.out.println("Nose:");
      ArrayList<String> noseInfo = getContinuousUserInfo();
      for (String info: noseInfo) {
        entry.addNose(info);
      }
      System.out.println("Palate:");
      ArrayList<String> palateInfo = getContinuousUserInfo();
      for (String info: palateInfo) {
        entry.addPalate(info);
      }
      System.out.println("Finish:");
      ArrayList<String> finishInfo = getContinuousUserInfo();
      for (String info: finishInfo) {
        entry.addFinish(info);
      }
      
    }

    /**
     * Gets user info until blank is entered.
     * Returns an arraylist of entered strings.
     * @return arraylist of entered strings
     */
    public ArrayList<String> getContinuousUserInfo() {
      ArrayList<String> returnList = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
      String next = scanner.nextLine();
      while (!next.equals("")) {
        returnList.add(next);
        next = scanner.nextLine();
      }
      return returnList;
    }

    /**
     * Checks to see if a given id is valid.
     * Id must be an integer less than or equal to 
     * the largest id number in the entries arraylist.
     * @param id id number to check
     * @return true if id number is valid, else false
     */
    public boolean validId(String id)  throws InvalidInfoException {
      int num = Integer.parseInt(id);
      if (num < 0 || num > entries.get(entries.size()-1).getId()) { throw new InvalidInfoException("Invalid ID number"); };
      return true;
    }

    /**
     * Checks to make sure info passed in is valid.
     * Returns true if name and category are not empty, 
     * and abv is able to be converted to a double.
     * @param name
     * @param category
     * @param abv
     * @return true if name and category are not empty, and abv is a number
     */
    public boolean validInfo(String name, String category, String abv) throws InvalidInfoException {
      // check that a valid number is entered
      try{
        Double.parseDouble(abv);
      }
      catch (NumberFormatException ex) {
        throw new InvalidInfoException("Please enter a valid alcohol %");
      }

      // check that no info is blank
      if (name.equals("")) { throw new InvalidInfoException("Please enter a name"); }
      if (category.equals("")) { throw new InvalidInfoException("Please enter a category"); }
      if (abv.equals("")) { throw new InvalidInfoException("Please enter an alcohol %"); }

      // if no exceptions thrown, reutrn true
      return true;

    }

    // print methods

    /**
     * Print all journal entries.
     */
    public void printEntries() {
      for (Entry e: entries) {
        e.print();
        //e.printNotes();
        System.out.println();
      }
      System.out.println();
    }

    /**
     * Prints a single existing journal entry.
     * @param id id of entry to print
     */
    public void printEntry(String id) {
      if (!validId(id)) { System.out.printf("%s is not a valid ID.", id); return; }
      Entry entry = findEntry(id);
      entry.printReview();
    }

    /**
     * Prints entries with matching names.
     * @param name name to search entry list for
     */
    public void searchName(String name) {
      entries.stream()
        .filter(entry -> entry.getWhisky().getName().contains(name))
        .forEach(entry -> entry.print());
    }

    /**
     * Prints entries with matching names.
     * @param name name to search entry list for
     */
    public void searchCategory(String category) {
      entries.stream()
        .filter(entry -> entry.getWhisky().getCategory().contains(category))
        .forEach(entry -> entry.print());
    }
}

// exceptions

class EntryNotFoundException extends RuntimeException {

  EntryNotFoundException() {
    super("Entry not found");
  }

  EntryNotFoundException(String message) {
    super(message);
  }
}

class InvalidInfoException extends RuntimeException {

  InvalidInfoException(String message) {
    super(message);
  }
}