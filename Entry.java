import java.util.ArrayList;

public class Entry
{
  private String name;
  private String category;
  private double abv;
  private int age;
  private int score;
  private ArrayList<String> misc;
  private ArrayList<String> nose;
  private ArrayList<String> palate;
  private ArrayList<String> finish;
  private ArrayList<String> notes;

  public Entry(String name, int age, double abv, String category) {
    this.name = name;
    this.age = age;
    this.abv = abv;
    this.category = category;
  }

  // getters

  public String getName() {
    return name;
  }

  public String getCategory() {
    return category;
  }

  public double getAbv() {
    return abv;
  }

  public int getAge() {
    return age;
  }

  public int getScore() {
    return score;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setAbv(double abv) {
    this.abv = abv;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setScore(int score) {
    this.score = score;
  }

  // misc methods

  /*
   * Prints object as formatted string
   */
  public void print() {
    System.out.printf("\nName: %s\nAge: %d\nABV: %.2f%%\n", name, age, abv);
  }

}