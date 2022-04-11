import java.util.ArrayList;
import java.time.LocalDate;

public class Entry
{
  private Whisky whisky;
  private int score;
  private ArrayList<String> misc;
  private ArrayList<String> nose;
  private ArrayList<String> palate;
  private ArrayList<String> finish;
  private ArrayList<String> notes;
  private LocalDate date;
  private int id;

  public Entry(Whisky whisky, int id) {
    this.whisky = whisky;
    this.date = LocalDate.now();
    this.id = id;
  }

  // getters

  public Whisky getWhisky() {
    return whisky;
  }

  public int getScore() {
    return score;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public ArrayList<String> getMisc() {
    return misc;
  }

  public ArrayList<String> getNose() {
    return nose;
  }

  public ArrayList<String> getPalate() {
    return palate;
  }

  public ArrayList<String> getFinish() {
    return finish;
  }

  public ArrayList<String> getNotes() {
    return notes;
  }

  public int getId() {
    return id;
  }

  // setters


  public void setScore(int score) {
    this.score = score;
  }

  // add info methods

  public void addMisc(String info) {
    misc.add(info);
  }

  public void addNose(String info) {
    nose.add(info);
  }

  public void addPalate(String info) {
    palate.add(info);
  }

  public void addFinish(String info) {
    finish.add(info);
  }

  public void addNotes(String info) {
    notes.add(info);
  }


  // misc methods

  /*
   * Prints object as formatted string
   */
  public void print() {
  }

  /*
   * Prints tasting notes
   */
  public void printNotes() {
  }

  /**
   * Returns true if two entries have the same id.
   * @param other other entry to compare
   * @return true if entries are equal
   */
  public boolean equals(Entry other) {
    return (this.id == other.getId());
  }
}