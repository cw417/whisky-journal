public class Whisky {
  
  private String name;
  private String category;
  private double abv;
  private int inventory;

  // constructors

  Whisky(String name, int inventory) {
    this.name = name;
  }

  Whisky(String name, String category, double abv) {
    this.name = name;
    this.category = category;
    this.abv = abv;
  }

  // getters

  public String getName() {
    return this.name;
  }

  public String getCategory() {
    return this.category;
  }

  public double getAbv() {
    return this.abv;
  }

  public int getInventory() {
    return this.inventory;
  }

  // setters

  public void setName(String name) {
    this.name = name;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setAbv(double abv) {
    this.abv = abv;
  }

  public void setInventory(int num) {
    this.inventory = num;
  }

  public void incrementInventory() {
    this.inventory++;
  }

  // comparison methods

  /**
   * Returns true if two whiskies have the same name.
   * @param other other whisky to compare
   * @return true if names are equal
   */
  public boolean equals(Whisky other) {
    return (this.name.equals(other.getName()));
  }
}
