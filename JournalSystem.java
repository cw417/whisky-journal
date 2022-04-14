import java.util.ArrayList;

/*
 * Models a simple CLI journal
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
    public Entry findEntry(int id) throws EntryNotFoundException {
      Entry entry = null;
      //find entry
      for (Entry e: entries) {
        if (e.getId() == id) {
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
    public void addInfo(int id, String nose, String palate, String finish) {
      // add info with entry add methods
      //Entry entry = findEntry(id);
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

    public void printHelpMenu() {
      System.out.println("\nCOMMANDS:\n");
      System.out.println("addinv    -  add item to invenory");
      System.out.println("addnotes  -  add notes to existing entry");
      System.out.println("entries   -  print entries");
      System.out.println("entry     -  create new entry");
      System.out.println("help      -  access this menu");
      System.out.println("q/quit    -  exit the program");
      System.out.println("printinv  -  print inventory");
    }
}

// exceptions

class EntryNotFoundException extends Exception {

  EntryNotFoundException(String message) {
    super(message);
  }
}

class InvalidInfoException extends Exception {

  InvalidInfoException(String message) {
    super(message);
  }
}