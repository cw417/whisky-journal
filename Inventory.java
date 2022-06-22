import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Inventory {

  private HashMap<String,Integer> inventory;
  //TODO: change path to 'inventory.csv'
  private String inventoryPath = "test/inventory.csv";

  Inventory() {
    try {
      inventory = readInventory(inventoryPath);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    //inventory = new HashMap<String,Integer>();
  }

  /**
   * Reads file located at inventoryPath.
   * Returns map containing the inventory data from the file.
   * @param path path to inventory file
   * @return map containing file data
   */
  public HashMap<String,Integer> readInventory(String path) throws IOException {

    HashMap<String,Integer> inv = new HashMap<String,Integer>();
    String line = "";
    BufferedReader br = new BufferedReader(new FileReader(path));

    while ((line = br.readLine()) != null) {
      String[] data = line.split(",");
      inv.put(data[0], Integer.parseInt(data[1]));
    }
    br.close();
    return inv;
  }

  /**
   * Writes current inventory to the inventory file located at inventoryPath.
   * @throws IOException
   */
  public void writeInventory() throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(inventoryPath));
    String data = "";
    for (Iterator<String> it = inventory.keySet().iterator(); it.hasNext();) {
      String name = (String) it.next();
      int num = inventory.get(name);
      data += String.format("%s,%d\n", name, num);
    }
    bw.write(data);
    bw.close();
  }

  /**
   * Clears the current inventory.
   */
  public void clearInventory() {
    System.out.println("Clearing inventory.");
    inventory.clear();
  }

  /**
   * Searches inventory for items containing a given name.
   * Prints all results containing the given name.
   * Matches are case-insensitive.
   * @param name string to search for in inventory keys
   */
  public void searchInventory(String name) {
    System.out.print("\n _____________________________\n");
    System.out.print(  "|_Num_|_________Name__________|");
    inventory.forEach((k,v) -> {
      if (k.toLowerCase().contains(name.toLowerCase())) {
        System.out.printf("\n|  %-2d |  %-20s |", v, k);
      }
    });
    System.out.print("\n|_____|_______________________|\n");
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
  public void addItem(String name, int num) {
    if (inventory.containsKey(name)) {
      int newCount = inventory.get(name) + num;
      inventory.put(name, newCount);
      System.out.printf("New total: %d\n", newCount);
    }
    else {
      inventory.put(name, num);
      System.out.printf("Item added: %s, %d\n", name, num);
    }
  }

  /**
   * Decrement number of item in inventory by 1.
   * @param name name of item to be decreased
   * @param number number of item to be removed from current total 
   */
  public void removeItem(String name, int num) {
    if (!inventory.keySet().contains(name)) { System.out.printf("%s could not be found.", name); return; }
    int newTotal = inventory.get(name) - num;
    if (newTotal < 0) { System.out.printf("Inventory cannot go below 0.\nCurrent inventory: %d\n", inventory.get(name)); return;}
    if (newTotal == 0) {
      System.out.printf("Removing %s.\n", name); 
      inventory.remove(name);
      return;
    }
    inventory.put(name, newTotal);
    System.out.printf("New total: %d\n", newTotal);
  }

  /**
   * Completely remove an item from inventory.
   * @param name name of item to be deleted
   */
  public void deleteItem(String name) {
    if (!inventory.containsKey(name)) { System.out.printf("%s could not be found.", name); return; }
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
