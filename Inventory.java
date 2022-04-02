import java.util.HashMap;

public class Inventory {

  HashMap<String,Integer> inventory;

  Inventory() {
    inventory = new HashMap<String,Integer>();
  }

  public int getNumber(String name) {
    return inventory.get(name);
  }
  
  public void addItem(String name, int number) {
    inventory.put(name, number);
  }

  public void decrementItem(String name) {
    int total = inventory.get(name);
    inventory.put(name, total--);
  }

  public void deleteItem(String name) {
    inventory.remove(name);
  }
  
}
