import java.util.ArrayList;

public class JournalSystem {
  
    private ArrayList<Entry> entries = new ArrayList<Entry>();

    public JournalSystem() {
      
      entries.add(new Entry("Redbreast 12", 12, 40.00, "Irish"));

    }

    public boolean createEntry(String name, int age, double abv, String category) {
      entries.add(new Entry(name, age, abv, category));
      return true;
    }

    public void printEntries() {
      for (Entry e: entries) {
        e.print();
      }
    }
}
