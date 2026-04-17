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



    public static void main(String[] args) {
    }
}