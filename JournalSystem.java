import java.util.ArrayList;

/*
 * Models a simple CLI journal
 */
public class JournalSystem {

    // create entry array to append to
    private ArrayList<Entry> entries = new ArrayList<Entry>();

    // create variable to use for generating order numbers
    private int idNumber = 0;

    public JournalSystem() {
      
      // add entries
      entries.add(new Entry("Redbreast 12", 12, 40.00, "Irish", generateIdNumber()));

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
     * @return true if entry created successfully, else false
     */
    public boolean createEntry(String name, int age, double abv, String category) {
      Entry newEntry = new Entry(name, age, abv, category, generateIdNumber());
      entries.add(newEntry);
      System.out.println("Created entry: ");
      newEntry.print();
      return true;
    }

    /**
     * Add additonal info to an existing entry.
     * @param id id for entry
     * @return true if info added successfully, else false
     */
    public boolean addInfo(int id) {
      // add info with entry add methods
      return true;
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
