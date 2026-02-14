package Day_8;

import java.util.Scanner;

public class PalindromeChecker {
    class Node{
        char data;
        Node next;

        Node(char data){
            this.data = data;
            this.next = null;
        }
    }
    class Stack{
        Node top;

        //Push Operation
        void push(char data){
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("---Palindrome Checker---");
            System.out.println("1. Check Palindrome");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter a word : ");
                    break;
            
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        
    }
}
