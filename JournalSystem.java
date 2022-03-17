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

    /*
     * Generates order number by incrementing the orderNumber variable
     */
    private int generateIdNumber() {
      return idNumber++;
    }

    /*
     * Create a new entry and add to entries array
     */
    public boolean createEntry(String name, int age, double abv, String category) {
      Entry newEntry = new Entry(name, age, abv, category, generateIdNumber());
      entries.add(newEntry);
      System.out.println("Created entry: ");
      newEntry.print();
      return true;
    }

    public int addInfo(int id) {
      // add ifno with entry add methods
      return 0;
    }

    /*
     * Prints all entries
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
