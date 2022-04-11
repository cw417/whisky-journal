public class Whisky {
  
  private String name;
  private String category;
  private double abv;
  private int age;

  Whisky(String name) {
    this.name = name;
  }

  Whisky(String name, String category, double abv) {
    this.name = name;
    this.category = category;
    this.abv = abv;
  }

  Whisky(String name, String category, int age, double abv) {
    this.name = name;
    this.category = category;
    this.abv = abv;
    this.age = age;
  }

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

  public void setName(String name) {
    this.name = name;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setAbv(double abv) {
    this.abv = abv;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
