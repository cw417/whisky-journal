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
    System.out.printf("\nName: %s \nAge: %d \nABV: %.2f%% \nDate: %s \nID#: %-3d\n", name, age, abv, date, id);
  }

  /*
   * Prints tasting notes
   */
  public void printNotes() {
    System.out.printf("Category: %s \nNose: %s \nPalate: %s \nFinish: %s \nNotes: %s \nMisc: %s", category, nose, palate, finish, notes, misc);
  }

}