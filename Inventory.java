import java.net.Inet4Address;
import java.util.HashMap;

public class Inventory {

  private HashMap<String,Integer> inventory;

  Inventory() {
    inventory = new HashMap<String,Integer>();
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
  // TODO: check if item already exists in inventory
  public void addItem(String name, int number) {
    inventory.put(name, number);
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
   */
  public void print() {
    for (HashMap.Entry<String,Integer> set: inventory.entrySet()) {
      System.out.printf("\n%-2d %s", set.getValue(), set.getKey());
    }
    System.out.println();
  }
}
