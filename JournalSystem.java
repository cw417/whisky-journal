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
      
      // create whiskies for testing
      Whisky rb12 = new Whisky("Redbreast 12", "Irish", 40.00); 

      // add entries
      entries.add(new Entry(rb12, generateIdNumber()));

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
    public void createEntry(String name, String category, double abv) {
      Whisky whisky = new Whisky(name, category, abv);
      Entry newEntry = new Entry(whisky, generateIdNumber());
      entries.add(newEntry);
      System.out.println("Created entry: ");
      newEntry.print();
    }

    /**
     * Finds an entry based on specified id.
     * @param id id of entry to return
     * @return returns entry with matching id
     */
    public Entry findEntry(int id) {
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
      Entry entry = findEntry(id);
    }

    /**
     * Print all journal entries.
     */
    public void printEntries() {
      for (Entry e: entries) {
        e.print();
        e.printNotes();
        System.out.println();
      }
      System.out.println();
    }
}

class EntryNotFoundException extends RuntimeException {

  EntryNotFoundException(String message) {
    super(message);
  }
}