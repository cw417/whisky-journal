import java.util.ArrayList;
import java.util.Scanner;

public class Entry
{
  private String distiller;
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

  public Entry(String distiller, String name, double abv, String category) {
    this.distiller = distiller;
    this.name = name;
    this.abv = abv;
    this.category = category;
  }

  public String getDistiller() {
    return distiller;
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

  public void setDistiller(String distiller) {
    this.distiller = distiller;
  }

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

}