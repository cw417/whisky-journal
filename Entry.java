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
    this.misc = new ArrayList<>();
    this.nose = new ArrayList<>();
    this.palate = new ArrayList<>();
    this.finish = new ArrayList<>();
    this.notes = new ArrayList<>();
  }

  // getters

  public Whisky getWhisky() {
    return this.whisky;
  }

  public int getScore() {
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public LocalDate getDate() {
    return this.date;
  }

  public ArrayList<String> getMisc() {
    return this.misc;
  }

  public ArrayList<String> getNose() {
    return this.nose;
  }

  public ArrayList<String> getPalate() {
    return this.palate;
  }

  public ArrayList<String> getFinish() {
    return this.finish;
  }

  public ArrayList<String> getNotes() {
    return this.notes;
  }

  public int getId() {
    return this.id;
  }

  // add info methods

  public void addMisc(String info) {
    this.misc.add(info);
  }

  public void addNose(String info) {
   this.nose.add(info);
  }

  public void addPalate(String info) {
    this.palate.add(info);
  }

  public void addFinish(String info) {
    this.finish.add(info);
  }

  public void addNotes(String info) {
    this.notes.add(info);
  }

  /*
   * Prints object as formatted string.
   */
  public void print() {
    this.whisky.print();
    System.out.printf("Date: %s\nID: %d\n", this.date, this.id);
  }

  public String formatInfo(ArrayList<String> list) {
    String returnString = "";
    for (String s: list) {
      returnString += s + ", ";
    }
    returnString = (returnString.length() > 0) ? returnString.substring(0,returnString.length()-2) : "";
    return returnString;
  }

  /*
   * Prints tasting notes.
   */
  public void printReview() {
    this.print();
    System.out.printf("Nose: %s\n", formatInfo(nose));
    System.out.printf("Palate: %s\n", formatInfo(palate));
    System.out.printf("Finish: %s\n", formatInfo(finish));
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