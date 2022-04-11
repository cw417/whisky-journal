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
      
      // create whiskies
      Whisky rb12 = new Whisky("Redbreast 12", "Irish", 12, 40.00); 

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
     * @return true if entry created successfully, else false
     */
    public void createEntry(String name, int age, double abv, String category) {
      Whisky whisky = new Whisky(name, category, age, abv);
      Entry newEntry = new Entry(whisky, generateIdNumber());
      entries.add(newEntry);
      System.out.println("Created entry: ");
      newEntry.print();
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
