package Day_7;

import java.util.Scanner;

public class DoublyLinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;
        Node prev; // new pointer

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }


    // ---------------- Main Method ----------------
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Doubly Linked List Menu =====");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Delete from start");
            System.out.println("4. Delete from end");
            System.out.println("5. Traverse forward");
            System.out.println("6. Traverse backward");
            System.out.println("7. Search for an element");
            System.out.println("8. List Size");
            System.out.println("9. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}