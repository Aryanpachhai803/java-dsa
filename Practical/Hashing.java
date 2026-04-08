package Practical;

public class Hashing {

    static int[] hashTable = new int[10]; // size of hash table

    static int hashFunction(int key) {
        return key % 10; // simple modulo hashing
    }
    static void insert(int key) {
        int index = hashFunction(key);
        hashTable[index] = key;
    }
    static boolean search(int key) {
        int index = hashFunction(key);
        return hashTable[index] == key;
    }
    static void display() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(i + " -> " + hashTable[i]);
        }
    }
    public static void main(String[] args) {
        insert(15);
        insert(25);
        insert(35);

        display();

        int key = 25;
        if (search(key))
            System.out.println("Found " + key);
        else
            System.out.println("Not Found");
    }
}