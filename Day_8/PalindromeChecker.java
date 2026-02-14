package Day_8;

import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    // Push Operation
    void push(char data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop Operation
    char pop() {
        if (top == null) {
            return 0;
        }
        char value = top.data;
        top = top.next;
        return value;
    }

    // Empty or not Operation
    boolean isEmpty() {
        return top == null;
    }

    // Stack clear Operation
    void clear() {
        top = null;
    }
}

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        String input;

        while (true) {
            System.out.println("---Palindrome Checker---");
            System.out.println("1. Check Palindrome");
            System.out.println("2. Exit the program");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    stack.clear();
                    System.out.println("Enter a word : ");
                    input = sc.nextLine();

                    // Pushing characters into the stack
                    for (int i = 0; i < input.length(); i++) {
                        stack.push(input.charAt(i));
                    }

                    boolean isPalindrome = true;

                    // Comparing characters
                    for (int i = 0; i < input.length(); i++) {
                        if (input.charAt(i) != stack.pop()) {
                            isPalindrome = false;
                            break;
                        }
                    }

                    if (isPalindrome) {
                        System.out.println("It is a Palindrome.");
                    } else {
                        System.out.println("It is not a Palindrome.");
                    }
                    break;

                case 2:
                    System.out.println("Exiting the program.....");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
