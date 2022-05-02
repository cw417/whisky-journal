import java.io.IOException;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;

public class Inventory {

  private HashMap<String,Integer> inventory;
  private String inventoryPath = "inventory.csv";

  Inventory() {
    inventory = readInventory(inventoryPath);
    //inventory = new HashMap<String,Integer>();
  }

  public HashMap<String,Integer> readInventory(String path) {

    HashMap<String,Integer> inv = new HashMap<String,Integer>();
    String line = "";

    try {
      BufferedReader br = new BufferedReader(new FileReader(path));

      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        inv.put(data[0], Integer.parseInt(data[1]));
      }
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
    return inv;
  }

  /**
   * Return number of item in inventory.
   * @param name name of item to search
   * @return number of item in inventory
   */
  public int getNumber(String name) {
    return inventory.get(name);
  }
  
  /**
   * Add an item to inventory.
   * @param name name of item to be added
   * @param number number of item to be added
   */
  public void addItem(String name, int number) {
    if (inventory.containsKey(name)) {
      int newCount = inventory.get(name) + number;
      inventory.put(name, newCount);
    }
    else {
      inventory.put(name, number);
    }
  }

  /**
   * Decrement number of item in inventory by 1.
   * @param name name of item to be decremented
   */
  public void decrementItem(String name) {
    int total = inventory.get(name);
    inventory.put(name, total--);
  }

  /**
   * Completely remove an item from inventory.
   * @param name name of item to be deleted
   */
  public void deleteItem(String name) {
    inventory.remove(name);
  }
  
  /**
   * Print formatted inventory list.
   * Prints by name as the default.
   * Prints by count if type == 1.
   */
  public void print(int type) {
    System.out.print("\n _____________________________\n");
    System.out.print(  "|_Num_|_________Name__________|");
    if (type == 1) { printByCount(); }
    else { printByName(); }
    System.out.print("\n|_____|_______________________|\n");
  }

  private void printByName() {
    inventory
      .entrySet()
      .stream()
      .sorted((item1, item2) -> item1.getKey().compareTo(item2.getKey()))
      .forEach(item -> System.out.printf("\n|  %-2d |  %-20s |", item.getValue(), item.getKey()));
  }

  private void printByCount() {
    inventory
      .entrySet()
      .stream()
      .sorted((item1, item2) -> item2.getValue().compareTo(item1.getValue()))
      .forEach(item -> System.out.printf("\n|  %-2d |  %-20s |", item.getValue(), item.getKey()));
  }

}
