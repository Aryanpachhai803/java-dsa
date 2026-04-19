package Practical;
import java.util.Scanner;

public class BinaryDemoGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 100;
        int guess;
        char response;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("Respond with:");
        System.out.println("'l' if the guess is lower");
        System.out.println("'h' if the guess is higher");
        System.out.println("'c' if the guess is correct");

        while (low <= high) {
            guess = low + (high - low) / 2;
            System.out.println("Is your number: " + guess + "?");
            response = sc.next().charAt(0);

            if (response == 'c') {
                System.out.println("Guessed your number");
                break;
            } else if (response == 'l') {
                high = guess - 1;
            } else if (response == 'h') {
                low = guess + 1;
            } else {
                System.out.println("Invalid input! Please enter h, l, or c.");
            }
        }

        sc.close();
    }
}