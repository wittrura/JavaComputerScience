package main;

public class HashTable {

  //Type here is dependent on what you want to store in the HashTable
  String[] table;
  //Size determines how many elements can be stored in the HashTable
  int size;
  //Stores how many values are in the HashTable
  int items = 0;

  // Instantiate the HashTable
  public HashTable(int size) {
    System.out.println("Initializing Hash Table");
    this.size = size;
    table = new String[size + 1];
  }

  // Create a hash function to map the ID to an index
  // The resulting index should be bounded from [0, size)
  public int hashFunction(int id) {
      int hashId = (id * (id + 3)) % (this.size + 1);
      return hashId;
  }

  // Insert a value into the HashTable given an ID
  public Boolean set(int id, String name) {
      int hashId = hashFunction(id);
      if (this.table[hashId] == null) {
          this.table[hashId] = name;
          this.items++;
      } else {
          this.table[hashId] = name;
      }

    return true;
  }

  // Access a value in the HashTable given an ID
  public String get(int id) {
      int hashId = hashFunction(id);
      return this.table[hashId];
  }

  // Delete a value in the HashTable given an ID
  public Boolean remove(int id) {
      int hashId = hashFunction(id);
      if (this.table[hashId] != null) {
          this.table[hashId] = null;
          this.items--;
          return true;
      } else {
          return false;
      }
  }

  // Return the number of items stored in the HashTable
  public int items() {
    return this.items;
  }

}
