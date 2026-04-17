package Practical;
import java.util.Scanner;

public class HashingDemo {

    static String[] userTable = new String[10];
    static String[] passTable = new String[10];

    static int hashFunction(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % 10;
    }

    static String hashPassword(String password) {
        int hash = 7;
        for (int i = 0; i < password.length(); i++) {
            hash = hash * 31 + password.charAt(i);
        }
        return String.valueOf(hash);
    }

    static void insert(String username, String password) {
        int index = hashFunction(username);

        // Linear probing for collision handling
        while (userTable[index] != null) {
            index = (index + 1) % 10;
        }

        userTable[index] = username;
        passTable[index] = hashPassword(password);
        System.out.println("User registered successfully!");
    }

    static boolean search(String username, String password) {
        int index = hashFunction(username);
        int startIndex = index;

        while (userTable[index] != null) {
            if (userTable[index].equals(username)) {
                return passTable[index].equals(hashPassword(password));
            }
            index = (index + 1) % 10;

            if (index == startIndex) break; // full loop
        }
        return false;
    }

    static void display() {
        for (int i = 0; i < userTable.length; i++) {
            System.out.println(i + " -> " + userTable[i] + " | " + passTable[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        insert("ram", "1234");
        insert("shyam", "abcd");

        display();

        System.out.print("\nEnter username: ");
        String user = sc.nextLine();

        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        if (search(user, pass))
            System.out.println("Login successful!");
        else
            System.out.println("Invalid credentials!");
    }
}