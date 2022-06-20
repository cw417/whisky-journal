public class Whisky {
  
  private String name;
  private String category;
  private double abv;
  private int inventory;

  Whisky(String name, int inventory) {
    this.name = name;
  }

  Whisky(String name, String category, double abv) {
    this.name = name;
    this.category = category;
    this.abv = abv;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return this.category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public double getAbv() {
    return this.abv;
  }

  public void setAbv(double abv) {
    this.abv = abv;
  }

  public int getInventory() {
    return this.inventory;
  }

  public void setInventory(int num) {
    this.inventory = num;
  }

  /**
   * Increment inventory by 1.
   */
  public void incrementInventory() {
    this.inventory++;
  }

  /**
   * Returns true if two whiskies have the same name.
   * @param other other whisky to compare
   * @return true if names are equal
   */
  public boolean equals(Whisky other) {
    return (this.name.equals(other.getName()));
  }

  /**
   * Print formatted info.
   */
  public void print() {
    System.out.printf(
     "\nName: %s \nABV: %.2f \nCategory: %s\n",
      this.name, this.abv, this.category);
  }
}
